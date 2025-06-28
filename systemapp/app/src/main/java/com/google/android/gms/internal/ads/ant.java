package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: source */
/* loaded from: classes.dex */
final class ant implements Executor {
    private final /* synthetic */ Executor a;
    private final /* synthetic */ zzdxo b;

    ant(Executor executor, zzdxo zzdxoVar) {
        this.a = executor;
        this.b = zzdxoVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        try {
            this.a.execute(runnable);
        } catch (RejectedExecutionException e) {
            this.b.a((Throwable) e);
        }
    }
}
