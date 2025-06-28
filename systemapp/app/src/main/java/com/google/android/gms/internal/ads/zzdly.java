package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdly implements zzepf<zzdlf> {
    private final zzeps<zzdpa> a;

    private zzdly(zzeps<zzdpa> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzdly a(zzeps<zzdpa> zzepsVar) {
        return new zzdly(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdlf(this.a.b());
    }
}
