package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzblm;
import com.google.android.gms.internal.ads.zzboc;
import com.google.android.gms.internal.ads.zzbrd;
import com.google.android.gms.internal.ads.zzbrg;
import com.google.android.gms.internal.ads.zzbwp;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzdil<AppOpenAd extends zzboc, AppOpenRequestComponent extends zzblm<AppOpenAd>, AppOpenRequestComponentBuilder extends zzbrd<AppOpenRequestComponent>> implements zzcyl<AppOpenAd> {
    protected final zzbgm a;
    private final Context b;
    private final Executor c;
    private final zzdir d;
    private final zzdkl<AppOpenRequestComponent, AppOpenAd> e;
    private final ViewGroup f;

    @GuardedBy("this")
    private final zzdnp g;

    @GuardedBy("this")
    @Nullable
    private zzdyz<AppOpenAd> h;

    protected zzdil(Context context, Executor executor, zzbgm zzbgmVar, zzdkl<AppOpenRequestComponent, AppOpenAd> zzdklVar, zzdir zzdirVar, zzdnp zzdnpVar) {
        this.b = context;
        this.c = executor;
        this.a = zzbgmVar;
        this.e = zzdklVar;
        this.d = zzdirVar;
        this.g = zzdnpVar;
        this.f = new FrameLayout(context);
    }

    protected abstract AppOpenRequestComponentBuilder a(zzblz zzblzVar, zzbrg zzbrgVar, zzbwp zzbwpVar);

    @Override // com.google.android.gms.internal.ads.zzcyl
    public final boolean a() {
        return (this.h == null || this.h.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcyl
    public final synchronized boolean a(zzvk zzvkVar, String str, zzcyo zzcyoVar, zzcyn<? super AppOpenAd> zzcynVar) throws RemoteException {
        Preconditions.b("loadAd must be called on the main UI thread.");
        if (str == null) {
            zzd.c("Ad unit ID should not be null for app open ad.");
            this.c.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.afm
                private final zzdil a;

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
        if (this.h != null) {
            return false;
        }
        zzdob.a(this.b, zzvkVar.f);
        zzdnn e = this.g.a(str).a(zzvn.c()).a(zzvkVar).e();
        afp afpVar = new afp(null);
        afpVar.a = e;
        this.h = this.e.a(new zzdkm(afpVar), new zzdkn(this) { // from class: com.google.android.gms.internal.ads.afo
            private final zzdil a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdkn
            public final zzbrd a(zzdkk zzdkkVar) {
                return this.a.a(zzdkkVar);
            }
        });
        zzdyr.a(this.h, new afn(this, zzcynVar, afpVar), this.c);
        return true;
    }

    /* renamed from: b */
    public final synchronized AppOpenRequestComponentBuilder a(zzdkk zzdkkVar) {
        afp afpVar = (afp) zzdkkVar;
        if (((Boolean) zzwq.e().a(zzabf.ep)).booleanValue()) {
            return a(new zzblz(this.f), new zzbrg.zza().a(this.b).a(afpVar.a).a(), new zzbwp.zza().a());
        }
        zzdir a = zzdir.a(this.d);
        zzbwp.zza zzaVar = new zzbwp.zza();
        zzaVar.a((zzbrz) a, this.c);
        zzaVar.a((zzbto) a, this.c);
        zzaVar.a((zzp) a, this.c);
        zzaVar.a(a);
        return a(new zzblz(this.f), new zzbrg.zza().a(this.b).a(afpVar.a).a(), zzaVar.a());
    }

    public final void a(zzvw zzvwVar) {
        this.g.a(zzvwVar);
    }

    final /* synthetic */ void b() {
        this.d.a_(zzdoi.a(zzdok.INVALID_AD_UNIT_ID, null, null));
    }

    static /* synthetic */ zzdyz a(zzdil zzdilVar, zzdyz zzdyzVar) {
        zzdilVar.h = null;
        return null;
    }
}
