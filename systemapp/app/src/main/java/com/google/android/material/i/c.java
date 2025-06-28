package com.google.android.material.i;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* compiled from: source */
/* loaded from: classes.dex */
public class c extends Drawable implements androidx.core.graphics.drawable.b {
    private final Paint a;
    private final Matrix[] b;
    private final Matrix[] c;
    private final d[] d;
    private final Matrix e;
    private final Path f;
    private final PointF g;
    private final d h;
    private final Region i;
    private final Region j;
    private final float[] k;
    private final float[] l;
    private e m;
    private boolean n;
    private boolean o;
    private float p;
    private int q;
    private int r;
    private int s;
    private int t;
    private float u;
    private float v;
    private Paint.Style w;
    private PorterDuffColorFilter x;
    private PorterDuff.Mode y;
    private ColorStateList z;

    private static int a(int i, int i2) {
        return (i * (i2 + (i2 >>> 7))) >>> 8;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public c() {
        this(null);
    }

    public c(e eVar) {
        this.a = new Paint();
        this.b = new Matrix[4];
        this.c = new Matrix[4];
        this.d = new d[4];
        this.e = new Matrix();
        this.f = new Path();
        this.g = new PointF();
        this.h = new d();
        this.i = new Region();
        this.j = new Region();
        this.k = new float[2];
        this.l = new float[2];
        this.m = null;
        this.n = false;
        this.o = false;
        this.p = 1.0f;
        this.q = -16777216;
        this.r = 5;
        this.s = 10;
        this.t = 255;
        this.u = 1.0f;
        this.v = 0.0f;
        this.w = Paint.Style.FILL_AND_STROKE;
        this.y = PorterDuff.Mode.SRC_IN;
        this.z = null;
        this.m = eVar;
        for (int i = 0; i < 4; i++) {
            this.b[i] = new Matrix();
            this.c[i] = new Matrix();
            this.d[i] = new d();
        }
    }

    public ColorStateList a() {
        return this.z;
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        this.z = colorStateList;
        c();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        this.y = mode;
        c();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.t = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        Rect bounds = getBounds();
        this.i.set(bounds);
        b(bounds.width(), bounds.height(), this.f);
        this.j.setPath(this.f, this.i);
        this.i.op(this.j, Region.Op.DIFFERENCE);
        return this.i;
    }

    public void a(boolean z) {
        this.n = z;
        invalidateSelf();
    }

    public float b() {
        return this.p;
    }

    public void a(float f) {
        this.p = f;
        invalidateSelf();
    }

    public void a(Paint.Style style) {
        this.w = style;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.a.setColorFilter(this.x);
        int alpha = this.a.getAlpha();
        this.a.setAlpha(a(alpha, this.t));
        this.a.setStrokeWidth(this.v);
        this.a.setStyle(this.w);
        if (this.r > 0 && this.n) {
            this.a.setShadowLayer(this.s, 0.0f, this.r, this.q);
        }
        if (this.m != null) {
            b(canvas.getWidth(), canvas.getHeight(), this.f);
            canvas.drawPath(this.f, this.a);
        } else {
            canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.a);
        }
        this.a.setAlpha(alpha);
    }

    public void a(int i, int i2, Path path) {
        path.rewind();
        if (this.m == null) {
            return;
        }
        for (int i3 = 0; i3 < 4; i3++) {
            a(i3, i, i2);
            b(i3, i, i2);
        }
        for (int i4 = 0; i4 < 4; i4++) {
            a(i4, path);
            b(i4, path);
        }
        path.close();
    }

    private void a(int i, int i2, int i3) {
        a(i, i2, i3, this.g);
        a(i).a(c(i, i2, i3), this.p, this.d[i]);
        float d = d(((i - 1) + 4) % 4, i2, i3) + 1.5707964f;
        this.b[i].reset();
        this.b[i].setTranslate(this.g.x, this.g.y);
        this.b[i].preRotate((float) Math.toDegrees(d));
    }

    private void b(int i, int i2, int i3) {
        this.k[0] = this.d[i].c;
        this.k[1] = this.d[i].d;
        this.b[i].mapPoints(this.k);
        float d = d(i, i2, i3);
        this.c[i].reset();
        this.c[i].setTranslate(this.k[0], this.k[1]);
        this.c[i].preRotate((float) Math.toDegrees(d));
    }

    private void a(int i, Path path) {
        this.k[0] = this.d[i].a;
        this.k[1] = this.d[i].b;
        this.b[i].mapPoints(this.k);
        if (i == 0) {
            path.moveTo(this.k[0], this.k[1]);
        } else {
            path.lineTo(this.k[0], this.k[1]);
        }
        this.d[i].a(this.b[i], path);
    }

    private void b(int i, Path path) {
        int i2 = (i + 1) % 4;
        this.k[0] = this.d[i].c;
        this.k[1] = this.d[i].d;
        this.b[i].mapPoints(this.k);
        this.l[0] = this.d[i2].a;
        this.l[1] = this.d[i2].b;
        this.b[i2].mapPoints(this.l);
        float hypot = (float) Math.hypot(this.k[0] - this.l[0], this.k[1] - this.l[1]);
        this.h.a(0.0f, 0.0f);
        b(i).a(hypot, this.p, this.h);
        this.h.a(this.c[i], path);
    }

    private a a(int i) {
        switch (i) {
            case 1:
                return this.m.b();
            case 2:
                return this.m.c();
            case 3:
                return this.m.d();
            default:
                return this.m.a();
        }
    }

    private b b(int i) {
        switch (i) {
            case 1:
                return this.m.f();
            case 2:
                return this.m.g();
            case 3:
                return this.m.h();
            default:
                return this.m.e();
        }
    }

    private void a(int i, int i2, int i3, PointF pointF) {
        switch (i) {
            case 1:
                pointF.set(i2, 0.0f);
                break;
            case 2:
                pointF.set(i2, i3);
                break;
            case 3:
                pointF.set(0.0f, i3);
                break;
            default:
                pointF.set(0.0f, 0.0f);
                break;
        }
    }

    private float c(int i, int i2, int i3) {
        a(((i - 1) + 4) % 4, i2, i3, this.g);
        float f = this.g.x;
        float f2 = this.g.y;
        a((i + 1) % 4, i2, i3, this.g);
        float f3 = this.g.x;
        float f4 = this.g.y;
        a(i, i2, i3, this.g);
        float f5 = this.g.x;
        float f6 = this.g.y;
        float atan2 = ((float) Math.atan2(f2 - f6, f - f5)) - ((float) Math.atan2(f4 - f6, f3 - f5));
        return atan2 < 0.0f ? (float) (atan2 + 6.283185307179586d) : atan2;
    }

    private float d(int i, int i2, int i3) {
        int i4 = (i + 1) % 4;
        a(i, i2, i3, this.g);
        float f = this.g.x;
        float f2 = this.g.y;
        a(i4, i2, i3, this.g);
        return (float) Math.atan2(this.g.y - f2, this.g.x - f);
    }

    private void b(int i, int i2, Path path) {
        a(i, i2, path);
        if (this.u == 1.0f) {
            return;
        }
        this.e.reset();
        this.e.setScale(this.u, this.u, i / 2, i2 / 2);
        path.transform(this.e);
    }

    private void c() {
        if (this.z == null || this.y == null) {
            this.x = null;
            return;
        }
        int colorForState = this.z.getColorForState(getState(), 0);
        this.x = new PorterDuffColorFilter(colorForState, this.y);
        if (this.o) {
            this.q = colorForState;
        }
    }
}
