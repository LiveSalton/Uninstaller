package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbpy implements zzepf<zza> {
    private final zzbpv a;
    private final zzeps<Context> b;
    private final zzeps<zzawq> c;

    private zzbpy(zzbpv zzbpvVar, zzeps<Context> zzepsVar, zzeps<zzawq> zzepsVar2) {
        this.a = zzbpvVar;
        this.b = zzepsVar;
        this.c = zzepsVar2;
    }

    public static zzbpy a(zzbpv zzbpvVar, zzeps<Context> zzepsVar, zzeps<zzawq> zzepsVar2) {
        return new zzbpy(zzbpvVar, zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zza) zzepl.a(new zza(this.b.b(), this.c.b(), null), "Cannot return null from a non-@Nullable @Provides method");
    }
}
