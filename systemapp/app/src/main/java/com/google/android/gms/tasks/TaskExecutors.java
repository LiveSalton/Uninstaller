package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.tasks.zzb;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class TaskExecutors {
    public static final Executor a = new a();
    static final Executor b = new h();

    private TaskExecutors() {
    }

    /* compiled from: source */
    private static final class a implements Executor {
        private final Handler a = new zzb(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.a.post(runnable);
        }
    }
}
