package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdcz implements zzepf<zzdcx> {
    private final zzeps<zzdzc> a;

    private zzdcz(zzeps<zzdzc> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzdcz a(zzeps<zzdzc> zzepsVar) {
        return new zzdcz(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdcx(this.a.b());
    }
}
