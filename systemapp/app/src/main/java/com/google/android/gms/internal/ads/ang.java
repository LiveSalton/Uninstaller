package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: source */
/* loaded from: classes.dex */
abstract class ang<T> extends anp<T> {
    private final Executor a;
    private final /* synthetic */ ane b;

    ang(ane aneVar, Executor executor) {
        this.b = aneVar;
        this.a = (Executor) zzdvv.a(executor);
    }

    abstract void a(T t);

    @Override // com.google.android.gms.internal.ads.anp
    final boolean c() {
        return this.b.isDone();
    }

    final void d() {
        try {
            this.a.execute(this);
        } catch (RejectedExecutionException e) {
            this.b.a((Throwable) e);
        }
    }

    @Override // com.google.android.gms.internal.ads.anp
    final void a(T t, Throwable th) {
        ane.a(this.b, (ang) null);
        if (th != null) {
            if (th instanceof ExecutionException) {
                this.b.a(th.getCause());
                return;
            } else if (th instanceof CancellationException) {
                this.b.cancel(false);
                return;
            } else {
                this.b.a(th);
                return;
            }
        }
        a(t);
    }
}
