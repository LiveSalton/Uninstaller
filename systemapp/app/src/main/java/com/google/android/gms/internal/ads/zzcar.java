package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcar implements zzepf<zzcap> {
    private final zzcap a;

    private zzcar(zzcap zzcapVar) {
        this.a = zzcapVar;
    }

    public static zzcar a(zzcap zzcapVar) {
        return new zzcar(zzcapVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        zzcap zzcapVar = this.a;
        if (zzcapVar == null) {
            throw null;
        }
        return (zzcap) zzepl.a(zzcapVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
