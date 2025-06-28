package androidx.navigation;

import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.lifecycle.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

/* compiled from: source */
/* loaded from: classes.dex */
class c extends v {
    private static final w.a a = new w.a() { // from class: androidx.navigation.c.1
        AnonymousClass1() {
        }

        @Override // androidx.lifecycle.w.a
        public <T extends v> T a(Class<T> cls) {
            return new c();
        }
    };
    private final HashMap<UUID, x> b = new HashMap<>();

    c() {
    }

    /* compiled from: source */
    /* renamed from: androidx.navigation.c$1 */
    class AnonymousClass1 implements w.a {
        AnonymousClass1() {
        }

        @Override // androidx.lifecycle.w.a
        public <T extends v> T a(Class<T> cls) {
            return new c();
        }
    }

    @Override // androidx.lifecycle.v
    protected void a() {
        Iterator<x> it = this.b.values().iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        this.b.clear();
    }

    x a(UUID uuid) {
        x xVar = this.b.get(uuid);
        if (xVar != null) {
            return xVar;
        }
        x xVar2 = new x();
        this.b.put(uuid, xVar2);
        return xVar2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NavControllerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} ViewModelStores (");
        Iterator<UUID> it = this.b.keySet().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
