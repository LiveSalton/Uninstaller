package com.github.ybq.android.spinkit.c;

import android.animation.ValueAnimator;

/* compiled from: source */
/* loaded from: classes.dex */
public class i extends com.github.ybq.android.spinkit.b.b {
    public i() {
        c(0.0f);
    }

    @Override // com.github.ybq.android.spinkit.b.b, com.github.ybq.android.spinkit.b.f
    public ValueAnimator a() {
        float[] fArr = {0.0f, 1.0f};
        return new com.github.ybq.android.spinkit.a.d(this).a(fArr, Float.valueOf(0.0f), Float.valueOf(1.0f)).a(fArr, 255, 0).a(1000L).a(fArr).a();
    }
}
