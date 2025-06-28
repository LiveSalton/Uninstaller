package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzckn implements zzepf<zzcko> {
    private final zzeps<zzckv> a;
    private final zzeps<zzayq> b;

    private zzckn(zzeps<zzckv> zzepsVar, zzeps<zzayq> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzckn a(zzeps<zzckv> zzepsVar, zzeps<zzayq> zzepsVar2) {
        return new zzckn(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcko(this.a.b(), this.b.b());
    }
}
