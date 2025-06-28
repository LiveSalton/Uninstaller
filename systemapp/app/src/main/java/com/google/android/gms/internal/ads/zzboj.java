package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzboj {
    private final Executor a;
    private final ScheduledExecutorService b;
    private final zzdyz<zzboi> c;
    private volatile boolean d = true;

    public zzboj(Executor executor, ScheduledExecutorService scheduledExecutorService, zzdyz<zzboi> zzdyzVar) {
        this.a = executor;
        this.b = scheduledExecutorService;
        this.c = zzdyzVar;
    }

    public final void a(zzdyo<zzboc> zzdyoVar) {
        zzdyr.a(this.c, new mg(this, zzdyoVar), this.a);
    }

    public final void a(List<? extends zzdyz<? extends zzboc>> list, zzdyo<zzboc> zzdyoVar) {
        if (list == null || list.isEmpty()) {
            this.a.execute(new Runnable(zzdyoVar) { // from class: com.google.android.gms.internal.ads.mc
                private final zzdyo a;

                {
                    this.a = zzdyoVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a((Throwable) new zzcme(zzdok.NO_FILL));
                }
            });
            return;
        }
        zzdyz a = zzdyr.a((Object) null);
        Iterator<? extends zzdyz<? extends zzboc>> it = list.iterator();
        while (it.hasNext()) {
            a = zzdyr.a(zzdyr.a(a, Throwable.class, new zzdyb(zzdyoVar) { // from class: com.google.android.gms.internal.ads.mb
                private final zzdyo a;

                {
                    this.a = zzdyoVar;
                }

                @Override // com.google.android.gms.internal.ads.zzdyb
                public final zzdyz a(Object obj) {
                    this.a.a((Throwable) obj);
                    return zzdyr.a((Object) null);
                }
            }, this.a), new zzdyb(this, zzdyoVar, it.next()) { // from class: com.google.android.gms.internal.ads.me
                private final zzboj a;
                private final zzdyo b;
                private final zzdyz c;

                {
                    this.a = this;
                    this.b = zzdyoVar;
                    this.c = zzdyzVar;
                }

                @Override // com.google.android.gms.internal.ads.zzdyb
                public final zzdyz a(Object obj) {
                    return this.a.a(this.b, this.c, (zzboc) obj);
                }
            }, this.a);
        }
        zzdyr.a(a, new mf(this, zzdyoVar), this.a);
    }

    public final boolean a() {
        return this.d;
    }

    public final void c() {
        zzazj.e.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.md
            private final zzboj a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.b();
            }
        });
    }

    final /* synthetic */ void b() {
        this.d = false;
    }

    final /* synthetic */ zzdyz a(zzdyo zzdyoVar, zzdyz zzdyzVar, zzboc zzbocVar) throws Exception {
        if (zzbocVar != null) {
            zzdyoVar.a((zzdyo) zzbocVar);
        }
        return zzdyr.a(zzdyzVar, zzadk.a.a().longValue(), TimeUnit.MILLISECONDS, this.b);
    }
}
