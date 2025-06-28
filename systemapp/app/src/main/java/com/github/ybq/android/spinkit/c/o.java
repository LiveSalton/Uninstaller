package com.github.ybq.android.spinkit.c;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.os.Build;

/* compiled from: source */
/* loaded from: classes.dex */
public class o extends com.github.ybq.android.spinkit.b.g {
    @Override // com.github.ybq.android.spinkit.b.g
    public com.github.ybq.android.spinkit.b.f[] s() {
        a[] aVarArr = new a[5];
        for (int i = 0; i < aVarArr.length; i++) {
            aVarArr[i] = new a();
            if (Build.VERSION.SDK_INT >= 24) {
                aVarArr[i].g(600 + (i * 100));
            } else {
                aVarArr[i].g((-1200) + (i * 100));
            }
        }
        return aVarArr;
    }

    @Override // com.github.ybq.android.spinkit.b.g, com.github.ybq.android.spinkit.b.f, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect b = b(rect);
        int width = b.width() / r();
        int width2 = ((b.width() / 5) * 3) / 5;
        for (int i = 0; i < r(); i++) {
            com.github.ybq.android.spinkit.b.f h = h(i);
            int i2 = b.left + (i * width) + (width / 5);
            h.a(i2, b.top, i2 + width2, b.bottom);
        }
    }

    /* compiled from: source */
    private class a extends com.github.ybq.android.spinkit.b.c {
        a() {
            e(0.4f);
        }

        @Override // com.github.ybq.android.spinkit.b.c, com.github.ybq.android.spinkit.b.f
        public ValueAnimator a() {
            float[] fArr = {0.0f, 0.2f, 0.4f, 1.0f};
            return new com.github.ybq.android.spinkit.a.d(this).b(fArr, Float.valueOf(0.4f), Float.valueOf(1.0f), Float.valueOf(0.4f), Float.valueOf(0.4f)).a(1200L).a(fArr).a();
        }
    }
}
