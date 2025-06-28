package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.h.b;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
class ActionMenuPresenter extends androidx.appcompat.view.menu.b implements b.a {
    d g;
    e h;
    a i;
    c j;
    final f k;
    int l;
    private Drawable m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;
    private final SparseBooleanArray y;
    private b z;

    public ActionMenuPresenter(Context context) {
        super(context, a.g.abc_action_menu_layout, a.g.abc_action_menu_item_layout);
        this.y = new SparseBooleanArray();
        this.k = new f();
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void a(Context context, androidx.appcompat.view.menu.g gVar) {
        super.a(context, gVar);
        Resources resources = context.getResources();
        androidx.appcompat.view.a a2 = androidx.appcompat.view.a.a(context);
        if (!this.p) {
            this.o = a2.b();
        }
        if (!this.v) {
            this.q = a2.c();
        }
        if (!this.t) {
            this.s = a2.a();
        }
        int i = this.q;
        if (this.o) {
            if (this.g == null) {
                this.g = new d(this.a);
                if (this.n) {
                    this.g.setImageDrawable(this.m);
                    this.m = null;
                    this.n = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.g.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.g.getMeasuredWidth();
        } else {
            this.g = null;
        }
        this.r = i;
        this.x = (int) (56.0f * resources.getDisplayMetrics().density);
    }

    public void a(Configuration configuration) {
        if (!this.t) {
            this.s = androidx.appcompat.view.a.a(this.b).a();
        }
        if (this.c != null) {
            this.c.b(true);
        }
    }

    public void b(boolean z) {
        this.o = z;
        this.p = true;
    }

    public void c(boolean z) {
        this.w = z;
    }

    public void a(Drawable drawable) {
        if (this.g != null) {
            this.g.setImageDrawable(drawable);
        } else {
            this.n = true;
            this.m = drawable;
        }
    }

    public Drawable d() {
        if (this.g != null) {
            return this.g.getDrawable();
        }
        if (this.n) {
            return this.m;
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.b
    public androidx.appcompat.view.menu.n a(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.n nVar = this.f;
        androidx.appcompat.view.menu.n a2 = super.a(viewGroup);
        if (nVar != a2) {
            ((ActionMenuView) a2).setPresenter(this);
        }
        return a2;
    }

    @Override // androidx.appcompat.view.menu.b
    public View a(androidx.appcompat.view.menu.i iVar, View view, ViewGroup viewGroup) {
        View actionView = iVar.getActionView();
        if (actionView == null || iVar.n()) {
            actionView = super.a(iVar, view, viewGroup);
        }
        actionView.setVisibility(iVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.b
    public void a(androidx.appcompat.view.menu.i iVar, n.a aVar) {
        aVar.a(iVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f);
        if (this.z == null) {
            this.z = new b();
        }
        actionMenuItemView.setPopupCallback(this.z);
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean a(int i, androidx.appcompat.view.menu.i iVar) {
        return iVar.j();
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void a(boolean z) {
        super.a(z);
        ((View) this.f).requestLayout();
        boolean z2 = false;
        if (this.c != null) {
            ArrayList<androidx.appcompat.view.menu.i> l = this.c.l();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                androidx.core.h.b a2 = l.get(i).a();
                if (a2 != null) {
                    a2.a(this);
                }
            }
        }
        ArrayList<androidx.appcompat.view.menu.i> m = this.c != null ? this.c.m() : null;
        if (this.o && m != null) {
            int size2 = m.size();
            if (size2 == 1) {
                z2 = !m.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.g == null) {
                this.g = new d(this.a);
            }
            ViewGroup viewGroup = (ViewGroup) this.g.getParent();
            if (viewGroup != this.f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.g);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.g, actionMenuView.c());
            }
        } else if (this.g != null && this.g.getParent() == this.f) {
            ((ViewGroup) this.f).removeView(this.g);
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.o);
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.g) {
            return false;
        }
        return super.a(viewGroup, i);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public boolean a(androidx.appcompat.view.menu.r rVar) {
        boolean z = false;
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.r rVar2 = rVar;
        while (rVar2.t() != this.c) {
            rVar2 = (androidx.appcompat.view.menu.r) rVar2.t();
        }
        View a2 = a(rVar2.getItem());
        if (a2 == null) {
            return false;
        }
        this.l = rVar.getItem().getItemId();
        int size = rVar.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = rVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        this.i = new a(this.b, rVar, a2);
        this.i.a(z);
        this.i.a();
        super.a(rVar);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof n.a) && ((n.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean e() {
        if (!this.o || j() || this.c == null || this.f == null || this.j != null || this.c.m().isEmpty()) {
            return false;
        }
        this.j = new c(new e(this.b, this.c, this.g, true));
        ((View) this.f).post(this.j);
        return true;
    }

    public boolean g() {
        if (this.j != null && this.f != null) {
            ((View) this.f).removeCallbacks(this.j);
            this.j = null;
            return true;
        }
        e eVar = this.h;
        if (eVar == null) {
            return false;
        }
        eVar.d();
        return true;
    }

    public boolean h() {
        return g() | i();
    }

    public boolean i() {
        if (this.i == null) {
            return false;
        }
        this.i.d();
        return true;
    }

    public boolean j() {
        return this.h != null && this.h.f();
    }

    public boolean k() {
        return this.j != null || j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0100  */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v15 */
    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b() {
        /*
            Method dump skipped, instructions count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuPresenter.b():boolean");
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
        h();
        super.a(gVar, z);
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable f() {
        SavedState savedState = new SavedState();
        savedState.a = this.l;
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(Parcelable parcelable) {
        MenuItem findItem;
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            if (savedState.a <= 0 || (findItem = this.c.findItem(savedState.a)) == null) {
                return;
            }
            a((androidx.appcompat.view.menu.r) findItem.getSubMenu());
        }
    }

    @Override // androidx.core.h.b.a
    public void d(boolean z) {
        if (z) {
            super.a((androidx.appcompat.view.menu.r) null);
        } else if (this.c != null) {
            this.c.a(false);
        }
    }

    public void a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.a(this.c);
    }

    /* compiled from: source */
    @SuppressLint({"BanParcelableUsage"})
    private static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.appcompat.widget.ActionMenuPresenter.SavedState.1
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
        public int a;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.a = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
        }

        /* compiled from: source */
        /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$SavedState$1 */
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
    private class d extends AppCompatImageView implements ActionMenuView.a {
        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean c() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean d() {
            return false;
        }

        public d(Context context) {
            super(context, null, a.C0001a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            ah.a(this, getContentDescription());
            setOnTouchListener(new s(this) { // from class: androidx.appcompat.widget.ActionMenuPresenter.d.1
                final /* synthetic */ ActionMenuPresenter a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(View this, ActionMenuPresenter actionMenuPresenter) {
                    super(this);
                    r3 = actionMenuPresenter;
                }

                @Override // androidx.appcompat.widget.s
                public androidx.appcompat.view.menu.p a() {
                    if (ActionMenuPresenter.this.h == null) {
                        return null;
                    }
                    return ActionMenuPresenter.this.h.b();
                }

                @Override // androidx.appcompat.widget.s
                public boolean b() {
                    ActionMenuPresenter.this.e();
                    return true;
                }

                @Override // androidx.appcompat.widget.s
                public boolean c() {
                    if (ActionMenuPresenter.this.j != null) {
                        return false;
                    }
                    ActionMenuPresenter.this.g();
                    return true;
                }
            });
        }

        /* compiled from: source */
        /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$d$1 */
        class AnonymousClass1 extends s {
            final /* synthetic */ ActionMenuPresenter a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(View this, ActionMenuPresenter actionMenuPresenter) {
                super(this);
                r3 = actionMenuPresenter;
            }

            @Override // androidx.appcompat.widget.s
            public androidx.appcompat.view.menu.p a() {
                if (ActionMenuPresenter.this.h == null) {
                    return null;
                }
                return ActionMenuPresenter.this.h.b();
            }

            @Override // androidx.appcompat.widget.s
            public boolean b() {
                ActionMenuPresenter.this.e();
                return true;
            }

            @Override // androidx.appcompat.widget.s
            public boolean c() {
                if (ActionMenuPresenter.this.j != null) {
                    return false;
                }
                ActionMenuPresenter.this.g();
                return true;
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.e();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.a(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* compiled from: source */
    private class e extends androidx.appcompat.view.menu.l {
        public e(Context context, androidx.appcompat.view.menu.g gVar, View view, boolean z) {
            super(context, gVar, view, z, a.C0001a.actionOverflowMenuStyle);
            a(8388613);
            a(ActionMenuPresenter.this.k);
        }

        @Override // androidx.appcompat.view.menu.l
        protected void e() {
            if (ActionMenuPresenter.this.c != null) {
                ActionMenuPresenter.this.c.close();
            }
            ActionMenuPresenter.this.h = null;
            super.e();
        }
    }

    /* compiled from: source */
    private class a extends androidx.appcompat.view.menu.l {
        public a(Context context, androidx.appcompat.view.menu.r rVar, View view) {
            super(context, rVar, view, false, a.C0001a.actionOverflowMenuStyle);
            if (!((androidx.appcompat.view.menu.i) rVar.getItem()).j()) {
                a(ActionMenuPresenter.this.g == null ? (View) ActionMenuPresenter.this.f : ActionMenuPresenter.this.g);
            }
            a(ActionMenuPresenter.this.k);
        }

        @Override // androidx.appcompat.view.menu.l
        protected void e() {
            ActionMenuPresenter.this.i = null;
            ActionMenuPresenter.this.l = 0;
            super.e();
        }
    }

    /* compiled from: source */
    private class f implements m.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean a(androidx.appcompat.view.menu.g gVar) {
            if (gVar == ActionMenuPresenter.this.c) {
                return false;
            }
            ActionMenuPresenter.this.l = ((androidx.appcompat.view.menu.r) gVar).getItem().getItemId();
            m.a a = ActionMenuPresenter.this.a();
            if (a != null) {
                return a.a(gVar);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
            if (gVar instanceof androidx.appcompat.view.menu.r) {
                gVar.q().a(false);
            }
            m.a a = ActionMenuPresenter.this.a();
            if (a != null) {
                a.a(gVar, z);
            }
        }
    }

    /* compiled from: source */
    private class c implements Runnable {
        private e b;

        public c(e eVar) {
            this.b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ActionMenuPresenter.this.c != null) {
                ActionMenuPresenter.this.c.g();
            }
            View view = (View) ActionMenuPresenter.this.f;
            if (view != null && view.getWindowToken() != null && this.b.c()) {
                ActionMenuPresenter.this.h = this.b;
            }
            ActionMenuPresenter.this.j = null;
        }
    }

    /* compiled from: source */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public androidx.appcompat.view.menu.p a() {
            if (ActionMenuPresenter.this.i != null) {
                return ActionMenuPresenter.this.i.b();
            }
            return null;
        }
    }
}
