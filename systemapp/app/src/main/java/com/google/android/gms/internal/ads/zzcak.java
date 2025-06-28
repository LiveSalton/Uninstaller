package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzue;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcak implements zzepf<zzcah> {
    private final zzeps<Context> a;
    private final zzeps<zzbdv> b;
    private final zzeps<zzdmu> c;
    private final zzeps<zzazh> d;
    private final zzeps<zzue.zza.EnumC0075zza> e;

    private zzcak(zzeps<Context> zzepsVar, zzeps<zzbdv> zzepsVar2, zzeps<zzdmu> zzepsVar3, zzeps<zzazh> zzepsVar4, zzeps<zzue.zza.EnumC0075zza> zzepsVar5) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
    }

    public static zzcak a(zzeps<Context> zzepsVar, zzeps<zzbdv> zzepsVar2, zzeps<zzdmu> zzepsVar3, zzeps<zzazh> zzepsVar4, zzeps<zzue.zza.EnumC0075zza> zzepsVar5) {
        return new zzcak(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4, zzepsVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcah(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b());
    }
}
