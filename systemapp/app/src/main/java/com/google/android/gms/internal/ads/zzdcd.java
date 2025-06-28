package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdcd implements zzepf<zzdcb> {
    private final zzeps<zzdzc> a;
    private final zzeps<zzcis> b;
    private final zzeps<zzdnn> c;
    private final zzeps<String> d;

    private zzdcd(zzeps<zzdzc> zzepsVar, zzeps<zzcis> zzepsVar2, zzeps<zzdnn> zzepsVar3, zzeps<String> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    public static zzdcd a(zzeps<zzdzc> zzepsVar, zzeps<zzcis> zzepsVar2, zzeps<zzdnn> zzepsVar3, zzeps<String> zzepsVar4) {
        return new zzdcd(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdcb(this.a.b(), this.b.b(), this.c.b(), this.d.b());
    }
}
