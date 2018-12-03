package therealfarfetchd.qcommon.croco;

import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

import java.util.Objects;

public final class Vec3 {

    public static final Vec3 ORIGIN = new Vec3(0, 0, 0);

    public final float x;
    public final float y;
    public final float z;

    private float length = Float.NaN;
    private float lengthSq = Float.NaN;
    private Vec3 normalized;
    private Vec3 negated;

    public Vec3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3 add(Vec3 other) {
        return new Vec3(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    public Vec3 sub(Vec3 other) {
        return new Vec3(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    public Vec3 mul(Vec3 other) {
        return new Vec3(this.x * other.x, this.y * other.y, this.z * other.z);
    }

    public Vec3 mul(float other) {
        return new Vec3(this.x * other, this.y * other, this.z * other);
    }

    public Vec3 div(Vec3 other) {
        return new Vec3(x / other.x, this.y / other.y, this.z / other.z);
    }

    public Vec3 div(float other) {
        return new Vec3(x / other, this.y / other, this.z / other);
    }

    public float dot(Vec3 other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    public Vec3 cross(Vec3 other) {
        float cx = this.y * other.z - this.z * other.y;
        float cy = this.z * other.x - this.x * other.z;
        float cz = this.x * other.y - this.y * other.x;
        return new Vec3(cx, cy, cz);
    }

    public float getLength() {
        if (Float.isNaN(length)) {
            length = (float) Math.sqrt(getLengthSq());
        }

        return length;
    }

    public float getLengthSq() {
        if (Float.isNaN(lengthSq)) {
            lengthSq = x * x + y * y + z * z;
        }

        return lengthSq;
    }

    public Vec3 getNormalized() {
        if (normalized == null) {
            normalized = new Vec3(x / getLength(), y / getLength(), z / getLength());
            normalized.length = 1;
            normalized.lengthSq = 1;
            normalized.normalized = normalized;
        }

        return normalized;
    }

    public Vec3 negate() {
        if (negated == null) {
            negated = new Vec3(-x, -y, -z);
            negated.length = length;
            negated.lengthSq = lengthSq;
            negated.negated = this;
        }

        return negated;
    }

    public Vec3d toVec3d() {
        return new Vec3d(x, y, z);
    }

    public Vec3i toVec3i() {
        return new Vec3i(x, y, z);
    }

    public Vec4 toVec4() {
        return new Vec4(x, y, z, 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vec3 vec3 = (Vec3) o;
        return vec3.x == x &&
            vec3.y == y &&
            vec3.z == z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return String.format("(%f, %f, %f)", x, y, z);
    }

    public static Vec3 from(Vec3i vec) {
        return new Vec3(vec.getX(), vec.getY(), vec.getZ());
    }

    public static Vec3 from(Vec3d vec) {
        return new Vec3((float) vec.x, (float) vec.y, (float) vec.z);
    }

}
