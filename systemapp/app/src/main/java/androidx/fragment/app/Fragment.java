package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.f;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

/* compiled from: source */
/* loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.j, y, androidx.savedstate.c {
    static final Object a = new Object();
    boolean A;
    boolean B;
    boolean C;
    boolean D;
    ViewGroup E;
    View F;
    boolean G;
    boolean H;
    a I;
    Runnable J;
    boolean K;
    boolean L;
    float M;
    LayoutInflater N;
    boolean O;
    f.b P;
    androidx.lifecycle.k Q;
    r R;
    androidx.lifecycle.o<androidx.lifecycle.j> S;
    androidx.savedstate.b T;
    private Boolean U;
    private boolean V;
    private int W;
    int b;
    Bundle c;
    SparseArray<Parcelable> d;
    Boolean e;
    String f;
    Bundle g;
    Fragment h;
    String i;
    int j;
    boolean k;
    boolean l;
    boolean m;
    boolean n;
    boolean o;
    boolean p;
    int q;
    i r;
    f<?> s;
    i t;
    Fragment u;
    int v;
    int w;
    String x;
    boolean y;
    boolean z;

    /* compiled from: source */
    interface c {
        void a();

        void b();
    }

    public void N() {
    }

    public Animation a(int i, boolean z, int i2) {
        return null;
    }

    public void a(int i, int i2, Intent intent) {
    }

    public void a(int i, String[] strArr, int[] iArr) {
    }

    public void a(Menu menu) {
    }

    public void a(Menu menu, MenuInflater menuInflater) {
    }

    public void a(View view, Bundle bundle) {
    }

    public void a(Fragment fragment) {
    }

    public void a(boolean z) {
    }

    public boolean a(MenuItem menuItem) {
        return false;
    }

    public Animator b(int i, boolean z, int i2) {
        return null;
    }

    public void b(Menu menu) {
    }

    public boolean b(MenuItem menuItem) {
        return false;
    }

    public void f(boolean z) {
    }

    public void g(boolean z) {
    }

    public void h(boolean z) {
    }

    public void j(Bundle bundle) {
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.Fragment$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.W();
        }
    }

    @Override // androidx.lifecycle.j
    public androidx.lifecycle.f b() {
        return this.Q;
    }

    @Override // androidx.lifecycle.y
    public x c() {
        if (this.r == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        return this.r.b(this);
    }

    @Override // androidx.savedstate.c
    public final androidx.savedstate.a e() {
        return this.T.a();
    }

    /* compiled from: source */
    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.fragment.app.Fragment.SavedState.1
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        final Bundle a;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            this.a = parcel.readBundle();
            if (classLoader == null || this.a == null) {
                return;
            }
            this.a.setClassLoader(classLoader);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.a);
        }

        /* compiled from: source */
        /* renamed from: androidx.fragment.app.Fragment$SavedState$1 */
        static class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }
    }

    /* compiled from: source */
    public static class b extends RuntimeException {
        public b(String str, Exception exc) {
            super(str, exc);
        }
    }

    public Fragment() {
        this.b = -1;
        this.f = UUID.randomUUID().toString();
        this.i = null;
        this.U = null;
        this.t = new j();
        this.D = true;
        this.H = true;
        this.J = new Runnable() { // from class: androidx.fragment.app.Fragment.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Fragment.this.W();
            }
        };
        this.P = f.b.RESUMED;
        this.S = new androidx.lifecycle.o<>();
        as();
    }

    public Fragment(int i) {
        this();
        this.W = i;
    }

    private void as() {
        this.Q = new androidx.lifecycle.k(this);
        this.T = androidx.savedstate.b.a(this);
        if (Build.VERSION.SDK_INT >= 19) {
            this.Q.a(new androidx.lifecycle.h() { // from class: androidx.fragment.app.Fragment.2
                AnonymousClass2() {
                }

                @Override // androidx.lifecycle.h
                public void a(androidx.lifecycle.j jVar, f.a aVar) {
                    if (aVar != f.a.ON_STOP || Fragment.this.F == null) {
                        return;
                    }
                    Fragment.this.F.cancelPendingInputEvents();
                }
            });
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.Fragment$2 */
    class AnonymousClass2 implements androidx.lifecycle.h {
        AnonymousClass2() {
        }

        @Override // androidx.lifecycle.h
        public void a(androidx.lifecycle.j jVar, f.a aVar) {
            if (aVar != f.a.ON_STOP || Fragment.this.F == null) {
                return;
            }
            Fragment.this.F.cancelPendingInputEvents();
        }
    }

    @Deprecated
    public static Fragment a(Context context, String str, Bundle bundle) {
        try {
            Fragment newInstance = e.b(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(newInstance.getClass().getClassLoader());
                newInstance.b(bundle);
            }
            return newInstance;
        } catch (IllegalAccessException e) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (InstantiationException e2) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new b("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new b("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }

    final void a(Bundle bundle) {
        if (this.d != null) {
            this.F.restoreHierarchyState(this.d);
            this.d = null;
        }
        this.V = false;
        i(bundle);
        if (!this.V) {
            throw new s("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
        if (this.F != null) {
            this.R.a(f.a.ON_CREATE);
        }
    }

    final boolean a() {
        return this.q > 0;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.f);
        sb.append(")");
        if (this.v != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.v));
        }
        if (this.x != null) {
            sb.append(" ");
            sb.append(this.x);
        }
        sb.append('}');
        return sb.toString();
    }

    public final int d() {
        return this.v;
    }

    public final String f() {
        return this.x;
    }

    public void b(Bundle bundle) {
        if (this.r != null && h()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.g = bundle;
    }

    public final Bundle g() {
        return this.g;
    }

    public final boolean h() {
        if (this.r == null) {
            return false;
        }
        return this.r.h();
    }

    public final Fragment i() {
        if (this.h != null) {
            return this.h;
        }
        if (this.r == null || this.i == null) {
            return null;
        }
        return this.r.c(this.i);
    }

    public final int j() {
        return this.j;
    }

    public Context k() {
        if (this.s == null) {
            return null;
        }
        return this.s.j();
    }

    public final Context l() {
        Context k = k();
        if (k != null) {
            return k;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final FragmentActivity m() {
        if (this.s == null) {
            return null;
        }
        return (FragmentActivity) this.s.i();
    }

    public final FragmentActivity n() {
        FragmentActivity m = m();
        if (m != null) {
            return m;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Object o() {
        if (this.s == null) {
            return null;
        }
        return this.s.h();
    }

    public final Resources p() {
        return l().getResources();
    }

    public final String a(int i) {
        return p().getString(i);
    }

    public final String a(int i, Object... objArr) {
        return p().getString(i, objArr);
    }

    public final i q() {
        i iVar = this.r;
        if (iVar != null) {
            return iVar;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public final i r() {
        if (this.s == null) {
            throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
        }
        return this.t;
    }

    public final Fragment s() {
        return this.u;
    }

    public final boolean t() {
        return this.s != null && this.k;
    }

    public final boolean u() {
        return this.z;
    }

    public final boolean v() {
        return this.l;
    }

    final boolean w() {
        Fragment s = s();
        return s != null && (s.v() || s.w());
    }

    public final boolean x() {
        return this.n;
    }

    public final boolean y() {
        return this.b >= 4;
    }

    public final boolean z() {
        return (!t() || A() || this.F == null || this.F.getWindowToken() == null || this.F.getVisibility() != 0) ? false : true;
    }

    public final boolean A() {
        return this.y;
    }

    public void b(boolean z) {
        this.A = z;
        if (this.r == null) {
            this.B = true;
        } else if (z) {
            this.r.c(this);
        } else {
            this.r.d(this);
        }
    }

    public final boolean B() {
        return this.A;
    }

    public void c(boolean z) {
        if (this.C != z) {
            this.C = z;
            if (!t() || A()) {
                return;
            }
            this.s.g();
        }
    }

    public void d(boolean z) {
        if (this.D != z) {
            this.D = z;
            if (this.C && t() && !A()) {
                this.s.g();
            }
        }
    }

    @Deprecated
    public void e(boolean z) {
        if (!this.H && z && this.b < 3 && this.r != null && t() && this.O) {
            this.r.e(this);
        }
        this.H = z;
        this.G = this.b < 3 && !z;
        if (this.c != null) {
            this.e = Boolean.valueOf(z);
        }
    }

    @Deprecated
    public boolean C() {
        return this.H;
    }

    public void a(@SuppressLint({"UnknownNullness"}) Intent intent) {
        a(intent, (Bundle) null);
    }

    public void a(@SuppressLint({"UnknownNullness"}) Intent intent, Bundle bundle) {
        if (this.s == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.s.a(this, intent, -1, bundle);
    }

    public void a(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        a(intent, i, (Bundle) null);
    }

    public void a(@SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (this.s == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.s.a(this, intent, i, bundle);
    }

    public final void a(String[] strArr, int i) {
        if (this.s == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.s.a(this, strArr, i);
    }

    public LayoutInflater c(Bundle bundle) {
        return e(bundle);
    }

    LayoutInflater d(Bundle bundle) {
        this.N = c(bundle);
        return this.N;
    }

    @Deprecated
    public LayoutInflater e(Bundle bundle) {
        if (this.s == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater e = this.s.e();
        androidx.core.h.f.a(e, this.t.B());
        return e;
    }

    public void a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.V = true;
        Activity i = this.s == null ? null : this.s.i();
        if (i != null) {
            this.V = false;
            a(i, attributeSet, bundle);
        }
    }

    @Deprecated
    public void a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.V = true;
    }

    public void a(Context context) {
        this.V = true;
        Activity i = this.s == null ? null : this.s.i();
        if (i != null) {
            this.V = false;
            a(i);
        }
    }

    @Deprecated
    public void a(Activity activity) {
        this.V = true;
    }

    public void f(Bundle bundle) {
        this.V = true;
        g(bundle);
        if (this.t.b(1)) {
            return;
        }
        this.t.n();
    }

    void g(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.t.a(parcelable);
        this.t.n();
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.W != 0) {
            return layoutInflater.inflate(this.W, viewGroup, false);
        }
        return null;
    }

    public View D() {
        return this.F;
    }

    public final View E() {
        View D = D();
        if (D != null) {
            return D;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public void h(Bundle bundle) {
        this.V = true;
    }

    public void i(Bundle bundle) {
        this.V = true;
    }

    public void F() {
        this.V = true;
    }

    public void G() {
        this.V = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.V = true;
    }

    public void H() {
        this.V = true;
    }

    public void I() {
        this.V = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.V = true;
    }

    public void J() {
        this.V = true;
    }

    public void K() {
        this.V = true;
    }

    void L() {
        as();
        this.f = UUID.randomUUID().toString();
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.q = 0;
        this.r = null;
        this.t = new j();
        this.s = null;
        this.v = 0;
        this.w = 0;
        this.x = null;
        this.y = false;
        this.z = false;
    }

    public void M() {
        this.V = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        n().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void a(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public void b(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    public Object O() {
        if (this.I == null) {
            return null;
        }
        return this.I.f;
    }

    public Object P() {
        if (this.I == null) {
            return null;
        }
        return this.I.g == a ? O() : this.I.g;
    }

    public Object Q() {
        if (this.I == null) {
            return null;
        }
        return this.I.h;
    }

    public Object R() {
        if (this.I == null) {
            return null;
        }
        return this.I.i == a ? Q() : this.I.i;
    }

    public Object S() {
        if (this.I == null) {
            return null;
        }
        return this.I.j;
    }

    public Object T() {
        if (this.I == null) {
            return null;
        }
        return this.I.k == a ? S() : this.I.k;
    }

    public boolean U() {
        if (this.I == null || this.I.m == null) {
            return true;
        }
        return this.I.m.booleanValue();
    }

    public boolean V() {
        if (this.I == null || this.I.l == null) {
            return true;
        }
        return this.I.l.booleanValue();
    }

    public void W() {
        if (this.r == null || this.r.c == null) {
            at().p = false;
        } else if (Looper.myLooper() != this.r.c.k().getLooper()) {
            this.r.c.k().postAtFrontOfQueue(new Runnable() { // from class: androidx.fragment.app.Fragment.3
                AnonymousClass3() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Fragment.this.X();
                }
            });
        } else {
            X();
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.Fragment$3 */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.X();
        }
    }

    void X() {
        c cVar;
        if (this.I == null) {
            cVar = null;
        } else {
            this.I.p = false;
            cVar = this.I.q;
            this.I.q = null;
        }
        if (cVar != null) {
            cVar.a();
        }
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.v));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.w));
        printWriter.print(" mTag=");
        printWriter.println(this.x);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.b);
        printWriter.print(" mWho=");
        printWriter.print(this.f);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.q);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.k);
        printWriter.print(" mRemoving=");
        printWriter.print(this.l);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.m);
        printWriter.print(" mInLayout=");
        printWriter.println(this.n);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.y);
        printWriter.print(" mDetached=");
        printWriter.print(this.z);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.D);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.C);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.A);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.H);
        if (this.r != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.r);
        }
        if (this.s != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.s);
        }
        if (this.u != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.u);
        }
        if (this.g != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.g);
        }
        if (this.c != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.c);
        }
        if (this.d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.d);
        }
        Fragment i = i();
        if (i != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(i);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.j);
        }
        if (aj() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(aj());
        }
        if (this.E != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.E);
        }
        if (this.F != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.F);
        }
        if (an() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(an());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(ap());
        }
        if (k() != null) {
            androidx.e.a.a.a(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.t + ":");
        this.t.a(str + "  ", fileDescriptor, printWriter, strArr);
    }

    Fragment a(String str) {
        return str.equals(this.f) ? this : this.t.b(str);
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.Fragment$4 */
    class AnonymousClass4 extends androidx.fragment.app.c {
        AnonymousClass4() {
        }

        @Override // androidx.fragment.app.c
        public View a(int i) {
            if (Fragment.this.F == null) {
                throw new IllegalStateException("Fragment " + this + " does not have a view");
            }
            return Fragment.this.F.findViewById(i);
        }

        @Override // androidx.fragment.app.c
        public boolean a() {
            return Fragment.this.F != null;
        }
    }

    void Y() {
        this.t.a(this.s, new androidx.fragment.app.c() { // from class: androidx.fragment.app.Fragment.4
            AnonymousClass4() {
            }

            @Override // androidx.fragment.app.c
            public View a(int i) {
                if (Fragment.this.F == null) {
                    throw new IllegalStateException("Fragment " + this + " does not have a view");
                }
                return Fragment.this.F.findViewById(i);
            }

            @Override // androidx.fragment.app.c
            public boolean a() {
                return Fragment.this.F != null;
            }
        }, this);
        this.b = 0;
        this.V = false;
        a(this.s.j());
        if (this.V) {
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onAttach()");
    }

    void k(Bundle bundle) {
        this.t.m();
        this.b = 1;
        this.V = false;
        this.T.a(bundle);
        f(bundle);
        this.O = true;
        if (!this.V) {
            throw new s("Fragment " + this + " did not call through to super.onCreate()");
        }
        this.Q.a(f.a.ON_CREATE);
    }

    void b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.t.m();
        this.p = true;
        this.R = new r();
        this.F = a(layoutInflater, viewGroup, bundle);
        if (this.F != null) {
            this.R.a();
            this.S.b((androidx.lifecycle.o<androidx.lifecycle.j>) this.R);
        } else {
            if (this.R.c()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.R = null;
        }
    }

    void l(Bundle bundle) {
        this.t.m();
        this.b = 2;
        this.V = false;
        h(bundle);
        if (!this.V) {
            throw new s("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
        this.t.o();
    }

    void Z() {
        this.t.m();
        this.t.a(true);
        this.b = 3;
        this.V = false;
        F();
        if (!this.V) {
            throw new s("Fragment " + this + " did not call through to super.onStart()");
        }
        this.Q.a(f.a.ON_START);
        if (this.F != null) {
            this.R.a(f.a.ON_START);
        }
        this.t.p();
    }

    void aa() {
        this.t.m();
        this.t.a(true);
        this.b = 4;
        this.V = false;
        G();
        if (!this.V) {
            throw new s("Fragment " + this + " did not call through to super.onResume()");
        }
        this.Q.a(f.a.ON_RESUME);
        if (this.F != null) {
            this.R.a(f.a.ON_RESUME);
        }
        this.t.q();
    }

    void ab() {
        this.t.m();
    }

    void ac() {
        boolean a2 = this.r.a(this);
        if (this.U == null || this.U.booleanValue() != a2) {
            this.U = Boolean.valueOf(a2);
            h(a2);
            this.t.w();
        }
    }

    void i(boolean z) {
        f(z);
        this.t.b(z);
    }

    void j(boolean z) {
        g(z);
        this.t.c(z);
    }

    void a(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.t.a(configuration);
    }

    void ad() {
        onLowMemory();
        this.t.v();
    }

    boolean b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.y) {
            return false;
        }
        if (this.C && this.D) {
            z = true;
            a(menu, menuInflater);
        }
        return z | this.t.a(menu, menuInflater);
    }

    boolean c(Menu menu) {
        boolean z = false;
        if (this.y) {
            return false;
        }
        if (this.C && this.D) {
            z = true;
            a(menu);
        }
        return z | this.t.a(menu);
    }

    boolean c(MenuItem menuItem) {
        if (this.y) {
            return false;
        }
        return (this.C && this.D && a(menuItem)) || this.t.a(menuItem);
    }

    boolean d(MenuItem menuItem) {
        if (this.y) {
            return false;
        }
        return b(menuItem) || this.t.b(menuItem);
    }

    void d(Menu menu) {
        if (this.y) {
            return;
        }
        if (this.C && this.D) {
            b(menu);
        }
        this.t.b(menu);
    }

    void m(Bundle bundle) {
        j(bundle);
        this.T.b(bundle);
        Parcelable k = this.t.k();
        if (k != null) {
            bundle.putParcelable("android:support:fragments", k);
        }
    }

    void ae() {
        this.t.r();
        if (this.F != null) {
            this.R.a(f.a.ON_PAUSE);
        }
        this.Q.a(f.a.ON_PAUSE);
        this.b = 3;
        this.V = false;
        H();
        if (this.V) {
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onPause()");
    }

    void af() {
        this.t.s();
        if (this.F != null) {
            this.R.a(f.a.ON_STOP);
        }
        this.Q.a(f.a.ON_STOP);
        this.b = 2;
        this.V = false;
        I();
        if (this.V) {
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onStop()");
    }

    void ag() {
        this.t.t();
        if (this.F != null) {
            this.R.a(f.a.ON_DESTROY);
        }
        this.b = 1;
        this.V = false;
        J();
        if (!this.V) {
            throw new s("Fragment " + this + " did not call through to super.onDestroyView()");
        }
        androidx.e.a.a.a(this).a();
        this.p = false;
    }

    void ah() {
        this.t.u();
        this.Q.a(f.a.ON_DESTROY);
        this.b = 0;
        this.V = false;
        this.O = false;
        K();
        if (this.V) {
            return;
        }
        throw new s("Fragment " + this + " did not call through to super.onDestroy()");
    }

    void ai() {
        this.b = -1;
        this.V = false;
        M();
        this.N = null;
        if (!this.V) {
            throw new s("Fragment " + this + " did not call through to super.onDetach()");
        }
        if (this.t.g()) {
            return;
        }
        this.t.u();
        this.t = new j();
    }

    void a(c cVar) {
        at();
        if (cVar == this.I.q) {
            return;
        }
        if (cVar != null && this.I.q != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        if (this.I.p) {
            this.I.q = cVar;
        }
        if (cVar != null) {
            cVar.b();
        }
    }

    private a at() {
        if (this.I == null) {
            this.I = new a();
        }
        return this.I;
    }

    int aj() {
        if (this.I == null) {
            return 0;
        }
        return this.I.d;
    }

    void b(int i) {
        if (this.I == null && i == 0) {
            return;
        }
        at().d = i;
    }

    int ak() {
        if (this.I == null) {
            return 0;
        }
        return this.I.e;
    }

    void c(int i) {
        if (this.I == null && i == 0) {
            return;
        }
        at();
        this.I.e = i;
    }

    androidx.core.app.m al() {
        if (this.I == null) {
            return null;
        }
        return this.I.n;
    }

    androidx.core.app.m am() {
        if (this.I == null) {
            return null;
        }
        return this.I.o;
    }

    View an() {
        if (this.I == null) {
            return null;
        }
        return this.I.a;
    }

    void c(View view) {
        at().a = view;
    }

    void a(Animator animator) {
        at().b = animator;
    }

    Animator ao() {
        if (this.I == null) {
            return null;
        }
        return this.I.b;
    }

    int ap() {
        if (this.I == null) {
            return 0;
        }
        return this.I.c;
    }

    void d(int i) {
        at().c = i;
    }

    boolean aq() {
        if (this.I == null) {
            return false;
        }
        return this.I.p;
    }

    boolean ar() {
        if (this.I == null) {
            return false;
        }
        return this.I.r;
    }

    void k(boolean z) {
        at().r = z;
    }

    /* compiled from: source */
    static class a {
        View a;
        Animator b;
        int c;
        int d;
        int e;
        Boolean l;
        Boolean m;
        boolean p;
        c q;
        boolean r;
        Object f = null;
        Object g = Fragment.a;
        Object h = null;
        Object i = Fragment.a;
        Object j = null;
        Object k = Fragment.a;
        androidx.core.app.m n = null;
        androidx.core.app.m o = null;

        a() {
        }
    }
}
