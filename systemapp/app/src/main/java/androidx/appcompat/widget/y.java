package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.LinearLayoutCompat;

/* compiled from: source */
/* loaded from: classes.dex */
public class y extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    private static final Interpolator j = new DecelerateInterpolator();
    Runnable a;
    LinearLayoutCompat b;
    int c;
    int d;
    private b e;
    private Spinner f;
    private boolean g;
    private int h;
    private int i;

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.b.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.c = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.c = View.MeasureSpec.getSize(i) / 2;
            }
            this.c = Math.min(this.c, this.d);
        } else {
            this.c = -1;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
        if (!z && this.g) {
            this.b.measure(0, makeMeasureSpec);
            if (this.b.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                b();
            } else {
                c();
            }
        } else {
            c();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.i);
    }

    private boolean a() {
        return this.f != null && this.f.getParent() == this;
    }

    public void setAllowCollapse(boolean z) {
        this.g = z;
    }

    private void b() {
        if (a()) {
            return;
        }
        if (this.f == null) {
            this.f = d();
        }
        removeView(this.b);
        addView(this.f, new ViewGroup.LayoutParams(-2, -1));
        if (this.f.getAdapter() == null) {
            this.f.setAdapter((SpinnerAdapter) new a());
        }
        if (this.a != null) {
            removeCallbacks(this.a);
            this.a = null;
        }
        this.f.setSelection(this.i);
    }

    private boolean c() {
        if (!a()) {
            return false;
        }
        removeView(this.f);
        addView(this.b, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f.getSelectedItemPosition());
        return false;
    }

    public void setTabSelected(int i) {
        this.i = i;
        int childCount = this.b.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.b.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                a(i);
            }
            i2++;
        }
        if (this.f == null || i < 0) {
            return;
        }
        this.f.setSelection(i);
    }

    public void setContentHeight(int i) {
        this.h = i;
        requestLayout();
    }

    private Spinner d() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, a.C0001a.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.view.a a2 = androidx.appcompat.view.a.a(getContext());
        setContentHeight(a2.e());
        this.d = a2.g();
    }

    public void a(int i) {
        View childAt = this.b.getChildAt(i);
        if (this.a != null) {
            removeCallbacks(this.a);
        }
        this.a = new Runnable() { // from class: androidx.appcompat.widget.y.1
            final /* synthetic */ View a;

            AnonymousClass1(View childAt2) {
                childAt = childAt2;
            }

            @Override // java.lang.Runnable
            public void run() {
                y.this.smoothScrollTo(childAt.getLeft() - ((y.this.getWidth() - childAt.getWidth()) / 2), 0);
                y.this.a = null;
            }
        };
        post(this.a);
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.widget.y$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ View a;

        AnonymousClass1(View childAt2) {
            childAt = childAt2;
        }

        @Override // java.lang.Runnable
        public void run() {
            y.this.smoothScrollTo(childAt.getLeft() - ((y.this.getWidth() - childAt.getWidth()) / 2), 0);
            y.this.a = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a != null) {
            post(this.a);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null) {
            removeCallbacks(this.a);
        }
    }

    c a(ActionBar.b bVar, boolean z) {
        c cVar = new c(getContext(), bVar, z);
        if (z) {
            cVar.setBackgroundDrawable(null);
            cVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.h));
        } else {
            cVar.setFocusable(true);
            if (this.e == null) {
                this.e = new b();
            }
            cVar.setOnClickListener(this.e);
        }
        return cVar;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j2) {
        ((c) view).b().d();
    }

    /* compiled from: source */
    private class c extends LinearLayout {
        private final int[] b;
        private ActionBar.b c;
        private TextView d;
        private ImageView e;
        private View f;

        public c(Context context, ActionBar.b bVar, boolean z) {
            super(context, null, a.C0001a.actionBarTabStyle);
            this.b = new int[]{R.attr.background};
            this.c = bVar;
            af a = af.a(context, null, this.b, a.C0001a.actionBarTabStyle, 0);
            if (a.g(0)) {
                setBackgroundDrawable(a.a(0));
            }
            a.b();
            if (z) {
                setGravity(8388627);
            }
            a();
        }

        public void a(ActionBar.b bVar) {
            this.c = bVar;
            a();
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (y.this.c <= 0 || getMeasuredWidth() <= y.this.c) {
                return;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(y.this.c, 1073741824), i2);
        }

        public void a() {
            ActionBar.b bVar = this.c;
            View c = bVar.c();
            if (c != null) {
                ViewParent parent = c.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(c);
                    }
                    addView(c);
                }
                this.f = c;
                if (this.d != null) {
                    this.d.setVisibility(8);
                }
                if (this.e != null) {
                    this.e.setVisibility(8);
                    this.e.setImageDrawable(null);
                    return;
                }
                return;
            }
            if (this.f != null) {
                removeView(this.f);
                this.f = null;
            }
            Drawable a = bVar.a();
            CharSequence b = bVar.b();
            if (a != null) {
                if (this.e == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.e = appCompatImageView;
                }
                this.e.setImageDrawable(a);
                this.e.setVisibility(0);
            } else if (this.e != null) {
                this.e.setVisibility(8);
                this.e.setImageDrawable(null);
            }
            boolean z = !TextUtils.isEmpty(b);
            if (z) {
                if (this.d == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, a.C0001a.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.d = appCompatTextView;
                }
                this.d.setText(b);
                this.d.setVisibility(0);
            } else if (this.d != null) {
                this.d.setVisibility(8);
                this.d.setText((CharSequence) null);
            }
            if (this.e != null) {
                this.e.setContentDescription(bVar.e());
            }
            ah.a(this, z ? null : bVar.e());
        }

        public ActionBar.b b() {
            return this.c;
        }
    }

    /* compiled from: source */
    private class a extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return y.this.b.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ((c) y.this.b.getChildAt(i)).b();
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return y.this.a((ActionBar.b) getItem(i), true);
            }
            ((c) view).a((ActionBar.b) getItem(i));
            return view;
        }
    }

    /* compiled from: source */
    private class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((c) view).b().d();
            int childCount = y.this.b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = y.this.b.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }
}
