package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
final class afn<AppOpenAd> implements zzdyo<AppOpenAd> {
    final /* synthetic */ zzdil a;
    private final /* synthetic */ zzcyn b;
    private final /* synthetic */ afp c;

    afn(zzdil zzdilVar, zzcyn zzcynVar, afp afpVar) {
        this.a = zzdilVar;
        this.b = zzcynVar;
        this.c = afpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Throwable th) {
        zzdkl zzdklVar;
        zzdir zzdirVar;
        zzbrd a;
        Executor executor;
        zzdklVar = this.a.e;
        zzblm zzblmVar = (zzblm) zzdklVar.a();
        zzve a2 = zzblmVar == null ? zzdoi.a(th, (zzcrg) null) : zzblmVar.c().a(th);
        synchronized (this.a) {
            zzdil.a(this.a, (zzdyz) null);
            if (zzblmVar != null) {
                zzblmVar.b().a_(a2);
                if (((Boolean) zzwq.e().a(zzabf.ep)).booleanValue()) {
                    executor = this.a.c;
                    executor.execute(new Runnable(this, a2) { // from class: com.google.android.gms.internal.ads.afq
                        private final afn a;
                        private final zzve b;

                        {
                            this.a = this;
                            this.b = a2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            zzdir zzdirVar2;
                            afn afnVar = this.a;
                            zzve zzveVar = this.b;
                            zzdirVar2 = afnVar.a.d;
                            zzdirVar2.a_(zzveVar);
                        }
                    });
                }
            } else {
                zzdirVar = this.a.d;
                zzdirVar.a_(a2);
                a = this.a.a(this.c);
                ((zzblm) a.b()).c().c().h_();
            }
            zzdob.a(a2.a, th, "AppOpenAdLoader.onFailure");
            this.b.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final /* synthetic */ void a(Object obj) {
        zzdir zzdirVar;
        zzboc zzbocVar = (zzboc) obj;
        synchronized (this.a) {
            zzdil.a(this.a, (zzdyz) null);
            if (((Boolean) zzwq.e().a(zzabf.ep)).booleanValue()) {
                zzbvn m = zzbocVar.m();
                zzdirVar = this.a.d;
                m.a(zzdirVar);
            }
            this.b.a(zzbocVar);
        }
    }
}
