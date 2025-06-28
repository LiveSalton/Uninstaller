package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbpl implements zzepf<zzayf> {
    private final zzeps<Clock> a;
    private final zzeps<zzayq> b;
    private final zzeps<zzdnn> c;

    private zzbpl(zzeps<Clock> zzepsVar, zzeps<zzayq> zzepsVar2, zzeps<zzdnn> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    public static zzbpl a(zzeps<Clock> zzepsVar, zzeps<zzayq> zzepsVar2, zzeps<zzdnn> zzepsVar3) {
        return new zzbpl(zzepsVar, zzepsVar2, zzepsVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzayf) zzepl.a(this.b.b().a(this.a.b(), this.c.b().f), "Cannot return null from a non-@Nullable @Provides method");
    }
}
