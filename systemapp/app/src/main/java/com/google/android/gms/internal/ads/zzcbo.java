package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcbo implements zzepf<zzcgh> {
    private final zzcbh a;

    public zzcbo(zzcbh zzcbhVar) {
        this.a = zzcbhVar;
    }

    public static zzcgh a(zzcbh zzcbhVar) {
        return (zzcgh) zzepl.a(zzcbhVar.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a);
    }
}
