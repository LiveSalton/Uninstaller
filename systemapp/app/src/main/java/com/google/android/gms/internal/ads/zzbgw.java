package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbgw implements zzepf<zzazh> {
    private final zzbgl a;

    public zzbgw(zzbgl zzbglVar) {
        this.a = zzbglVar;
    }

    public static zzazh a(zzbgl zzbglVar) {
        return (zzazh) zzepl.a(zzbglVar.c(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a);
    }
}
