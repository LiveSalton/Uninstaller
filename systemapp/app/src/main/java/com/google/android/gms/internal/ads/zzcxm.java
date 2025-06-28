package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbrg;
import com.google.android.gms.internal.ads.zzbwp;
import java.util.Collections;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcxm extends zzxf implements zzbue {
    private final zzbgm a;
    private final Context b;
    private final ViewGroup c;
    private final zzbua f;
    private zzvn g;

    @GuardedBy("this")
    private zzacb i;

    @GuardedBy("this")
    private zzbme j;

    @GuardedBy("this")
    private zzdyz<zzbme> k;
    private final zzcxq d = new zzcxq();
    private final zzcyd e = new zzcyd();

    @GuardedBy("this")
    private final zzdnp h = new zzdnp();

    public zzcxm(zzbgm zzbgmVar, Context context, zzvn zzvnVar, String str) {
        this.c = new FrameLayout(context);
        this.a = zzbgmVar;
        this.b = context;
        this.h.a(zzvnVar).a(str);
        this.f = zzbgmVar.e();
        this.f.a(this, this.a.a());
        this.g = zzvnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzart zzartVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzarz zzarzVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzaup zzaupVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzsl zzslVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzvw zzvwVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzyy zzyyVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void b(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void b(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final boolean c() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void g() {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void h() {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final IObjectWrapper a() {
        Preconditions.b("destroy must be called on the main UI thread.");
        return ObjectWrapper.a(this.c);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized boolean a(zzvk zzvkVar) {
        b(this.g);
        return b(zzvkVar);
    }

    private final synchronized void b(zzvn zzvnVar) {
        this.h.a(zzvnVar);
        this.h.a(this.g.m);
    }

    private final synchronized boolean b(zzvk zzvkVar) {
        Preconditions.b("loadAd must be called on the main UI thread.");
        zzp.c();
        if (com.google.android.gms.ads.internal.util.zzm.o(this.b) && zzvkVar.s == null) {
            zzd.c("Failed to load the ad because app ID is missing.");
            if (this.d != null) {
                this.d.a_(zzdoi.a(zzdok.APP_ID_MISSING, null, null));
            }
            return false;
        }
        if (this.k != null) {
            return false;
        }
        zzdob.a(this.b, zzvkVar.f);
        zzdnn e = this.h.a(zzvkVar).e();
        if (zzadc.b.a().booleanValue() && this.h.b().k && this.d != null) {
            this.d.a_(zzdoi.a(zzdok.INVALID_AD_SIZE, null, null));
            return false;
        }
        zzbna a = a(e);
        this.k = a.b().b();
        zzdyr.a(this.k, new aaq(this, a), this.a.a());
        return true;
    }

    private final synchronized zzbna a(zzdnn zzdnnVar) {
        if (((Boolean) zzwq.e().a(zzabf.en)).booleanValue()) {
            return this.a.h().a(new zzbrg.zza().a(this.b).a(zzdnnVar).a()).a(new zzbwp.zza().a()).a(new zzcwq(this.i)).a(new zzcap(zzccl.a, null)).a(new zzbnv(this.f)).a(new zzblz(this.c)).b();
        }
        return this.a.h().a(new zzbrg.zza().a(this.b).a(zzdnnVar).a()).a(new zzbwp.zza().a((zzva) this.d, this.a.a()).a(this.e, this.a.a()).a((zzbsm) this.d, this.a.a()).a((zzbru) this.d, this.a.a()).a((zzbtj) this.d, this.a.a()).a((zzbrz) this.d, this.a.a()).a((AppEventListener) this.d, this.a.a()).a((zzbub) this.d, this.a.a()).a()).a(new zzcwq(this.i)).a(new zzcap(zzccl.a, null)).a(new zzbnv(this.f)).a(new zzblz(this.c)).b();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized void b() {
        Preconditions.b("destroy must be called on the main UI thread.");
        if (this.j != null) {
            this.j.b();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized void d() {
        Preconditions.b("pause must be called on the main UI thread.");
        if (this.j != null) {
            this.j.j().a((Context) null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized void e() {
        Preconditions.b("resume must be called on the main UI thread.");
        if (this.j != null) {
            this.j.j().b(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzwt zzwtVar) {
        Preconditions.b("setAdListener must be called on the main UI thread.");
        this.d.a(zzwtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzwt p() {
        return this.d.i();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzxo zzxoVar) {
        Preconditions.b("setAppEventListener must be called on the main UI thread.");
        this.d.a(zzxoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzxo o() {
        return this.d.j();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized void i() {
        Preconditions.b("recordManualImpression must be called on the main UI thread.");
        if (this.j != null) {
            this.j.g();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized zzvn j() {
        Preconditions.b("getAdSize must be called on the main UI thread.");
        if (this.j != null) {
            return zzdns.a(this.b, (List<zzdmx>) Collections.singletonList(this.j.d()));
        }
        return this.h.b();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized void a(zzvn zzvnVar) {
        Preconditions.b("setAdSize must be called on the main UI thread.");
        this.h.a(zzvnVar);
        this.g = zzvnVar;
        if (this.j != null) {
            this.j.a(this.c, zzvnVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized String k() {
        if (this.j == null || this.j.k() == null) {
            return null;
        }
        return this.j.k().a();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized String l() {
        if (this.j == null || this.j.k() == null) {
            return null;
        }
        return this.j.k().a();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized zzyn m() {
        if (!((Boolean) zzwq.e().a(zzabf.dT)).booleanValue()) {
            return null;
        }
        if (this.j == null) {
            return null;
        }
        return this.j.k();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized void a(zzxu zzxuVar) {
        Preconditions.b("setCorrelationIdProvider must be called on the main UI thread");
        this.h.a(zzxuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized void a(boolean z) {
        Preconditions.b("setManualImpressionsEnabled must be called from the main thread.");
        this.h.b(z);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized boolean q() {
        boolean z;
        if (this.k != null) {
            z = this.k.isDone() ? false : true;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized zzys r() {
        Preconditions.b("getVideoController must be called from the main thread.");
        if (this.j == null) {
            return null;
        }
        return this.j.c();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized String n() {
        return this.h.c();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized void a(zzaak zzaakVar) {
        Preconditions.b("setVideoOptions must be called on the main UI thread.");
        this.h.a(zzaakVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzws zzwsVar) {
        Preconditions.b("setAdListener must be called on the main UI thread.");
        this.e.a(zzwsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized void a(zzacb zzacbVar) {
        Preconditions.b("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.i = zzacbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbue
    public final synchronized void s() {
        boolean a;
        Object parent = this.c.getParent();
        if (parent instanceof View) {
            View view = (View) parent;
            a = zzp.c().a(view, view.getContext());
        } else {
            a = false;
        }
        if (a) {
            zzvn b = this.h.b();
            if (this.j != null && this.j.e() != null && this.h.f()) {
                b = zzdns.a(this.b, (List<zzdmx>) Collections.singletonList(this.j.e()));
            }
            b(b);
            b(this.h.a());
            return;
        }
        this.f.a(60);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzym zzymVar) {
        Preconditions.b("setPaidEventListener must be called on the main UI thread.");
        this.d.a(zzymVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzxj zzxjVar) {
        Preconditions.b("setAdMetadataListener must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final Bundle f() {
        Preconditions.b("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    static /* synthetic */ zzdyz a(zzcxm zzcxmVar, zzdyz zzdyzVar) {
        zzcxmVar.k = null;
        return null;
    }
}
