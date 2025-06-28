package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: source */
/* loaded from: classes.dex */
final class ft<T> implements zzdyo<T> {
    private final /* synthetic */ zzazx a;

    ft(zzazx zzazxVar) {
        this.a = zzazxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(T t) {
        AtomicInteger atomicInteger;
        atomicInteger = this.a.b;
        atomicInteger.set(1);
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Throwable th) {
        AtomicInteger atomicInteger;
        atomicInteger = this.a.b;
        atomicInteger.set(-1);
    }
}
