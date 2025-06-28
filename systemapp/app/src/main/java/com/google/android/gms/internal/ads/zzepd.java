package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzepd<T> implements zzepf<T> {
    private zzeps<T> a;

    @Override // com.google.android.gms.internal.ads.zzeps
    public final T b() {
        if (this.a == null) {
            throw new IllegalStateException();
        }
        return this.a.b();
    }

    public static <T> void a(zzeps<T> zzepsVar, zzeps<T> zzepsVar2) {
        zzepl.a(zzepsVar2);
        zzepd zzepdVar = (zzepd) zzepsVar;
        if (zzepdVar.a != null) {
            throw new IllegalStateException();
        }
        zzepdVar.a = zzepsVar2;
    }
}
