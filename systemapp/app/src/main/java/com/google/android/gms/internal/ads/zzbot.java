package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbot implements zzepf<zzdmz> {
    private final zzbos a;

    private zzbot(zzbos zzbosVar) {
        this.a = zzbosVar;
    }

    public static zzbot a(zzbos zzbosVar) {
        return new zzbot(zzbosVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzdmz) zzepl.a(this.a.c(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
