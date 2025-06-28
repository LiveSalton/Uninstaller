package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdrg<O> {
    final /* synthetic */ zzdra a;
    private final E b;
    private final String c;
    private final zzdyz<?> d;
    private final List<zzdyz<?>> e;
    private final zzdyz<O> f;

    /* JADX INFO: Access modifiers changed from: private */
    zzdrg(zzdra zzdraVar, E e, String str, zzdyz<?> zzdyzVar, List<zzdyz<?>> list, zzdyz<O> zzdyzVar2) {
        this.a = zzdraVar;
        this.b = e;
        this.c = str;
        this.d = zzdyzVar;
        this.e = list;
        this.f = zzdyzVar2;
    }

    public final zzdrg<O> a(String str) {
        return new zzdrg<>(this.a, this.b, str, this.d, this.e, this.f);
    }

    public final <O2> zzdrg<O2> a(zzdqv<O, O2> zzdqvVar) {
        return a((zzdyb) new zzdyb(zzdqvVar) { // from class: com.google.android.gms.internal.ads.ajt
            private final zzdqv a;

            {
                this.a = zzdqvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return zzdyr.a(this.a.a(obj));
            }
        });
    }

    public final <O2> zzdrg<O2> a(zzdyb<O, O2> zzdybVar) {
        zzdzc zzdzcVar;
        zzdzcVar = this.a.b;
        return a(zzdybVar, zzdzcVar);
    }

    private final <O2> zzdrg<O2> a(zzdyb<O, O2> zzdybVar, Executor executor) {
        return new zzdrg<>(this.a, this.b, this.c, this.d, this.e, zzdyr.a(this.f, zzdybVar, executor));
    }

    public final <O2> zzdrg<O2> a(zzdyz<O2> zzdyzVar) {
        return a(new zzdyb(zzdyzVar) { // from class: com.google.android.gms.internal.ads.ajv
            private final zzdyz a;

            {
                this.a = zzdyzVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return this.a;
            }
        }, zzazj.f);
    }

    public final <T extends Throwable> zzdrg<O> a(Class<T> cls, zzdqv<T, O> zzdqvVar) {
        return a(cls, new zzdyb(zzdqvVar) { // from class: com.google.android.gms.internal.ads.aju
            private final zzdqv a;

            {
                this.a = zzdqvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return zzdyr.a(this.a.a((Throwable) obj));
            }
        });
    }

    public final <T extends Throwable> zzdrg<O> a(Class<T> cls, zzdyb<T, O> zzdybVar) {
        zzdzc zzdzcVar;
        zzdra zzdraVar = this.a;
        E e = this.b;
        String str = this.c;
        zzdyz<?> zzdyzVar = this.d;
        List<zzdyz<?>> list = this.e;
        zzdyz<O> zzdyzVar2 = this.f;
        zzdzcVar = this.a.b;
        return new zzdrg<>(zzdraVar, e, str, zzdyzVar, list, zzdyr.a(zzdyzVar2, cls, zzdybVar, zzdzcVar));
    }

    public final zzdrg<O> a(long j, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService;
        zzdra zzdraVar = this.a;
        E e = this.b;
        String str = this.c;
        zzdyz<?> zzdyzVar = this.d;
        List<zzdyz<?>> list = this.e;
        zzdyz<O> zzdyzVar2 = this.f;
        scheduledExecutorService = this.a.c;
        return new zzdrg<>(zzdraVar, e, str, zzdyzVar, list, zzdyr.a(zzdyzVar2, j, timeUnit, scheduledExecutorService));
    }

    public final zzdqx<E, O> a() {
        zzdrm zzdrmVar;
        zzdqx<E, O> zzdqxVar = new zzdqx<>(this.b, this.c == null ? this.a.b((zzdra) this.b) : this.c, this.f);
        zzdrmVar = this.a.d;
        zzdrmVar.a(zzdqxVar);
        this.d.a(new Runnable(this, zzdqxVar) { // from class: com.google.android.gms.internal.ads.ajx
            private final zzdrg a;
            private final zzdqx b;

            {
                this.a = this;
                this.b = zzdqxVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzdrm zzdrmVar2;
                zzdrg zzdrgVar = this.a;
                zzdqx zzdqxVar2 = this.b;
                zzdrmVar2 = zzdrgVar.a.d;
                zzdrmVar2.b(zzdqxVar2);
            }
        }, zzazj.f);
        zzdyr.a(zzdqxVar, new ajw(this, zzdqxVar), zzazj.f);
        return zzdqxVar;
    }

    public final zzdrg<O> a(E e) {
        return this.a.a((zzdra) e, (zzdyz) a());
    }

    /* synthetic */ zzdrg(zzdra zzdraVar, Object obj, String str, zzdyz zzdyzVar, List list, zzdyz zzdyzVar2, ajp ajpVar) {
        this(zzdraVar, obj, null, zzdyzVar, list, zzdyzVar2);
    }
}
