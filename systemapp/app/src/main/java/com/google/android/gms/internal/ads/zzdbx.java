package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdbx implements zzepf<zzdbv> {
    private final zzeps<zzdjv> a;

    private zzdbx(zzeps<zzdjv> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzdbx a(zzeps<zzdjv> zzepsVar) {
        return new zzdbx(zzepsVar);
    }

    public static zzdbv a(zzdjv zzdjvVar) {
        return new zzdbv(zzdjvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a.b());
    }
}
