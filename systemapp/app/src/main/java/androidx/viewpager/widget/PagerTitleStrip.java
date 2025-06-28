package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.core.widget.i;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* compiled from: source */
@ViewPager.a
/* loaded from: classes.dex */
public class PagerTitleStrip extends ViewGroup {
    private static final int[] n = {R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};
    private static final int[] o = {R.attr.textAllCaps};
    ViewPager a;
    TextView b;
    TextView c;
    TextView d;
    float e;
    int f;
    private int g;
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private final a l;
    private WeakReference<androidx.viewpager.widget.a> m;
    private int p;

    /* compiled from: source */
    private static class b extends SingleLineTransformationMethod {
        private Locale a;

        b(Context context) {
            this.a = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.a);
            }
            return null;
        }
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new b(textView.getContext()));
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = -1;
        this.e = -1.0f;
        this.l = new a();
        TextView textView = new TextView(context);
        this.b = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.c = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.d = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, n);
        boolean z = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            i.a(this.b, resourceId);
            i.a(this.c, resourceId);
            i.a(this.d, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            a(0, dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.b.setTextColor(color);
            this.c.setTextColor(color);
            this.d.setTextColor(color);
        }
        this.i = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.f = this.c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, o);
            z = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z) {
            setSingleLineAllCaps(this.b);
            setSingleLineAllCaps(this.c);
            setSingleLineAllCaps(this.d);
        } else {
            this.b.setSingleLine();
            this.c.setSingleLine();
            this.d.setSingleLine();
        }
        this.h = (int) (16.0f * context.getResources().getDisplayMetrics().density);
    }

    public void setTextSpacing(int i) {
        this.h = i;
        requestLayout();
    }

    public int getTextSpacing() {
        return this.h;
    }

    public void setNonPrimaryAlpha(float f) {
        this.p = ((int) (f * 255.0f)) & 255;
        int i = (this.p << 24) | (this.f & 16777215);
        this.b.setTextColor(i);
        this.d.setTextColor(i);
    }

    public void setTextColor(int i) {
        this.f = i;
        this.c.setTextColor(i);
        int i2 = (this.p << 24) | (this.f & 16777215);
        this.b.setTextColor(i2);
        this.d.setTextColor(i2);
    }

    public void a(int i, float f) {
        this.b.setTextSize(i, f);
        this.c.setTextSize(i, f);
        this.d.setTextSize(i, f);
    }

    public void setGravity(int i) {
        this.i = i;
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        ViewPager viewPager = (ViewPager) parent;
        androidx.viewpager.widget.a adapter = viewPager.getAdapter();
        viewPager.c(this.l);
        viewPager.a((ViewPager.d) this.l);
        this.a = viewPager;
        a(this.m != null ? this.m.get() : null, adapter);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null) {
            a(this.a.getAdapter(), (androidx.viewpager.widget.a) null);
            this.a.c((ViewPager.e) null);
            this.a.b((ViewPager.d) this.l);
            this.a = null;
        }
    }

    void a(int i, androidx.viewpager.widget.a aVar) {
        int a2 = aVar != null ? aVar.a() : 0;
        this.j = true;
        CharSequence charSequence = null;
        this.b.setText((i < 1 || aVar == null) ? null : aVar.a(i - 1));
        this.c.setText((aVar == null || i >= a2) ? null : aVar.a(i));
        int i2 = i + 1;
        if (i2 < a2 && aVar != null) {
            charSequence = aVar.a(i2);
        }
        this.d.setText(charSequence);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.b.measure(makeMeasureSpec, makeMeasureSpec2);
        this.c.measure(makeMeasureSpec, makeMeasureSpec2);
        this.d.measure(makeMeasureSpec, makeMeasureSpec2);
        this.g = i;
        if (!this.k) {
            a(i, this.e, false);
        }
        this.j = false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.j) {
            return;
        }
        super.requestLayout();
    }

    void a(androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
        if (aVar != null) {
            aVar.b(this.l);
            this.m = null;
        }
        if (aVar2 != null) {
            aVar2.a((DataSetObserver) this.l);
            this.m = new WeakReference<>(aVar2);
        }
        if (this.a != null) {
            this.g = -1;
            this.e = -1.0f;
            a(this.a.getCurrentItem(), aVar2);
            requestLayout();
        }
    }

    void a(int i, float f, boolean z) {
        int i2;
        int i3;
        int i4;
        if (i != this.g) {
            a(i, this.a.getAdapter());
        } else if (!z && f == this.e) {
            return;
        }
        this.k = true;
        int measuredWidth = this.b.getMeasuredWidth();
        int measuredWidth2 = this.c.getMeasuredWidth();
        int measuredWidth3 = this.d.getMeasuredWidth();
        int i5 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i6 = paddingRight + i5;
        int i7 = (width - (paddingLeft + i5)) - i6;
        float f2 = 0.5f + f;
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        }
        int i8 = ((width - i6) - ((int) (i7 * f2))) - i5;
        int i9 = measuredWidth2 + i8;
        int baseline = this.b.getBaseline();
        int baseline2 = this.c.getBaseline();
        int baseline3 = this.d.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i10 = max - baseline;
        int i11 = max - baseline2;
        int i12 = max - baseline3;
        int max2 = Math.max(Math.max(this.b.getMeasuredHeight() + i10, this.c.getMeasuredHeight() + i11), this.d.getMeasuredHeight() + i12);
        int i13 = this.i & 112;
        if (i13 == 16) {
            int i14 = (((height - paddingTop) - paddingBottom) - max2) / 2;
            i2 = i10 + i14;
            i3 = i11 + i14;
            i4 = i14 + i12;
        } else if (i13 != 80) {
            i2 = i10 + paddingTop;
            i3 = i11 + paddingTop;
            i4 = paddingTop + i12;
        } else {
            int i15 = (height - paddingBottom) - max2;
            i2 = i10 + i15;
            i3 = i11 + i15;
            i4 = i15 + i12;
        }
        this.c.layout(i8, i3, i9, this.c.getMeasuredHeight() + i3);
        int min = Math.min(paddingLeft, (i8 - this.h) - measuredWidth);
        this.b.layout(min, i2, measuredWidth + min, this.b.getMeasuredHeight() + i2);
        int max3 = Math.max((width - paddingRight) - measuredWidth3, i9 + this.h);
        this.d.layout(max3, i4, max3 + measuredWidth3, this.d.getMeasuredHeight() + i4);
        this.e = f;
        this.k = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int max;
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int size = View.MeasureSpec.getSize(i);
        int childMeasureSpec2 = getChildMeasureSpec(i, (int) (size * 0.2f), -2);
        this.b.measure(childMeasureSpec2, childMeasureSpec);
        this.c.measure(childMeasureSpec2, childMeasureSpec);
        this.d.measure(childMeasureSpec2, childMeasureSpec);
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            max = View.MeasureSpec.getSize(i2);
        } else {
            max = Math.max(getMinHeight(), this.c.getMeasuredHeight() + paddingTop);
        }
        setMeasuredDimension(size, View.resolveSizeAndState(max, i2, this.c.getMeasuredState() << 16));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.a != null) {
            a(this.g, this.e >= 0.0f ? this.e : 0.0f, true);
        }
    }

    int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    /* compiled from: source */
    private class a extends DataSetObserver implements ViewPager.d, ViewPager.e {
        private int b;

        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void a(int i, float f, int i2) {
            if (f > 0.5f) {
                i++;
            }
            PagerTitleStrip.this.a(i, f, false);
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void a(int i) {
            if (this.b == 0) {
                PagerTitleStrip.this.a(PagerTitleStrip.this.a.getCurrentItem(), PagerTitleStrip.this.a.getAdapter());
                PagerTitleStrip.this.a(PagerTitleStrip.this.a.getCurrentItem(), PagerTitleStrip.this.e >= 0.0f ? PagerTitleStrip.this.e : 0.0f, true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void b(int i) {
            this.b = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.d
        public void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2) {
            PagerTitleStrip.this.a(aVar, aVar2);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip.this.a(PagerTitleStrip.this.a.getCurrentItem(), PagerTitleStrip.this.a.getAdapter());
            PagerTitleStrip.this.a(PagerTitleStrip.this.a.getCurrentItem(), PagerTitleStrip.this.e >= 0.0f ? PagerTitleStrip.this.e : 0.0f, true);
        }
    }
}
