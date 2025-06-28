package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbpw implements zzepf<zzbob> {
    private final zzeps<zzdnj> a;
    private final zzeps<zzdmu> b;
    private final zzeps<zzbso> c;
    private final zzeps<zzbte> d;
    private final zzeps<zzdki> e;
    private final zzeps<zzbrp> f;
    private final zzeps<zzbul> g;

    private zzbpw(zzeps<zzdnj> zzepsVar, zzeps<zzdmu> zzepsVar2, zzeps<zzbso> zzepsVar3, zzeps<zzbte> zzepsVar4, zzeps<zzdki> zzepsVar5, zzeps<zzbrp> zzepsVar6, zzeps<zzbul> zzepsVar7) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
        this.f = zzepsVar6;
        this.g = zzepsVar7;
    }

    public static zzbpw a(zzeps<zzdnj> zzepsVar, zzeps<zzdmu> zzepsVar2, zzeps<zzbso> zzepsVar3, zzeps<zzbte> zzepsVar4, zzeps<zzdki> zzepsVar5, zzeps<zzbrp> zzepsVar6, zzeps<zzbul> zzepsVar7) {
        return new zzbpw(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4, zzepsVar5, zzepsVar6, zzepsVar7);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbob(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b(), this.f.b(), this.g.b());
    }
}
