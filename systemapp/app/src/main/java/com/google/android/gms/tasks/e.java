package com.google.android.gms.tasks;

import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
final class e<TResult> implements g<TResult> {
    private final Executor a;
    private final Object b = new Object();

    @GuardedBy("mLock")
    private OnFailureListener c;

    public e(Executor executor, OnFailureListener onFailureListener) {
        this.a = executor;
        this.c = onFailureListener;
    }

    @Override // com.google.android.gms.tasks.g
    public final void a(Task<TResult> task) {
        if (task.b() || task.c()) {
            return;
        }
        synchronized (this.b) {
            if (this.c == null) {
                return;
            }
            this.a.execute(new d(this, task));
        }
    }
}
