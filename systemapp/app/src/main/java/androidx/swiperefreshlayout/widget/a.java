package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.h.w;

/* compiled from: source */
/* loaded from: classes.dex */
class a extends ImageView {
    int a;
    private Animation.AnimationListener b;

    a(Context context, int i) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) (1.75f * f);
        int i3 = (int) (0.0f * f);
        this.a = (int) (3.5f * f);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            w.a(this, 4.0f * f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new C0048a(this.a));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer(this.a, i3, i2, 503316480);
            int i4 = this.a;
            setPadding(i4, i4, i4, i4);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i);
        w.a(this, shapeDrawable);
    }

    private boolean a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (a()) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth() + (this.a * 2), getMeasuredHeight() + (this.a * 2));
    }

    public void a(Animation.AnimationListener animationListener) {
        this.b = animationListener;
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.b != null) {
            this.b.onAnimationStart(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.b != null) {
            this.b.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.swiperefreshlayout.widget.a$a */
    private class C0048a extends OvalShape {
        private RadialGradient b;
        private Paint c = new Paint();

        C0048a(int i) {
            a.this.a = i;
            a((int) rect().width());
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        protected void onResize(float f, float f2) {
            super.onResize(f, f2);
            a((int) f);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            float width = a.this.getWidth() / 2;
            float height = a.this.getHeight() / 2;
            canvas.drawCircle(width, height, width, this.c);
            canvas.drawCircle(width, height, r0 - a.this.a, paint);
        }

        private void a(int i) {
            float f = i / 2;
            this.b = new RadialGradient(f, f, a.this.a, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.c.setShader(this.b);
        }
    }
}
