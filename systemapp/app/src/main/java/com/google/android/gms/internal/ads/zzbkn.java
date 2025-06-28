package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbkn implements zzepf<zzamq> {
    private final zzeps<zzaml> a;

    private zzbkn(zzeps<zzaml> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzbkn a(zzeps<zzaml> zzepsVar) {
        return new zzbkn(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzamq) zzepl.a(this.a.b().a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
