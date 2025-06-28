package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.google.android.material.circularreveal.c;

/* compiled from: source */
/* loaded from: classes.dex */
public class b {
    public static final int a;
    private final a b;
    private final View c;
    private final Path d;
    private final Paint e;
    private final Paint f;
    private c.d g;
    private Drawable h;
    private boolean i;
    private boolean j;

    /* compiled from: source */
    public interface a {
        void a(Canvas canvas);

        boolean c();
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            a = 2;
        } else if (Build.VERSION.SDK_INT >= 18) {
            a = 1;
        } else {
            a = 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(a aVar) {
        this.b = aVar;
        this.c = (View) aVar;
        this.c.setWillNotDraw(false);
        this.d = new Path();
        this.e = new Paint(7);
        this.f = new Paint(1);
        this.f.setColor(0);
    }

    public void a() {
        if (a == 0) {
            this.i = true;
            this.j = false;
            this.c.buildDrawingCache();
            Bitmap drawingCache = this.c.getDrawingCache();
            if (drawingCache == null && this.c.getWidth() != 0 && this.c.getHeight() != 0) {
                drawingCache = Bitmap.createBitmap(this.c.getWidth(), this.c.getHeight(), Bitmap.Config.ARGB_8888);
                this.c.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                this.e.setShader(new BitmapShader(drawingCache, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            }
            this.i = false;
            this.j = true;
        }
    }

    public void b() {
        if (a == 0) {
            this.j = false;
            this.c.destroyDrawingCache();
            this.e.setShader(null);
            this.c.invalidate();
        }
    }

    public void a(c.d dVar) {
        if (dVar == null) {
            this.g = null;
        } else {
            if (this.g == null) {
                this.g = new c.d(dVar);
            } else {
                this.g.a(dVar);
            }
            if (com.google.android.material.e.a.b(dVar.c, b(dVar), 1.0E-4f)) {
                this.g.c = Float.MAX_VALUE;
            }
        }
        g();
    }

    public c.d c() {
        if (this.g == null) {
            return null;
        }
        c.d dVar = new c.d(this.g);
        if (dVar.a()) {
            dVar.c = b(dVar);
        }
        return dVar;
    }

    public void a(int i) {
        this.f.setColor(i);
        this.c.invalidate();
    }

    public int d() {
        return this.f.getColor();
    }

    public Drawable e() {
        return this.h;
    }

    public void a(Drawable drawable) {
        this.h = drawable;
        this.c.invalidate();
    }

    private void g() {
        if (a == 1) {
            this.d.rewind();
            if (this.g != null) {
                this.d.addCircle(this.g.a, this.g.b, this.g.c, Path.Direction.CW);
            }
        }
        this.c.invalidate();
    }

    private float b(c.d dVar) {
        return com.google.android.material.e.a.a(dVar.a, dVar.b, 0.0f, 0.0f, this.c.getWidth(), this.c.getHeight());
    }

    public void a(Canvas canvas) {
        if (h()) {
            switch (a) {
                case 0:
                    canvas.drawCircle(this.g.a, this.g.b, this.g.c, this.e);
                    if (i()) {
                        canvas.drawCircle(this.g.a, this.g.b, this.g.c, this.f);
                        break;
                    }
                    break;
                case 1:
                    int save = canvas.save();
                    canvas.clipPath(this.d);
                    this.b.a(canvas);
                    if (i()) {
                        canvas.drawRect(0.0f, 0.0f, this.c.getWidth(), this.c.getHeight(), this.f);
                    }
                    canvas.restoreToCount(save);
                    break;
                case 2:
                    this.b.a(canvas);
                    if (i()) {
                        canvas.drawRect(0.0f, 0.0f, this.c.getWidth(), this.c.getHeight(), this.f);
                        break;
                    }
                    break;
                default:
                    throw new IllegalStateException("Unsupported strategy " + a);
            }
        } else {
            this.b.a(canvas);
            if (i()) {
                canvas.drawRect(0.0f, 0.0f, this.c.getWidth(), this.c.getHeight(), this.f);
            }
        }
        b(canvas);
    }

    private void b(Canvas canvas) {
        if (j()) {
            Rect bounds = this.h.getBounds();
            float width = this.g.a - (bounds.width() / 2.0f);
            float height = this.g.b - (bounds.height() / 2.0f);
            canvas.translate(width, height);
            this.h.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    public boolean f() {
        return this.b.c() && !h();
    }

    private boolean h() {
        boolean z = this.g == null || this.g.a();
        return a == 0 ? !z && this.j : !z;
    }

    private boolean i() {
        return (this.i || Color.alpha(this.f.getColor()) == 0) ? false : true;
    }

    private boolean j() {
        return (this.i || this.h == null || this.g == null) ? false : true;
    }
}
