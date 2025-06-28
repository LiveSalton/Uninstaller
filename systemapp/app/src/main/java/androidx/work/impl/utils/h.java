package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.k;
import androidx.work.n;

/* compiled from: source */
/* loaded from: classes.dex */
public class h implements Runnable {
    private static final String a = androidx.work.h.a("StopWorkRunnable");
    private androidx.work.impl.h b;
    private String c;

    public h(androidx.work.impl.h hVar, String str) {
        this.b = hVar;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        WorkDatabase c = this.b.c();
        k o = c.o();
        c.g();
        try {
            if (o.f(this.c) == n.a.RUNNING) {
                o.a(n.a.ENQUEUED, this.c);
            }
            androidx.work.h.a().b(a, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", this.c, Boolean.valueOf(this.b.f().b(this.c))), new Throwable[0]);
            c.j();
        } finally {
            c.h();
        }
    }
}
