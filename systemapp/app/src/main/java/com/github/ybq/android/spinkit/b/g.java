package com.github.ybq.android.spinkit.b;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class g extends f {
    private f[] m = s();
    private int n;

    @Override // com.github.ybq.android.spinkit.b.f
    public ValueAnimator a() {
        return null;
    }

    public void a(f... fVarArr) {
    }

    @Override // com.github.ybq.android.spinkit.b.f
    protected void a_(Canvas canvas) {
    }

    public abstract f[] s();

    public g() {
        t();
        a(this.m);
    }

    private void t() {
        if (this.m != null) {
            for (f fVar : this.m) {
                fVar.setCallback(this);
            }
        }
    }

    public int r() {
        if (this.m == null) {
            return 0;
        }
        return this.m.length;
    }

    public f h(int i) {
        if (this.m == null) {
            return null;
        }
        return this.m[i];
    }

    @Override // com.github.ybq.android.spinkit.b.f
    public void a(int i) {
        this.n = i;
        for (int i2 = 0; i2 < r(); i2++) {
            h(i2).a(i);
        }
    }

    @Override // com.github.ybq.android.spinkit.b.f
    public int b() {
        return this.n;
    }

    @Override // com.github.ybq.android.spinkit.b.f, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        super.draw(canvas);
        a(canvas);
    }

    public void a(Canvas canvas) {
        if (this.m != null) {
            for (f fVar : this.m) {
                int save = canvas.save();
                fVar.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
    }

    @Override // com.github.ybq.android.spinkit.b.f, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        for (f fVar : this.m) {
            fVar.setBounds(rect);
        }
    }

    @Override // com.github.ybq.android.spinkit.b.f, android.graphics.drawable.Animatable
    public void start() {
        super.start();
        com.github.ybq.android.spinkit.a.a.a(this.m);
    }

    @Override // com.github.ybq.android.spinkit.b.f, android.graphics.drawable.Animatable
    public void stop() {
        super.stop();
        com.github.ybq.android.spinkit.a.a.b(this.m);
    }

    @Override // com.github.ybq.android.spinkit.b.f, android.graphics.drawable.Animatable
    public boolean isRunning() {
        return com.github.ybq.android.spinkit.a.a.c(this.m) || super.isRunning();
    }
}
