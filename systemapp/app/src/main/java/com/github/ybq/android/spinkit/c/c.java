package com.github.ybq.android.spinkit.c;

import android.animation.ValueAnimator;
import android.graphics.Rect;

/* compiled from: source */
/* loaded from: classes.dex */
public class c extends com.github.ybq.android.spinkit.b.g {
    @Override // com.github.ybq.android.spinkit.b.g
    public com.github.ybq.android.spinkit.b.f[] s() {
        int[] iArr = {200, 300, 400, 100, 200, 300, 0, 100, 200};
        a[] aVarArr = new a[9];
        for (int i = 0; i < aVarArr.length; i++) {
            aVarArr[i] = new a();
            aVarArr[i].g(iArr[i]);
        }
        return aVarArr;
    }

    @Override // com.github.ybq.android.spinkit.b.g, com.github.ybq.android.spinkit.b.f, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect b = b(rect);
        int width = (int) (b.width() * 0.33f);
        int height = (int) (b.height() * 0.33f);
        for (int i = 0; i < r(); i++) {
            int i2 = b.left + ((i % 3) * width);
            int i3 = b.top + ((i / 3) * height);
            h(i).a(i2, i3, i2 + width, i3 + height);
        }
    }

    /* compiled from: source */
    private class a extends com.github.ybq.android.spinkit.b.c {
        private a() {
        }

        /* synthetic */ a(c cVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.github.ybq.android.spinkit.b.c, com.github.ybq.android.spinkit.b.f
        public ValueAnimator a() {
            float[] fArr = {0.0f, 0.35f, 0.7f, 1.0f};
            return new com.github.ybq.android.spinkit.a.d(this).a(fArr, Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(1.0f), Float.valueOf(1.0f)).a(1300L).a(fArr).a();
        }
    }
}
