package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbmo implements zzepf<zzdmx> {
    private final zzbmh a;

    public zzbmo(zzbmh zzbmhVar) {
        this.a = zzbmhVar;
    }

    public static zzdmx a(zzbmh zzbmhVar) {
        return (zzdmx) zzepl.a(zzbmhVar.d(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a);
    }
}
