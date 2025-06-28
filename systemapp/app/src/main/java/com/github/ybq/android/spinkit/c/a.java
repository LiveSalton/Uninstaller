package com.github.ybq.android.spinkit.c;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.os.Build;
import android.view.animation.LinearInterpolator;

/* compiled from: source */
/* loaded from: classes.dex */
public class a extends com.github.ybq.android.spinkit.b.g {
    @Override // com.github.ybq.android.spinkit.b.g
    public com.github.ybq.android.spinkit.b.f[] s() {
        return new com.github.ybq.android.spinkit.b.f[]{new C0055a(), new C0055a()};
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

    @Override // com.github.ybq.android.spinkit.b.g, com.github.ybq.android.spinkit.b.f
    public ValueAnimator a() {
        return new com.github.ybq.android.spinkit.a.d(this).d(new float[]{0.0f, 1.0f}, 0, 360).a(2000L).a(new LinearInterpolator()).a();
    }

    @Override // com.github.ybq.android.spinkit.b.g, com.github.ybq.android.spinkit.b.f, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect b = b(rect);
        int width = (int) (b.width() * 0.6f);
        h(0).a(b.right - width, b.top, b.right, b.top + width);
        h(1).a(b.right - width, b.bottom - width, b.right, b.bottom);
    }

    /* compiled from: source */
    /* renamed from: com.github.ybq.android.spinkit.c.a$a */
    private class C0055a extends com.github.ybq.android.spinkit.b.b {
        C0055a() {
            c(0.0f);
        }

        @Override // com.github.ybq.android.spinkit.b.b, com.github.ybq.android.spinkit.b.f
        public ValueAnimator a() {
            float[] fArr = {0.0f, 0.5f, 1.0f};
            return new com.github.ybq.android.spinkit.a.d(this).a(fArr, Float.valueOf(0.0f), Float.valueOf(1.0f), Float.valueOf(0.0f)).a(2000L).a(fArr).a();
        }
    }
}
