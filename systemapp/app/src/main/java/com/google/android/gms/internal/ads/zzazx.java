package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: source */
@Deprecated
/* loaded from: classes.dex */
public class zzazx<T> {
    private final zzazq<T> a = new zzazq<>();
    private final AtomicInteger b = new AtomicInteger(0);

    public zzazx() {
        zzdyr.a(this.a, new ft(this), zzazj.f);
    }

    @Deprecated
    public final void a(zzazu<T> zzazuVar, zzazs zzazsVar) {
        zzdyr.a(this.a, new fu(this, zzazuVar, zzazsVar), zzazj.f);
    }

    @Deprecated
    public final void a(T t) {
        this.a.b(t);
    }

    @Deprecated
    public final void d() {
        this.a.a(new Exception());
    }

    @Deprecated
    public final int e() {
        return this.b.get();
    }
}
