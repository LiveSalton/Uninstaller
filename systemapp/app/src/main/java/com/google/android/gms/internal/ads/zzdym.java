package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzdym<V> extends zzdyn<V> implements zzdyz<V> {
    protected zzdym() {
    }

    @Override // com.google.android.gms.internal.ads.zzdyn
    /* renamed from: b */
    public abstract zzdyz<? extends V> a();

    @Override // com.google.android.gms.internal.ads.zzdyz
    public void a(Runnable runnable, Executor executor) {
        a().a(runnable, executor);
    }
}
