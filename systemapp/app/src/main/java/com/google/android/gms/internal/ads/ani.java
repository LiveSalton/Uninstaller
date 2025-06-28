package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxo;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: source */
/* loaded from: classes.dex */
class ani<V> extends zzdyi<V> implements zzdxo.g<V> {
    ani() {
    }

    @Override // com.google.android.gms.internal.ads.zzdxo, java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (V) super.get(j, timeUnit);
    }
}
