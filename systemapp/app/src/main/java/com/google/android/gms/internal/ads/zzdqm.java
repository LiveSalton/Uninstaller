package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdqm implements zzepf<zzdzc> {
    public static zzdqm a() {
        zzdqm zzdqmVar;
        zzdqmVar = ajk.a;
        return zzdqmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        zzdzc zzdzcVar;
        if (((Boolean) zzwq.e().a(zzabf.cT)).booleanValue()) {
            zzdzcVar = zzazj.c;
        } else {
            if (((Boolean) zzwq.e().a(zzabf.cS)).booleanValue()) {
                zzdzcVar = zzazj.a;
            } else {
                zzdzcVar = zzazj.e;
            }
        }
        return (zzdzc) zzepl.a(zzdzcVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
