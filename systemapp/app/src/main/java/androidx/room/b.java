package androidx.room;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class b<T> extends m {
    protected abstract void a(androidx.g.a.f fVar, T t);

    public b(i iVar) {
        super(iVar);
    }

    public final void a(T t) {
        androidx.g.a.f c = c();
        try {
            a(c, t);
            c.b();
        } finally {
            a(c);
        }
    }
}
