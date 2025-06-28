package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.internal.ads.zzbrg;
import com.google.android.gms.internal.ads.zzbwp;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdkv implements zzcyl<zzbyx> {
    private final Context a;
    private final Executor b;
    private final zzbgm c;
    private final zzcxq d;
    private final zzdlf e;
    private zzacb f;

    @GuardedBy("this")
    private final zzdnp g;

    @GuardedBy("this")
    private zzdyz<zzbyx> h;

    public zzdkv(Context context, Executor executor, zzbgm zzbgmVar, zzcxq zzcxqVar, zzdlf zzdlfVar, zzdnp zzdnpVar) {
        this.a = context;
        this.b = executor;
        this.c = zzbgmVar;
        this.d = zzcxqVar;
        this.g = zzdnpVar;
        this.e = zzdlfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcyl
    public final boolean a() {
        return (this.h == null || this.h.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcyl
    public final boolean a(zzvk zzvkVar, String str, zzcyo zzcyoVar, zzcyn<? super zzbyx> zzcynVar) throws RemoteException {
        zzvn zzvnVar;
        zzbzx b;
        if (str == null) {
            zzd.c("Ad unit ID should not be null for interstitial ad.");
            this.b.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.agw
                private final zzdkv a;

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
        if (a()) {
            return false;
        }
        if (zzcyoVar instanceof zzdks) {
            zzvnVar = ((zzdks) zzcyoVar).a;
        } else {
            zzvnVar = new zzvn();
        }
        zzdnn e = this.g.a(str).a(zzvnVar).a(zzvkVar).e();
        if (((Boolean) zzwq.e().a(zzabf.eq)).booleanValue()) {
            b = this.c.l().a(new zzbrg.zza().a(this.a).a(e).a()).a(new zzbwp.zza().a()).a(new zzcwq(this.f)).b();
        } else {
            zzbwp.zza zzaVar = new zzbwp.zza();
            if (this.e != null) {
                zzaVar.a((zzbru) this.e, this.b).a((zzbtj) this.e, this.b).a((zzbrz) this.e, this.b);
            }
            b = this.c.l().a(new zzbrg.zza().a(this.a).a(e).a()).a(zzaVar.a((zzbru) this.d, this.b).a((zzbtj) this.d, this.b).a((zzbrz) this.d, this.b).a((zzva) this.d, this.b).a((AppEventListener) this.d, this.b).a((zzbub) this.d, this.b).a()).a(new zzcwq(this.f)).b();
        }
        this.h = b.b().b();
        zzdyr.a(this.h, new agy(this, zzcynVar, b), this.b);
        return true;
    }

    public final void a(zzacb zzacbVar) {
        this.f = zzacbVar;
    }

    final /* synthetic */ void b() {
        this.d.a_(zzdoi.a(zzdok.INVALID_AD_UNIT_ID, null, null));
    }

    static /* synthetic */ zzdyz a(zzdkv zzdkvVar, zzdyz zzdyzVar) {
        zzdkvVar.h = null;
        return null;
    }
}
