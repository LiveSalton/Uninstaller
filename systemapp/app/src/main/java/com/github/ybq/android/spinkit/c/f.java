package com.github.ybq.android.spinkit.c;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.view.animation.LinearInterpolator;

/* compiled from: source */
/* loaded from: classes.dex */
public class f extends com.github.ybq.android.spinkit.b.g {
    private boolean m = false;

    @Override // com.github.ybq.android.spinkit.b.g
    public com.github.ybq.android.spinkit.b.f[] s() {
        a[] aVarArr = new a[4];
        for (int i = 0; i < aVarArr.length; i++) {
            aVarArr[i] = new a();
            if (Build.VERSION.SDK_INT >= 24) {
                aVarArr[i].g(300 * i);
            } else {
                aVarArr[i].g((300 * i) - 1200);
            }
        }
        return aVarArr;
    }

    @Override // com.github.ybq.android.spinkit.b.g, com.github.ybq.android.spinkit.b.f, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect b = b(rect);
        int min = Math.min(b.width(), b.height());
        if (this.m) {
            min = (int) Math.sqrt((min * min) / 2);
            int width = (b.width() - min) / 2;
            int height = (b.height() - min) / 2;
            b = new Rect(b.left + width, b.top + height, b.right - width, b.bottom - height);
        }
        int i = min / 2;
        int i2 = b.left + i + 1;
        int i3 = b.top + i + 1;
        for (int i4 = 0; i4 < r(); i4++) {
            com.github.ybq.android.spinkit.b.f h = h(i4);
            h.a(b.left, b.top, i2, i3);
            h.f(h.q().right);
            h.g(h.q().bottom);
        }
    }

    @Override // com.github.ybq.android.spinkit.b.g
    public void a(Canvas canvas) {
        Rect b = b(getBounds());
        for (int i = 0; i < r(); i++) {
            int save = canvas.save();
            canvas.rotate(45 + (i * 90), b.centerX(), b.centerY());
            h(i).draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    /* compiled from: source */
    private class a extends com.github.ybq.android.spinkit.b.c {
        a() {
            setAlpha(0);
            e(-180);
        }

        @Override // com.github.ybq.android.spinkit.b.c, com.github.ybq.android.spinkit.b.f
        public ValueAnimator a() {
            float[] fArr = {0.0f, 0.1f, 0.25f, 0.75f, 0.9f, 1.0f};
            return new com.github.ybq.android.spinkit.a.d(this).a(fArr, 0, 0, 255, 255, 0, 0).b(fArr, -180, -180, 0, 0, 0, 0).c(fArr, 0, 0, 0, 0, 180, 180).a(2400L).a(new LinearInterpolator()).a();
        }
    }
}
