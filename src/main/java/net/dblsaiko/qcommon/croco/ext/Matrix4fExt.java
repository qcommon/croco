package net.dblsaiko.qcommon.croco.ext;

import net.minecraft.client.util.math.Matrix4f;

public interface Matrix4fExt {

    void setData(float[] values);

    float[] getData();

    static Matrix4fExt from(Matrix4f self) {
        return (Matrix4fExt) (Object) self;
    }

}
