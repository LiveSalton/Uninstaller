package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzw extends Thread {
    private final BlockingQueue<zzaa<?>> a;
    private final zzx b;
    private final zzk c;
    private final zzak d;
    private volatile boolean e = false;

    public zzw(BlockingQueue<zzaa<?>> blockingQueue, zzx zzxVar, zzk zzkVar, zzak zzakVar) {
        this.a = blockingQueue;
        this.b = zzxVar;
        this.c = zzkVar;
        this.d = zzakVar;
    }

    public final void a() {
        this.e = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                b();
            } catch (InterruptedException unused) {
                if (this.e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzaq.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private final void b() throws InterruptedException {
        zzaa<?> take = this.a.take();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        take.a(3);
        try {
            take.b("network-queue-take");
            take.h();
            TrafficStats.setThreadStatsTag(take.d());
            zzy a = this.b.a(take);
            take.b("network-http-complete");
            if (a.e && take.m()) {
                take.c("not-modified");
                take.n();
                return;
            }
            zzaj<?> a2 = take.a(a);
            take.b("network-parse-complete");
            if (take.i() && a2.b != null) {
                this.c.a(take.f(), a2.b);
                take.b("network-cache-written");
            }
            take.l();
            this.d.a(take, a2);
            take.a(a2);
        } catch (zzao e) {
            e.a(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.d.a(take, e);
            take.n();
        } catch (Exception e2) {
            zzaq.a(e2, "Unhandled exception %s", e2.toString());
            zzao zzaoVar = new zzao(e2);
            zzaoVar.a(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.d.a(take, zzaoVar);
            take.n();
        } finally {
            take.a(4);
        }
    }
}
