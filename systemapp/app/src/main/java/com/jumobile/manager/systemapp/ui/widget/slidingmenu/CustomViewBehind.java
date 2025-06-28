package com.jumobile.manager.systemapp.ui.widget.slidingmenu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.jumobile.manager.systemapp.R;
import com.jumobile.manager.systemapp.ui.widget.slidingmenu.SlidingMenu;

/* compiled from: source */
/* loaded from: classes.dex */
public class CustomViewBehind extends ViewGroup {
    private int a;
    private CustomViewAbove b;
    private View c;
    private View d;
    private int e;
    private int f;
    private SlidingMenu.a g;
    private boolean h;
    private int i;
    private boolean j;
    private final Paint k;
    private float l;
    private Drawable m;
    private Drawable n;
    private int o;
    private float p;
    private boolean q;
    private Bitmap r;
    private View s;

    public CustomViewBehind(Context context) {
        this(context, null);
    }

    public CustomViewBehind(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.k = new Paint();
        this.q = true;
        this.e = (int) TypedValue.applyDimension(1, 48.0f, getResources().getDisplayMetrics());
    }

    public void setCustomViewAbove(CustomViewAbove customViewAbove) {
        this.b = customViewAbove;
    }

    public void setCanvasTransformer(SlidingMenu.a aVar) {
        this.g = aVar;
    }

    public void setWidthOffset(int i) {
        this.f = i;
        requestLayout();
    }

    public void setMarginThreshold(int i) {
        this.e = i;
    }

    public int getMarginThreshold() {
        return this.e;
    }

    public int getBehindWidth() {
        return this.c.getWidth();
    }

    public void setContent(View view) {
        if (this.c != null) {
            removeView(this.c);
        }
        this.c = view;
        addView(this.c);
    }

    public View getContent() {
        return this.c;
    }

    public void setSecondaryContent(View view) {
        if (this.d != null) {
            removeView(this.d);
        }
        this.d = view;
        addView(this.d);
    }

    public View getSecondaryContent() {
        return this.d;
    }

    public void setChildrenEnabled(boolean z) {
        this.h = z;
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
        if (this.g != null) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return !this.h;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return !this.h;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.g != null) {
            canvas.save();
            this.g.a(canvas, this.b.getPercentOpen());
            super.dispatchDraw(canvas);
            canvas.restore();
            return;
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.c.layout(0, 0, i5 - this.f, i6);
        if (this.d != null) {
            this.d.layout(0, 0, i5 - this.f, i6);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(0, i);
        int defaultSize2 = getDefaultSize(0, i2);
        setMeasuredDimension(defaultSize, defaultSize2);
        int childMeasureSpec = getChildMeasureSpec(i, 0, defaultSize - this.f);
        int childMeasureSpec2 = getChildMeasureSpec(i2, 0, defaultSize2);
        this.c.measure(childMeasureSpec, childMeasureSpec2);
        if (this.d != null) {
            this.d.measure(childMeasureSpec, childMeasureSpec2);
        }
    }

    public void setMode(int i) {
        if (i == 0 || i == 1) {
            if (this.c != null) {
                this.c.setVisibility(0);
            }
            if (this.d != null) {
                this.d.setVisibility(4);
            }
        }
        this.i = i;
    }

    public int getMode() {
        return this.i;
    }

    public void setScrollScale(float f) {
        this.l = f;
    }

    public float getScrollScale() {
        return this.l;
    }

    public void setShadowDrawable(Drawable drawable) {
        this.m = drawable;
        invalidate();
    }

    public void setSecondaryShadowDrawable(Drawable drawable) {
        this.n = drawable;
        invalidate();
    }

    public void setShadowWidth(int i) {
        this.o = i;
        invalidate();
    }

    public void setFadeEnabled(boolean z) {
        this.j = z;
    }

    public void setFadeDegree(float f) {
        if (f > 1.0f || f < 0.0f) {
            throw new IllegalStateException("The BehindFadeDegree must be between 0.0f and 1.0f");
        }
        this.p = f;
    }

    public int a(int i) {
        if (i > 1) {
            i = 2;
        } else if (i < 1) {
            i = 0;
        }
        if (this.i == 0 && i > 1) {
            return 0;
        }
        if (this.i != 1 || i >= 1) {
            return i;
        }
        return 2;
    }

    public void a(View view, int i, int i2) {
        if (this.i == 0) {
            r1 = i >= view.getLeft() ? 4 : 0;
            scrollTo((int) ((i + getBehindWidth()) * this.l), i2);
        } else if (this.i == 1) {
            r1 = i <= view.getLeft() ? 4 : 0;
            scrollTo((int) ((getBehindWidth() - getWidth()) + ((i - getBehindWidth()) * this.l)), i2);
        } else if (this.i == 2) {
            this.c.setVisibility(i >= view.getLeft() ? 4 : 0);
            this.d.setVisibility(i <= view.getLeft() ? 4 : 0);
            r1 = i == 0 ? 4 : 0;
            if (i <= view.getLeft()) {
                scrollTo((int) ((i + getBehindWidth()) * this.l), i2);
            } else {
                scrollTo((int) ((getBehindWidth() - getWidth()) + ((i - getBehindWidth()) * this.l)), i2);
            }
        }
        if (r1 == 4) {
            Log.v("CustomViewBehind", "behind INVISIBLE");
        }
        setVisibility(r1);
    }

    public int a(View view, int i) {
        if (this.i == 0) {
            if (i == 0) {
                return view.getLeft() - getBehindWidth();
            }
            if (i == 2) {
                return view.getLeft();
            }
        } else if (this.i == 1) {
            if (i == 0) {
                return view.getLeft();
            }
            if (i == 2) {
                return view.getLeft() + getBehindWidth();
            }
        } else if (this.i == 2) {
            if (i == 0) {
                return view.getLeft() - getBehindWidth();
            }
            if (i == 2) {
                return view.getLeft() + getBehindWidth();
            }
        }
        return view.getLeft();
    }

    public int a(View view) {
        if (this.i == 0 || this.i == 2) {
            return view.getLeft() - getBehindWidth();
        }
        if (this.i == 1) {
            return view.getLeft();
        }
        return 0;
    }

    public int b(View view) {
        if (this.i == 0) {
            return view.getLeft();
        }
        if (this.i == 1 || this.i == 2) {
            return view.getLeft() + getBehindWidth();
        }
        return 0;
    }

    public boolean b(View view, int i) {
        int left = view.getLeft();
        int right = view.getRight();
        if (this.i == 0) {
            return i >= left && i <= this.e + left;
        }
        if (this.i == 1) {
            return i <= right && i >= right - this.e;
        }
        if (this.i == 2) {
            return (i >= left && i <= this.e + left) || (i <= right && i >= right - this.e);
        }
        return false;
    }

    public void setTouchMode(int i) {
        this.a = i;
    }

    public boolean a(View view, int i, float f) {
        switch (this.a) {
            case 0:
                return b(view, i, f);
            case 1:
                return true;
            default:
                return false;
        }
    }

    public boolean b(View view, int i, float f) {
        return (this.i == 0 || (this.i == 2 && i == 0)) ? f >= ((float) view.getLeft()) : (this.i == 1 || (this.i == 2 && i == 2)) && f <= ((float) view.getRight());
    }

    public boolean a(float f) {
        return this.i == 0 ? f > 0.0f : this.i == 1 ? f < 0.0f : this.i == 2;
    }

    public boolean b(float f) {
        return this.i == 0 ? f < 0.0f : this.i == 1 ? f > 0.0f : this.i == 2;
    }

    public void a(View view, Canvas canvas) {
        int i;
        if (this.m == null || this.o <= 0) {
            return;
        }
        if (this.i == 0) {
            i = view.getLeft() - this.o;
        } else if (this.i == 1) {
            i = view.getRight();
        } else if (this.i == 2) {
            if (this.n != null) {
                int right = view.getRight();
                this.n.setBounds(right, 0, this.o + right, getHeight());
                this.n.draw(canvas);
            }
            i = view.getLeft() - this.o;
        } else {
            i = 0;
        }
        this.m.setBounds(i, 0, this.o + i, getHeight());
        this.m.draw(canvas);
    }

    public void a(View view, Canvas canvas, float f) {
        int i;
        if (this.j) {
            int i2 = 0;
            this.k.setColor(Color.argb((int) (this.p * 255.0f * Math.abs(1.0f - f)), 0, 0, 0));
            if (this.i == 0) {
                i2 = view.getLeft() - getBehindWidth();
                i = view.getLeft();
            } else if (this.i == 1) {
                i2 = view.getRight();
                i = view.getRight() + getBehindWidth();
            } else if (this.i == 2) {
                canvas.drawRect(view.getLeft() - getBehindWidth(), 0.0f, view.getLeft(), getHeight(), this.k);
                i2 = view.getRight();
                i = view.getRight() + getBehindWidth();
            } else {
                i = 0;
            }
            canvas.drawRect(i2, 0.0f, i, getHeight(), this.k);
        }
    }

    public void b(View view, Canvas canvas, float f) {
        if (this.q && this.r != null && this.s != null && ((String) this.s.getTag(R.id.selected_view)).equals("CustomViewBehindSelectedView")) {
            canvas.save();
            int width = (int) (this.r.getWidth() * f);
            if (this.i == 0) {
                int left = view.getLeft();
                int i = left - width;
                canvas.clipRect(i, 0, left, getHeight());
                canvas.drawBitmap(this.r, i, getSelectorTop(), (Paint) null);
            } else if (this.i == 1) {
                int right = view.getRight();
                canvas.clipRect(right, 0, width + right, getHeight());
                canvas.drawBitmap(this.r, r7 - this.r.getWidth(), getSelectorTop(), (Paint) null);
            }
            canvas.restore();
        }
    }

    public void setSelectorEnabled(boolean z) {
        this.q = z;
    }

    public void setSelectedView(View view) {
        if (this.s != null) {
            this.s.setTag(R.id.selected_view, null);
            this.s = null;
        }
        if (view == null || view.getParent() == null) {
            return;
        }
        this.s = view;
        this.s.setTag(R.id.selected_view, "CustomViewBehindSelectedView");
        invalidate();
    }

    private int getSelectorTop() {
        return this.s.getTop() + ((this.s.getHeight() - this.r.getHeight()) / 2);
    }

    public void setSelectorBitmap(Bitmap bitmap) {
        this.r = bitmap;
        refreshDrawableState();
    }
}
