package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcwn<AdT> implements zzepf<zzcwj<AdT>> {
    private final zzeps<zzdro> a;
    private final zzeps<zzdzc> b;
    private final zzeps<zzacb> c;
    private final zzeps<zzcwo<AdT>> d;

    public zzcwn(zzeps<zzdro> zzepsVar, zzeps<zzdzc> zzepsVar2, zzeps<zzacb> zzepsVar3, zzeps<zzcwo<AdT>> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcwj(this.a.b(), this.b.b(), this.c.b(), this.d.b());
    }
}
