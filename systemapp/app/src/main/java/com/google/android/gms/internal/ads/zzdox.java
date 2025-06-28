package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdox implements zzepf<zzayq> {
    private final zzdot a;
    private final zzeps<zzdor> b;

    private zzdox(zzdot zzdotVar, zzeps<zzdor> zzepsVar) {
        this.a = zzdotVar;
        this.b = zzepsVar;
    }

    public static zzdox a(zzdot zzdotVar, zzeps<zzdor> zzepsVar) {
        return new zzdox(zzdotVar, zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzayq) zzepl.a(this.b.b().c, "Cannot return null from a non-@Nullable @Provides method");
    }
}
