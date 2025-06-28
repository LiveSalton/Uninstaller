package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcpw implements zzepf<zzcpr> {
    private final zzeps<zzcpp> a;
    private final zzeps<zzdzc> b;

    private zzcpw(zzeps<zzcpp> zzepsVar, zzeps<zzdzc> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzcpw a(zzeps<zzcpp> zzepsVar, zzeps<zzdzc> zzepsVar2) {
        return new zzcpw(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcpr(this.a.b(), this.b.b());
    }
}
