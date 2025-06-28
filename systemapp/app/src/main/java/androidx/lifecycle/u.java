package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.f;

/* compiled from: source */
/* loaded from: classes.dex */
public class u {
    private final k a;
    private final Handler b = new Handler();
    private a c;

    public u(j jVar) {
        this.a = new k(jVar);
    }

    private void a(f.a aVar) {
        if (this.c != null) {
            this.c.run();
        }
        this.c = new a(this.a, aVar);
        this.b.postAtFrontOfQueue(this.c);
    }

    public void a() {
        a(f.a.ON_CREATE);
    }

    public void b() {
        a(f.a.ON_START);
    }

    public void c() {
        a(f.a.ON_START);
    }

    public void d() {
        a(f.a.ON_STOP);
        a(f.a.ON_DESTROY);
    }

    public f e() {
        return this.a;
    }

    /* compiled from: source */
    static class a implements Runnable {
        final f.a a;
        private final k b;
        private boolean c = false;

        a(k kVar, f.a aVar) {
            this.b = kVar;
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c) {
                return;
            }
            this.b.a(this.a);
            this.c = true;
        }
    }
}
