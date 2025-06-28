package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.widget.af;
import androidx.core.h.ae;
import androidx.core.h.w;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.a;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.f;
import com.google.android.material.internal.g;
import com.google.android.material.internal.k;

/* compiled from: source */
/* loaded from: classes.dex */
public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] d = {R.attr.state_checked};
    private static final int[] e = {-16842910};
    a c;
    private final f f;
    private final g g;
    private final int h;
    private MenuInflater i;

    /* compiled from: source */
    public interface a {
        boolean a(MenuItem menuItem);
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.navigationViewStyle);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ColorStateList c;
        boolean z;
        int i2;
        this.g = new g();
        this.f = new f(context);
        af b = k.b(context, attributeSet, a.k.NavigationView, i, a.j.Widget_Design_NavigationView, new int[0]);
        w.a(this, b.a(a.k.NavigationView_android_background));
        if (b.g(a.k.NavigationView_elevation)) {
            w.a(this, b.e(a.k.NavigationView_elevation, 0));
        }
        w.b(this, b.a(a.k.NavigationView_android_fitsSystemWindows, false));
        this.h = b.e(a.k.NavigationView_android_maxWidth, 0);
        if (b.g(a.k.NavigationView_itemIconTint)) {
            c = b.e(a.k.NavigationView_itemIconTint);
        } else {
            c = c(R.attr.textColorSecondary);
        }
        if (b.g(a.k.NavigationView_itemTextAppearance)) {
            i2 = b.g(a.k.NavigationView_itemTextAppearance, 0);
            z = true;
        } else {
            z = false;
            i2 = 0;
        }
        ColorStateList e2 = b.g(a.k.NavigationView_itemTextColor) ? b.e(a.k.NavigationView_itemTextColor) : null;
        if (!z && e2 == null) {
            e2 = c(R.attr.textColorPrimary);
        }
        Drawable a2 = b.a(a.k.NavigationView_itemBackground);
        if (b.g(a.k.NavigationView_itemHorizontalPadding)) {
            this.g.d(b.e(a.k.NavigationView_itemHorizontalPadding, 0));
        }
        int e3 = b.e(a.k.NavigationView_itemIconPadding, 0);
        this.f.a(new g.a() { // from class: com.google.android.material.navigation.NavigationView.1
            @Override // androidx.appcompat.view.menu.g.a
            public void a(androidx.appcompat.view.menu.g gVar) {
            }

            AnonymousClass1() {
            }

            @Override // androidx.appcompat.view.menu.g.a
            public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
                return NavigationView.this.c != null && NavigationView.this.c.a(menuItem);
            }
        });
        this.g.a(1);
        this.g.a(context, this.f);
        this.g.a(c);
        if (z) {
            this.g.c(i2);
        }
        this.g.b(e2);
        this.g.a(a2);
        this.g.e(e3);
        this.f.a(this.g);
        addView((View) this.g.a((ViewGroup) this));
        if (b.g(a.k.NavigationView_menu)) {
            a(b.g(a.k.NavigationView_menu, 0));
        }
        if (b.g(a.k.NavigationView_headerLayout)) {
            b(b.g(a.k.NavigationView_headerLayout, 0));
        }
        b.b();
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.navigation.NavigationView$1 */
    class AnonymousClass1 implements g.a {
        @Override // androidx.appcompat.view.menu.g.a
        public void a(androidx.appcompat.view.menu.g gVar) {
        }

        AnonymousClass1() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            return NavigationView.this.c != null && NavigationView.this.c.a(menuItem);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = new Bundle();
        this.f.a(savedState.a);
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.f.b(savedState.a);
    }

    public void setNavigationItemSelectedListener(a aVar) {
        this.c = aVar;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), this.h), 1073741824);
        } else if (mode == 0) {
            i = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    protected void a(ae aeVar) {
        this.g.a(aeVar);
    }

    public void a(int i) {
        this.g.b(true);
        getMenuInflater().inflate(i, this.f);
        this.g.b(false);
        this.g.a(false);
    }

    public Menu getMenu() {
        return this.f;
    }

    public View b(int i) {
        return this.g.b(i);
    }

    public int getHeaderCount() {
        return this.g.d();
    }

    public ColorStateList getItemIconTintList() {
        return this.g.e();
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.g.a(colorStateList);
    }

    public ColorStateList getItemTextColor() {
        return this.g.g();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.g.b(colorStateList);
    }

    public Drawable getItemBackground() {
        return this.g.h();
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(androidx.core.content.a.a(getContext(), i));
    }

    public void setItemBackground(Drawable drawable) {
        this.g.a(drawable);
    }

    public int getItemHorizontalPadding() {
        return this.g.i();
    }

    public void setItemHorizontalPadding(int i) {
        this.g.d(i);
    }

    public void setItemHorizontalPaddingResource(int i) {
        this.g.d(getResources().getDimensionPixelSize(i));
    }

    public int getItemIconPadding() {
        return this.g.j();
    }

    public void setItemIconPadding(int i) {
        this.g.e(i);
    }

    public void setItemIconPaddingResource(int i) {
        this.g.e(getResources().getDimensionPixelSize(i));
    }

    public void setCheckedItem(int i) {
        MenuItem findItem = this.f.findItem(i);
        if (findItem != null) {
            this.g.a((i) findItem);
        }
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem findItem = this.f.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.g.a((i) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    public MenuItem getCheckedItem() {
        return this.g.a();
    }

    public void setItemTextAppearance(int i) {
        this.g.c(i);
    }

    private MenuInflater getMenuInflater() {
        if (this.i == null) {
            this.i = new androidx.appcompat.view.g(getContext());
        }
        return this.i;
    }

    private ColorStateList c(int i) {
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
        return new ColorStateList(new int[][]{e, d, EMPTY_STATE_SET}, new int[]{a2.getColorForState(e, defaultColor), i2, defaultColor});
    }

    /* compiled from: source */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.navigation.NavigationView.SavedState.1
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public Bundle a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readBundle(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.a);
        }

        /* compiled from: source */
        /* renamed from: com.google.android.material.navigation.NavigationView$SavedState$1 */
        static class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }
    }
}
