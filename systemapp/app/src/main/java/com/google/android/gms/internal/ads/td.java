package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class td<T> implements zzahv<Object> {
    private final WeakReference<T> a;
    private final String b;
    private final zzahv<T> c;
    private final /* synthetic */ zzcgh d;

    private td(zzcgh zzcghVar, WeakReference<T> weakReference, String str, zzahv<T> zzahvVar) {
        this.d = zzcghVar;
        this.a = weakReference;
        this.b = str;
        this.c = zzahvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahv
    public final void a(Object obj, Map<String, String> map) {
        T t = this.a.get();
        if (t == null) {
            this.d.b(this.b, this);
        } else {
            this.c.a(t, map);
        }
    }

    /* synthetic */ td(zzcgh zzcghVar, WeakReference weakReference, String str, zzahv zzahvVar, sx sxVar) {
        this(zzcghVar, weakReference, str, zzahvVar);
    }
}
