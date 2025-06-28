package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcyg extends zzxf {
    private final zzvn a;
    private final Context b;
    private final zzdkv c;
    private final String d;
    private final zzcxq e;
    private final zzdlf f;

    @GuardedBy("this")
    private zzbyx g;

    @GuardedBy("this")
    private boolean h = false;

    public zzcyg(Context context, zzvn zzvnVar, String str, zzdkv zzdkvVar, zzcxq zzcxqVar, zzdlf zzdlfVar) {
        this.a = zzvnVar;
        this.d = str;
        this.b = context;
        this.c = zzdkvVar;
        this.e = zzcxqVar;
        this.f = zzdlfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final IObjectWrapper a() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzaak zzaakVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzart zzartVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzarz zzarzVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzsl zzslVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzvn zzvnVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzvw zzvwVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzws zzwsVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzxu zzxuVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzyy zzyyVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void b(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void h() {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void i() {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzvn j() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzys r() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized boolean a(zzvk zzvkVar) throws RemoteException {
        Preconditions.b("loadAd must be called on the main UI thread.");
        zzp.c();
        if (com.google.android.gms.ads.internal.util.zzm.o(this.b) && zzvkVar.s == null) {
            zzd.c("Failed to load the ad because app ID is missing.");
            if (this.e != null) {
                this.e.a_(zzdoi.a(zzdok.APP_ID_MISSING, null, null));
            }
            return false;
        }
        if (s()) {
            return false;
        }
        zzdob.a(this.b, zzvkVar.f);
        this.g = null;
        return this.c.a(zzvkVar, this.d, new zzdks(this.a), new abf(this));
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized void b() {
        Preconditions.b("destroy must be called on the main UI thread.");
        if (this.g != null) {
            this.g.j().c(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized void d() {
        Preconditions.b("pause must be called on the main UI thread.");
        if (this.g != null) {
            this.g.j().a((Context) null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized void e() {
        Preconditions.b("resume must be called on the main UI thread.");
        if (this.g != null) {
            this.g.j().b(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzwt zzwtVar) {
        Preconditions.b("setAdListener must be called on the main UI thread.");
        this.e.a(zzwtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzxo zzxoVar) {
        Preconditions.b("setAppEventListener must be called on the main UI thread.");
        this.e.a(zzxoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized void g() {
        Preconditions.b("showInterstitial must be called on the main UI thread.");
        if (this.g == null) {
            return;
        }
        this.g.a(this.h);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized String k() {
        if (this.g == null || this.g.k() == null) {
            return null;
        }
        return this.g.k().a();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized String l() {
        if (this.g == null || this.g.k() == null) {
            return null;
        }
        return this.g.k().a();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized zzyn m() {
        if (!((Boolean) zzwq.e().a(zzabf.dT)).booleanValue()) {
            return null;
        }
        if (this.g == null) {
            return null;
        }
        return this.g.k();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized boolean q() {
        return this.c.a();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized boolean c() {
        Preconditions.b("isLoaded must be called on the main UI thread.");
        return s();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized String n() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzxo o() {
        return this.e.j();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzwt p() {
        return this.e.i();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized void b(boolean z) {
        Preconditions.b("setImmersiveMode must be called on the main UI thread.");
        this.h = z;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final synchronized void a(zzacb zzacbVar) {
        Preconditions.b("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.c.a(zzacbVar);
    }

    private final synchronized boolean s() {
        boolean z;
        if (this.g != null) {
            z = this.g.a() ? false : true;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzym zzymVar) {
        Preconditions.b("setPaidEventListener must be called on the main UI thread.");
        this.e.a(zzymVar);
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

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzaup zzaupVar) {
        this.f.a(zzaupVar);
    }
}
