package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class abl implements zzdyo<zzboc> {
    final /* synthetic */ zzcyp a;
    private final /* synthetic */ zzcyn b;
    private final /* synthetic */ zzcat c;

    abl(zzcyp zzcypVar, zzcyn zzcynVar, zzcat zzcatVar) {
        this.a = zzcypVar;
        this.b = zzcynVar;
        this.c = zzcatVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Throwable th) {
        zzbgm zzbgmVar;
        zzve a = this.c.a().a(th);
        this.c.b().a_(a);
        if (((Boolean) zzwq.e().a(zzabf.er)).booleanValue()) {
            zzbgmVar = this.a.b;
            zzbgmVar.a().execute(new Runnable(this, a) { // from class: com.google.android.gms.internal.ads.abm
                private final abl a;
                private final zzve b;

                {
                    this.a = this;
                    this.b = a;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzcyj zzcyjVar;
                    abl ablVar = this.a;
                    zzve zzveVar = this.b;
                    zzcyjVar = ablVar.a.d;
                    zzcyjVar.e().a_(zzveVar);
                }
            });
        }
        zzdob.a(a.a, th, "NativeAdLoader.onFailure");
        this.b.a();
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final /* synthetic */ void a(zzboc zzbocVar) {
        zzbgm zzbgmVar;
        zzcyj zzcyjVar;
        zzboc zzbocVar2 = zzbocVar;
        synchronized (this.a) {
            if (((Boolean) zzwq.e().a(zzabf.er)).booleanValue()) {
                zzbvn m = zzbocVar2.m();
                zzcyjVar = this.a.d;
                m.a(zzcyjVar.b());
            }
            this.b.a(zzbocVar2);
            if (((Boolean) zzwq.e().a(zzabf.er)).booleanValue()) {
                zzbgmVar = this.a.b;
                zzbgmVar.a().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.abk
                    private final abl a;

                    {
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcyj zzcyjVar2;
                        zzcyjVar2 = this.a.a.d;
                        zzcyjVar2.d().a();
                    }
                });
            }
        }
    }
}
