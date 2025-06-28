package com.github.ybq.android.spinkit.c;

import android.animation.ValueAnimator;
import android.os.Build;

/* compiled from: source */
/* loaded from: classes.dex */
public class d extends com.github.ybq.android.spinkit.b.g {
    @Override // com.github.ybq.android.spinkit.b.g
    public com.github.ybq.android.spinkit.b.f[] s() {
        return new com.github.ybq.android.spinkit.b.f[]{new a(), new a()};
    }

    @Override // com.github.ybq.android.spinkit.b.g
    public void a(com.github.ybq.android.spinkit.b.f... fVarArr) {
        super.a(fVarArr);
        if (Build.VERSION.SDK_INT >= 24) {
            fVarArr[1].g(1000);
        } else {
            fVarArr[1].g(-1000);
        }
    }

    /* compiled from: source */
    private class a extends com.github.ybq.android.spinkit.b.b {
        a() {
            setAlpha(153);
            c(0.0f);
        }

        @Override // com.github.ybq.android.spinkit.b.b, com.github.ybq.android.spinkit.b.f
        public ValueAnimator a() {
            float[] fArr = {0.0f, 0.5f, 1.0f};
            return new com.github.ybq.android.spinkit.a.d(this).a(fArr, Float.valueOf(0.0f), Float.valueOf(1.0f), Float.valueOf(0.0f)).a(2000L).a(fArr).a();
        }
    }
}
