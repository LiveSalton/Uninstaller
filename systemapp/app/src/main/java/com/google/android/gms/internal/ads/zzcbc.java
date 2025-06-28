package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrg;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcbc implements zzepf<zzbod<zzbme>> {
    private final zzeps<zzbgm> a;
    private final zzeps<zzbrg.zza> b;
    private final zzeps<zzbwp> c;
    private final zzeps<zzcap> d;
    private final zzeps<zzbua> e;

    public zzcbc(zzeps<zzbgm> zzepsVar, zzeps<zzbrg.zza> zzepsVar2, zzeps<zzbwp> zzepsVar3, zzeps<zzcap> zzepsVar4, zzeps<zzbua> zzepsVar5) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        zzbgm b = this.a.b();
        zzbrg.zza b2 = this.b.b();
        zzbwp b3 = this.c.b();
        return (zzbod) zzepl.a(b.h().a(b2.a()).a(b3).a(this.d.b()).a(new zzcwq(null)).a(new zzbnv(this.e.b())).a(new zzblz(null)).b().c(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
