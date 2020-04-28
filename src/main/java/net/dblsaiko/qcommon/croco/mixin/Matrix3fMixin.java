package net.dblsaiko.qcommon.croco.mixin;

import net.minecraft.client.util.math.Matrix3f;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.dblsaiko.qcommon.croco.ext.Matrix4fExt;

@Mixin(Matrix3f.class)
public abstract class Matrix3fMixin implements Matrix4fExt {

    @Shadow protected float a00;
    @Shadow protected float a01;
    @Shadow protected float a02;
    @Shadow protected float a10;
    @Shadow protected float a11;
    @Shadow protected float a12;
    @Shadow protected float a20;
    @Shadow protected float a21;
    @Shadow protected float a22;

    @Override
    public void setData(float[] values) {
        this.a00 = values[0];
        this.a01 = values[1];
        this.a02 = values[2];
        this.a10 = values[3];
        this.a11 = values[4];
        this.a12 = values[5];
        this.a20 = values[6];
        this.a21 = values[7];
        this.a22 = values[8];
    }

    @Override
    public float[] getData() {
        return new float[]{
            a00, a01, a02,
            a10, a11, a12,
            a20, a21, a22,
        };
    }

}
