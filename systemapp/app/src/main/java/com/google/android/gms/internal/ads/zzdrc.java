package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdrc {
    private final E a;
    private final List<zzdyz<?>> b;
    private final /* synthetic */ zzdra c;

    /* JADX INFO: Access modifiers changed from: private */
    zzdrc(zzdra zzdraVar, E e, List<zzdyz<?>> list) {
        this.c = zzdraVar;
        this.a = e;
        this.b = list;
    }

    public final <O> zzdrg<O> a(Callable<O> callable) {
        zzdzc zzdzcVar;
        zzdys c = zzdyr.c(this.b);
        zzdyz a = c.a(ajr.a, zzazj.f);
        zzdra zzdraVar = this.c;
        E e = this.a;
        List<zzdyz<?>> list = this.b;
        zzdzcVar = this.c.b;
        return new zzdrg<>(zzdraVar, e, a, list, c.a(callable, zzdzcVar));
    }

    /* synthetic */ zzdrc(zzdra zzdraVar, Object obj, List list, ajp ajpVar) {
        this(zzdraVar, obj, list);
    }
}
