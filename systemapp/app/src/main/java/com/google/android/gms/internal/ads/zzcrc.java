package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcrc<DelegateT, AdapterT> implements zzcqz<AdapterT> {

    @VisibleForTesting
    private final zzcqz<DelegateT> a;
    private final zzdvm<DelegateT, AdapterT> b;

    public zzcrc(zzcqz<DelegateT> zzcqzVar, zzdvm<DelegateT, AdapterT> zzdvmVar) {
        this.a = zzcqzVar;
        this.b = zzdvmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcqz
    public final boolean a(zzdnj zzdnjVar, zzdmu zzdmuVar) {
        return this.a.a(zzdnjVar, zzdmuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcqz
    public final zzdyz<AdapterT> b(zzdnj zzdnjVar, zzdmu zzdmuVar) {
        return zzdyr.a(this.a.b(zzdnjVar, zzdmuVar), this.b, zzazj.a);
    }
}
