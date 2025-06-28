package com.github.ybq.android.spinkit.c;

import android.animation.ValueAnimator;
import android.graphics.Rect;

/* compiled from: source */
/* loaded from: classes.dex */
public class m extends com.github.ybq.android.spinkit.b.g {
    @Override // com.github.ybq.android.spinkit.b.g
    public com.github.ybq.android.spinkit.b.f[] s() {
        return new com.github.ybq.android.spinkit.b.f[]{new a(), new a(), new a()};
    }

    @Override // com.github.ybq.android.spinkit.b.g
    public void a(com.github.ybq.android.spinkit.b.f... fVarArr) {
        super.a(fVarArr);
        fVarArr[1].g(160);
        fVarArr[2].g(320);
    }

    @Override // com.github.ybq.android.spinkit.b.g, com.github.ybq.android.spinkit.b.f, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect b = b(rect);
        int width = b.width() / 8;
        int centerY = b.centerY() - width;
        int centerY2 = b.centerY() + width;
        for (int i = 0; i < r(); i++) {
            int width2 = ((b.width() * i) / 3) + b.left;
            h(i).a(width2, centerY, (width * 2) + width2, centerY2);
        }
    }

    /* compiled from: source */
    private class a extends com.github.ybq.android.spinkit.b.b {
        a() {
            c(0.0f);
        }

        @Override // com.github.ybq.android.spinkit.b.b, com.github.ybq.android.spinkit.b.f
        public ValueAnimator a() {
            float[] fArr = {0.0f, 0.4f, 0.8f, 1.0f};
            return new com.github.ybq.android.spinkit.a.d(this).a(fArr, Float.valueOf(0.0f), Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(0.0f)).a(1400L).a(fArr).a();
        }
    }
}
