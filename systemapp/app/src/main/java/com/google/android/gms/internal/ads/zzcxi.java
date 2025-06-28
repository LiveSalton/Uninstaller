package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcxi extends zzxf {
    private final Context a;
    private final zzwt b;
    private final zzdnn c;
    private final zzbme d;
    private final ViewGroup e;

    public zzcxi(Context context, zzwt zzwtVar, zzdnn zzdnnVar, zzbme zzbmeVar) {
        this.a = context;
        this.b = zzwtVar;
        this.c = zzdnnVar;
        this.d = zzbmeVar;
        FrameLayout frameLayout = new FrameLayout(this.a);
        frameLayout.removeAllViews();
        frameLayout.addView(this.d.a(), zzp.e().c());
        frameLayout.setMinimumHeight(j().c);
        frameLayout.setMinimumWidth(j().f);
        this.e = frameLayout;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzart zzartVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzarz zzarzVar, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzaup zzaupVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzsl zzslVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzvw zzvwVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzyy zzyyVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void b(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void b(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final boolean c() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void g() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void h() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final boolean q() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final IObjectWrapper a() throws RemoteException {
        return ObjectWrapper.a(this.e);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void b() throws RemoteException {
        Preconditions.b("destroy must be called on the main UI thread.");
        this.d.b();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final boolean a(zzvk zzvkVar) throws RemoteException {
        zzd.d("loadAd is not supported for a Publisher AdView returned from AdLoader.");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void d() throws RemoteException {
        Preconditions.b("destroy must be called on the main UI thread.");
        this.d.j().a((Context) null);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void e() throws RemoteException {
        Preconditions.b("destroy must be called on the main UI thread.");
        this.d.j().b(null);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void i() throws RemoteException {
        this.d.g();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzvn j() {
        Preconditions.b("getAdSize must be called on the main UI thread.");
        return zzdns.a(this.a, (List<zzdmx>) Collections.singletonList(this.d.d()));
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final String k() throws RemoteException {
        if (this.d.k() != null) {
            return this.d.k().a();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzys r() throws RemoteException {
        return this.d.c();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final String n() throws RemoteException {
        return this.c.f;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzxo o() throws RemoteException {
        return this.c.m;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzwt p() throws RemoteException {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final String l() throws RemoteException {
        if (this.d.k() != null) {
            return this.d.k().a();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzyn m() {
        return this.d.k();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzaak zzaakVar) throws RemoteException {
        zzd.d("setVideoOptions is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzvn zzvnVar) throws RemoteException {
        Preconditions.b("setAdSize must be called on the main UI thread.");
        if (this.d != null) {
            this.d.a(this.e, zzvnVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzacb zzacbVar) throws RemoteException {
        zzd.d("setOnCustomRenderedAdLoadedListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzws zzwsVar) throws RemoteException {
        zzd.d("setAdClickListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzxu zzxuVar) throws RemoteException {
        zzd.d("setCorrelationIdProvider is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(boolean z) throws RemoteException {
        zzd.d("setManualImpressionsEnabled is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzwt zzwtVar) throws RemoteException {
        zzd.d("setAdListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzxo zzxoVar) throws RemoteException {
        zzd.d("setAppEventListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzxj zzxjVar) throws RemoteException {
        zzd.d("setAdMetadataListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final Bundle f() throws RemoteException {
        zzd.d("getAdMetadata is not supported in Publisher AdView returned by AdLoader.");
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void a(zzym zzymVar) {
        zzd.d("setOnPaidEventListener is not supported in Publisher AdView returned by AdLoader.");
    }
}
