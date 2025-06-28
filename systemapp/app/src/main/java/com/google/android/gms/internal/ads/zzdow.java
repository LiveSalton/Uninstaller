package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzf;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdow implements zzepf<zzf> {
    private final zzdot a;
    private final zzeps<zzdor> b;

    private zzdow(zzdot zzdotVar, zzeps<zzdor> zzepsVar) {
        this.a = zzdotVar;
        this.b = zzepsVar;
    }

    public static zzdow a(zzdot zzdotVar, zzeps<zzdor> zzepsVar) {
        return new zzdow(zzdotVar, zzepsVar);
    }

    public static zzf a(zzdot zzdotVar, zzdor zzdorVar) {
        return (zzf) zzepl.a(zzdorVar.b, "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a, this.b.b());
    }
}
