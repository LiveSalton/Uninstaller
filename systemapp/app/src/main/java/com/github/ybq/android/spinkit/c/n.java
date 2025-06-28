package com.github.ybq.android.spinkit.c;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.os.Build;

/* compiled from: source */
/* loaded from: classes.dex */
public class n extends com.github.ybq.android.spinkit.b.g {
    @Override // com.github.ybq.android.spinkit.b.g
    public com.github.ybq.android.spinkit.b.f[] s() {
        return new com.github.ybq.android.spinkit.b.f[]{new a(0), new a(3)};
    }

    @Override // com.github.ybq.android.spinkit.b.g
    public void a(com.github.ybq.android.spinkit.b.f... fVarArr) {
        super.a(fVarArr);
        if (Build.VERSION.SDK_INT < 24) {
            fVarArr[1].g(-900);
        }
    }

    @Override // com.github.ybq.android.spinkit.b.g, com.github.ybq.android.spinkit.b.f, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Rect b = b(rect);
        super.onBoundsChange(b);
        for (int i = 0; i < r(); i++) {
            h(i).a(b.left, b.top, b.left + (b.width() / 4), b.top + (b.height() / 4));
        }
    }

    /* compiled from: source */
    private class a extends com.github.ybq.android.spinkit.b.c {
        int m;

        public a(int i) {
            this.m = i;
        }

        @Override // com.github.ybq.android.spinkit.b.c, com.github.ybq.android.spinkit.b.f
        public ValueAnimator a() {
            float[] fArr = {0.0f, 0.25f, 0.5f, 0.51f, 0.75f, 1.0f};
            com.github.ybq.android.spinkit.a.d a = new com.github.ybq.android.spinkit.a.d(this).d(fArr, 0, -90, -179, -180, -270, -360).c(fArr, Float.valueOf(0.0f), Float.valueOf(0.75f), Float.valueOf(0.75f), Float.valueOf(0.75f), Float.valueOf(0.0f), Float.valueOf(0.0f)).d(fArr, Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.75f), Float.valueOf(0.75f), Float.valueOf(0.75f), Float.valueOf(0.0f)).a(fArr, Float.valueOf(1.0f), Float.valueOf(0.5f), Float.valueOf(1.0f), Float.valueOf(1.0f), Float.valueOf(0.5f), Float.valueOf(1.0f)).a(1800L).a(fArr);
            if (Build.VERSION.SDK_INT >= 24) {
                a.a(this.m);
            }
            return a.a();
        }
    }
}
