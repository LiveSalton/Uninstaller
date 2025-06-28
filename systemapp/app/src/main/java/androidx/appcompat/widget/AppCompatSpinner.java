package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.a;
import androidx.appcompat.app.a;

/* compiled from: source */
/* loaded from: classes.dex */
public class AppCompatSpinner extends Spinner implements androidx.core.h.u {
    private static final int[] c = {R.attr.spinnerMode};
    int a;
    final Rect b;
    private final androidx.appcompat.widget.d d;
    private final Context e;
    private s f;
    private SpinnerAdapter g;
    private final boolean h;
    private d i;

    /* compiled from: source */
    interface d {
        CharSequence a();

        void a(int i);

        void a(int i, int i2);

        void a(Drawable drawable);

        void a(ListAdapter listAdapter);

        void a(CharSequence charSequence);

        Drawable b();

        void b(int i);

        int c();

        void c(int i);

        void d();

        boolean e();

        int f();
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0001a.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0050, code lost:
    
        if (r11 != null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
    
        r11.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0064, code lost:
    
        if (r11 == null) goto L79;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AppCompatSpinner(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$1 */
    class AnonymousClass1 extends s {
        final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(View view, c cVar) {
            super(view);
            r3 = cVar;
        }

        @Override // androidx.appcompat.widget.s
        public androidx.appcompat.view.menu.p a() {
            return r3;
        }

        @Override // androidx.appcompat.widget.s
        @SuppressLint({"SyntheticAccessor"})
        public boolean b() {
            if (AppCompatSpinner.this.getInternalPopup().e()) {
                return true;
            }
            AppCompatSpinner.this.a();
            return true;
        }
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.e;
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.i != null) {
            this.i.a(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(androidx.appcompat.a.a.a.b(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        if (this.i != null) {
            return this.i.b();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        if (this.i != null) {
            this.i.a(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        if (this.i != null) {
            return this.i.c();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        if (this.i != null) {
            this.i.c(i);
            this.i.b(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        if (this.i != null) {
            return this.i.f();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.i != null) {
            this.a = i;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.i != null) {
            return this.a;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.h) {
            this.g = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.i != null) {
            this.i.a(new b(spinnerAdapter, (this.e == null ? getContext() : this.e).getTheme()));
        }
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.i == null || !this.i.e()) {
            return;
        }
        this.i.d();
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f == null || !this.f.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.i == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        if (this.i != null) {
            if (this.i.e()) {
                return true;
            }
            a();
            return true;
        }
        return super.performClick();
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        if (this.i != null) {
            this.i.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        return this.i != null ? this.i.a() : super.getPrompt();
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.d != null) {
            this.d.a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.d != null) {
            this.d.a(drawable);
        }
    }

    @Override // androidx.core.h.u
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.d != null) {
            this.d.a(colorStateList);
        }
    }

    @Override // androidx.core.h.u
    public ColorStateList getSupportBackgroundTintList() {
        if (this.d != null) {
            return this.d.a();
        }
        return null;
    }

    @Override // androidx.core.h.u
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.d != null) {
            this.d.a(mode);
        }
    }

    @Override // androidx.core.h.u
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.d != null) {
            return this.d.b();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.d != null) {
            this.d.c();
        }
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int i2 = 0;
        View view = null;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i2;
        }
        drawable.getPadding(this.b);
        return i2 + this.b.left + this.b.right;
    }

    final d getInternalPopup() {
        return this.i;
    }

    void a() {
        if (Build.VERSION.SDK_INT >= 17) {
            this.i.a(getTextDirection(), getTextAlignment());
        } else {
            this.i.a(-1, -1);
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.i != null && this.i.e();
        return savedState;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!savedState.a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.2
            AnonymousClass2() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (!AppCompatSpinner.this.getInternalPopup().e()) {
                    AppCompatSpinner.this.a();
                }
                ViewTreeObserver viewTreeObserver2 = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver2 != null) {
                    if (Build.VERSION.SDK_INT >= 16) {
                        viewTreeObserver2.removeOnGlobalLayoutListener(this);
                    } else {
                        viewTreeObserver2.removeGlobalOnLayoutListener(this);
                    }
                }
            }
        });
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$2 */
    class AnonymousClass2 implements ViewTreeObserver.OnGlobalLayoutListener {
        AnonymousClass2() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!AppCompatSpinner.this.getInternalPopup().e()) {
                AppCompatSpinner.this.a();
            }
            ViewTreeObserver viewTreeObserver2 = AppCompatSpinner.this.getViewTreeObserver();
            if (viewTreeObserver2 != null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    viewTreeObserver2.removeOnGlobalLayoutListener(this);
                } else {
                    viewTreeObserver2.removeGlobalOnLayoutListener(this);
                }
            }
        }
    }

    /* compiled from: source */
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.appcompat.widget.AppCompatSpinner.SavedState.1
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readByte() != 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.a ? (byte) 1 : (byte) 0);
        }

        /* compiled from: source */
        /* renamed from: androidx.appcompat.widget.AppCompatSpinner$SavedState$1 */
        class AnonymousClass1 implements Parcelable.Creator<SavedState> {
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }
    }

    /* compiled from: source */
    private static class b implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter a;
        private ListAdapter b;

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        public b(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                        return;
                    }
                    return;
                }
                if (spinnerAdapter instanceof ab) {
                    ab abVar = (ab) spinnerAdapter;
                    if (abVar.a() == null) {
                        abVar.a(theme);
                    }
                }
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.a == null) {
                return 0;
            }
            return this.a.getCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.a == null) {
                return null;
            }
            return this.a.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            if (this.a == null) {
                return -1L;
            }
            return this.a.getItemId(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            if (this.a == null) {
                return null;
            }
            return this.a.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            return this.a != null && this.a.hasStableIds();
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.a != null) {
                this.a.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.a != null) {
                this.a.unregisterDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    /* compiled from: source */
    class a implements DialogInterface.OnClickListener, d {
        androidx.appcompat.app.a a;
        private ListAdapter c;
        private CharSequence d;

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public Drawable b() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public int c() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public int f() {
            return 0;
        }

        a() {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void d() {
            if (this.a != null) {
                this.a.dismiss();
                this.a = null;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public boolean e() {
            if (this.a != null) {
                return this.a.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void a(ListAdapter listAdapter) {
            this.c = listAdapter;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void a(CharSequence charSequence) {
            this.d = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public CharSequence a() {
            return this.d;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void a(int i, int i2) {
            if (this.c == null) {
                return;
            }
            a.C0004a c0004a = new a.C0004a(AppCompatSpinner.this.getPopupContext());
            if (this.d != null) {
                c0004a.a(this.d);
            }
            this.a = c0004a.a(this.c, AppCompatSpinner.this.getSelectedItemPosition(), this).b();
            ListView a = this.a.a();
            if (Build.VERSION.SDK_INT >= 17) {
                a.setTextDirection(i);
                a.setTextAlignment(i2);
            }
            this.a.show();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            AppCompatSpinner.this.setSelection(i);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick(null, i, this.c.getItemId(i));
            }
            d();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void a(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void a(int i) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void b(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void c(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }
    }

    /* compiled from: source */
    class c extends ListPopupWindow implements d {
        ListAdapter a;
        private CharSequence h;
        private final Rect i;
        private int j;

        public c(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.i = new Rect();
            b(AppCompatSpinner.this);
            a(true);
            d(0);
            a(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.c.1
                final /* synthetic */ AppCompatSpinner a;

                AnonymousClass1(AppCompatSpinner appCompatSpinner) {
                    r2 = appCompatSpinner;
                }

                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    AppCompatSpinner.this.setSelection(i2);
                    if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                        AppCompatSpinner.this.performItemClick(view, i2, c.this.a.getItemId(i2));
                    }
                    c.this.d();
                }
            });
        }

        /* compiled from: source */
        /* renamed from: androidx.appcompat.widget.AppCompatSpinner$c$1 */
        class AnonymousClass1 implements AdapterView.OnItemClickListener {
            final /* synthetic */ AppCompatSpinner a;

            AnonymousClass1(AppCompatSpinner appCompatSpinner) {
                r2 = appCompatSpinner;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                AppCompatSpinner.this.setSelection(i2);
                if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                    AppCompatSpinner.this.performItemClick(view, i2, c.this.a.getItemId(i2));
                }
                c.this.d();
            }
        }

        @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.AppCompatSpinner.d
        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.a = listAdapter;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public CharSequence a() {
            return this.h;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void a(CharSequence charSequence) {
            this.h = charSequence;
        }

        void h() {
            int i;
            Drawable b = b();
            int i2 = 0;
            if (b != null) {
                b.getPadding(AppCompatSpinner.this.b);
                i2 = al.a(AppCompatSpinner.this) ? AppCompatSpinner.this.b.right : -AppCompatSpinner.this.b.left;
            } else {
                Rect rect = AppCompatSpinner.this.b;
                AppCompatSpinner.this.b.right = 0;
                rect.left = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            if (AppCompatSpinner.this.a == -2) {
                int a = AppCompatSpinner.this.a((SpinnerAdapter) this.a, b());
                int i3 = (AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.this.b.left) - AppCompatSpinner.this.b.right;
                if (a > i3) {
                    a = i3;
                }
                h(Math.max(a, (width - paddingLeft) - paddingRight));
            } else if (AppCompatSpinner.this.a == -1) {
                h((width - paddingLeft) - paddingRight);
            } else {
                h(AppCompatSpinner.this.a);
            }
            if (al.a(AppCompatSpinner.this)) {
                i = i2 + (((width - paddingRight) - l()) - i());
            } else {
                i = i2 + paddingLeft + i();
            }
            b(i);
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void a(int i, int i2) {
            ViewTreeObserver viewTreeObserver;
            boolean e = e();
            h();
            i(2);
            super.a_();
            ListView g = g();
            g.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                g.setTextDirection(i);
                g.setTextAlignment(i2);
            }
            j(AppCompatSpinner.this.getSelectedItemPosition());
            if (e || (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) == null) {
                return;
            }
            AnonymousClass2 anonymousClass2 = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.c.2
                AnonymousClass2() {
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (!c.this.a(AppCompatSpinner.this)) {
                        c.this.d();
                    } else {
                        c.this.h();
                        c.super.a_();
                    }
                }
            };
            viewTreeObserver.addOnGlobalLayoutListener(anonymousClass2);
            a(new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.c.3
                final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener a;

                AnonymousClass3(ViewTreeObserver.OnGlobalLayoutListener anonymousClass22) {
                    onGlobalLayoutListener = anonymousClass22;
                }

                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    ViewTreeObserver viewTreeObserver2 = AppCompatSpinner.this.getViewTreeObserver();
                    if (viewTreeObserver2 != null) {
                        viewTreeObserver2.removeGlobalOnLayoutListener(onGlobalLayoutListener);
                    }
                }
            });
        }

        /* compiled from: source */
        /* renamed from: androidx.appcompat.widget.AppCompatSpinner$c$2 */
        class AnonymousClass2 implements ViewTreeObserver.OnGlobalLayoutListener {
            AnonymousClass2() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (!c.this.a(AppCompatSpinner.this)) {
                    c.this.d();
                } else {
                    c.this.h();
                    c.super.a_();
                }
            }
        }

        /* compiled from: source */
        /* renamed from: androidx.appcompat.widget.AppCompatSpinner$c$3 */
        class AnonymousClass3 implements PopupWindow.OnDismissListener {
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener a;

            AnonymousClass3(ViewTreeObserver.OnGlobalLayoutListener anonymousClass22) {
                onGlobalLayoutListener = anonymousClass22;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver2 = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver2 != null) {
                    viewTreeObserver2.removeGlobalOnLayoutListener(onGlobalLayoutListener);
                }
            }
        }

        boolean a(View view) {
            return androidx.core.h.w.F(view) && view.getGlobalVisibleRect(this.i);
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.d
        public void c(int i) {
            this.j = i;
        }

        public int i() {
            return this.j;
        }
    }
}
