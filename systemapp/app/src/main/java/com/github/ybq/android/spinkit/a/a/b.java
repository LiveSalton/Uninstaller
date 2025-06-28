package com.github.ybq.android.spinkit.a.a;

import android.animation.TimeInterpolator;
import android.view.animation.Interpolator;

/* compiled from: source */
/* loaded from: classes.dex */
public class b implements Interpolator {
    private TimeInterpolator a;
    private float[] b;

    public static b a(float... fArr) {
        b bVar = new b(a.a(), new float[0]);
        bVar.b(fArr);
        return bVar;
    }

    public static b a(float f, float f2, float f3, float f4, float... fArr) {
        b bVar = new b(c.a(f, f2, f3, f4), new float[0]);
        bVar.b(fArr);
        return bVar;
    }

    public b(TimeInterpolator timeInterpolator, float... fArr) {
        this.a = timeInterpolator;
        this.b = fArr;
    }

    public void b(float... fArr) {
        this.b = fArr;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (this.b.length > 1) {
            int i = 0;
            while (i < this.b.length - 1) {
                float f2 = this.b[i];
                i++;
                float f3 = this.b[i];
                float f4 = f3 - f2;
                if (f >= f2 && f <= f3) {
                    return f2 + (this.a.getInterpolation((f - f2) / f4) * f4);
                }
            }
        }
        return this.a.getInterpolation(f);
    }
}
