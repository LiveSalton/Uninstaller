package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;

/* compiled from: source */
/* loaded from: classes.dex */
public class PagerTabStrip extends PagerTitleStrip {
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private final Paint m;
    private final Rect n;
    private int o;
    private boolean p;
    private boolean q;
    private int r;
    private boolean s;
    private float t;
    private float u;
    private int v;

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = new Paint();
        this.n = new Rect();
        this.o = 255;
        this.p = false;
        this.q = false;
        this.g = this.f;
        this.m.setColor(this.g);
        float f = context.getResources().getDisplayMetrics().density;
        this.h = (int) ((3.0f * f) + 0.5f);
        this.i = (int) ((6.0f * f) + 0.5f);
        this.j = (int) (64.0f * f);
        this.l = (int) ((16.0f * f) + 0.5f);
        this.r = (int) ((1.0f * f) + 0.5f);
        this.k = (int) ((32.0f * f) + 0.5f);
        this.v = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.b.setFocusable(true);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: androidx.viewpager.widget.PagerTabStrip.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PagerTabStrip.this.a.setCurrentItem(PagerTabStrip.this.a.getCurrentItem() - 1);
            }
        });
        this.d.setFocusable(true);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: androidx.viewpager.widget.PagerTabStrip.2
            AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PagerTabStrip.this.a.setCurrentItem(PagerTabStrip.this.a.getCurrentItem() + 1);
            }
        });
        if (getBackground() == null) {
            this.p = true;
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.viewpager.widget.PagerTabStrip$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PagerTabStrip.this.a.setCurrentItem(PagerTabStrip.this.a.getCurrentItem() - 1);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.viewpager.widget.PagerTabStrip$2 */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PagerTabStrip.this.a.setCurrentItem(PagerTabStrip.this.a.getCurrentItem() + 1);
        }
    }

    public void setTabIndicatorColor(int i) {
        this.g = i;
        this.m.setColor(this.g);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i) {
        setTabIndicatorColor(androidx.core.content.a.c(getContext(), i));
    }

    public int getTabIndicatorColor() {
        return this.g;
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        if (i4 < this.i) {
            i4 = this.i;
        }
        super.setPadding(i, i2, i3, i4);
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int i) {
        if (i < this.j) {
            i = this.j;
        }
        super.setTextSpacing(i);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.q) {
            return;
        }
        this.p = drawable == null;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (this.q) {
            return;
        }
        this.p = (i & (-16777216)) == 0;
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.q) {
            return;
        }
        this.p = i == 0;
    }

    public void setDrawFullUnderline(boolean z) {
        this.p = z;
        this.q = true;
        invalidate();
    }

    public boolean getDrawFullUnderline() {
        return this.p;
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    int getMinHeight() {
        return Math.max(super.getMinHeight(), this.k);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0074, code lost:
    
        return true;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getAction()
            r1 = 0
            if (r0 == 0) goto Lc
            boolean r2 = r4.s
            if (r2 == 0) goto Lc
            return r1
        Lc:
            float r2 = r5.getX()
            float r5 = r5.getY()
            r3 = 1
            switch(r0) {
                case 0: goto L6e;
                case 1: goto L38;
                case 2: goto L19;
                default: goto L18;
            }
        L18:
            goto L74
        L19:
            float r0 = r4.t
            float r2 = r2 - r0
            float r0 = java.lang.Math.abs(r2)
            int r1 = r4.v
            float r1 = (float) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L35
            float r0 = r4.u
            float r5 = r5 - r0
            float r5 = java.lang.Math.abs(r5)
            int r0 = r4.v
            float r0 = (float) r0
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 <= 0) goto L74
        L35:
            r4.s = r3
            goto L74
        L38:
            android.widget.TextView r5 = r4.c
            int r5 = r5.getLeft()
            int r0 = r4.l
            int r5 = r5 - r0
            float r5 = (float) r5
            int r5 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r5 >= 0) goto L53
            androidx.viewpager.widget.ViewPager r5 = r4.a
            androidx.viewpager.widget.ViewPager r0 = r4.a
            int r0 = r0.getCurrentItem()
            int r0 = r0 - r3
            r5.setCurrentItem(r0)
            goto L74
        L53:
            android.widget.TextView r5 = r4.c
            int r5 = r5.getRight()
            int r0 = r4.l
            int r5 = r5 + r0
            float r5 = (float) r5
            int r5 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r5 <= 0) goto L74
            androidx.viewpager.widget.ViewPager r5 = r4.a
            androidx.viewpager.widget.ViewPager r0 = r4.a
            int r0 = r0.getCurrentItem()
            int r0 = r0 + r3
            r5.setCurrentItem(r0)
            goto L74
        L6e:
            r4.t = r2
            r4.u = r5
            r4.s = r1
        L74:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.PagerTabStrip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.c.getLeft() - this.l;
        int right = this.c.getRight() + this.l;
        int i = height - this.h;
        this.m.setColor((this.o << 24) | (this.g & 16777215));
        float f = height;
        canvas.drawRect(left, i, right, f, this.m);
        if (this.p) {
            this.m.setColor((-16777216) | (this.g & 16777215));
            canvas.drawRect(getPaddingLeft(), height - this.r, getWidth() - getPaddingRight(), f, this.m);
        }
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    void a(int i, float f, boolean z) {
        Rect rect = this.n;
        int height = getHeight();
        int left = this.c.getLeft() - this.l;
        int right = this.c.getRight() + this.l;
        int i2 = height - this.h;
        rect.set(left, i2, right, height);
        super.a(i, f, z);
        this.o = (int) (Math.abs(f - 0.5f) * 2.0f * 255.0f);
        rect.union(this.c.getLeft() - this.l, i2, this.c.getRight() + this.l, height);
        invalidate(rect);
    }
}
