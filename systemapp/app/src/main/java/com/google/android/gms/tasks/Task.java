package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class Task<TResult> {
    public abstract Task<TResult> a(Executor executor, OnFailureListener onFailureListener);

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c();

    public abstract TResult d();

    public abstract Exception e();

    public <TContinuationResult> Task<TContinuationResult> a(Executor executor, Continuation<TResult, TContinuationResult> continuation) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }
}
