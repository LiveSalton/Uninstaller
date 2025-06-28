package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
class n implements Executor {
    private final Executor a;
    private final ArrayDeque<Runnable> b = new ArrayDeque<>();
    private Runnable c;

    n(Executor executor) {
        this.a = executor;
    }

    /* compiled from: source */
    /* renamed from: androidx.room.n$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Runnable a;

        AnonymousClass1(Runnable runnable) {
            runnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                runnable.run();
            } finally {
                n.this.a();
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        this.b.offer(new Runnable() { // from class: androidx.room.n.1
            final /* synthetic */ Runnable a;

            AnonymousClass1(Runnable runnable2) {
                runnable = runnable2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } finally {
                    n.this.a();
                }
            }
        });
        if (this.c == null) {
            a();
        }
    }

    synchronized void a() {
        Runnable poll = this.b.poll();
        this.c = poll;
        if (poll != null) {
            this.a.execute(this.c);
        }
    }
}
