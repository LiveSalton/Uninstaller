package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public class x {
    private final HashMap<String, v> a = new HashMap<>();

    final void a(String str, v vVar) {
        v put = this.a.put(str, vVar);
        if (put != null) {
            put.a();
        }
    }

    final v a(String str) {
        return this.a.get(str);
    }

    Set<String> a() {
        return new HashSet(this.a.keySet());
    }

    public final void b() {
        Iterator<v> it = this.a.values().iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        this.a.clear();
    }
}
