package com.google.android.gms.tasks;

import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
final class f<TResult> {
    private final Object a = new Object();

    @GuardedBy("mLock")
    private Queue<g<TResult>> b;

    @GuardedBy("mLock")
    private boolean c;

    f() {
    }

    public final void a(g<TResult> gVar) {
        synchronized (this.a) {
            if (this.b == null) {
                this.b = new ArrayDeque();
            }
            this.b.add(gVar);
        }
    }

    public final void a(Task<TResult> task) {
        g<TResult> poll;
        synchronized (this.a) {
            if (this.b != null && !this.c) {
                this.c = true;
                while (true) {
                    synchronized (this.a) {
                        poll = this.b.poll();
                        if (poll == null) {
                            this.c = false;
                            return;
                        }
                    }
                    poll.a(task);
                }
            }
        }
    }
}
