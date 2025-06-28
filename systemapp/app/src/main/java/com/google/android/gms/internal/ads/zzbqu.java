package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbqu implements zzbru, zzbsi, zzbvz, zzbxn {
    private final zzbsl a;
    private final zzdmu b;
    private final ScheduledExecutorService c;
    private final Executor d;
    private zzdzh<Boolean> e = zzdzh.h();
    private ScheduledFuture<?> f;

    public zzbqu(zzbsl zzbslVar, zzdmu zzdmuVar, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.a = zzbslVar;
        this.b = zzdmuVar;
        this.c = scheduledExecutorService;
        this.d = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void a(zzauf zzaufVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void d() {
    }

    @Override // com.google.android.gms.internal.ads.zzbxn
    public final void e() {
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void f() {
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void g() {
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void h() {
    }

    @Override // com.google.android.gms.internal.ads.zzbvz
    public final void i() {
    }

    @Override // com.google.android.gms.internal.ads.zzbru
    public final void c() {
        if (this.b.S == 0 || this.b.S == 1) {
            this.a.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxn
    public final void a() {
        if (((Boolean) zzwq.e().a(zzabf.aQ)).booleanValue() && this.b.S == 2) {
            if (this.b.p == 0) {
                this.a.a();
            } else {
                zzdyr.a(this.e, new mn(this), this.d);
                this.f = this.c.schedule(new Runnable(this) { // from class: com.google.android.gms.internal.ads.mm
                    private final zzbqu a;

                    {
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.j();
                    }
                }, this.b.p, TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsi
    public final synchronized void a(zzve zzveVar) {
        if (this.e.isDone()) {
            return;
        }
        if (this.f != null) {
            this.f.cancel(true);
        }
        this.e.a((Throwable) new Exception());
    }

    @Override // com.google.android.gms.internal.ads.zzbvz
    public final synchronized void i_() {
        if (this.e.isDone()) {
            return;
        }
        if (this.f != null) {
            this.f.cancel(true);
        }
        this.e.b((zzdzh<Boolean>) true);
    }

    final /* synthetic */ void j() {
        synchronized (this) {
            if (this.e.isDone()) {
                return;
            }
            this.e.b((zzdzh<Boolean>) true);
        }
    }
}
