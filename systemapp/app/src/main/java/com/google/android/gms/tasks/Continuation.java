package com.google.android.gms.tasks;

/* compiled from: source */
/* loaded from: classes.dex */
public interface Continuation<TResult, TContinuationResult> {
    TContinuationResult a(Task<TResult> task) throws Exception;
}
