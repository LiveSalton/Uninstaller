package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdre {
    private final E a;
    private final /* synthetic */ zzdra b;

    /* JADX INFO: Access modifiers changed from: private */
    zzdre(zzdra zzdraVar, E e) {
        this.b = zzdraVar;
        this.a = e;
    }

    public final <O> zzdrg<O> a(zzdyz<O> zzdyzVar) {
        zzdyz zzdyzVar2;
        zzdra zzdraVar = this.b;
        E e = this.a;
        zzdyzVar2 = zzdra.a;
        return new zzdrg<>(zzdraVar, e, zzdyzVar2, Collections.emptyList(), zzdyzVar);
    }

    public final <O> zzdrg<O> a(Callable<O> callable) {
        zzdzc zzdzcVar;
        zzdzcVar = this.b.b;
        return a(callable, zzdzcVar);
    }

    private final <O> zzdrg<O> a(Callable<O> callable, zzdzc zzdzcVar) {
        zzdyz zzdyzVar;
        zzdra zzdraVar = this.b;
        E e = this.a;
        zzdyzVar = zzdra.a;
        return new zzdrg<>(zzdraVar, e, zzdyzVar, Collections.emptyList(), zzdzcVar.submit(callable));
    }

    public final zzdrg<?> a(zzdqy zzdqyVar, zzdzc zzdzcVar) {
        return a(new Callable(zzdqyVar) { // from class: com.google.android.gms.internal.ads.ajs
            private final zzdqy a;

            {
                this.a = zzdqyVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                this.a.a();
                return null;
            }
        }, zzdzcVar);
    }

    /* synthetic */ zzdre(zzdra zzdraVar, Object obj, ajp ajpVar) {
        this(zzdraVar, obj);
    }
}
