package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbou implements zzepf<String> {
    private final zzbos a;

    private zzbou(zzbos zzbosVar) {
        this.a = zzbosVar;
    }

    public static zzbou a(zzbos zzbosVar) {
        return new zzbou(zzbosVar);
    }

    public static String b(zzbos zzbosVar) {
        return (String) zzepl.a(zzbosVar.d(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return b(this.a);
    }
}
