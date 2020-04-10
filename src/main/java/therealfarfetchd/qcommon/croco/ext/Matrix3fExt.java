package therealfarfetchd.qcommon.croco.ext;

import net.minecraft.client.util.math.Matrix3f;

public interface Matrix3fExt {

    void setData(float[] values);

    float[] getData();

    static Matrix3fExt from(Matrix3f self) {
        return (Matrix3fExt) (Object) self;
    }

}
