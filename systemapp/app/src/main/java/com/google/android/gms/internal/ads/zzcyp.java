package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzbrg;
import com.google.android.gms.internal.ads.zzbwp;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcyp implements zzcyl<zzboc> {

    @GuardedBy("this")
    private final zzdnp a;
    private final zzbgm b;
    private final Context c;
    private final zzcyj d;

    @GuardedBy("this")
    private zzboj e;

    public zzcyp(zzbgm zzbgmVar, Context context, zzcyj zzcyjVar, zzdnp zzdnpVar) {
        this.b = zzbgmVar;
        this.c = context;
        this.d = zzcyjVar;
        this.a = zzdnpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcyl
    public final boolean a() {
        return this.e != null && this.e.a();
    }

    @Override // com.google.android.gms.internal.ads.zzcyl
    public final boolean a(zzvk zzvkVar, String str, zzcyo zzcyoVar, zzcyn<? super zzboc> zzcynVar) throws RemoteException {
        zzcat b;
        zzp.c();
        if (com.google.android.gms.ads.internal.util.zzm.o(this.c) && zzvkVar.s == null) {
            zzd.c("Failed to load the ad because app ID is missing.");
            this.b.a().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.abj
                private final zzcyp a;

                {
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.c();
                }
            });
            return false;
        }
        if (str == null) {
            zzd.c("Ad unit ID should not be null for NativeAdLoader.");
            this.b.a().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.abi
                private final zzcyp a;

                {
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.b();
                }
            });
            return false;
        }
        zzdob.a(this.c, zzvkVar.f);
        zzdnn e = this.a.a(zzvkVar).a(zzcyoVar instanceof zzcyq ? ((zzcyq) zzcyoVar).a : 1).e();
        if (((Boolean) zzwq.e().a(zzabf.er)).booleanValue()) {
            b = this.b.n().a(new zzbrg.zza().a(this.c).a(e).a()).a(new zzbwp.zza().a()).a(this.d.a()).a(new zzblz(null)).b();
        } else {
            b = this.b.n().a(new zzbrg.zza().a(this.c).a(e).a()).a(new zzbwp.zza().a(this.d.d(), this.b.a()).a(this.d.e(), this.b.a()).a(this.d.f(), this.b.a()).a(this.d.g(), this.b.a()).a(this.d.c(), this.b.a()).a(e.m, this.b.a()).a()).a(this.d.a()).a(new zzblz(null)).b();
        }
        this.b.t().a(1);
        this.e = new zzboj(this.b.c(), this.b.b(), b.a().b());
        this.e.a(new abl(this, zzcynVar, b));
        return true;
    }

    final /* synthetic */ void b() {
        this.d.e().a_(zzdoi.a(zzdok.INVALID_AD_UNIT_ID, null, null));
    }

    final /* synthetic */ void c() {
        this.d.e().a_(zzdoi.a(zzdok.APP_ID_MISSING, null, null));
    }
}
