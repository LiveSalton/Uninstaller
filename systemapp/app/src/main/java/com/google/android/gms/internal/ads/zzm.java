package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzm extends Thread {
    private static final boolean a = zzaq.a;
    private final BlockingQueue<zzaa<?>> b;
    private final BlockingQueue<zzaa<?>> c;
    private final zzk d;
    private final zzak e;
    private volatile boolean f = false;
    private final bba g = new bba(this);

    public zzm(BlockingQueue<zzaa<?>> blockingQueue, BlockingQueue<zzaa<?>> blockingQueue2, zzk zzkVar, zzak zzakVar) {
        this.b = blockingQueue;
        this.c = blockingQueue2;
        this.d = zzkVar;
        this.e = zzakVar;
    }

    public final void a() {
        this.f = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (a) {
            zzaq.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.d.a();
        while (true) {
            try {
                b();
            } catch (InterruptedException unused) {
                if (this.f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzaq.c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private final void b() throws InterruptedException {
        boolean b;
        boolean b2;
        boolean b3;
        boolean b4;
        zzaa<?> take = this.b.take();
        take.b("cache-queue-take");
        take.a(1);
        try {
            take.h();
            zzn a2 = this.d.a(take.f());
            if (a2 == null) {
                take.b("cache-miss");
                b4 = this.g.b(take);
                if (!b4) {
                    this.c.put(take);
                }
                return;
            }
            if (a2.a()) {
                take.b("cache-hit-expired");
                take.a(a2);
                b3 = this.g.b(take);
                if (!b3) {
                    this.c.put(take);
                }
                return;
            }
            take.b("cache-hit");
            zzaj<?> a3 = take.a(new zzy(a2.a, a2.g));
            take.b("cache-hit-parsed");
            if (!a3.a()) {
                take.b("cache-parsing-failed");
                this.d.a(take.f(), true);
                take.a((zzn) null);
                b2 = this.g.b(take);
                if (!b2) {
                    this.c.put(take);
                }
                return;
            }
            if (!(a2.f < System.currentTimeMillis())) {
                this.e.a(take, a3);
            } else {
                take.b("cache-hit-refresh-needed");
                take.a(a2);
                a3.d = true;
                b = this.g.b(take);
                if (!b) {
                    this.e.a(take, a3, new bbd(this, take));
                } else {
                    this.e.a(take, a3);
                }
            }
        } finally {
            take.a(2);
        }
    }
}
