package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdfa implements zzepf<zzdey> {
    private final zzeps<zzdkt> a;

    private zzdfa(zzeps<zzdkt> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzdfa a(zzeps<zzdkt> zzepsVar) {
        return new zzdfa(zzepsVar);
    }

    public static zzdey a(zzdkt zzdktVar) {
        return new zzdey(zzdktVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a.b());
    }
}
