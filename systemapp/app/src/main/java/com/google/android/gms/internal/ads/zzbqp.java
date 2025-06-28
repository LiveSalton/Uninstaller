package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbqp implements zzepf<zzbxy<zzbui>> {
    private final zzbqq a;
    private final zzeps<zzbqo> b;

    private zzbqp(zzbqq zzbqqVar, zzeps<zzbqo> zzepsVar) {
        this.a = zzbqqVar;
        this.b = zzepsVar;
    }

    public static zzbqp a(zzbqq zzbqqVar, zzeps<zzbqo> zzepsVar) {
        return new zzbqp(zzbqqVar, zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzbxy) zzepl.a(new zzbxy(this.b.b(), zzazj.f), "Cannot return null from a non-@Nullable @Provides method");
    }
}
