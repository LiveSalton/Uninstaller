package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcag implements zzepf<zzcqz<zzbyx>> {
    private final zzeps<zzdro> a;
    private final zzeps<zzdzc> b;
    private final zzeps<zzcth> c;
    private final zzeps<zzcvu> d;

    public zzcag(zzeps<zzdro> zzepsVar, zzeps<zzdzc> zzepsVar2, zzeps<zzcth> zzepsVar3, zzeps<zzcvu> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzcqz) zzepl.a(new zzcvy(this.a.b(), this.b.b(), this.d.b(), this.c.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
