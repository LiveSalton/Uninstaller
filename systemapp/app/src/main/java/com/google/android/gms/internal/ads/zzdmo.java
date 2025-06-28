package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdmo extends zzaul {
    private final zzdma a;
    private final zzdlf b;
    private final zzdni c;

    @GuardedBy("this")
    private zzchc d;

    @GuardedBy("this")
    private boolean e = false;

    public zzdmo(zzdma zzdmaVar, zzdlf zzdlfVar, zzdni zzdniVar) {
        this.a = zzdmaVar;
        this.b = zzdlfVar;
        this.c = zzdniVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void c(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final synchronized void a(zzauv zzauvVar) throws RemoteException {
        Preconditions.b("loadAd must be called on the main UI thread.");
        if (zzabh.a(zzauvVar.b)) {
            return;
        }
        if (j()) {
            if (!((Boolean) zzwq.e().a(zzabf.cJ)).booleanValue()) {
                return;
            }
        }
        zzdmb zzdmbVar = new zzdmb(null);
        this.d = null;
        this.a.a(zzdnf.a);
        this.a.a(zzauvVar.a, zzauvVar.b, zzdmbVar, new aih(this));
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void f() throws RemoteException {
        d(null);
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final synchronized void d(IObjectWrapper iObjectWrapper) {
        Preconditions.b("destroy must be called on the main UI thread.");
        Context context = null;
        this.b.a((AdMetadataListener) null);
        if (this.d != null) {
            if (iObjectWrapper != null) {
                context = (Context) ObjectWrapper.a(iObjectWrapper);
            }
            this.d.j().c(context);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void d() {
        b((IObjectWrapper) null);
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final synchronized void b(IObjectWrapper iObjectWrapper) {
        Preconditions.b("pause must be called on the main UI thread.");
        if (this.d != null) {
            this.d.j().a(iObjectWrapper == null ? null : (Context) ObjectWrapper.a(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void e() {
        c((IObjectWrapper) null);
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final synchronized void c(IObjectWrapper iObjectWrapper) {
        Preconditions.b("resume must be called on the main UI thread.");
        if (this.d != null) {
            this.d.j().b(iObjectWrapper == null ? null : (Context) ObjectWrapper.a(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final synchronized void a() throws RemoteException {
        a((IObjectWrapper) null);
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final synchronized void a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Activity activity;
        Preconditions.b("showAd must be called on the main UI thread.");
        if (this.d == null) {
            return;
        }
        if (iObjectWrapper != null) {
            Object a = ObjectWrapper.a(iObjectWrapper);
            if (a instanceof Activity) {
                activity = (Activity) a;
                this.d.a(this.e, activity);
            }
        }
        activity = null;
        this.d.a(this.e, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final boolean h() {
        return this.d != null && this.d.e();
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final synchronized String g() throws RemoteException {
        if (this.d == null || this.d.k() == null) {
            return null;
        }
        return this.d.k().a();
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final boolean c() throws RemoteException {
        Preconditions.b("isLoaded must be called on the main UI thread.");
        return j();
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void a(zzaup zzaupVar) throws RemoteException {
        Preconditions.b("setRewardedVideoAdListener can only be called from the UI thread.");
        this.b.a(zzaupVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void a(zzaug zzaugVar) {
        Preconditions.b("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.b.a(zzaugVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final void a(zzxj zzxjVar) {
        Preconditions.b("setAdMetadataListener can only be called from the UI thread.");
        if (zzxjVar == null) {
            this.b.a((AdMetadataListener) null);
        } else {
            this.b.a(new aig(this, zzxjVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final Bundle b() {
        Preconditions.b("getAdMetadata can only be called from the UI thread.");
        return this.d != null ? this.d.f() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final synchronized void a(String str) throws RemoteException {
        Preconditions.b("setUserId must be called on the main UI thread.");
        this.c.a = str;
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final synchronized void b(String str) throws RemoteException {
        if (((Boolean) zzwq.e().a(zzabf.ap)).booleanValue()) {
            Preconditions.b("#008 Must be called on the main UI thread.: setCustomData");
            this.c.b = str;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final synchronized void a(boolean z) {
        Preconditions.b("setImmersiveMode must be called on the main UI thread.");
        this.e = z;
    }

    @Override // com.google.android.gms.internal.ads.zzaui
    public final synchronized zzyn i() throws RemoteException {
        if (!((Boolean) zzwq.e().a(zzabf.dT)).booleanValue()) {
            return null;
        }
        if (this.d == null) {
            return null;
        }
        return this.d.k();
    }

    private final synchronized boolean j() {
        boolean z;
        if (this.d != null) {
            z = this.d.d() ? false : true;
        }
        return z;
    }
}
