package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdaz implements zzepf<zzdax> {
    private final zzeps<zzdzc> a;
    private final zzeps<zzdnn> b;
    private final zzeps<zzazh> c;

    private zzdaz(zzeps<zzdzc> zzepsVar, zzeps<zzdnn> zzepsVar2, zzeps<zzazh> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    public static zzdaz a(zzeps<zzdzc> zzepsVar, zzeps<zzdnn> zzepsVar2, zzeps<zzazh> zzepsVar3) {
        return new zzdaz(zzepsVar, zzepsVar2, zzepsVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdax(this.a.b(), this.b.b(), this.c.b());
    }
}
