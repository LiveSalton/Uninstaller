package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzddh implements zzepf<zzddf> {
    private final zzeps<zzdzc> a;

    private zzddh(zzeps<zzdzc> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzddh a(zzeps<zzdzc> zzepsVar) {
        return new zzddh(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzddf(this.a.b());
    }
}
