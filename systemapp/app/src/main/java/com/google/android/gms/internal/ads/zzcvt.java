package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcvt implements zzepf<zzcvu> {
    private final zzeps<zzcwx> a;

    private zzcvt(zzeps<zzcwx> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzcvt a(zzeps<zzcwx> zzepsVar) {
        return new zzcvt(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcvu(this.a.b());
    }
}
