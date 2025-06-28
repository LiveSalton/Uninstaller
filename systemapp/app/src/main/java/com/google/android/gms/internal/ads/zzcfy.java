package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcfy implements zzepf<zzcft> {
    private final zzeps<zzcbt> a;
    private final zzeps<zzcce> b;

    private zzcfy(zzeps<zzcbt> zzepsVar, zzeps<zzcce> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzcfy a(zzeps<zzcbt> zzepsVar, zzeps<zzcce> zzepsVar2) {
        return new zzcfy(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcft(this.a.b(), this.b.b());
    }
}
