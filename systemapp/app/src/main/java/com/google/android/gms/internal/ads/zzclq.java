package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzclq implements zzepf<zzcln> {
    private final zzeps<zzclb> a;
    private final zzeps<zzbgm> b;

    private zzclq(zzeps<zzclb> zzepsVar, zzeps<zzbgm> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzclq a(zzeps<zzclb> zzepsVar, zzeps<zzbgm> zzepsVar2) {
        return new zzclq(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcln(this.a.b(), this.b.b());
    }
}
