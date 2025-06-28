package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.core.h.w;
import androidx.fragment.a;
import androidx.lifecycle.f;
import androidx.lifecycle.y;

/* compiled from: source */
/* loaded from: classes.dex */
class l {
    private final h a;
    private final Fragment b;
    private int c = -1;

    l(h hVar, Fragment fragment) {
        this.a = hVar;
        this.b = fragment;
    }

    l(h hVar, ClassLoader classLoader, e eVar, FragmentState fragmentState) {
        this.a = hVar;
        this.b = eVar.c(classLoader, fragmentState.a);
        if (fragmentState.j != null) {
            fragmentState.j.setClassLoader(classLoader);
        }
        this.b.b(fragmentState.j);
        this.b.f = fragmentState.b;
        this.b.m = fragmentState.c;
        this.b.o = true;
        this.b.v = fragmentState.d;
        this.b.w = fragmentState.e;
        this.b.x = fragmentState.f;
        this.b.A = fragmentState.g;
        this.b.l = fragmentState.h;
        this.b.z = fragmentState.i;
        this.b.y = fragmentState.k;
        this.b.P = f.b.values()[fragmentState.l];
        if (fragmentState.m != null) {
            this.b.c = fragmentState.m;
        } else {
            this.b.c = new Bundle();
        }
        if (i.a(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + this.b);
        }
    }

    l(h hVar, Fragment fragment, FragmentState fragmentState) {
        this.a = hVar;
        this.b = fragment;
        this.b.d = null;
        this.b.q = 0;
        this.b.n = false;
        this.b.k = false;
        this.b.i = this.b.h != null ? this.b.h.f : null;
        this.b.h = null;
        if (fragmentState.m != null) {
            this.b.c = fragmentState.m;
        } else {
            this.b.c = new Bundle();
        }
    }

    Fragment a() {
        return this.b;
    }

    void a(int i) {
        this.c = i;
    }

    int b() {
        int i = this.c;
        if (this.b.m) {
            if (this.b.n) {
                i = Math.max(this.c, 1);
            } else {
                i = Math.min(i, 1);
            }
        }
        if (!this.b.k) {
            i = Math.min(i, 1);
        }
        if (this.b.l) {
            if (this.b.a()) {
                i = Math.min(i, 1);
            } else {
                i = Math.min(i, -1);
            }
        }
        if (this.b.G && this.b.b < 3) {
            i = Math.min(i, 2);
        }
        switch (this.b.P) {
            case RESUMED:
                return i;
            case STARTED:
                return Math.min(i, 3);
            case CREATED:
                return Math.min(i, 1);
            default:
                return Math.min(i, -1);
        }
    }

    void c() {
        if (this.b.m && this.b.n && !this.b.p) {
            if (i.a(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.b);
            }
            this.b.b(this.b.d(this.b.c), (ViewGroup) null, this.b.c);
            if (this.b.F != null) {
                this.b.F.setSaveFromParentEnabled(false);
                if (this.b.y) {
                    this.b.F.setVisibility(8);
                }
                this.b.a(this.b.F, this.b.c);
                this.a.a(this.b, this.b.F, this.b.c, false);
            }
        }
    }

    void a(ClassLoader classLoader) {
        if (this.b.c == null) {
            return;
        }
        this.b.c.setClassLoader(classLoader);
        this.b.d = this.b.c.getSparseParcelableArray("android:view_state");
        this.b.i = this.b.c.getString("android:target_state");
        if (this.b.i != null) {
            this.b.j = this.b.c.getInt("android:target_req_state", 0);
        }
        if (this.b.e != null) {
            this.b.H = this.b.e.booleanValue();
            this.b.e = null;
        } else {
            this.b.H = this.b.c.getBoolean("android:user_visible_hint", true);
        }
        if (this.b.H) {
            return;
        }
        this.b.G = true;
    }

    void a(f<?> fVar, i iVar, Fragment fragment) {
        this.b.s = fVar;
        this.b.u = fragment;
        this.b.r = iVar;
        this.a.a(this.b, fVar.j(), false);
        this.b.Y();
        if (this.b.u == null) {
            fVar.b(this.b);
        } else {
            this.b.u.a(this.b);
        }
        this.a.b(this.b, fVar.j(), false);
    }

    void d() {
        if (i.a(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.b);
        }
        if (!this.b.O) {
            this.a.a(this.b, this.b.c, false);
            this.b.k(this.b.c);
            this.a.b(this.b, this.b.c, false);
        } else {
            this.b.g(this.b.c);
            this.b.b = 1;
        }
    }

    void a(c cVar) {
        String str;
        if (this.b.m) {
            return;
        }
        if (i.a(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.b);
        }
        ViewGroup viewGroup = null;
        if (this.b.E != null) {
            viewGroup = this.b.E;
        } else if (this.b.w != 0) {
            if (this.b.w == -1) {
                throw new IllegalArgumentException("Cannot create fragment " + this.b + " for a container view with no id");
            }
            viewGroup = (ViewGroup) cVar.a(this.b.w);
            if (viewGroup == null && !this.b.o) {
                try {
                    str = this.b.p().getResourceName(this.b.w);
                } catch (Resources.NotFoundException unused) {
                    str = "unknown";
                }
                throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.b.w) + " (" + str + ") for fragment " + this.b);
            }
        }
        this.b.E = viewGroup;
        this.b.b(this.b.d(this.b.c), viewGroup, this.b.c);
        if (this.b.F != null) {
            boolean z = false;
            this.b.F.setSaveFromParentEnabled(false);
            this.b.F.setTag(a.b.fragment_container_view_tag, this.b);
            if (viewGroup != null) {
                viewGroup.addView(this.b.F);
            }
            if (this.b.y) {
                this.b.F.setVisibility(8);
            }
            w.t(this.b.F);
            this.b.a(this.b.F, this.b.c);
            this.a.a(this.b, this.b.F, this.b.c, false);
            Fragment fragment = this.b;
            if (this.b.F.getVisibility() == 0 && this.b.E != null) {
                z = true;
            }
            fragment.K = z;
        }
    }

    void e() {
        if (i.a(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.b);
        }
        this.b.l(this.b.c);
        this.a.c(this.b, this.b.c, false);
    }

    void f() {
        if (i.a(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this.b);
        }
        if (this.b.F != null) {
            this.b.a(this.b.c);
        }
        this.b.c = null;
    }

    void g() {
        if (i.a(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.b);
        }
        this.b.Z();
        this.a.a(this.b, false);
    }

    void h() {
        if (i.a(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.b);
        }
        this.b.aa();
        this.a.b(this.b, false);
        this.b.c = null;
        this.b.d = null;
    }

    void i() {
        if (i.a(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.b);
        }
        this.b.ae();
        this.a.c(this.b, false);
    }

    void j() {
        if (i.a(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.b);
        }
        this.b.af();
        this.a.d(this.b, false);
    }

    FragmentState k() {
        FragmentState fragmentState = new FragmentState(this.b);
        if (this.b.b > -1 && fragmentState.m == null) {
            fragmentState.m = m();
            if (this.b.i != null) {
                if (fragmentState.m == null) {
                    fragmentState.m = new Bundle();
                }
                fragmentState.m.putString("android:target_state", this.b.i);
                if (this.b.j != 0) {
                    fragmentState.m.putInt("android:target_req_state", this.b.j);
                }
            }
        } else {
            fragmentState.m = this.b.c;
        }
        return fragmentState;
    }

    private Bundle m() {
        Bundle bundle = new Bundle();
        this.b.m(bundle);
        this.a.d(this.b, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.b.F != null) {
            l();
        }
        if (this.b.d != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.b.d);
        }
        if (!this.b.H) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.b.H);
        }
        return bundle;
    }

    void l() {
        if (this.b.F == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.b.F.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.b.d = sparseArray;
        }
    }

    void a(f<?> fVar, k kVar) {
        if (i.a(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.b);
        }
        boolean z = true;
        boolean z2 = this.b.l && !this.b.a();
        if (z2 || kVar.b(this.b)) {
            if (fVar instanceof y) {
                z = kVar.b();
            } else if (fVar.j() instanceof Activity) {
                z = true ^ ((Activity) fVar.j()).isChangingConfigurations();
            }
            if (z2 || z) {
                kVar.f(this.b);
            }
            this.b.ah();
            this.a.f(this.b, false);
            return;
        }
        this.b.b = 0;
    }

    void a(k kVar) {
        if (i.a(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.b);
        }
        this.b.ai();
        boolean z = false;
        this.a.g(this.b, false);
        this.b.b = -1;
        this.b.s = null;
        this.b.u = null;
        this.b.r = null;
        if (this.b.l && !this.b.a()) {
            z = true;
        }
        if (z || kVar.b(this.b)) {
            if (i.a(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.b);
            }
            this.b.L();
        }
    }
}
