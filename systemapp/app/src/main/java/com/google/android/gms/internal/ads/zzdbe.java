package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdbe implements zzepf<zzdbc> {
    private final zzeps<String> a;
    private final zzeps<String> b;
    private final zzeps<zzbpo> c;
    private final zzeps<zzdon> d;
    private final zzeps<zzdnn> e;

    private zzdbe(zzeps<String> zzepsVar, zzeps<String> zzepsVar2, zzeps<zzbpo> zzepsVar3, zzeps<zzdon> zzepsVar4, zzeps<zzdnn> zzepsVar5) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
    }

    public static zzdbe a(zzeps<String> zzepsVar, zzeps<String> zzepsVar2, zzeps<zzbpo> zzepsVar3, zzeps<zzdon> zzepsVar4, zzeps<zzdnn> zzepsVar5) {
        return new zzdbe(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4, zzepsVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdbc(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b());
    }
}
