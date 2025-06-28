package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzckf implements zzepf<zzckg> {
    private final zzeps<zzcko> a;
    private final zzeps<zzckv> b;

    private zzckf(zzeps<zzcko> zzepsVar, zzeps<zzckv> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzckf a(zzeps<zzcko> zzepsVar, zzeps<zzckv> zzepsVar2) {
        return new zzckf(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzckg(this.a.b(), this.b.b());
    }
}
