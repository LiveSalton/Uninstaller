package androidx.work.impl.background.systemalarm;

import androidx.work.h;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
class g {
    private static final String d = h.a("WorkTimer");
    private final ThreadFactory e = new ThreadFactory() { // from class: androidx.work.impl.background.systemalarm.g.1
        private int b = 0;

        AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            newThread.setName("WorkManager-WorkTimer-thread-" + this.b);
            this.b = this.b + 1;
            return newThread;
        }
    };
    final Map<String, b> a = new HashMap();
    final Map<String, a> b = new HashMap();
    final Object c = new Object();
    private final ScheduledExecutorService f = Executors.newSingleThreadScheduledExecutor(this.e);

    /* compiled from: source */
    interface a {
        void a(String str);
    }

    /* compiled from: source */
    /* renamed from: androidx.work.impl.background.systemalarm.g$1 */
    class AnonymousClass1 implements ThreadFactory {
        private int b = 0;

        AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            newThread.setName("WorkManager-WorkTimer-thread-" + this.b);
            this.b = this.b + 1;
            return newThread;
        }
    }

    g() {
    }

    void a(String str, long j, a aVar) {
        synchronized (this.c) {
            h.a().b(d, String.format("Starting timer for %s", str), new Throwable[0]);
            a(str);
            b bVar = new b(this, str);
            this.a.put(str, bVar);
            this.b.put(str, aVar);
            this.f.schedule(bVar, j, TimeUnit.MILLISECONDS);
        }
    }

    void a(String str) {
        synchronized (this.c) {
            if (this.a.remove(str) != null) {
                h.a().b(d, String.format("Stopping timer for %s", str), new Throwable[0]);
                this.b.remove(str);
            }
        }
    }

    void a() {
        if (this.f.isShutdown()) {
            return;
        }
        this.f.shutdownNow();
    }

    /* compiled from: source */
    static class b implements Runnable {
        private final g a;
        private final String b;

        b(g gVar, String str) {
            this.a = gVar;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.a.c) {
                if (this.a.a.remove(this.b) != null) {
                    a remove = this.a.b.remove(this.b);
                    if (remove != null) {
                        remove.a(this.b);
                    }
                } else {
                    h.a().b("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", this.b), new Throwable[0]);
                }
            }
        }
    }
}
