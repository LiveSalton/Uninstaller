package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.t;
import androidx.appcompat.widget.u;
import androidx.core.h.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
final class d extends k implements View.OnKeyListener, PopupWindow.OnDismissListener, m {
    private static final int g = a.g.abc_cascading_menu_item_layout;
    private PopupWindow.OnDismissListener A;
    final Handler a;
    View d;
    ViewTreeObserver e;
    boolean f;
    private final Context h;
    private final int i;
    private final int j;
    private final int k;
    private final boolean l;
    private View r;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private boolean y;
    private m.a z;
    private final List<g> m = new ArrayList();
    final List<a> b = new ArrayList();
    final ViewTreeObserver.OnGlobalLayoutListener c = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.d.1
        AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!d.this.e() || d.this.b.size() <= 0 || d.this.b.get(0).a.j()) {
                return;
            }
            View view = d.this.d;
            if (view == null || !view.isShown()) {
                d.this.d();
                return;
            }
            Iterator<a> it = d.this.b.iterator();
            while (it.hasNext()) {
                it.next().a.a_();
            }
        }
    };
    private final View.OnAttachStateChangeListener n = new View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.d.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        AnonymousClass2() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (d.this.e != null) {
                if (!d.this.e.isAlive()) {
                    d.this.e = view.getViewTreeObserver();
                }
                d.this.e.removeGlobalOnLayoutListener(d.this.c);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private final t o = new t() { // from class: androidx.appcompat.view.menu.d.3
        AnonymousClass3() {
        }

        @Override // androidx.appcompat.widget.t
        public void a(g gVar, MenuItem menuItem) {
            d.this.a.removeCallbacksAndMessages(gVar);
        }

        @Override // androidx.appcompat.widget.t
        public void b(g gVar, MenuItem menuItem) {
            d.this.a.removeCallbacksAndMessages(null);
            int size = d.this.b.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (gVar == d.this.b.get(i).b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return;
            }
            int i2 = i + 1;
            d.this.a.postAtTime(new Runnable() { // from class: androidx.appcompat.view.menu.d.3.1
                final /* synthetic */ a a;
                final /* synthetic */ MenuItem b;
                final /* synthetic */ g c;

                AnonymousClass1(a aVar, MenuItem menuItem2, g gVar2) {
                    aVar = aVar;
                    menuItem = menuItem2;
                    gVar = gVar2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (aVar != null) {
                        d.this.f = true;
                        aVar.b.a(false);
                        d.this.f = false;
                    }
                    if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                        gVar.a(menuItem, 4);
                    }
                }
            }, gVar2, SystemClock.uptimeMillis() + 200);
        }

        /* compiled from: source */
        /* renamed from: androidx.appcompat.view.menu.d$3$1 */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ a a;
            final /* synthetic */ MenuItem b;
            final /* synthetic */ g c;

            AnonymousClass1(a aVar, MenuItem menuItem2, g gVar2) {
                aVar = aVar;
                menuItem = menuItem2;
                gVar = gVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (aVar != null) {
                    d.this.f = true;
                    aVar.b.a(false);
                    d.this.f = false;
                }
                if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                    gVar.a(menuItem, 4);
                }
            }
        }
    };
    private int p = 0;
    private int q = 0;
    private boolean x = false;
    private int s = k();

    @Override // androidx.appcompat.view.menu.m
    public void a(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean b() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable f() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.k
    protected boolean h() {
        return false;
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.view.menu.d$1 */
    class AnonymousClass1 implements ViewTreeObserver.OnGlobalLayoutListener {
        AnonymousClass1() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!d.this.e() || d.this.b.size() <= 0 || d.this.b.get(0).a.j()) {
                return;
            }
            View view = d.this.d;
            if (view == null || !view.isShown()) {
                d.this.d();
                return;
            }
            Iterator<a> it = d.this.b.iterator();
            while (it.hasNext()) {
                it.next().a.a_();
            }
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.view.menu.d$2 */
    class AnonymousClass2 implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        AnonymousClass2() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (d.this.e != null) {
                if (!d.this.e.isAlive()) {
                    d.this.e = view.getViewTreeObserver();
                }
                d.this.e.removeGlobalOnLayoutListener(d.this.c);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.appcompat.view.menu.d$3 */
    class AnonymousClass3 implements t {
        AnonymousClass3() {
        }

        @Override // androidx.appcompat.widget.t
        public void a(g gVar, MenuItem menuItem) {
            d.this.a.removeCallbacksAndMessages(gVar);
        }

        @Override // androidx.appcompat.widget.t
        public void b(g gVar2, MenuItem menuItem2) {
            d.this.a.removeCallbacksAndMessages(null);
            int size = d.this.b.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (gVar2 == d.this.b.get(i).b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return;
            }
            int i2 = i + 1;
            d.this.a.postAtTime(new Runnable() { // from class: androidx.appcompat.view.menu.d.3.1
                final /* synthetic */ a a;
                final /* synthetic */ MenuItem b;
                final /* synthetic */ g c;

                AnonymousClass1(a aVar, MenuItem menuItem22, g gVar22) {
                    aVar = aVar;
                    menuItem = menuItem22;
                    gVar = gVar22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (aVar != null) {
                        d.this.f = true;
                        aVar.b.a(false);
                        d.this.f = false;
                    }
                    if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                        gVar.a(menuItem, 4);
                    }
                }
            }, gVar22, SystemClock.uptimeMillis() + 200);
        }

        /* compiled from: source */
        /* renamed from: androidx.appcompat.view.menu.d$3$1 */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ a a;
            final /* synthetic */ MenuItem b;
            final /* synthetic */ g c;

            AnonymousClass1(a aVar, MenuItem menuItem22, g gVar22) {
                aVar = aVar;
                menuItem = menuItem22;
                gVar = gVar22;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (aVar != null) {
                    d.this.f = true;
                    aVar.b.a(false);
                    d.this.f = false;
                }
                if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                    gVar.a(menuItem, 4);
                }
            }
        }
    }

    public d(Context context, View view, int i, int i2, boolean z) {
        this.h = context;
        this.r = view;
        this.j = i;
        this.k = i2;
        this.l = z;
        Resources resources = context.getResources();
        this.i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
        this.a = new Handler();
    }

    @Override // androidx.appcompat.view.menu.k
    public void b(boolean z) {
        this.x = z;
    }

    private u j() {
        u uVar = new u(this.h, null, this.j, this.k);
        uVar.a(this.o);
        uVar.a((AdapterView.OnItemClickListener) this);
        uVar.a((PopupWindow.OnDismissListener) this);
        uVar.b(this.r);
        uVar.f(this.q);
        uVar.a(true);
        uVar.i(2);
        return uVar;
    }

    @Override // androidx.appcompat.view.menu.p
    public void a_() {
        if (e()) {
            return;
        }
        Iterator<g> it = this.m.iterator();
        while (it.hasNext()) {
            c(it.next());
        }
        this.m.clear();
        this.d = this.r;
        if (this.d != null) {
            boolean z = this.e == null;
            this.e = this.d.getViewTreeObserver();
            if (z) {
                this.e.addOnGlobalLayoutListener(this.c);
            }
            this.d.addOnAttachStateChangeListener(this.n);
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public void d() {
        int size = this.b.size();
        if (size > 0) {
            a[] aVarArr = (a[]) this.b.toArray(new a[size]);
            for (int i = size - 1; i >= 0; i--) {
                a aVar = aVarArr[i];
                if (aVar.a.e()) {
                    aVar.a.d();
                }
            }
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        d();
        return true;
    }

    private int k() {
        return w.h(this.r) == 1 ? 0 : 1;
    }

    private int d(int i) {
        ListView a2 = this.b.get(this.b.size() - 1).a();
        int[] iArr = new int[2];
        a2.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.d.getWindowVisibleDisplayFrame(rect);
        return this.s == 1 ? (iArr[0] + a2.getWidth()) + i > rect.right ? 0 : 1 : iArr[0] - i < 0 ? 1 : 0;
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(g gVar) {
        gVar.a(this, this.h);
        if (e()) {
            c(gVar);
        } else {
            this.m.add(gVar);
        }
    }

    private void c(g gVar) {
        a aVar;
        View view;
        int i;
        int i2;
        int width;
        LayoutInflater from = LayoutInflater.from(this.h);
        f fVar = new f(gVar, from, this.l, g);
        if (!e() && this.x) {
            fVar.a(true);
        } else if (e()) {
            fVar.a(k.b(gVar));
        }
        int a2 = a(fVar, null, this.h, this.i);
        u j = j();
        j.a((ListAdapter) fVar);
        j.h(a2);
        j.f(this.q);
        if (this.b.size() > 0) {
            aVar = this.b.get(this.b.size() - 1);
            view = a(aVar, gVar);
        } else {
            aVar = null;
            view = null;
        }
        if (view != null) {
            j.c(false);
            j.a((Object) null);
            int d = d(a2);
            boolean z = d == 1;
            this.s = d;
            if (Build.VERSION.SDK_INT >= 26) {
                j.b(view);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.r.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.q & 7) == 5) {
                    iArr[0] = iArr[0] + this.r.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.q & 5) == 5) {
                width = z ? i + a2 : i - view.getWidth();
            } else {
                width = z ? i + view.getWidth() : i - a2;
            }
            j.b(width);
            j.b(true);
            j.a(i2);
        } else {
            if (this.t) {
                j.b(this.v);
            }
            if (this.u) {
                j.a(this.w);
            }
            j.a(i());
        }
        this.b.add(new a(j, gVar, this.s));
        j.a_();
        ListView g2 = j.g();
        g2.setOnKeyListener(this);
        if (aVar == null && this.y && gVar.n() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(a.g.abc_popup_menu_header_item_layout, (ViewGroup) g2, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(gVar.n());
            g2.addHeaderView(frameLayout, null, false);
            j.a_();
        }
    }

    private MenuItem a(g gVar, g gVar2) {
        int size = gVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = gVar.getItem(i);
            if (item.hasSubMenu() && gVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View a(a aVar, g gVar) {
        f fVar;
        int i;
        int firstVisiblePosition;
        MenuItem a2 = a(aVar.b, gVar);
        if (a2 == null) {
            return null;
        }
        ListView a3 = aVar.a();
        ListAdapter adapter = a3.getAdapter();
        int i2 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i = headerViewListAdapter.getHeadersCount();
            fVar = (f) headerViewListAdapter.getWrappedAdapter();
        } else {
            fVar = (f) adapter;
            i = 0;
        }
        int count = fVar.getCount();
        while (true) {
            if (i2 >= count) {
                i2 = -1;
                break;
            }
            if (a2 == fVar.getItem(i2)) {
                break;
            }
            i2++;
        }
        if (i2 != -1 && (firstVisiblePosition = (i2 + i) - a3.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a3.getChildCount()) {
            return a3.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean e() {
        return this.b.size() > 0 && this.b.get(0).a.e();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        a aVar;
        int size = this.b.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.b.get(i);
            if (!aVar.a.e()) {
                break;
            } else {
                i++;
            }
        }
        if (aVar != null) {
            aVar.b.a(false);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(boolean z) {
        Iterator<a> it = this.b.iterator();
        while (it.hasNext()) {
            a(it.next().a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(m.a aVar) {
        this.z = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean a(r rVar) {
        for (a aVar : this.b) {
            if (rVar == aVar.b) {
                aVar.a().requestFocus();
                return true;
            }
        }
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        a((g) rVar);
        if (this.z != null) {
            this.z.a(rVar);
        }
        return true;
    }

    private int d(g gVar) {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            if (gVar == this.b.get(i).b) {
                return i;
            }
        }
        return -1;
    }

    @Override // androidx.appcompat.view.menu.m
    public void a(g gVar, boolean z) {
        int d = d(gVar);
        if (d < 0) {
            return;
        }
        int i = d + 1;
        if (i < this.b.size()) {
            this.b.get(i).b.a(false);
        }
        a remove = this.b.remove(d);
        remove.b.b(this);
        if (this.f) {
            remove.a.b((Object) null);
            remove.a.e(0);
        }
        remove.a.d();
        int size = this.b.size();
        if (size > 0) {
            this.s = this.b.get(size - 1).c;
        } else {
            this.s = k();
        }
        if (size != 0) {
            if (z) {
                this.b.get(0).b.a(false);
                return;
            }
            return;
        }
        d();
        if (this.z != null) {
            this.z.a(gVar, true);
        }
        if (this.e != null) {
            if (this.e.isAlive()) {
                this.e.removeGlobalOnLayoutListener(this.c);
            }
            this.e = null;
        }
        this.d.removeOnAttachStateChangeListener(this.n);
        this.A.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(int i) {
        if (this.p != i) {
            this.p = i;
            this.q = androidx.core.h.d.a(i, w.h(this.r));
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(View view) {
        if (this.r != view) {
            this.r = view;
            this.q = androidx.core.h.d.a(this.p, w.h(this.r));
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.A = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView g() {
        if (this.b.isEmpty()) {
            return null;
        }
        return this.b.get(this.b.size() - 1).a();
    }

    @Override // androidx.appcompat.view.menu.k
    public void b(int i) {
        this.t = true;
        this.v = i;
    }

    @Override // androidx.appcompat.view.menu.k
    public void c(int i) {
        this.u = true;
        this.w = i;
    }

    @Override // androidx.appcompat.view.menu.k
    public void c(boolean z) {
        this.y = z;
    }

    /* compiled from: source */
    private static class a {
        public final u a;
        public final g b;
        public final int c;

        public a(u uVar, g gVar, int i) {
            this.a = uVar;
            this.b = gVar;
            this.c = i;
        }

        public ListView a() {
            return this.a.g();
        }
    }
}
