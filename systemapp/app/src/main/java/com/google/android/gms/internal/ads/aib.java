package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
final class aib implements zzdyo<zzchc> {
    final /* synthetic */ zzdma a;
    private final /* synthetic */ zzcyn b;
    private final /* synthetic */ aic c;

    aib(zzdma zzdmaVar, zzcyn zzcynVar, aic aicVar) {
        this.a = zzdmaVar;
        this.b = zzcynVar;
        this.c = aicVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Throwable th) {
        zzdkl zzdklVar;
        zzdlf zzdlfVar;
        zzchi a;
        Executor executor;
        zzdklVar = this.a.e;
        zzchf zzchfVar = (zzchf) zzdklVar.a();
        zzve a2 = zzchfVar == null ? zzdoi.a(th, (zzcrg) null) : zzchfVar.c().a(th);
        synchronized (this.a) {
            try {
                if (zzchfVar != null) {
                    zzchfVar.b().a_(a2);
                    if (((Boolean) zzwq.e().a(zzabf.eo)).booleanValue()) {
                        executor = this.a.b;
                        executor.execute(new Runnable(this, a2) { // from class: com.google.android.gms.internal.ads.aid
                            private final aib a;
                            private final zzve b;

                            {
                                this.a = this;
                                this.b = a2;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                zzdlf zzdlfVar2;
                                aib aibVar = this.a;
                                zzve zzveVar = this.b;
                                zzdlfVar2 = aibVar.a.d;
                                zzdlfVar2.a_(zzveVar);
                            }
                        });
                    }
                } else {
                    zzdlfVar = this.a.d;
                    zzdlfVar.a_(a2);
                    a = this.a.a(this.c);
                    a.b().c().c().h_();
                }
                zzdob.a(a2.a, th, "RewardedAdLoader.onFailure");
                this.b.a();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final /* synthetic */ void a(zzchc zzchcVar) {
        zzdlf zzdlfVar;
        Executor executor;
        zzdlf zzdlfVar2;
        zzchc zzchcVar2 = zzchcVar;
        synchronized (this.a) {
            if (((Boolean) zzwq.e().a(zzabf.eo)).booleanValue()) {
                zzbvn m = zzchcVar2.m();
                zzdlfVar2 = this.a.d;
                m.a(zzdlfVar2);
            }
            this.b.a(zzchcVar2);
            if (((Boolean) zzwq.e().a(zzabf.eo)).booleanValue()) {
                executor = this.a.b;
                executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.aia
                    private final aib a;

                    {
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzdlf zzdlfVar3;
                        zzdlfVar3 = this.a.a.d;
                        zzdlfVar3.a();
                    }
                });
            }
            zzdlfVar = this.a.d;
            zzdlfVar.k_();
        }
    }
}
