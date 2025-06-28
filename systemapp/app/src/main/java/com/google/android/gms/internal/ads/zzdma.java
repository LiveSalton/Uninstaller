package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.internal.ads.zzbrg;
import com.google.android.gms.internal.ads.zzbwp;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdma implements zzcyl<zzchc> {
    private final Context a;
    private final Executor b;
    private final zzbgm c;
    private final zzdlf d;
    private final zzdkl<zzchf, zzchc> e;
    private final zzdni f;

    @GuardedBy("this")
    private final zzdnp g;

    @GuardedBy("this")
    private zzdyz<zzchc> h;

    public zzdma(Context context, Executor executor, zzbgm zzbgmVar, zzdkl<zzchf, zzchc> zzdklVar, zzdlf zzdlfVar, zzdnp zzdnpVar, zzdni zzdniVar) {
        this.a = context;
        this.b = executor;
        this.c = zzbgmVar;
        this.e = zzdklVar;
        this.d = zzdlfVar;
        this.g = zzdnpVar;
        this.f = zzdniVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcyl
    public final boolean a() {
        return (this.h == null || this.h.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcyl
    public final boolean a(zzvk zzvkVar, String str, zzcyo zzcyoVar, zzcyn<? super zzchc> zzcynVar) throws RemoteException {
        zzauv zzauvVar = new zzauv(zzvkVar, str);
        String str2 = zzcyoVar instanceof zzdmb ? ((zzdmb) zzcyoVar).a : null;
        if (zzauvVar.b == null) {
            zzd.c("Ad unit ID should not be null for rewarded video ad.");
            this.b.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.ahz
                private final zzdma a;

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
        if (this.h != null && !this.h.isDone()) {
            return false;
        }
        zzdob.a(this.a, zzauvVar.a.f);
        zzdnn e = this.g.a(zzauvVar.b).a(zzvn.b()).a(zzauvVar.a).e();
        aic aicVar = new aic(null);
        aicVar.a = e;
        aicVar.b = str2;
        this.h = this.e.a(new zzdkm(aicVar), new zzdkn(this) { // from class: com.google.android.gms.internal.ads.ahy
            private final zzdma a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdkn
            public final zzbrd a(zzdkk zzdkkVar) {
                return this.a.a(zzdkkVar);
            }
        });
        zzdyr.a(this.h, new aib(this, zzcynVar, aicVar), this.b);
        return true;
    }

    final void a(int i) {
        this.g.d().a(i);
    }

    /* renamed from: b */
    public final zzchi a(zzdkk zzdkkVar) {
        aic aicVar = (aic) zzdkkVar;
        if (((Boolean) zzwq.e().a(zzabf.eo)).booleanValue()) {
            return this.c.o().a(new zzbrg.zza().a(this.a).a(aicVar.a).a(aicVar.b).a(this.f).a()).a(new zzbwp.zza().a());
        }
        zzdlf a = zzdlf.a(this.d);
        return this.c.o().a(new zzbrg.zza().a(this.a).a(aicVar.a).a(aicVar.b).a(this.f).a()).a(new zzbwp.zza().a((zzbru) a, this.b).a((zzbtj) a, this.b).a((zzbrz) a, this.b).a((AdMetadataListener) a, this.b).a((zzbsi) a, this.b).a((zzbub) a, this.b).a(a).a());
    }

    final /* synthetic */ void b() {
        this.d.a_(zzdoi.a(zzdok.INVALID_AD_UNIT_ID, null, null));
    }
}
