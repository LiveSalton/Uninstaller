package com.github.ybq.android.spinkit.b;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;

/* compiled from: source */
/* loaded from: classes.dex */
public class b extends e {
    @Override // com.github.ybq.android.spinkit.b.f
    public ValueAnimator a() {
        return null;
    }

    @Override // com.github.ybq.android.spinkit.b.e
    public void a(Canvas canvas, Paint paint) {
        if (q() != null) {
            canvas.drawCircle(q().centerX(), q().centerY(), Math.min(q().width(), q().height()) / 2, paint);
        }
    }
}
