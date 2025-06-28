package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class Tasks {
    public static <TResult> Task<TResult> a(TResult tresult) {
        i iVar = new i();
        iVar.a((i) tresult);
        return iVar;
    }

    public static <TResult> Task<TResult> a(Executor executor, Callable<TResult> callable) {
        Preconditions.a(executor, "Executor must not be null");
        Preconditions.a(callable, "Callback must not be null");
        i iVar = new i();
        executor.execute(new k(iVar, callable));
        return iVar;
    }

    private Tasks() {
    }
}
