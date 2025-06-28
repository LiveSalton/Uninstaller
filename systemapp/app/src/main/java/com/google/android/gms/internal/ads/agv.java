package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
final class agv implements zzdvm<zzcoh, zzdkj> {
    private final /* synthetic */ agt a;

    agv(agt agtVar) {
        this.a = agtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdvm
    @NullableDecl
    public final /* synthetic */ zzdkj a(@NullableDecl zzcoh zzcohVar) {
        zzdpq b;
        zzdkj zzdkjVar;
        zzaza.c("", zzcohVar);
        zzd.a("Failed to get a cache key, reverting to legacy flow.");
        agt agtVar = this.a;
        b = this.a.b();
        agtVar.e = new zzdkj(null, b, null);
        zzdkjVar = this.a.e;
        return zzdkjVar;
    }
}
