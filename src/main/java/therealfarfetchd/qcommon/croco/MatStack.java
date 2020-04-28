package therealfarfetchd.qcommon.croco;

import net.minecraft.client.util.math.Matrix4f;
import net.minecraft.client.util.math.MatrixStack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MatStack {

    private Deque<Mat4> stack = new LinkedList<>();

    public MatStack() {
        stack.add(Mat4.IDENTITY);
    }

    public Mat4 mat() {
        return stack.getLast();
    }

    public void push() {
        stack.add(mat());
    }

    public void pop() {
        if (stack.size() < 2) {
            throw new IllegalStateException("stack underflow");
        }
        stack.removeLast();
    }

    public void loadIdentity() {
        stack.removeLast();
        stack.add(Mat4.IDENTITY);
    }

    public void load(Mat4 mat) {
        stack.removeLast();
        stack.add(mat);
    }

    public void translate(float x, float y, float z) {
        stack.add(stack.removeLast().translate(x, y, z));
    }

    public void scale(float x, float y, float z) {
        stack.add(stack.removeLast().scale(x, y, z));
    }

    public void rotate(float x, float y, float z, float angle) {
        stack.add(stack.removeLast().rotate(x, y, z, angle));
    }

    public void translate(Vec3 xyz) {
        stack.add(stack.removeLast().translate(xyz));
    }

    public void mul(Mat4 other) {
        stack.add(stack.removeLast().mul(other));
    }

    public int depth() {
        return stack.size();
    }

    public static MatStack fromMatrixStack(MatrixStack stack) {
        MatStack ms = new MatStack();
        List<Matrix4f> matrices = new ArrayList<>();
        while (!stack.isEmpty()) {
            matrices.add(stack.peek().getModel());
            stack.pop();
        }
        matrices.add(stack.peek().getModel());

        while (!matrices.isEmpty()) {
            Matrix4f mat = matrices.remove(matrices.size() - 1);
            ms.load(Mat4.fromMatrix4f(mat));
            ms.push();
        }
        ms.pop();

        // restore original MatrixStack
        ms.intoMatrixStack(stack);
        return ms;
    }

    public MatrixStack toMatrixStack() {
        MatrixStack stack = new MatrixStack();
        intoMatrixStack(stack);
        return stack;
    }

    public void intoMatrixStack(MatrixStack target) {
        stack.forEach(mat -> {
            mat.intoMatrix4f(target.peek().getModel());
            mat.getRotation().intoMatrix3f(target.peek().getNormal());
            target.push();
        });
        target.pop();
    }

}
