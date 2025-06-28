package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
final class b<TResult, TContinuationResult> implements g<TResult> {
    private final Executor a;
    private final Continuation<TResult, TContinuationResult> b;
    private final i<TContinuationResult> c;

    public b(Executor executor, Continuation<TResult, TContinuationResult> continuation, i<TContinuationResult> iVar) {
        this.a = executor;
        this.b = continuation;
        this.c = iVar;
    }

    @Override // com.google.android.gms.tasks.g
    public final void a(Task<TResult> task) {
        this.a.execute(new c(this, task));
    }
}
