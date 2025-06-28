package com.github.ybq.android.spinkit.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class e extends f {
    private Paint m;
    private int n;
    private int o;

    public abstract void a(Canvas canvas, Paint paint);

    public e() {
        a(-1);
        this.m = new Paint();
        this.m.setAntiAlias(true);
        this.m.setColor(this.n);
    }

    @Override // com.github.ybq.android.spinkit.b.f
    public void a(int i) {
        this.o = i;
        r();
    }

    @Override // com.github.ybq.android.spinkit.b.f
    public int b() {
        return this.o;
    }

    @Override // com.github.ybq.android.spinkit.b.f, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        super.setAlpha(i);
        r();
    }

    private void r() {
        int alpha = getAlpha();
        this.n = ((((this.o >>> 24) * (alpha + (alpha >> 7))) >> 8) << 24) | ((this.o << 8) >>> 8);
    }

    @Override // com.github.ybq.android.spinkit.b.f, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.m.setColorFilter(colorFilter);
    }

    @Override // com.github.ybq.android.spinkit.b.f
    protected final void a_(Canvas canvas) {
        this.m.setColor(this.n);
        a(canvas, this.m);
    }
}
