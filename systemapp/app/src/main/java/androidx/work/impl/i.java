package androidx.work.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.b.j;
import androidx.work.impl.b.k;
import androidx.work.impl.b.n;
import androidx.work.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* compiled from: source */
/* loaded from: classes.dex */
public class i implements Runnable {
    static final String a = androidx.work.h.a("WorkerWrapper");
    j b;
    ListenableWorker c;
    private Context f;
    private String g;
    private List<d> h;
    private WorkerParameters.a i;
    private androidx.work.b j;
    private androidx.work.impl.utils.b.a k;
    private WorkDatabase l;
    private k m;
    private androidx.work.impl.b.b n;
    private n o;
    private List<String> p;
    private String q;
    private volatile boolean s;
    ListenableWorker.a d = ListenableWorker.a.c();
    private androidx.work.impl.utils.a.c<Boolean> r = androidx.work.impl.utils.a.c.d();
    com.google.a.a.a.a<ListenableWorker.a> e = null;

    i(a aVar) {
        this.f = aVar.a;
        this.k = aVar.c;
        this.g = aVar.f;
        this.h = aVar.g;
        this.i = aVar.h;
        this.c = aVar.b;
        this.j = aVar.d;
        this.l = aVar.e;
        this.m = this.l.o();
        this.n = this.l.p();
        this.o = this.l.q();
    }

    public com.google.a.a.a.a<Boolean> a() {
        return this.r;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.p = this.o.a(this.g);
        this.q = a(this.p);
        d();
    }

    private void d() {
        androidx.work.e a2;
        if (f()) {
            return;
        }
        this.l.g();
        try {
            this.b = this.m.b(this.g);
            if (this.b == null) {
                androidx.work.h.a().e(a, String.format("Didn't find WorkSpec for id %s", this.g), new Throwable[0]);
                b(false);
                return;
            }
            if (this.b.b != n.a.ENQUEUED) {
                e();
                this.l.j();
                androidx.work.h.a().b(a, String.format("%s is not in ENQUEUED state. Nothing more to do.", this.b.c), new Throwable[0]);
                return;
            }
            if (this.b.a() || this.b.b()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (!(this.b.n == 0) && currentTimeMillis < this.b.c()) {
                    androidx.work.h.a().b(a, String.format("Delaying execution for %s because it is being executed before schedule.", this.b.c), new Throwable[0]);
                    b(true);
                    return;
                }
            }
            this.l.j();
            this.l.h();
            if (this.b.a()) {
                a2 = this.b.e;
            } else {
                androidx.work.g a3 = androidx.work.g.a(this.b.d);
                if (a3 == null) {
                    androidx.work.h.a().e(a, String.format("Could not create Input Merger %s", this.b.d), new Throwable[0]);
                    c();
                    return;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.b.e);
                    arrayList.addAll(this.m.g(this.g));
                    a2 = a3.a(arrayList);
                }
            }
            WorkerParameters workerParameters = new WorkerParameters(UUID.fromString(this.g), a2, this.p, this.i, this.b.k, this.j.a(), this.k, this.j.c());
            if (this.c == null) {
                this.c = this.j.c().b(this.f, this.b.c, workerParameters);
            }
            if (this.c == null) {
                androidx.work.h.a().e(a, String.format("Could not create Worker %s", this.b.c), new Throwable[0]);
                c();
                return;
            }
            if (this.c.isUsed()) {
                androidx.work.h.a().e(a, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", this.b.c), new Throwable[0]);
                c();
                return;
            }
            this.c.setUsed();
            if (!g()) {
                e();
            } else {
                if (f()) {
                    return;
                }
                androidx.work.impl.utils.a.c d = androidx.work.impl.utils.a.c.d();
                this.k.a().execute(new Runnable() { // from class: androidx.work.impl.i.1
                    final /* synthetic */ androidx.work.impl.utils.a.c a;

                    AnonymousClass1(androidx.work.impl.utils.a.c d2) {
                        d = d2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            androidx.work.h.a().b(i.a, String.format("Starting work for %s", i.this.b.c), new Throwable[0]);
                            i.this.e = i.this.c.startWork();
                            d.a((com.google.a.a.a.a) i.this.e);
                        } catch (Throwable th) {
                            d.a(th);
                        }
                    }
                });
                d2.a(new Runnable() { // from class: androidx.work.impl.i.2
                    final /* synthetic */ androidx.work.impl.utils.a.c a;
                    final /* synthetic */ String b;

                    AnonymousClass2(androidx.work.impl.utils.a.c d2, String str) {
                        d = d2;
                        str = str;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    @SuppressLint({"SyntheticAccessor"})
                    public void run() {
                        try {
                            try {
                                ListenableWorker.a aVar = (ListenableWorker.a) d.get();
                                if (aVar == null) {
                                    androidx.work.h.a().e(i.a, String.format("%s returned a null result. Treating it as a failure.", i.this.b.c), new Throwable[0]);
                                } else {
                                    androidx.work.h.a().b(i.a, String.format("%s returned a %s result.", i.this.b.c, aVar), new Throwable[0]);
                                    i.this.d = aVar;
                                }
                            } catch (InterruptedException | ExecutionException e) {
                                androidx.work.h.a().e(i.a, String.format("%s failed because it threw an exception/error", str), e);
                            } catch (CancellationException e2) {
                                androidx.work.h.a().c(i.a, String.format("%s was cancelled", str), e2);
                            }
                        } finally {
                            i.this.b();
                        }
                    }
                }, this.k.b());
            }
        } finally {
            this.l.h();
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.i$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ androidx.work.impl.utils.a.c a;

        AnonymousClass1(androidx.work.impl.utils.a.c d2) {
            d = d2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                androidx.work.h.a().b(i.a, String.format("Starting work for %s", i.this.b.c), new Throwable[0]);
                i.this.e = i.this.c.startWork();
                d.a((com.google.a.a.a.a) i.this.e);
            } catch (Throwable th) {
                d.a(th);
            }
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.i$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ androidx.work.impl.utils.a.c a;
        final /* synthetic */ String b;

        AnonymousClass2(androidx.work.impl.utils.a.c d2, String str) {
            d = d2;
            str = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            try {
                try {
                    ListenableWorker.a aVar = (ListenableWorker.a) d.get();
                    if (aVar == null) {
                        androidx.work.h.a().e(i.a, String.format("%s returned a null result. Treating it as a failure.", i.this.b.c), new Throwable[0]);
                    } else {
                        androidx.work.h.a().b(i.a, String.format("%s returned a %s result.", i.this.b.c, aVar), new Throwable[0]);
                        i.this.d = aVar;
                    }
                } catch (InterruptedException | ExecutionException e) {
                    androidx.work.h.a().e(i.a, String.format("%s failed because it threw an exception/error", str), e);
                } catch (CancellationException e2) {
                    androidx.work.h.a().c(i.a, String.format("%s was cancelled", str), e2);
                }
            } finally {
                i.this.b();
            }
        }
    }

    void b() {
        boolean a2;
        boolean z = false;
        if (!f()) {
            this.l.g();
            try {
                n.a f = this.m.f(this.g);
                if (f == null) {
                    b(false);
                    a2 = true;
                } else if (f == n.a.RUNNING) {
                    a(this.d);
                    a2 = this.m.f(this.g).a();
                } else {
                    if (!f.a()) {
                        h();
                    }
                    this.l.j();
                }
                z = a2;
                this.l.j();
            } finally {
                this.l.h();
            }
        }
        if (this.h != null) {
            if (z) {
                Iterator<d> it = this.h.iterator();
                while (it.hasNext()) {
                    it.next().a(this.g);
                }
            }
            e.a(this.j, this.l, this.h);
        }
    }

    public void a(boolean z) {
        this.s = true;
        f();
        if (this.e != null) {
            this.e.cancel(true);
        }
        if (this.c != null) {
            this.c.stop();
        }
    }

    private void e() {
        n.a f = this.m.f(this.g);
        if (f == n.a.RUNNING) {
            androidx.work.h.a().b(a, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", this.g), new Throwable[0]);
            b(true);
        } else {
            androidx.work.h.a().b(a, String.format("Status for %s is %s; not doing any work", this.g, f), new Throwable[0]);
            b(false);
        }
    }

    private boolean f() {
        if (!this.s) {
            return false;
        }
        androidx.work.h.a().b(a, String.format("Work interrupted for %s", this.q), new Throwable[0]);
        if (this.m.f(this.g) == null) {
            b(false);
        } else {
            b(!r0.a());
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001e A[Catch: all -> 0x0039, TryCatch #0 {all -> 0x0039, blocks: (B:3:0x0005, B:5:0x0012, B:10:0x001e, B:11:0x0025), top: B:2:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(boolean r4) {
        /*
            r3 = this;
            androidx.work.impl.WorkDatabase r0 = r3.l
            r0.g()
            androidx.work.impl.WorkDatabase r0 = r3.l     // Catch: java.lang.Throwable -> L39
            androidx.work.impl.b.k r0 = r0.o()     // Catch: java.lang.Throwable -> L39
            java.util.List r0 = r0.a()     // Catch: java.lang.Throwable -> L39
            r1 = 0
            if (r0 == 0) goto L1b
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L39
            if (r0 == 0) goto L19
            goto L1b
        L19:
            r0 = r1
            goto L1c
        L1b:
            r0 = 1
        L1c:
            if (r0 == 0) goto L25
            android.content.Context r0 = r3.f     // Catch: java.lang.Throwable -> L39
            java.lang.Class<androidx.work.impl.background.systemalarm.RescheduleReceiver> r2 = androidx.work.impl.background.systemalarm.RescheduleReceiver.class
            androidx.work.impl.utils.d.a(r0, r2, r1)     // Catch: java.lang.Throwable -> L39
        L25:
            androidx.work.impl.WorkDatabase r0 = r3.l     // Catch: java.lang.Throwable -> L39
            r0.j()     // Catch: java.lang.Throwable -> L39
            androidx.work.impl.WorkDatabase r0 = r3.l
            r0.h()
            androidx.work.impl.utils.a.c<java.lang.Boolean> r0 = r3.r
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r0.a(r4)
            return
        L39:
            r4 = move-exception
            androidx.work.impl.WorkDatabase r0 = r3.l
            r0.h()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.i.b(boolean):void");
    }

    private void a(ListenableWorker.a aVar) {
        if (aVar instanceof ListenableWorker.a.c) {
            androidx.work.h.a().c(a, String.format("Worker result SUCCESS for %s", this.q), new Throwable[0]);
            if (this.b.a()) {
                i();
                return;
            } else {
                j();
                return;
            }
        }
        if (aVar instanceof ListenableWorker.a.b) {
            androidx.work.h.a().c(a, String.format("Worker result RETRY for %s", this.q), new Throwable[0]);
            h();
            return;
        }
        androidx.work.h.a().c(a, String.format("Worker result FAILURE for %s", this.q), new Throwable[0]);
        if (this.b.a()) {
            i();
        } else {
            c();
        }
    }

    private boolean g() {
        this.l.g();
        try {
            boolean z = true;
            if (this.m.f(this.g) == n.a.ENQUEUED) {
                this.m.a(n.a.RUNNING, this.g);
                this.m.d(this.g);
            } else {
                z = false;
            }
            this.l.j();
            return z;
        } finally {
            this.l.h();
        }
    }

    void c() {
        this.l.g();
        try {
            a(this.g);
            this.m.a(this.g, ((ListenableWorker.a.C0050a) this.d).d());
            this.l.j();
        } finally {
            this.l.h();
            b(false);
        }
    }

    private void a(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.m.f(str2) != n.a.CANCELLED) {
                this.m.a(n.a.FAILED, str2);
            }
            linkedList.addAll(this.n.b(str2));
        }
    }

    private void h() {
        this.l.g();
        try {
            this.m.a(n.a.ENQUEUED, this.g);
            this.m.a(this.g, System.currentTimeMillis());
            this.m.b(this.g, -1L);
            this.l.j();
        } finally {
            this.l.h();
            b(true);
        }
    }

    private void i() {
        this.l.g();
        try {
            this.m.a(this.g, System.currentTimeMillis());
            this.m.a(n.a.ENQUEUED, this.g);
            this.m.e(this.g);
            this.m.b(this.g, -1L);
            this.l.j();
        } finally {
            this.l.h();
            b(false);
        }
    }

    private void j() {
        this.l.g();
        try {
            this.m.a(n.a.SUCCEEDED, this.g);
            this.m.a(this.g, ((ListenableWorker.a.c) this.d).d());
            long currentTimeMillis = System.currentTimeMillis();
            for (String str : this.n.b(this.g)) {
                if (this.m.f(str) == n.a.BLOCKED && this.n.a(str)) {
                    androidx.work.h.a().c(a, String.format("Setting status to enqueued for %s", str), new Throwable[0]);
                    this.m.a(n.a.ENQUEUED, str);
                    this.m.a(str, currentTimeMillis);
                }
            }
            this.l.j();
        } finally {
            this.l.h();
            b(false);
        }
    }

    private String a(List<String> list) {
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.g);
        sb.append(", tags={ ");
        boolean z = true;
        for (String str : list) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(" } ]");
        return sb.toString();
    }

    /* compiled from: source */
    public static class a {
        Context a;
        ListenableWorker b;
        androidx.work.impl.utils.b.a c;
        androidx.work.b d;
        WorkDatabase e;
        String f;
        List<d> g;
        WorkerParameters.a h = new WorkerParameters.a();

        public a(Context context, androidx.work.b bVar, androidx.work.impl.utils.b.a aVar, WorkDatabase workDatabase, String str) {
            this.a = context.getApplicationContext();
            this.c = aVar;
            this.d = bVar;
            this.e = workDatabase;
            this.f = str;
        }

        public a a(List<d> list) {
            this.g = list;
            return this;
        }

        public a a(WorkerParameters.a aVar) {
            if (aVar != null) {
                this.h = aVar;
            }
            return this;
        }

        public i a() {
            return new i(this);
        }
    }
}
