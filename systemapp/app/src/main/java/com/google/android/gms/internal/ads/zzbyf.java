package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbyf implements zzepf<zzbyg> {
    private final zzeps<zzdmu> a;
    private final zzeps<zzdrz> b;

    private zzbyf(zzeps<zzdmu> zzepsVar, zzeps<zzdrz> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzbyf a(zzeps<zzdmu> zzepsVar, zzeps<zzdrz> zzepsVar2) {
        return new zzbyf(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbyg(this.a.b(), this.b.b());
    }
}
