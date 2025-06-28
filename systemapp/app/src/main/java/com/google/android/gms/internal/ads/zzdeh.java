package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdeh implements zzepf<zzdee> {
    private final zzeps<String> a;

    private zzdeh(zzeps<String> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzdeh a(zzeps<String> zzepsVar) {
        return new zzdeh(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdee(this.a.b());
    }
}
