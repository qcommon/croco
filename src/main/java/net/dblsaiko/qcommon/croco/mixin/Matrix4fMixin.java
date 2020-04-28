package net.dblsaiko.qcommon.croco.mixin;

import net.minecraft.client.util.math.Matrix4f;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.dblsaiko.qcommon.croco.ext.Matrix4fExt;

@Mixin(Matrix4f.class)
public abstract class Matrix4fMixin implements Matrix4fExt {

    @Shadow protected float a00;
    @Shadow protected float a01;
    @Shadow protected float a02;
    @Shadow protected float a03;
    @Shadow protected float a10;
    @Shadow protected float a11;
    @Shadow protected float a12;
    @Shadow protected float a13;
    @Shadow protected float a20;
    @Shadow protected float a21;
    @Shadow protected float a22;
    @Shadow protected float a23;
    @Shadow protected float a30;
    @Shadow protected float a31;
    @Shadow protected float a32;
    @Shadow protected float a33;

    @Override
    public void setData(float[] values) {
        this.a00 = values[0];
        this.a01 = values[1];
        this.a02 = values[2];
        this.a03 = values[3];
        this.a10 = values[4];
        this.a11 = values[5];
        this.a12 = values[6];
        this.a13 = values[7];
        this.a20 = values[8];
        this.a21 = values[9];
        this.a22 = values[10];
        this.a23 = values[11];
        this.a30 = values[12];
        this.a31 = values[13];
        this.a32 = values[14];
        this.a33 = values[15];
    }

    @Override
    public float[] getData() {
        return new float[]{
            a00, a01, a02, a03,
            a10, a11, a12, a13,
            a20, a21, a22, a23,
            a30, a31, a32, a33
        };
    }

}
