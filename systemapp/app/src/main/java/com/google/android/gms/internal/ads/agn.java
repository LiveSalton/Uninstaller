package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzboc;
import com.google.android.gms.internal.ads.zzbre;

/* compiled from: source */
/* loaded from: classes.dex */
final class agn<R extends zzbre<AdT>, AdT extends zzboc> implements zzdqc<AdT> {
    private final zzdkl<R, zzdpn<AdT>> a;

    public agn(zzdkl<R, zzdpn<AdT>> zzdklVar) {
        this.a = zzdklVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdqc
    public final void a(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzdqc
    public final zzdyz<zzdpn<AdT>> a(zzdqb zzdqbVar) {
        agm agmVar = (agm) zzdqbVar;
        return this.a.a(agmVar.b, agmVar.a);
    }

    @Override // com.google.android.gms.internal.ads.zzdqc
    public final void a(zzdpn<AdT> zzdpnVar) {
        zzdpnVar.a = this.a.a().c();
    }
}
