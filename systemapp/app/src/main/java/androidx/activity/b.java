package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class b {
    private boolean a;
    private CopyOnWriteArrayList<a> b = new CopyOnWriteArrayList<>();

    public abstract void c();

    public b(boolean z) {
        this.a = z;
    }

    public final void a(boolean z) {
        this.a = z;
    }

    public final boolean a() {
        return this.a;
    }

    public final void b() {
        Iterator<a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    void a(a aVar) {
        this.b.add(aVar);
    }

    void b(a aVar) {
        this.b.remove(aVar);
    }
}
