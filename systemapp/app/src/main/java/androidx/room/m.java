package androidx.room;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class m {
    private final AtomicBoolean a = new AtomicBoolean(false);
    private final i b;
    private volatile androidx.g.a.f c;

    protected abstract String a();

    public m(i iVar) {
        this.b = iVar;
    }

    protected void b() {
        this.b.e();
    }

    private androidx.g.a.f d() {
        return this.b.a(a());
    }

    private androidx.g.a.f a(boolean z) {
        if (z) {
            if (this.c == null) {
                this.c = d();
            }
            return this.c;
        }
        return d();
    }

    public androidx.g.a.f c() {
        b();
        return a(this.a.compareAndSet(false, true));
    }

    public void a(androidx.g.a.f fVar) {
        if (fVar == this.c) {
            this.a.set(false);
        }
    }
}
