package com.github.ybq.android.spinkit.c;

import android.animation.ValueAnimator;

/* compiled from: source */
/* loaded from: classes.dex */
public class k extends com.github.ybq.android.spinkit.b.b {
    @Override // com.github.ybq.android.spinkit.b.b, com.github.ybq.android.spinkit.b.f
    public ValueAnimator a() {
        float[] fArr = {0.0f, 0.5f, 1.0f};
        return new com.github.ybq.android.spinkit.a.d(this).b(fArr, 0, -180, -180).c(fArr, 0, 0, -180).a(1200L).a(fArr).a();
    }
}
