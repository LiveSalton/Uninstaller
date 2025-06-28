package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbmn implements zzepf<zzbnz> {
    private final zzbmh a;

    public zzbmn(zzbmh zzbmhVar) {
        this.a = zzbmhVar;
    }

    public static zzbnz a(zzbmh zzbmhVar) {
        return (zzbnz) zzepl.a(zzbmhVar.c(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a);
    }
}
