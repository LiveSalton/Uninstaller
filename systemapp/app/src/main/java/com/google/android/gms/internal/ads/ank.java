package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: source */
/* loaded from: classes.dex */
final class ank<V> implements Runnable {
    private final Future<V> a;
    private final zzdyo<? super V> b;

    ank(Future<V> future, zzdyo<? super V> zzdyoVar) {
        this.a = future;
        this.b = zzdyoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable a;
        if ((this.a instanceof zzdzr) && (a = zzdzu.a((zzdzr) this.a)) != null) {
            this.b.a(a);
            return;
        }
        try {
            this.b.a((zzdyo<? super V>) zzdyr.a((Future) this.a));
        } catch (Error | RuntimeException e) {
            this.b.a(e);
        } catch (ExecutionException e2) {
            this.b.a(e2.getCause());
        }
    }

    public final String toString() {
        return zzdvo.a(this).a(this.b).toString();
    }
}
