package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzboy implements zzepf<zzbov> {
    private final zzeps<zzbsu> a;

    private zzboy(zzeps<zzbsu> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzboy a(zzeps<zzbsu> zzepsVar) {
        return new zzboy(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbov(this.a.b());
    }
}
