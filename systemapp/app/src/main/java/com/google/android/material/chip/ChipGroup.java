package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.google.android.material.a;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.k;

/* compiled from: source */
/* loaded from: classes.dex */
public class ChipGroup extends FlowLayout {
    private int a;
    private int b;
    private boolean c;
    private b d;
    private final a e;
    private c f;
    private int g;
    private boolean h;

    /* compiled from: source */
    public interface b {
        void a(ChipGroup chipGroup, int i);
    }

    /* compiled from: source */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.chipGroupStyle);
    }

    public ChipGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new a();
        this.f = new c();
        this.g = -1;
        this.h = false;
        TypedArray a2 = k.a(context, attributeSet, a.k.ChipGroup, i, a.j.Widget_MaterialComponents_ChipGroup, new int[0]);
        int dimensionPixelOffset = a2.getDimensionPixelOffset(a.k.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(a2.getDimensionPixelOffset(a.k.ChipGroup_chipSpacingHorizontal, dimensionPixelOffset));
        setChipSpacingVertical(a2.getDimensionPixelOffset(a.k.ChipGroup_chipSpacingVertical, dimensionPixelOffset));
        setSingleLine(a2.getBoolean(a.k.ChipGroup_singleLine, false));
        setSingleSelection(a2.getBoolean(a.k.ChipGroup_singleSelection, false));
        int resourceId = a2.getResourceId(a.k.ChipGroup_checkedChip, -1);
        if (resourceId != -1) {
            this.g = resourceId;
        }
        a2.recycle();
        super.setOnHierarchyChangeListener(this.f);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f.b = onHierarchyChangeListener;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (this.g != -1) {
            a(this.g, true);
            setCheckedId(this.g);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                if (this.g != -1 && this.c) {
                    a(this.g, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i, layoutParams);
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerHorizontal(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public int getCheckedChipId() {
        if (this.c) {
            return this.g;
        }
        return -1;
    }

    public void a() {
        this.h = true;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof Chip) {
                ((Chip) childAt).setChecked(false);
            }
        }
        this.h = false;
        setCheckedId(-1);
    }

    public void setOnCheckedChangeListener(b bVar) {
        this.d = bVar;
    }

    public void setCheckedId(int i) {
        this.g = i;
        if (this.d == null || !this.c) {
            return;
        }
        this.d.a(this, i);
    }

    public void a(int i, boolean z) {
        View findViewById = findViewById(i);
        if (findViewById instanceof Chip) {
            this.h = true;
            ((Chip) findViewById).setChecked(z);
            this.h = false;
        }
    }

    public void setChipSpacing(int i) {
        setChipSpacingHorizontal(i);
        setChipSpacingVertical(i);
    }

    public void setChipSpacingResource(int i) {
        setChipSpacing(getResources().getDimensionPixelOffset(i));
    }

    public int getChipSpacingHorizontal() {
        return this.a;
    }

    public void setChipSpacingHorizontal(int i) {
        if (this.a != i) {
            this.a = i;
            setItemSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i));
    }

    public int getChipSpacingVertical() {
        return this.b;
    }

    public void setChipSpacingVertical(int i) {
        if (this.b != i) {
            this.b = i;
            setLineSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i));
    }

    public void setSingleLine(int i) {
        setSingleLine(getResources().getBoolean(i));
    }

    public void setSingleSelection(boolean z) {
        if (this.c != z) {
            this.c = z;
            a();
        }
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }

    /* compiled from: source */
    private class a implements CompoundButton.OnCheckedChangeListener {
        private a() {
        }

        /* synthetic */ a(ChipGroup chipGroup, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (ChipGroup.this.h) {
                return;
            }
            int id = compoundButton.getId();
            if (z) {
                if (ChipGroup.this.g != -1 && ChipGroup.this.g != id && ChipGroup.this.c) {
                    ChipGroup.this.a(ChipGroup.this.g, false);
                }
                ChipGroup.this.setCheckedId(id);
                return;
            }
            if (ChipGroup.this.g == id) {
                ChipGroup.this.setCheckedId(-1);
            }
        }
    }

    /* compiled from: source */
    private class c implements ViewGroup.OnHierarchyChangeListener {
        private ViewGroup.OnHierarchyChangeListener b;

        private c() {
        }

        /* synthetic */ c(ChipGroup chipGroup, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            int hashCode;
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    if (Build.VERSION.SDK_INT >= 17) {
                        hashCode = View.generateViewId();
                    } else {
                        hashCode = view2.hashCode();
                    }
                    view2.setId(hashCode);
                }
                ((Chip) view2).setOnCheckedChangeListenerInternal(ChipGroup.this.e);
            }
            if (this.b != null) {
                this.b.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                ((Chip) view2).setOnCheckedChangeListenerInternal(null);
            }
            if (this.b != null) {
                this.b.onChildViewRemoved(view, view2);
            }
        }
    }
}
