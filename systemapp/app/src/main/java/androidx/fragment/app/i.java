package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.a;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.b;
import androidx.fragment.app.o;
import androidx.lifecycle.f;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class i {
    private static boolean f = false;
    private ArrayList<androidx.fragment.app.a> A;
    private ArrayList<Boolean> B;
    private ArrayList<Fragment> C;
    private ArrayList<d> D;
    private k E;
    ArrayList<androidx.fragment.app.a> a;
    f<?> c;
    androidx.fragment.app.c d;
    Fragment e;
    private boolean h;
    private ArrayList<Fragment> j;
    private OnBackPressedDispatcher l;
    private ArrayList<b> o;
    private Fragment s;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;
    private final ArrayList<c> g = new ArrayList<>();
    private final m i = new m();
    private final g k = new g(this);
    private final androidx.activity.b m = new androidx.activity.b(false) { // from class: androidx.fragment.app.i.1
        AnonymousClass1(boolean z) {
            super(z);
        }

        @Override // androidx.activity.b
        public void c() {
            i.this.c();
        }
    };
    private final AtomicInteger n = new AtomicInteger();
    private ConcurrentHashMap<Fragment, HashSet<androidx.core.d.a>> p = new ConcurrentHashMap<>();
    private final o.a q = new o.a() { // from class: androidx.fragment.app.i.2
        AnonymousClass2() {
        }

        @Override // androidx.fragment.app.o.a
        public void a(Fragment fragment, androidx.core.d.a aVar) {
            i.this.a(fragment, aVar);
        }

        @Override // androidx.fragment.app.o.a
        public void b(Fragment fragment, androidx.core.d.a aVar) {
            if (aVar.a()) {
                return;
            }
            i.this.b(fragment, aVar);
        }
    };
    private final h r = new h(this);
    int b = -1;
    private e t = null;
    private e u = new e() { // from class: androidx.fragment.app.i.3
        AnonymousClass3() {
        }

        @Override // androidx.fragment.app.e
        public Fragment c(ClassLoader classLoader, String str) {
            return i.this.c.a(i.this.c.j(), str, (Bundle) null);
        }
    };
    private Runnable F = new Runnable() { // from class: androidx.fragment.app.i.4
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.a(true);
        }
    };

    /* compiled from: source */
    public static abstract class a {
        public void a(i iVar, Fragment fragment) {
        }

        public void a(i iVar, Fragment fragment, Context context) {
        }

        public void a(i iVar, Fragment fragment, Bundle bundle) {
        }

        public void a(i iVar, Fragment fragment, View view, Bundle bundle) {
        }

        public void b(i iVar, Fragment fragment) {
        }

        public void b(i iVar, Fragment fragment, Context context) {
        }

        public void b(i iVar, Fragment fragment, Bundle bundle) {
        }

        public void c(i iVar, Fragment fragment) {
        }

        public void c(i iVar, Fragment fragment, Bundle bundle) {
        }

        public void d(i iVar, Fragment fragment) {
        }

        public void d(i iVar, Fragment fragment, Bundle bundle) {
        }

        public void e(i iVar, Fragment fragment) {
        }

        public void f(i iVar, Fragment fragment) {
        }

        public void g(i iVar, Fragment fragment) {
        }
    }

    /* compiled from: source */
    public interface b {
        void a();
    }

    /* compiled from: source */
    interface c {
        boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    static int d(int i) {
        if (i == 4097) {
            return 8194;
        }
        if (i != 4099) {
            return i != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    static boolean a(int i) {
        return f || Log.isLoggable("FragmentManager", i);
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.i$1 */
    class AnonymousClass1 extends androidx.activity.b {
        AnonymousClass1(boolean z) {
            super(z);
        }

        @Override // androidx.activity.b
        public void c() {
            i.this.c();
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.i$2 */
    class AnonymousClass2 implements o.a {
        AnonymousClass2() {
        }

        @Override // androidx.fragment.app.o.a
        public void a(Fragment fragment, androidx.core.d.a aVar) {
            i.this.a(fragment, aVar);
        }

        @Override // androidx.fragment.app.o.a
        public void b(Fragment fragment, androidx.core.d.a aVar) {
            if (aVar.a()) {
                return;
            }
            i.this.b(fragment, aVar);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.i$3 */
    class AnonymousClass3 extends e {
        AnonymousClass3() {
        }

        @Override // androidx.fragment.app.e
        public Fragment c(ClassLoader classLoader, String str) {
            return i.this.c.a(i.this.c.j(), str, (Bundle) null);
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.i$4 */
    class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.a(true);
        }
    }

    public n a() {
        return new androidx.fragment.app.a(this);
    }

    public boolean b() {
        boolean a2 = a(true);
        G();
        return a2;
    }

    private void C() {
        synchronized (this.g) {
            if (!this.g.isEmpty()) {
                this.m.a(true);
            } else {
                this.m.a(e() > 0 && a(this.s));
            }
        }
    }

    boolean a(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        i iVar = fragment.r;
        return fragment.equals(iVar.x()) && a(iVar.s);
    }

    void c() {
        a(true);
        if (this.m.a()) {
            d();
        } else {
            this.l.a();
        }
    }

    public boolean d() {
        return a((String) null, -1, 0);
    }

    private boolean a(String str, int i, int i2) {
        a(false);
        d(true);
        if (this.e != null && i < 0 && str == null && this.e.r().d()) {
            return true;
        }
        boolean a2 = a(this.A, this.B, str, i, i2);
        if (a2) {
            this.h = true;
            try {
                b(this.A, this.B);
            } finally {
                F();
            }
        }
        C();
        I();
        this.i.b();
        return a2;
    }

    public int e() {
        if (this.a != null) {
            return this.a.size();
        }
        return 0;
    }

    void a(Fragment fragment, androidx.core.d.a aVar) {
        if (this.p.get(fragment) == null) {
            this.p.put(fragment, new HashSet<>());
        }
        this.p.get(fragment).add(aVar);
    }

    void b(Fragment fragment, androidx.core.d.a aVar) {
        HashSet<androidx.core.d.a> hashSet = this.p.get(fragment);
        if (hashSet != null && hashSet.remove(aVar) && hashSet.isEmpty()) {
            this.p.remove(fragment);
            if (fragment.b < 3) {
                r(fragment);
                a(fragment, fragment.ap());
            }
        }
    }

    static Fragment a(View view) {
        Object tag = view.getTag(a.b.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    public List<Fragment> f() {
        return this.i.e();
    }

    x b(Fragment fragment) {
        return this.E.e(fragment);
    }

    private k p(Fragment fragment) {
        return this.E.d(fragment);
    }

    void c(Fragment fragment) {
        if (h()) {
            if (a(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.E.a(fragment) && a(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
        }
    }

    void d(Fragment fragment) {
        if (h()) {
            if (a(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.E.c(fragment) && a(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    public boolean g() {
        return this.y;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        if (this.s != null) {
            sb.append(this.s.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.s)));
            sb.append("}");
        } else {
            sb.append(this.c.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.c)));
            sb.append("}");
        }
        sb.append("}}");
        return sb.toString();
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.i.a(str, fileDescriptor, printWriter, strArr);
        if (this.j != null && (size2 = this.j.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i = 0; i < size2; i++) {
                Fragment fragment = this.j.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        if (this.a != null && (size = this.a.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i2 = 0; i2 < size; i2++) {
                androidx.fragment.app.a aVar = this.a.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.a(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.n.get());
        synchronized (this.g) {
            int size3 = this.g.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i3 = 0; i3 < size3; i3++) {
                    c cVar = this.g.get(i3);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i3);
                    printWriter.print(": ");
                    printWriter.println(cVar);
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.c);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.d);
        if (this.s != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.s);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.b);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.w);
        printWriter.print(" mStopped=");
        printWriter.print(this.x);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.y);
        if (this.v) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.v);
        }
    }

    void e(Fragment fragment) {
        if (fragment.G) {
            if (this.h) {
                this.z = true;
            } else {
                fragment.G = false;
                a(fragment, this.b);
            }
        }
    }

    boolean b(int i) {
        return this.b >= i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(androidx.fragment.app.Fragment r10, int r11) {
        /*
            Method dump skipped, instructions count: 594
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.i.a(androidx.fragment.app.Fragment, int):void");
    }

    private void q(Fragment fragment) {
        HashSet<androidx.core.d.a> hashSet = this.p.get(fragment);
        if (hashSet != null) {
            Iterator<androidx.core.d.a> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            hashSet.clear();
            r(fragment);
            this.p.remove(fragment);
        }
    }

    void a(Fragment fragment, boolean z) {
        ViewGroup u = u(fragment);
        if (u == null || !(u instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) u).setDrawDisappearingViewsLast(!z);
    }

    private void r(Fragment fragment) {
        fragment.ag();
        this.r.e(fragment, false);
        fragment.E = null;
        fragment.F = null;
        fragment.R = null;
        fragment.S.b((androidx.lifecycle.o<androidx.lifecycle.j>) null);
        fragment.n = false;
    }

    void f(Fragment fragment) {
        a(fragment, this.b);
    }

    private void s(Fragment fragment) {
        if (fragment.F != null) {
            b.a a2 = androidx.fragment.app.b.a(this.c.j(), this.d, fragment, !fragment.y);
            if (a2 != null && a2.b != null) {
                a2.b.setTarget(fragment.F);
                if (fragment.y) {
                    if (fragment.ar()) {
                        fragment.k(false);
                    } else {
                        ViewGroup viewGroup = fragment.E;
                        View view = fragment.F;
                        viewGroup.startViewTransition(view);
                        a2.b.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.i.5
                            final /* synthetic */ ViewGroup a;
                            final /* synthetic */ View b;
                            final /* synthetic */ Fragment c;

                            AnonymousClass5(ViewGroup viewGroup2, View view2, Fragment fragment2) {
                                viewGroup = viewGroup2;
                                view = view2;
                                fragment = fragment2;
                            }

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                viewGroup.endViewTransition(view);
                                animator.removeListener(this);
                                if (fragment.F == null || !fragment.y) {
                                    return;
                                }
                                fragment.F.setVisibility(8);
                            }
                        });
                    }
                } else {
                    fragment2.F.setVisibility(0);
                }
                a2.b.start();
            } else {
                if (a2 != null) {
                    fragment2.F.startAnimation(a2.a);
                    a2.a.start();
                }
                fragment2.F.setVisibility((!fragment2.y || fragment2.ar()) ? 0 : 8);
                if (fragment2.ar()) {
                    fragment2.k(false);
                }
            }
        }
        if (fragment2.k && w(fragment2)) {
            this.v = true;
        }
        fragment2.L = false;
        fragment2.a(fragment2.y);
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.i$5 */
    class AnonymousClass5 extends AnimatorListenerAdapter {
        final /* synthetic */ ViewGroup a;
        final /* synthetic */ View b;
        final /* synthetic */ Fragment c;

        AnonymousClass5(ViewGroup viewGroup2, View view2, Fragment fragment2) {
            viewGroup = viewGroup2;
            view = view2;
            fragment = fragment2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            viewGroup.endViewTransition(view);
            animator.removeListener(this);
            if (fragment.F == null || !fragment.y) {
                return;
            }
            fragment.F.setVisibility(8);
        }
    }

    void g(Fragment fragment) {
        if (!this.i.b(fragment.f)) {
            if (a(3)) {
                Log.d("FragmentManager", "Ignoring moving " + fragment + " to state " + this.b + "since it is not added to " + this);
                return;
            }
            return;
        }
        f(fragment);
        if (fragment.F != null) {
            Fragment c2 = this.i.c(fragment);
            if (c2 != null) {
                View view = c2.F;
                ViewGroup viewGroup = fragment.E;
                int indexOfChild = viewGroup.indexOfChild(view);
                int indexOfChild2 = viewGroup.indexOfChild(fragment.F);
                if (indexOfChild2 < indexOfChild) {
                    viewGroup.removeViewAt(indexOfChild2);
                    viewGroup.addView(fragment.F, indexOfChild);
                }
            }
            if (fragment.K && fragment.E != null) {
                if (fragment.M > 0.0f) {
                    fragment.F.setAlpha(fragment.M);
                }
                fragment.M = 0.0f;
                fragment.K = false;
                b.a a2 = androidx.fragment.app.b.a(this.c.j(), this.d, fragment, true);
                if (a2 != null) {
                    if (a2.a != null) {
                        fragment.F.startAnimation(a2.a);
                    } else {
                        a2.b.setTarget(fragment.F);
                        a2.b.start();
                    }
                }
            }
        }
        if (fragment.L) {
            s(fragment);
        }
    }

    void a(int i, boolean z) {
        if (this.c == null && i != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.b) {
            this.b = i;
            Iterator<Fragment> it = this.i.e().iterator();
            while (it.hasNext()) {
                g(it.next());
            }
            for (Fragment fragment : this.i.f()) {
                if (fragment != null && !fragment.K) {
                    g(fragment);
                }
            }
            D();
            if (this.v && this.c != null && this.b == 4) {
                this.c.g();
                this.v = false;
            }
        }
    }

    private void D() {
        for (Fragment fragment : this.i.f()) {
            if (fragment != null) {
                e(fragment);
            }
        }
    }

    void h(Fragment fragment) {
        if (this.i.b(fragment.f)) {
            return;
        }
        l lVar = new l(this.r, fragment);
        lVar.a(this.c.j().getClassLoader());
        this.i.a(lVar);
        if (fragment.B) {
            if (fragment.A) {
                c(fragment);
            } else {
                d(fragment);
            }
            fragment.B = false;
        }
        lVar.a(this.b);
        if (a(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    private void a(l lVar) {
        Fragment a2 = lVar.a();
        if (this.i.b(a2.f)) {
            if (a(2)) {
                Log.v("FragmentManager", "Removed fragment from active set " + a2);
            }
            this.i.b(lVar);
            d(a2);
        }
    }

    void i(Fragment fragment) {
        if (a(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        h(fragment);
        if (fragment.z) {
            return;
        }
        this.i.a(fragment);
        fragment.l = false;
        if (fragment.F == null) {
            fragment.L = false;
        }
        if (w(fragment)) {
            this.v = true;
        }
    }

    void j(Fragment fragment) {
        if (a(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.q);
        }
        boolean z = !fragment.a();
        if (!fragment.z || z) {
            this.i.b(fragment);
            if (w(fragment)) {
                this.v = true;
            }
            fragment.l = true;
            t(fragment);
        }
    }

    void k(Fragment fragment) {
        if (a(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.y) {
            return;
        }
        fragment.y = true;
        fragment.L = true ^ fragment.L;
        t(fragment);
    }

    void l(Fragment fragment) {
        if (a(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.y) {
            fragment.y = false;
            fragment.L = !fragment.L;
        }
    }

    void m(Fragment fragment) {
        if (a(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.z) {
            return;
        }
        fragment.z = true;
        if (fragment.k) {
            if (a(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.i.b(fragment);
            if (w(fragment)) {
                this.v = true;
            }
            t(fragment);
        }
    }

    void n(Fragment fragment) {
        if (a(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.z) {
            fragment.z = false;
            if (fragment.k) {
                return;
            }
            this.i.a(fragment);
            if (a(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (w(fragment)) {
                this.v = true;
            }
        }
    }

    public Fragment c(int i) {
        return this.i.b(i);
    }

    public Fragment a(String str) {
        return this.i.a(str);
    }

    Fragment b(String str) {
        return this.i.d(str);
    }

    Fragment c(String str) {
        return this.i.e(str);
    }

    private void E() {
        if (h()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public boolean h() {
        return this.w || this.x;
    }

    void a(c cVar, boolean z) {
        if (!z) {
            if (this.c == null) {
                if (this.y) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            E();
        }
        synchronized (this.g) {
            if (this.c == null) {
                if (!z) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } else {
                this.g.add(cVar);
                i();
            }
        }
    }

    void i() {
        synchronized (this.g) {
            boolean z = (this.D == null || this.D.isEmpty()) ? false : true;
            boolean z2 = this.g.size() == 1;
            if (z || z2) {
                this.c.k().removeCallbacks(this.F);
                this.c.k().post(this.F);
                C();
            }
        }
    }

    int j() {
        return this.n.getAndIncrement();
    }

    private void d(boolean z) {
        if (this.h) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.c == null) {
            if (this.y) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        }
        if (Looper.myLooper() != this.c.k().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            E();
        }
        if (this.A == null) {
            this.A = new ArrayList<>();
            this.B = new ArrayList<>();
        }
        this.h = true;
        try {
            a((ArrayList<androidx.fragment.app.a>) null, (ArrayList<Boolean>) null);
        } finally {
            this.h = false;
        }
    }

    void b(c cVar, boolean z) {
        if (z && (this.c == null || this.y)) {
            return;
        }
        d(z);
        if (cVar.a(this.A, this.B)) {
            this.h = true;
            try {
                b(this.A, this.B);
            } finally {
                F();
            }
        }
        C();
        I();
        this.i.b();
    }

    private void F() {
        this.h = false;
        this.B.clear();
        this.A.clear();
    }

    boolean a(boolean z) {
        d(z);
        boolean z2 = false;
        while (c(this.A, this.B)) {
            this.h = true;
            try {
                b(this.A, this.B);
                F();
                z2 = true;
            } catch (Throwable th) {
                F();
                throw th;
            }
        }
        C();
        I();
        this.i.b();
        return z2;
    }

    private void a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        int size = this.D == null ? 0 : this.D.size();
        int i = 0;
        while (i < size) {
            d dVar = this.D.get(i);
            if (arrayList != null && !dVar.a && (indexOf2 = arrayList.indexOf(dVar.b)) != -1 && arrayList2 != null && arrayList2.get(indexOf2).booleanValue()) {
                this.D.remove(i);
                i--;
                size--;
                dVar.e();
            } else if (dVar.c() || (arrayList != null && dVar.b.a(arrayList, 0, arrayList.size()))) {
                this.D.remove(i);
                i--;
                size--;
                if (arrayList != null && !dVar.a && (indexOf = arrayList.indexOf(dVar.b)) != -1 && arrayList2 != null && arrayList2.get(indexOf).booleanValue()) {
                    dVar.e();
                } else {
                    dVar.d();
                }
            }
            i++;
        }
    }

    private void b(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        a(arrayList, arrayList2);
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!arrayList.get(i).s) {
                if (i2 != i) {
                    a(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (arrayList2.get(i).booleanValue()) {
                    while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).s) {
                        i2++;
                    }
                }
                a(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            a(arrayList, arrayList2, i2, size);
        }
    }

    private void a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        int i4 = i;
        boolean z = arrayList.get(i4).s;
        if (this.C == null) {
            this.C = new ArrayList<>();
        } else {
            this.C.clear();
        }
        this.C.addAll(this.i.e());
        Fragment x = x();
        boolean z2 = false;
        for (int i5 = i4; i5 < i2; i5++) {
            androidx.fragment.app.a aVar = arrayList.get(i5);
            if (!arrayList2.get(i5).booleanValue()) {
                x = aVar.a(this.C, x);
            } else {
                x = aVar.b(this.C, x);
            }
            z2 = z2 || aVar.j;
        }
        this.C.clear();
        if (!z) {
            o.a(this, arrayList, arrayList2, i4, i2, false, this.q);
        }
        b(arrayList, arrayList2, i, i2);
        if (z) {
            androidx.b.b<Fragment> bVar = new androidx.b.b<>();
            b(bVar);
            int a2 = a(arrayList, arrayList2, i4, i2, bVar);
            a(bVar);
            i3 = a2;
        } else {
            i3 = i2;
        }
        if (i3 != i4 && z) {
            o.a(this, arrayList, arrayList2, i4, i3, true, this.q);
            a(this.b, true);
        }
        while (i4 < i2) {
            androidx.fragment.app.a aVar2 = arrayList.get(i4);
            if (arrayList2.get(i4).booleanValue() && aVar2.c >= 0) {
                aVar2.c = -1;
            }
            aVar2.a();
            i4++;
        }
        if (z2) {
            J();
        }
    }

    private void a(androidx.b.b<Fragment> bVar) {
        int size = bVar.size();
        for (int i = 0; i < size; i++) {
            Fragment b2 = bVar.b(i);
            if (!b2.k) {
                View E = b2.E();
                b2.M = E.getAlpha();
                E.setAlpha(0.0f);
            }
        }
    }

    private int a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, androidx.b.b<Fragment> bVar) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            androidx.fragment.app.a aVar = arrayList.get(i4);
            boolean booleanValue = arrayList2.get(i4).booleanValue();
            if (aVar.e() && !aVar.a(arrayList, i4 + 1, i2)) {
                if (this.D == null) {
                    this.D = new ArrayList<>();
                }
                d dVar = new d(aVar, booleanValue);
                this.D.add(dVar);
                aVar.a(dVar);
                if (booleanValue) {
                    aVar.d();
                } else {
                    aVar.b(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, aVar);
                }
                b(bVar);
            }
        }
        return i3;
    }

    void a(androidx.fragment.app.a aVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            aVar.b(z3);
        } else {
            aVar.d();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            o.a(this, arrayList, arrayList2, 0, 1, true, this.q);
        }
        if (z3) {
            a(this.b, true);
        }
        for (Fragment fragment : this.i.f()) {
            if (fragment != null && fragment.F != null && fragment.K && aVar.b(fragment.w)) {
                if (fragment.M > 0.0f) {
                    fragment.F.setAlpha(fragment.M);
                }
                if (z3) {
                    fragment.M = 0.0f;
                } else {
                    fragment.M = -1.0f;
                    fragment.K = false;
                }
            }
        }
    }

    private static void b(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            androidx.fragment.app.a aVar = arrayList.get(i);
            if (arrayList2.get(i).booleanValue()) {
                aVar.a(-1);
                aVar.b(i == i2 + (-1));
            } else {
                aVar.a(1);
                aVar.d();
            }
            i++;
        }
    }

    private void t(Fragment fragment) {
        ViewGroup u = u(fragment);
        if (u != null) {
            if (u.getTag(a.b.visible_removing_fragment_view_tag) == null) {
                u.setTag(a.b.visible_removing_fragment_view_tag, fragment);
            }
            ((Fragment) u.getTag(a.b.visible_removing_fragment_view_tag)).b(fragment.aj());
        }
    }

    private ViewGroup u(Fragment fragment) {
        if (fragment.w > 0 && this.d.a()) {
            View a2 = this.d.a(fragment.w);
            if (a2 instanceof ViewGroup) {
                return (ViewGroup) a2;
            }
        }
        return null;
    }

    private void b(androidx.b.b<Fragment> bVar) {
        if (this.b < 1) {
            return;
        }
        int min = Math.min(this.b, 3);
        for (Fragment fragment : this.i.e()) {
            if (fragment.b < min) {
                a(fragment, min);
                if (fragment.F != null && !fragment.y && fragment.K) {
                    bVar.add(fragment);
                }
            }
        }
    }

    private void G() {
        if (this.D != null) {
            while (!this.D.isEmpty()) {
                this.D.remove(0).d();
            }
        }
    }

    private void H() {
        if (this.p.isEmpty()) {
            return;
        }
        for (Fragment fragment : this.p.keySet()) {
            q(fragment);
            a(fragment, fragment.ap());
        }
    }

    private boolean c(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.g) {
            if (this.g.isEmpty()) {
                return false;
            }
            int size = this.g.size();
            boolean z = false;
            for (int i = 0; i < size; i++) {
                z |= this.g.get(i).a(arrayList, arrayList2);
            }
            this.g.clear();
            this.c.k().removeCallbacks(this.F);
            return z;
        }
    }

    private void I() {
        if (this.z) {
            this.z = false;
            D();
        }
    }

    private void J() {
        if (this.o != null) {
            for (int i = 0; i < this.o.size(); i++) {
                this.o.get(i).a();
            }
        }
    }

    void a(androidx.fragment.app.a aVar) {
        if (this.a == null) {
            this.a = new ArrayList<>();
        }
        this.a.add(aVar);
    }

    boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        int size;
        if (this.a == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size2 = this.a.size() - 1;
            if (size2 < 0) {
                return false;
            }
            arrayList.add(this.a.remove(size2));
            arrayList2.add(true);
        } else {
            if (str != null || i >= 0) {
                size = this.a.size() - 1;
                while (size >= 0) {
                    androidx.fragment.app.a aVar = this.a.get(size);
                    if ((str != null && str.equals(aVar.f())) || (i >= 0 && i == aVar.c)) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size--;
                    while (size >= 0) {
                        androidx.fragment.app.a aVar2 = this.a.get(size);
                        if ((str == null || !str.equals(aVar2.f())) && (i < 0 || i != aVar2.c)) {
                            break;
                        }
                        size--;
                    }
                }
            } else {
                size = -1;
            }
            if (size == this.a.size() - 1) {
                return false;
            }
            for (int size3 = this.a.size() - 1; size3 > size; size3--) {
                arrayList.add(this.a.remove(size3));
                arrayList2.add(true);
            }
        }
        return true;
    }

    Parcelable k() {
        int size;
        G();
        H();
        a(true);
        this.w = true;
        ArrayList<FragmentState> c2 = this.i.c();
        BackStackState[] backStackStateArr = null;
        if (c2.isEmpty()) {
            if (a(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        ArrayList<String> d2 = this.i.d();
        if (this.a != null && (size = this.a.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i = 0; i < size; i++) {
                backStackStateArr[i] = new BackStackState(this.a.get(i));
                if (a(2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i + ": " + this.a.get(i));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.a = c2;
        fragmentManagerState.b = d2;
        fragmentManagerState.c = backStackStateArr;
        fragmentManagerState.d = this.n.get();
        if (this.e != null) {
            fragmentManagerState.e = this.e.f;
        }
        return fragmentManagerState;
    }

    void a(Parcelable parcelable) {
        l lVar;
        if (parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.a == null) {
            return;
        }
        this.i.a();
        Iterator<FragmentState> it = fragmentManagerState.a.iterator();
        while (it.hasNext()) {
            FragmentState next = it.next();
            if (next != null) {
                Fragment a2 = this.E.a(next.b);
                if (a2 != null) {
                    if (a(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + a2);
                    }
                    lVar = new l(this.r, a2, next);
                } else {
                    lVar = new l(this.r, this.c.j().getClassLoader(), y(), next);
                }
                Fragment a3 = lVar.a();
                a3.r = this;
                if (a(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + a3.f + "): " + a3);
                }
                lVar.a(this.c.j().getClassLoader());
                this.i.a(lVar);
                lVar.a(this.b);
            }
        }
        for (Fragment fragment : this.E.c()) {
            if (!this.i.b(fragment.f)) {
                if (a(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + fragmentManagerState.a);
                }
                a(fragment, 1);
                fragment.l = true;
                a(fragment, -1);
            }
        }
        this.i.a(fragmentManagerState.b);
        if (fragmentManagerState.c != null) {
            this.a = new ArrayList<>(fragmentManagerState.c.length);
            for (int i = 0; i < fragmentManagerState.c.length; i++) {
                androidx.fragment.app.a a4 = fragmentManagerState.c[i].a(this);
                if (a(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + a4.c + "): " + a4);
                    PrintWriter printWriter = new PrintWriter(new androidx.core.g.b("FragmentManager"));
                    a4.a("  ", printWriter, false);
                    printWriter.close();
                }
                this.a.add(a4);
            }
        } else {
            this.a = null;
        }
        this.n.set(fragmentManagerState.d);
        if (fragmentManagerState.e != null) {
            this.e = c(fragmentManagerState.e);
            v(this.e);
        }
    }

    Fragment l() {
        return this.s;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void a(f<?> fVar, androidx.fragment.app.c cVar, Fragment fragment) {
        if (this.c != null) {
            throw new IllegalStateException("Already attached");
        }
        this.c = fVar;
        this.d = cVar;
        this.s = fragment;
        if (this.s != null) {
            C();
        }
        if (fVar instanceof androidx.activity.c) {
            androidx.activity.c cVar2 = (androidx.activity.c) fVar;
            this.l = cVar2.d();
            Fragment fragment2 = cVar2;
            if (fragment != null) {
                fragment2 = fragment;
            }
            this.l.a(fragment2, this.m);
        }
        if (fragment != null) {
            this.E = fragment.r.p(fragment);
        } else if (fVar instanceof y) {
            this.E = k.a(((y) fVar).c());
        } else {
            this.E = new k(false);
        }
    }

    void m() {
        this.w = false;
        this.x = false;
        for (Fragment fragment : this.i.e()) {
            if (fragment != null) {
                fragment.ab();
            }
        }
    }

    void n() {
        this.w = false;
        this.x = false;
        e(1);
    }

    void o() {
        this.w = false;
        this.x = false;
        e(2);
    }

    void p() {
        this.w = false;
        this.x = false;
        e(3);
    }

    void q() {
        this.w = false;
        this.x = false;
        e(4);
    }

    void r() {
        e(3);
    }

    void s() {
        this.x = true;
        e(2);
    }

    void t() {
        e(1);
    }

    void u() {
        this.y = true;
        a(true);
        H();
        e(-1);
        this.c = null;
        this.d = null;
        this.s = null;
        if (this.l != null) {
            this.m.b();
            this.l = null;
        }
    }

    private void e(int i) {
        try {
            this.h = true;
            this.i.a(i);
            a(i, false);
            this.h = false;
            a(true);
        } catch (Throwable th) {
            this.h = false;
            throw th;
        }
    }

    void b(boolean z) {
        for (Fragment fragment : this.i.e()) {
            if (fragment != null) {
                fragment.i(z);
            }
        }
    }

    void c(boolean z) {
        for (Fragment fragment : this.i.e()) {
            if (fragment != null) {
                fragment.j(z);
            }
        }
    }

    void a(Configuration configuration) {
        for (Fragment fragment : this.i.e()) {
            if (fragment != null) {
                fragment.a(configuration);
            }
        }
    }

    void v() {
        for (Fragment fragment : this.i.e()) {
            if (fragment != null) {
                fragment.ad();
            }
        }
    }

    boolean a(Menu menu, MenuInflater menuInflater) {
        if (this.b < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (Fragment fragment : this.i.e()) {
            if (fragment != null && fragment.b(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.j != null) {
            for (int i = 0; i < this.j.size(); i++) {
                Fragment fragment2 = this.j.get(i);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.N();
                }
            }
        }
        this.j = arrayList;
        return z;
    }

    boolean a(Menu menu) {
        boolean z = false;
        if (this.b < 1) {
            return false;
        }
        for (Fragment fragment : this.i.e()) {
            if (fragment != null && fragment.c(menu)) {
                z = true;
            }
        }
        return z;
    }

    boolean a(MenuItem menuItem) {
        if (this.b < 1) {
            return false;
        }
        for (Fragment fragment : this.i.e()) {
            if (fragment != null && fragment.c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    boolean b(MenuItem menuItem) {
        if (this.b < 1) {
            return false;
        }
        for (Fragment fragment : this.i.e()) {
            if (fragment != null && fragment.d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void b(Menu menu) {
        if (this.b < 1) {
            return;
        }
        for (Fragment fragment : this.i.e()) {
            if (fragment != null) {
                fragment.d(menu);
            }
        }
    }

    void o(Fragment fragment) {
        if (fragment != null && (!fragment.equals(c(fragment.f)) || (fragment.s != null && fragment.r != this))) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        Fragment fragment2 = this.e;
        this.e = fragment;
        v(fragment2);
        v(this.e);
    }

    private void v(Fragment fragment) {
        if (fragment == null || !fragment.equals(c(fragment.f))) {
            return;
        }
        fragment.ac();
    }

    void w() {
        C();
        v(this.e);
    }

    public Fragment x() {
        return this.e;
    }

    void a(Fragment fragment, f.b bVar) {
        if (!fragment.equals(c(fragment.f)) || (fragment.s != null && fragment.r != this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        fragment.P = bVar;
    }

    public e y() {
        if (this.t != null) {
            return this.t;
        }
        if (this.s != null) {
            return this.s.r.y();
        }
        return this.u;
    }

    h z() {
        return this.r;
    }

    boolean A() {
        boolean z = false;
        for (Fragment fragment : this.i.f()) {
            if (fragment != null) {
                z = w(fragment);
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    private boolean w(Fragment fragment) {
        return (fragment.C && fragment.D) || fragment.t.A();
    }

    LayoutInflater.Factory2 B() {
        return this.k;
    }

    /* compiled from: source */
    static class d implements Fragment.c {
        final boolean a;
        final androidx.fragment.app.a b;
        private int c;

        d(androidx.fragment.app.a aVar, boolean z) {
            this.a = z;
            this.b = aVar;
        }

        @Override // androidx.fragment.app.Fragment.c
        public void a() {
            this.c--;
            if (this.c != 0) {
                return;
            }
            this.b.a.i();
        }

        @Override // androidx.fragment.app.Fragment.c
        public void b() {
            this.c++;
        }

        public boolean c() {
            return this.c == 0;
        }

        void d() {
            boolean z = this.c > 0;
            for (Fragment fragment : this.b.a.f()) {
                fragment.a((Fragment.c) null);
                if (z && fragment.aq()) {
                    fragment.W();
                }
            }
            this.b.a.a(this.b, this.a, !z, true);
        }

        void e() {
            this.b.a.a(this.b, this.a, false, false);
        }
    }
}
