package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbpn implements zzepf<zzbpo> {
    private final zzeps<Clock> a;
    private final zzeps<zzayf> b;

    private zzbpn(zzeps<Clock> zzepsVar, zzeps<zzayf> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzbpn a(zzeps<Clock> zzepsVar, zzeps<zzayf> zzepsVar2) {
        return new zzbpn(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbpo(this.a.b(), this.b.b());
    }
}
