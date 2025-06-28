package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.h;
import androidx.work.impl.b.j;
import androidx.work.impl.background.systemalarm.e;
import androidx.work.impl.background.systemalarm.g;
import androidx.work.impl.utils.i;
import java.util.Collections;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public class d implements androidx.work.impl.a, androidx.work.impl.a.c, g.a {
    private static final String a = h.a("DelayMetCommandHandler");
    private final Context b;
    private final int c;
    private final String d;
    private final e e;
    private final androidx.work.impl.a.d f;
    private PowerManager.WakeLock i;
    private boolean j = false;
    private int h = 0;
    private final Object g = new Object();

    d(Context context, int i, String str, e eVar) {
        this.b = context;
        this.c = i;
        this.e = eVar;
        this.d = str;
        this.f = new androidx.work.impl.a.d(this.b, eVar.e(), this);
    }

    @Override // androidx.work.impl.a.c
    public void a(List<String> list) {
        if (list.contains(this.d)) {
            synchronized (this.g) {
                if (this.h == 0) {
                    this.h = 1;
                    h.a().b(a, String.format("onAllConstraintsMet for %s", this.d), new Throwable[0]);
                    if (this.e.b().a(this.d)) {
                        this.e.c().a(this.d, 600000L, this);
                    } else {
                        c();
                    }
                } else {
                    h.a().b(a, String.format("Already started work for %s", this.d), new Throwable[0]);
                }
            }
        }
    }

    @Override // androidx.work.impl.a
    public void a(String str, boolean z) {
        h.a().b(a, String.format("onExecuted %s, %s", str, Boolean.valueOf(z)), new Throwable[0]);
        c();
        if (z) {
            this.e.a(new e.a(this.e, b.a(this.b, this.d), this.c));
        }
        if (this.j) {
            this.e.a(new e.a(this.e, b.a(this.b), this.c));
        }
    }

    @Override // androidx.work.impl.background.systemalarm.g.a
    public void a(String str) {
        h.a().b(a, String.format("Exceeded time limits on execution for %s", str), new Throwable[0]);
        b();
    }

    @Override // androidx.work.impl.a.c
    public void b(List<String> list) {
        b();
    }

    void a() {
        this.i = i.a(this.b, String.format("%s (%s)", this.d, Integer.valueOf(this.c)));
        h.a().b(a, String.format("Acquiring wakelock %s for WorkSpec %s", this.i, this.d), new Throwable[0]);
        this.i.acquire();
        j b = this.e.d().c().o().b(this.d);
        if (b == null) {
            b();
            return;
        }
        this.j = b.d();
        if (!this.j) {
            h.a().b(a, String.format("No constraints for %s", this.d), new Throwable[0]);
            a(Collections.singletonList(this.d));
        } else {
            this.f.a(Collections.singletonList(b));
        }
    }

    private void b() {
        synchronized (this.g) {
            if (this.h < 2) {
                this.h = 2;
                h.a().b(a, String.format("Stopping work for WorkSpec %s", this.d), new Throwable[0]);
                this.e.a(new e.a(this.e, b.c(this.b, this.d), this.c));
                if (this.e.b().e(this.d)) {
                    h.a().b(a, String.format("WorkSpec %s needs to be rescheduled", this.d), new Throwable[0]);
                    this.e.a(new e.a(this.e, b.a(this.b, this.d), this.c));
                } else {
                    h.a().b(a, String.format("Processor does not have WorkSpec %s. No need to reschedule ", this.d), new Throwable[0]);
                }
            } else {
                h.a().b(a, String.format("Already stopped work for %s", this.d), new Throwable[0]);
            }
        }
    }

    private void c() {
        synchronized (this.g) {
            this.f.a();
            this.e.c().a(this.d);
            if (this.i != null && this.i.isHeld()) {
                h.a().b(a, String.format("Releasing wakelock %s for WorkSpec %s", this.i, this.d), new Throwable[0]);
                this.i.release();
            }
        }
    }
}
