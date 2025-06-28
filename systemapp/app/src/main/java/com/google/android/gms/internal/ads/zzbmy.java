package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbmy implements zzepf<zzbxy<zzbvs>> {
    private final zzbmh a;
    private final zzeps<zzbua> b;

    public zzbmy(zzbmh zzbmhVar, zzeps<zzbua> zzepsVar) {
        this.a = zzbmhVar;
        this.b = zzepsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzbxy) zzepl.a(new zzbxy(new zzbvs(this.b.b()) { // from class: com.google.android.gms.internal.ads.lt
            private final zzbua a;

            {
                this.a = b;
            }

            @Override // com.google.android.gms.internal.ads.zzbvs
            public final void a() {
                this.a.c();
            }
        }, zzazj.f), "Cannot return null from a non-@Nullable @Provides method");
    }
}
