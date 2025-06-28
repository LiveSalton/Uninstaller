package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcjq implements zzepf<zzcjj> {
    private final zzeps<zzts> a;
    private final zzeps<zzdkt> b;

    private zzcjq(zzeps<zzts> zzepsVar, zzeps<zzdkt> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzcjq a(zzeps<zzts> zzepsVar, zzeps<zzdkt> zzepsVar2) {
        return new zzcjq(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcjj(this.a.b(), this.b.b());
    }
}
