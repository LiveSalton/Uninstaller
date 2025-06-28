package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbip implements zzepf<zzamy> {
    private final zzbim a;

    public zzbip(zzbim zzbimVar) {
        this.a = zzbimVar;
    }

    public static zzamy a(zzbim zzbimVar) {
        return (zzamy) zzepl.a(zzbimVar.d(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a);
    }
}
