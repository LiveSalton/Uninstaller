package com.github.ybq.android.spinkit.b;

import android.graphics.Canvas;
import android.graphics.Rect;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class a extends g {
    @Override // com.github.ybq.android.spinkit.b.g
    public void a(Canvas canvas) {
        for (int i = 0; i < r(); i++) {
            f h = h(i);
            int save = canvas.save();
            canvas.rotate((i * 360) / r(), getBounds().centerX(), getBounds().centerY());
            h.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // com.github.ybq.android.spinkit.b.g, com.github.ybq.android.spinkit.b.f, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        Rect b = b(rect);
        int width = (int) (((b.width() * 3.141592653589793d) / 3.5999999046325684d) / r());
        int centerX = b.centerX() - width;
        int centerX2 = b.centerX() + width;
        for (int i = 0; i < r(); i++) {
            h(i).a(centerX, b.top, centerX2, b.top + (width * 2));
        }
    }
}
