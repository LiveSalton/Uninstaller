package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbtc;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcwc<AdT, AdapterT, ListenerT extends zzbtc> implements zzepf<zzcvy<AdT, AdapterT, ListenerT>> {
    private final zzeps<zzdro> a;
    private final zzeps<zzdzc> b;
    private final zzeps<zzcre<AdapterT, ListenerT>> c;
    private final zzeps<zzcrh<AdT, AdapterT, ListenerT>> d;

    private zzcwc(zzeps<zzdro> zzepsVar, zzeps<zzdzc> zzepsVar2, zzeps<zzcre<AdapterT, ListenerT>> zzepsVar3, zzeps<zzcrh<AdT, AdapterT, ListenerT>> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    public static <AdT, AdapterT, ListenerT extends zzbtc> zzcwc<AdT, AdapterT, ListenerT> a(zzeps<zzdro> zzepsVar, zzeps<zzdzc> zzepsVar2, zzeps<zzcre<AdapterT, ListenerT>> zzepsVar3, zzeps<zzcrh<AdT, AdapterT, ListenerT>> zzepsVar4) {
        return new zzcwc<>(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcvy(this.a.b(), this.b.b(), this.c.b(), this.d.b());
    }
}
