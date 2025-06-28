package androidx.work.impl.utils;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public class f implements Executor {
    private final Executor b;
    private volatile Runnable d;
    private final ArrayDeque<a> a = new ArrayDeque<>();
    private final Object c = new Object();

    public f(Executor executor) {
        this.b = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        synchronized (this.c) {
            this.a.add(new a(this, runnable));
            if (this.d == null) {
                a();
            }
        }
    }

    void a() {
        synchronized (this.c) {
            a poll = this.a.poll();
            this.d = poll;
            if (poll != null) {
                this.b.execute(this.d);
            }
        }
    }

    /* compiled from: source */
    static class a implements Runnable {
        final f a;
        final Runnable b;

        a(f fVar, Runnable runnable) {
            this.a = fVar;
            this.b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.b.run();
            } finally {
                this.a.a();
            }
        }
    }
}
