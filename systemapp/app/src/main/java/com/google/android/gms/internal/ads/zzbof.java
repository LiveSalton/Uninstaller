package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbof<AdT> implements zzepf<zzbog<AdT>> {
    private final zzeps<Map<String, zzcqz<AdT>>> a;

    private zzbof(zzeps<Map<String, zzcqz<AdT>>> zzepsVar) {
        this.a = zzepsVar;
    }

    public static <AdT> zzbof<AdT> a(zzeps<Map<String, zzcqz<AdT>>> zzepsVar) {
        return new zzbof<>(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbog(this.a.b());
    }
}
