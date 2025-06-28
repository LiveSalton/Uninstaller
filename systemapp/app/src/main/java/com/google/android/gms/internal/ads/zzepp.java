package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzepp<T> implements zzeps<T> {
    private static final Object a = new Object();
    private volatile zzeps<T> b;
    private volatile Object c = a;

    private zzepp(zzeps<T> zzepsVar) {
        this.b = zzepsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final T b() {
        T t = (T) this.c;
        if (t != a) {
            return t;
        }
        zzeps<T> zzepsVar = this.b;
        if (zzepsVar == null) {
            return (T) this.c;
        }
        T b = zzepsVar.b();
        this.c = b;
        this.b = null;
        return b;
    }

    public static <P extends zzeps<T>, T> zzeps<T> a(P p) {
        return ((p instanceof zzepp) || (p instanceof zzepg)) ? p : new zzepp((zzeps) zzepl.a(p));
    }
}
