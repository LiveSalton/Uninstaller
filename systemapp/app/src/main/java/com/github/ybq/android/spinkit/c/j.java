package com.github.ybq.android.spinkit.c;

import android.animation.ValueAnimator;

/* compiled from: source */
/* loaded from: classes.dex */
public class j extends com.github.ybq.android.spinkit.b.d {
    public j() {
        c(0.0f);
    }

    @Override // com.github.ybq.android.spinkit.b.d, com.github.ybq.android.spinkit.b.f
    public ValueAnimator a() {
        float[] fArr = {0.0f, 0.7f, 1.0f};
        return new com.github.ybq.android.spinkit.a.d(this).a(fArr, Float.valueOf(0.0f), Float.valueOf(1.0f), Float.valueOf(1.0f)).a(fArr, 255, 178, 0).a(1000L).a(com.github.ybq.android.spinkit.a.a.b.a(0.21f, 0.53f, 0.56f, 0.8f, fArr)).a();
    }
}
