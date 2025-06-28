package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.view.menu.r;
import androidx.core.h.ae;
import androidx.core.h.w;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.a;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public class g implements m {
    LinearLayout a;
    androidx.appcompat.view.menu.g b;
    b c;
    LayoutInflater d;
    int e;
    boolean f;
    ColorStateList g;
    ColorStateList h;
    Drawable i;
    int j;
    int k;
    int l;
    final View.OnClickListener m = new View.OnClickListener() { // from class: com.google.android.material.internal.g.1
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.b(true);
            androidx.appcompat.view.menu.i itemData = ((NavigationMenuItemView) view).getItemData();
            boolean a2 = g.this.b.a(itemData, g.this, 0);
            if (itemData != null && itemData.isCheckable() && a2) {
                g.this.c.a(itemData);
            }
            g.this.b(false);
            g.this.a(false);
        }
    };
    private NavigationMenuView n;
    private m.a o;
    private int p;
    private int q;

    /* compiled from: source */
    private interface d {
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean a(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean a(r rVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean b() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean b(androidx.appcompat.view.menu.g gVar, androidx.appcompat.view.menu.i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(Context context, androidx.appcompat.view.menu.g gVar) {
        this.d = LayoutInflater.from(context);
        this.b = gVar;
        this.l = context.getResources().getDimensionPixelOffset(a.d.design_navigation_separator_vertical_padding);
    }

    public n a(ViewGroup viewGroup) {
        if (this.n == null) {
            this.n = (NavigationMenuView) this.d.inflate(a.h.design_navigation_menu, viewGroup, false);
            if (this.c == null) {
                this.c = new b();
            }
            this.a = (LinearLayout) this.d.inflate(a.h.design_navigation_item_header, (ViewGroup) this.n, false);
            this.n.setAdapter(this.c);
        }
        return this.n;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(boolean z) {
        if (this.c != null) {
            this.c.d();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(m.a aVar) {
        this.o = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(androidx.appcompat.view.menu.g gVar, boolean z) {
        if (this.o != null) {
            this.o.a(gVar, z);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public int c() {
        return this.p;
    }

    public void a(int i2) {
        this.p = i2;
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable f() {
        Bundle bundle = new Bundle();
        if (this.n != null) {
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            this.n.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        if (this.c != null) {
            bundle.putBundle("android:menu:adapter", this.c.f());
        }
        if (this.a != null) {
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            this.a.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.n.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.c.a(bundle2);
            }
            SparseArray sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.a.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    public void a(androidx.appcompat.view.menu.i iVar) {
        this.c.a(iVar);
    }

    public androidx.appcompat.view.menu.i a() {
        return this.c.e();
    }

    public View b(int i2) {
        View inflate = this.d.inflate(i2, (ViewGroup) this.a, false);
        a(inflate);
        return inflate;
    }

    public void a(View view) {
        this.a.addView(view);
        this.n.setPadding(0, 0, 0, this.n.getPaddingBottom());
    }

    public int d() {
        return this.a.getChildCount();
    }

    public ColorStateList e() {
        return this.h;
    }

    public void a(ColorStateList colorStateList) {
        this.h = colorStateList;
        a(false);
    }

    public ColorStateList g() {
        return this.g;
    }

    public void b(ColorStateList colorStateList) {
        this.g = colorStateList;
        a(false);
    }

    public void c(int i2) {
        this.e = i2;
        this.f = true;
        a(false);
    }

    public Drawable h() {
        return this.i;
    }

    public void a(Drawable drawable) {
        this.i = drawable;
        a(false);
    }

    public int i() {
        return this.j;
    }

    public void d(int i2) {
        this.j = i2;
        a(false);
    }

    public int j() {
        return this.k;
    }

    public void e(int i2) {
        this.k = i2;
        a(false);
    }

    public void b(boolean z) {
        if (this.c != null) {
            this.c.a(z);
        }
    }

    public void a(ae aeVar) {
        int b2 = aeVar.b();
        if (this.q != b2) {
            this.q = b2;
            if (this.a.getChildCount() == 0) {
                this.n.setPadding(0, this.q, 0, this.n.getPaddingBottom());
            }
        }
        w.b(this.a, aeVar);
    }

    /* compiled from: source */
    private static abstract class j extends RecyclerView.v {
        public j(View view) {
            super(view);
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.internal.g$g */
    private static class C0084g extends j {
        public C0084g(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(a.h.design_navigation_item, viewGroup, false));
            this.a.setOnClickListener(onClickListener);
        }
    }

    /* compiled from: source */
    private static class i extends j {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(a.h.design_navigation_item_subheader, viewGroup, false));
        }
    }

    /* compiled from: source */
    private static class h extends j {
        public h(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(a.h.design_navigation_item_separator, viewGroup, false));
        }
    }

    /* compiled from: source */
    private static class a extends j {
        public a(View view) {
            super(view);
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.android.material.internal.g$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.b(true);
            androidx.appcompat.view.menu.i itemData = ((NavigationMenuItemView) view).getItemData();
            boolean a2 = g.this.b.a(itemData, g.this, 0);
            if (itemData != null && itemData.isCheckable() && a2) {
                g.this.c.a(itemData);
            }
            g.this.b(false);
            g.this.a(false);
        }
    }

    /* compiled from: source */
    private class b extends RecyclerView.a<j> {
        private final ArrayList<d> b = new ArrayList<>();
        private androidx.appcompat.view.menu.i c;
        private boolean d;

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public long b(int i) {
            return i;
        }

        b() {
            g();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public int a() {
            return this.b.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public int a(int i) {
            d dVar = this.b.get(i);
            if (dVar instanceof e) {
                return 2;
            }
            if (dVar instanceof c) {
                return 3;
            }
            if (dVar instanceof f) {
                return ((f) dVar).a().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        /* renamed from: c */
        public j a(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    return new C0084g(g.this.d, viewGroup, g.this.m);
                case 1:
                    return new i(g.this.d, viewGroup);
                case 2:
                    return new h(g.this.d, viewGroup);
                case 3:
                    return new a(g.this.a);
                default:
                    return null;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public void a(j jVar, int i) {
            switch (a(i)) {
                case 0:
                    NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) jVar.a;
                    navigationMenuItemView.setIconTintList(g.this.h);
                    if (g.this.f) {
                        navigationMenuItemView.setTextAppearance(g.this.e);
                    }
                    if (g.this.g != null) {
                        navigationMenuItemView.setTextColor(g.this.g);
                    }
                    w.a(navigationMenuItemView, g.this.i != null ? g.this.i.getConstantState().newDrawable() : null);
                    f fVar = (f) this.b.get(i);
                    navigationMenuItemView.setNeedsEmptyIcon(fVar.a);
                    navigationMenuItemView.setHorizontalPadding(g.this.j);
                    navigationMenuItemView.setIconPadding(g.this.k);
                    navigationMenuItemView.a(fVar.a(), 0);
                    break;
                case 1:
                    ((TextView) jVar.a).setText(((f) this.b.get(i)).a().getTitle());
                    break;
                case 2:
                    e eVar = (e) this.b.get(i);
                    jVar.a.setPadding(0, eVar.a(), 0, eVar.b());
                    break;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a
        public void a(j jVar) {
            if (jVar instanceof C0084g) {
                ((NavigationMenuItemView) jVar.a).b();
            }
        }

        public void d() {
            g();
            c();
        }

        private void g() {
            if (this.d) {
                return;
            }
            boolean z = true;
            this.d = true;
            this.b.clear();
            this.b.add(new c());
            int size = g.this.b.j().size();
            int i = -1;
            int i2 = 0;
            boolean z2 = false;
            int i3 = 0;
            while (i2 < size) {
                androidx.appcompat.view.menu.i iVar = g.this.b.j().get(i2);
                if (iVar.isChecked()) {
                    a(iVar);
                }
                if (iVar.isCheckable()) {
                    iVar.a(false);
                }
                if (iVar.hasSubMenu()) {
                    SubMenu subMenu = iVar.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i2 != 0) {
                            this.b.add(new e(g.this.l, 0));
                        }
                        this.b.add(new f(iVar));
                        int size2 = this.b.size();
                        int size3 = subMenu.size();
                        int i4 = 0;
                        boolean z3 = false;
                        while (i4 < size3) {
                            androidx.appcompat.view.menu.i iVar2 = (androidx.appcompat.view.menu.i) subMenu.getItem(i4);
                            if (iVar2.isVisible()) {
                                if (!z3 && iVar2.getIcon() != null) {
                                    z3 = z;
                                }
                                if (iVar2.isCheckable()) {
                                    iVar2.a(false);
                                }
                                if (iVar.isChecked()) {
                                    a(iVar);
                                }
                                this.b.add(new f(iVar2));
                            }
                            i4++;
                            z = true;
                        }
                        if (z3) {
                            a(size2, this.b.size());
                        }
                    }
                } else {
                    int groupId = iVar.getGroupId();
                    if (groupId != i) {
                        i3 = this.b.size();
                        boolean z4 = iVar.getIcon() != null;
                        if (i2 != 0) {
                            i3++;
                            this.b.add(new e(g.this.l, g.this.l));
                        }
                        z2 = z4;
                    } else if (!z2 && iVar.getIcon() != null) {
                        a(i3, this.b.size());
                        z2 = true;
                    }
                    f fVar = new f(iVar);
                    fVar.a = z2;
                    this.b.add(fVar);
                    i = groupId;
                }
                i2++;
                z = true;
            }
            this.d = false;
        }

        private void a(int i, int i2) {
            while (i < i2) {
                ((f) this.b.get(i)).a = true;
                i++;
            }
        }

        public void a(androidx.appcompat.view.menu.i iVar) {
            if (this.c == iVar || !iVar.isCheckable()) {
                return;
            }
            if (this.c != null) {
                this.c.setChecked(false);
            }
            this.c = iVar;
            iVar.setChecked(true);
        }

        public androidx.appcompat.view.menu.i e() {
            return this.c;
        }

        public Bundle f() {
            Bundle bundle = new Bundle();
            if (this.c != null) {
                bundle.putInt("android:menu:checked", this.c.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                d dVar = this.b.get(i);
                if (dVar instanceof f) {
                    androidx.appcompat.view.menu.i a = ((f) dVar).a();
                    View actionView = a != null ? a.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(a.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        public void a(Bundle bundle) {
            androidx.appcompat.view.menu.i a;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            androidx.appcompat.view.menu.i a2;
            int i = bundle.getInt("android:menu:checked", 0);
            if (i != 0) {
                this.d = true;
                int size = this.b.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    d dVar = this.b.get(i2);
                    if ((dVar instanceof f) && (a2 = ((f) dVar).a()) != null && a2.getItemId() == i) {
                        a(a2);
                        break;
                    }
                    i2++;
                }
                this.d = false;
                g();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.b.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    d dVar2 = this.b.get(i3);
                    if ((dVar2 instanceof f) && (a = ((f) dVar2).a()) != null && (actionView = a.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(a.getItemId())) != null) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public void a(boolean z) {
            this.d = z;
        }
    }

    /* compiled from: source */
    private static class f implements d {
        boolean a;
        private final androidx.appcompat.view.menu.i b;

        f(androidx.appcompat.view.menu.i iVar) {
            this.b = iVar;
        }

        public androidx.appcompat.view.menu.i a() {
            return this.b;
        }
    }

    /* compiled from: source */
    private static class e implements d {
        private final int a;
        private final int b;

        public e(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public int a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }
    }

    /* compiled from: source */
    private static class c implements d {
        c() {
        }
    }
}
