package com.google.android.material.bottomnavigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.n;
import androidx.core.g.d;
import androidx.core.h.w;
import androidx.d.a.a.b;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionSet;
import androidx.transition.v;
import com.google.android.material.a;
import com.google.android.material.internal.j;

/* compiled from: source */
/* loaded from: classes.dex */
public class BottomNavigationMenuView extends ViewGroup implements n {
    private static final int[] a = {R.attr.state_checked};
    private static final int[] b = {-16842910};
    private final TransitionSet c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final int h;
    private final View.OnClickListener i;
    private final d.a<BottomNavigationItemView> j;
    private boolean k;
    private int l;
    private BottomNavigationItemView[] m;
    private int n;
    private int o;
    private ColorStateList p;
    private int q;
    private ColorStateList r;
    private final ColorStateList s;
    private int t;
    private int u;
    private Drawable v;
    private int w;
    private int[] x;
    private BottomNavigationPresenter y;
    private g z;

    private boolean a(int i, int i2) {
        if (i == -1) {
            if (i2 <= 3) {
                return false;
            }
        } else if (i != 0) {
            return false;
        }
        return true;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public BottomNavigationMenuView(Context context) {
        this(context, null);
    }

    public BottomNavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = new d.c(5);
        this.n = 0;
        this.o = 0;
        Resources resources = getResources();
        this.d = resources.getDimensionPixelSize(a.d.design_bottom_navigation_item_max_width);
        this.e = resources.getDimensionPixelSize(a.d.design_bottom_navigation_item_min_width);
        this.f = resources.getDimensionPixelSize(a.d.design_bottom_navigation_active_item_max_width);
        this.g = resources.getDimensionPixelSize(a.d.design_bottom_navigation_active_item_min_width);
        this.h = resources.getDimensionPixelSize(a.d.design_bottom_navigation_height);
        this.s = a(R.attr.textColorSecondary);
        this.c = new AutoTransition();
        this.c.a(0);
        this.c.a(115L);
        this.c.a(new b());
        this.c.a(new j());
        this.i = new View.OnClickListener() { // from class: com.google.android.material.bottomnavigation.BottomNavigationMenuView.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i itemData = ((BottomNavigationItemView) view).getItemData();
                if (BottomNavigationMenuView.this.z.a(itemData, BottomNavigationMenuView.this.y, 0)) {
                    return;
                }
                itemData.setChecked(true);
            }
        };
        this.x = new int[5];
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.bottomnavigation.BottomNavigationMenuView$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i itemData = ((BottomNavigationItemView) view).getItemData();
            if (BottomNavigationMenuView.this.z.a(itemData, BottomNavigationMenuView.this.y, 0)) {
                return;
            }
            itemData.setChecked(true);
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public void a(g gVar) {
        this.z = gVar;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.z.j().size();
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
        if (a(this.l, size2) && this.k) {
            View childAt = getChildAt(this.o);
            int i3 = this.g;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.f, Integer.MIN_VALUE), makeMeasureSpec);
                i3 = Math.max(i3, childAt.getMeasuredWidth());
            }
            int i4 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min = Math.min(size - (this.e * i4), Math.min(i3, this.f));
            int i5 = size - min;
            int min2 = Math.min(i5 / (i4 == 0 ? 1 : i4), this.d);
            int i6 = i5 - (i4 * min2);
            int i7 = 0;
            while (i7 < childCount) {
                if (getChildAt(i7).getVisibility() != 8) {
                    this.x[i7] = i7 == this.o ? min : min2;
                    if (i6 > 0) {
                        int[] iArr = this.x;
                        iArr[i7] = iArr[i7] + 1;
                        i6--;
                    }
                } else {
                    this.x[i7] = 0;
                }
                i7++;
            }
        } else {
            int min3 = Math.min(size / (size2 == 0 ? 1 : size2), this.f);
            int i8 = size - (size2 * min3);
            for (int i9 = 0; i9 < childCount; i9++) {
                if (getChildAt(i9).getVisibility() != 8) {
                    this.x[i9] = min3;
                    if (i8 > 0) {
                        int[] iArr2 = this.x;
                        iArr2[i9] = iArr2[i9] + 1;
                        i8--;
                    }
                } else {
                    this.x[i9] = 0;
                }
            }
        }
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt2 = getChildAt(i11);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.x[i11], 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i10 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i10, View.MeasureSpec.makeMeasureSpec(i10, 1073741824), 0), View.resolveSizeAndState(this.h, makeMeasureSpec, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                if (w.h(this) == 1) {
                    int i9 = i5 - i7;
                    childAt.layout(i9 - childAt.getMeasuredWidth(), 0, i9, i6);
                } else {
                    childAt.layout(i7, 0, childAt.getMeasuredWidth() + i7, i6);
                }
                i7 += childAt.getMeasuredWidth();
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.p = colorStateList;
        if (this.m != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.m) {
                bottomNavigationItemView.setIconTintList(colorStateList);
            }
        }
    }

    public ColorStateList getIconTintList() {
        return this.p;
    }

    public void setItemIconSize(int i) {
        this.q = i;
        if (this.m != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.m) {
                bottomNavigationItemView.setIconSize(i);
            }
        }
    }

    public int getItemIconSize() {
        return this.q;
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.r = colorStateList;
        if (this.m != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.m) {
                bottomNavigationItemView.setTextColor(colorStateList);
            }
        }
    }

    public ColorStateList getItemTextColor() {
        return this.r;
    }

    public void setItemTextAppearanceInactive(int i) {
        this.t = i;
        if (this.m != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.m) {
                bottomNavigationItemView.setTextAppearanceInactive(i);
                if (this.r != null) {
                    bottomNavigationItemView.setTextColor(this.r);
                }
            }
        }
    }

    public int getItemTextAppearanceInactive() {
        return this.t;
    }

    public void setItemTextAppearanceActive(int i) {
        this.u = i;
        if (this.m != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.m) {
                bottomNavigationItemView.setTextAppearanceActive(i);
                if (this.r != null) {
                    bottomNavigationItemView.setTextColor(this.r);
                }
            }
        }
    }

    public int getItemTextAppearanceActive() {
        return this.u;
    }

    public void setItemBackgroundRes(int i) {
        this.w = i;
        if (this.m != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.m) {
                bottomNavigationItemView.setItemBackground(i);
            }
        }
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.w;
    }

    public void setItemBackground(Drawable drawable) {
        this.v = drawable;
        if (this.m != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.m) {
                bottomNavigationItemView.setItemBackground(drawable);
            }
        }
    }

    public Drawable getItemBackground() {
        if (this.m != null && this.m.length > 0) {
            return this.m[0].getBackground();
        }
        return this.v;
    }

    public void setLabelVisibilityMode(int i) {
        this.l = i;
    }

    public int getLabelVisibilityMode() {
        return this.l;
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.k = z;
    }

    public boolean a() {
        return this.k;
    }

    public ColorStateList a(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList a2 = androidx.appcompat.a.a.a.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(a.C0001a.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = a2.getDefaultColor();
        return new ColorStateList(new int[][]{b, a, EMPTY_STATE_SET}, new int[]{a2.getColorForState(b, defaultColor), i2, defaultColor});
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        this.y = bottomNavigationPresenter;
    }

    public void b() {
        removeAllViews();
        if (this.m != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.m) {
                if (bottomNavigationItemView != null) {
                    this.j.a(bottomNavigationItemView);
                }
            }
        }
        if (this.z.size() == 0) {
            this.n = 0;
            this.o = 0;
            this.m = null;
            return;
        }
        this.m = new BottomNavigationItemView[this.z.size()];
        boolean a2 = a(this.l, this.z.j().size());
        for (int i = 0; i < this.z.size(); i++) {
            this.y.b(true);
            this.z.getItem(i).setCheckable(true);
            this.y.b(false);
            BottomNavigationItemView newItem = getNewItem();
            this.m[i] = newItem;
            newItem.setIconTintList(this.p);
            newItem.setIconSize(this.q);
            newItem.setTextColor(this.s);
            newItem.setTextAppearanceInactive(this.t);
            newItem.setTextAppearanceActive(this.u);
            newItem.setTextColor(this.r);
            if (this.v != null) {
                newItem.setItemBackground(this.v);
            } else {
                newItem.setItemBackground(this.w);
            }
            newItem.setShifting(a2);
            newItem.setLabelVisibilityMode(this.l);
            newItem.a((i) this.z.getItem(i), 0);
            newItem.setItemPosition(i);
            newItem.setOnClickListener(this.i);
            addView(newItem);
        }
        this.o = Math.min(this.z.size() - 1, this.o);
        this.z.getItem(this.o).setChecked(true);
    }

    public void c() {
        if (this.z == null || this.m == null) {
            return;
        }
        int size = this.z.size();
        if (size != this.m.length) {
            b();
            return;
        }
        int i = this.n;
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = this.z.getItem(i2);
            if (item.isChecked()) {
                this.n = item.getItemId();
                this.o = i2;
            }
        }
        if (i != this.n) {
            v.a(this, this.c);
        }
        boolean a2 = a(this.l, this.z.j().size());
        for (int i3 = 0; i3 < size; i3++) {
            this.y.b(true);
            this.m[i3].setLabelVisibilityMode(this.l);
            this.m[i3].setShifting(a2);
            this.m[i3].a((i) this.z.getItem(i3), 0);
            this.y.b(false);
        }
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView a2 = this.j.a();
        return a2 == null ? new BottomNavigationItemView(getContext()) : a2;
    }

    public int getSelectedItemId() {
        return this.n;
    }

    void b(int i) {
        int size = this.z.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = this.z.getItem(i2);
            if (i == item.getItemId()) {
                this.n = i;
                this.o = i2;
                item.setChecked(true);
                return;
            }
        }
    }
}
