package com.google.android.material.bottomnavigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.af;
import androidx.core.h.w;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.a;
import com.google.android.material.internal.k;

/* compiled from: source */
/* loaded from: classes.dex */
public class BottomNavigationView extends FrameLayout {
    private final g a;
    private final BottomNavigationMenuView b;
    private final BottomNavigationPresenter c;
    private MenuInflater d;
    private b e;
    private a f;

    /* compiled from: source */
    public interface a {
        void a(MenuItem menuItem);
    }

    /* compiled from: source */
    public interface b {
        boolean a(MenuItem menuItem);
    }

    public int getMaxItemCount() {
        return 5;
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.bottomNavigationStyle);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new BottomNavigationPresenter();
        this.a = new com.google.android.material.bottomnavigation.a(context);
        this.b = new BottomNavigationMenuView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.b.setLayoutParams(layoutParams);
        this.c.a(this.b);
        this.c.a(1);
        this.b.setPresenter(this.c);
        this.a.a(this.c);
        this.c.a(getContext(), this.a);
        af b2 = k.b(context, attributeSet, a.k.BottomNavigationView, i, a.j.Widget_Design_BottomNavigationView, a.k.BottomNavigationView_itemTextAppearanceInactive, a.k.BottomNavigationView_itemTextAppearanceActive);
        if (b2.g(a.k.BottomNavigationView_itemIconTint)) {
            this.b.setIconTintList(b2.e(a.k.BottomNavigationView_itemIconTint));
        } else {
            this.b.setIconTintList(this.b.a(R.attr.textColorSecondary));
        }
        setItemIconSize(b2.e(a.k.BottomNavigationView_itemIconSize, getResources().getDimensionPixelSize(a.d.design_bottom_navigation_icon_size)));
        if (b2.g(a.k.BottomNavigationView_itemTextAppearanceInactive)) {
            setItemTextAppearanceInactive(b2.g(a.k.BottomNavigationView_itemTextAppearanceInactive, 0));
        }
        if (b2.g(a.k.BottomNavigationView_itemTextAppearanceActive)) {
            setItemTextAppearanceActive(b2.g(a.k.BottomNavigationView_itemTextAppearanceActive, 0));
        }
        if (b2.g(a.k.BottomNavigationView_itemTextColor)) {
            setItemTextColor(b2.e(a.k.BottomNavigationView_itemTextColor));
        }
        if (b2.g(a.k.BottomNavigationView_elevation)) {
            w.a(this, b2.e(a.k.BottomNavigationView_elevation, 0));
        }
        setLabelVisibilityMode(b2.c(a.k.BottomNavigationView_labelVisibilityMode, -1));
        setItemHorizontalTranslationEnabled(b2.a(a.k.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        this.b.setItemBackgroundRes(b2.g(a.k.BottomNavigationView_itemBackground, 0));
        if (b2.g(a.k.BottomNavigationView_menu)) {
            a(b2.g(a.k.BottomNavigationView_menu, 0));
        }
        b2.b();
        addView(this.b, layoutParams);
        if (Build.VERSION.SDK_INT < 21) {
            a(context);
        }
        this.a.a(new g.a() { // from class: com.google.android.material.bottomnavigation.BottomNavigationView.1
            @Override // androidx.appcompat.view.menu.g.a
            public void a(g gVar) {
            }

            AnonymousClass1() {
            }

            @Override // androidx.appcompat.view.menu.g.a
            public boolean a(g gVar, MenuItem menuItem) {
                if (BottomNavigationView.this.f == null || menuItem.getItemId() != BottomNavigationView.this.getSelectedItemId()) {
                    return (BottomNavigationView.this.e == null || BottomNavigationView.this.e.a(menuItem)) ? false : true;
                }
                BottomNavigationView.this.f.a(menuItem);
                return true;
            }
        });
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.bottomnavigation.BottomNavigationView$1 */
    class AnonymousClass1 implements g.a {
        @Override // androidx.appcompat.view.menu.g.a
        public void a(g gVar) {
        }

        AnonymousClass1() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(g gVar, MenuItem menuItem) {
            if (BottomNavigationView.this.f == null || menuItem.getItemId() != BottomNavigationView.this.getSelectedItemId()) {
                return (BottomNavigationView.this.e == null || BottomNavigationView.this.e.a(menuItem)) ? false : true;
            }
            BottomNavigationView.this.f.a(menuItem);
            return true;
        }
    }

    public void setOnNavigationItemSelectedListener(b bVar) {
        this.e = bVar;
    }

    public void setOnNavigationItemReselectedListener(a aVar) {
        this.f = aVar;
    }

    public Menu getMenu() {
        return this.a;
    }

    public void a(int i) {
        this.c.b(true);
        getMenuInflater().inflate(i, this.a);
        this.c.b(false);
        this.c.a(true);
    }

    public ColorStateList getItemIconTintList() {
        return this.b.getIconTintList();
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.b.setIconTintList(colorStateList);
    }

    public void setItemIconSize(int i) {
        this.b.setItemIconSize(i);
    }

    public void setItemIconSizeRes(int i) {
        setItemIconSize(getResources().getDimensionPixelSize(i));
    }

    public int getItemIconSize() {
        return this.b.getItemIconSize();
    }

    public ColorStateList getItemTextColor() {
        return this.b.getItemTextColor();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.b.setItemTextColor(colorStateList);
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.b.getItemBackgroundRes();
    }

    public void setItemBackgroundResource(int i) {
        this.b.setItemBackgroundRes(i);
    }

    public Drawable getItemBackground() {
        return this.b.getItemBackground();
    }

    public void setItemBackground(Drawable drawable) {
        this.b.setItemBackground(drawable);
    }

    public int getSelectedItemId() {
        return this.b.getSelectedItemId();
    }

    public void setSelectedItemId(int i) {
        MenuItem findItem = this.a.findItem(i);
        if (findItem == null || this.a.a(findItem, this.c, 0)) {
            return;
        }
        findItem.setChecked(true);
    }

    public void setLabelVisibilityMode(int i) {
        if (this.b.getLabelVisibilityMode() != i) {
            this.b.setLabelVisibilityMode(i);
            this.c.a(false);
        }
    }

    public int getLabelVisibilityMode() {
        return this.b.getLabelVisibilityMode();
    }

    public void setItemTextAppearanceInactive(int i) {
        this.b.setItemTextAppearanceInactive(i);
    }

    public int getItemTextAppearanceInactive() {
        return this.b.getItemTextAppearanceInactive();
    }

    public void setItemTextAppearanceActive(int i) {
        this.b.setItemTextAppearanceActive(i);
    }

    public int getItemTextAppearanceActive() {
        return this.b.getItemTextAppearanceActive();
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        if (this.b.a() != z) {
            this.b.setItemHorizontalTranslationEnabled(z);
            this.c.a(false);
        }
    }

    private void a(Context context) {
        View view = new View(context);
        view.setBackgroundColor(androidx.core.content.a.c(context, a.c.design_bottom_navigation_shadow_color));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(a.d.design_bottom_navigation_shadow_height)));
        addView(view);
    }

    private MenuInflater getMenuInflater() {
        if (this.d == null) {
            this.d = new androidx.appcompat.view.g(getContext());
        }
        return this.d;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = new Bundle();
        this.a.a(savedState.a);
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
        this.a.b(savedState.a);
    }

    /* compiled from: source */
    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.bottomnavigation.BottomNavigationView.SavedState.1
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
        Bundle a;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.a);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.a = parcel.readBundle(classLoader);
        }

        /* compiled from: source */
        /* renamed from: com.google.android.material.bottomnavigation.BottomNavigationView$SavedState$1 */
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
