package com.github.ybq.android.spinkit.c;

import android.animation.ValueAnimator;
import android.os.Build;

/* compiled from: source */
/* loaded from: classes.dex */
public class e extends com.github.ybq.android.spinkit.b.a {
    @Override // com.github.ybq.android.spinkit.b.g
    public com.github.ybq.android.spinkit.b.f[] s() {
        a[] aVarArr = new a[12];
        for (int i = 0; i < aVarArr.length; i++) {
            aVarArr[i] = new a();
            if (Build.VERSION.SDK_INT >= 24) {
                aVarArr[i].g(100 * i);
            } else {
                aVarArr[i].g((100 * i) - 1200);
            }
        }
        return aVarArr;
    }

    /* compiled from: source */
    private class a extends com.github.ybq.android.spinkit.b.b {
        a() {
            setAlpha(0);
        }

        @Override // com.github.ybq.android.spinkit.b.b, com.github.ybq.android.spinkit.b.f
        public ValueAnimator a() {
            float[] fArr = {0.0f, 0.39f, 0.4f, 1.0f};
            return new com.github.ybq.android.spinkit.a.d(this).a(fArr, 0, 0, 255, 0).a(1200L).a(fArr).a();
        }
    }
}
