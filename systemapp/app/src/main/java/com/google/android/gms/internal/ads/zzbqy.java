package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbqy implements zzepf<zzbua> {
    private final zzeps<zzbua> a;

    private zzbqy(zzeps<zzbua> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzbqy a(zzeps<zzbua> zzepsVar) {
        return new zzbqy(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzbua) zzepl.a(this.a.b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
