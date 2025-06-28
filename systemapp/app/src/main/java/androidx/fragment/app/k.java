package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.lifecycle.x;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
final class k extends v {
    private static final w.a a = new w.a() { // from class: androidx.fragment.app.k.1
        AnonymousClass1() {
        }

        @Override // androidx.lifecycle.w.a
        public <T extends v> T a(Class<T> cls) {
            return new k(true);
        }
    };
    private final boolean e;
    private final HashMap<String, Fragment> b = new HashMap<>();
    private final HashMap<String, k> c = new HashMap<>();
    private final HashMap<String, x> d = new HashMap<>();
    private boolean f = false;
    private boolean g = false;

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.k$1 */
    static class AnonymousClass1 implements w.a {
        AnonymousClass1() {
        }

        @Override // androidx.lifecycle.w.a
        public <T extends v> T a(Class<T> cls) {
            return new k(true);
        }
    }

    static k a(x xVar) {
        return (k) new w(xVar, a).a(k.class);
    }

    k(boolean z) {
        this.e = z;
    }

    @Override // androidx.lifecycle.v
    protected void a() {
        if (i.a(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f = true;
    }

    boolean b() {
        return this.f;
    }

    boolean a(Fragment fragment) {
        if (this.b.containsKey(fragment.f)) {
            return false;
        }
        this.b.put(fragment.f, fragment);
        return true;
    }

    Fragment a(String str) {
        return this.b.get(str);
    }

    Collection<Fragment> c() {
        return this.b.values();
    }

    boolean b(Fragment fragment) {
        if (!this.b.containsKey(fragment.f)) {
            return true;
        }
        if (this.e) {
            return this.f;
        }
        return !this.g;
    }

    boolean c(Fragment fragment) {
        return this.b.remove(fragment.f) != null;
    }

    k d(Fragment fragment) {
        k kVar = this.c.get(fragment.f);
        if (kVar != null) {
            return kVar;
        }
        k kVar2 = new k(this.e);
        this.c.put(fragment.f, kVar2);
        return kVar2;
    }

    x e(Fragment fragment) {
        x xVar = this.d.get(fragment.f);
        if (xVar != null) {
            return xVar;
        }
        x xVar2 = new x();
        this.d.put(fragment.f, xVar2);
        return xVar2;
    }

    void f(Fragment fragment) {
        if (i.a(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        k kVar = this.c.get(fragment.f);
        if (kVar != null) {
            kVar.a();
            this.c.remove(fragment.f);
        }
        x xVar = this.d.get(fragment.f);
        if (xVar != null) {
            xVar.b();
            this.d.remove(fragment.f);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.b.equals(kVar.b) && this.c.equals(kVar.c) && this.d.equals(kVar.d);
    }

    public int hashCode() {
        return (31 * ((this.b.hashCode() * 31) + this.c.hashCode())) + this.d.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.b.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
