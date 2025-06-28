package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzepg<T> implements zzeoz<T>, zzeps<T> {
    private static final Object a = new Object();
    private volatile zzeps<T> b;
    private volatile Object c = a;

    private zzepg(zzeps<T> zzepsVar) {
        this.b = zzepsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeoz, com.google.android.gms.internal.ads.zzeps
    public final T b() {
        T t = (T) this.c;
        if (t == a) {
            synchronized (this) {
                t = (T) this.c;
                if (t == a) {
                    t = this.b.b();
                    Object obj = this.c;
                    if (((obj == a || (obj instanceof zzepm)) ? false : true) && obj != t) {
                        String valueOf = String.valueOf(obj);
                        String valueOf2 = String.valueOf(t);
                        StringBuilder sb = new StringBuilder(118 + String.valueOf(valueOf).length() + String.valueOf(valueOf2).length());
                        sb.append("Scoped provider was invoked recursively returning different results: ");
                        sb.append(valueOf);
                        sb.append(" & ");
                        sb.append(valueOf2);
                        sb.append(". This is likely due to a circular dependency.");
                        throw new IllegalStateException(sb.toString());
                    }
                    this.c = t;
                    this.b = null;
                }
            }
        }
        return t;
    }

    public static <P extends zzeps<T>, T> zzeps<T> a(P p) {
        zzepl.a(p);
        return p instanceof zzepg ? p : new zzepg(p);
    }

    public static <P extends zzeps<T>, T> zzeoz<T> b(P p) {
        if (p instanceof zzeoz) {
            return (zzeoz) p;
        }
        return new zzepg((zzeps) zzepl.a(p));
    }
}
