package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdmi extends zzavg {
    private final zzdma a;
    private final zzdlf b;
    private final String c;
    private final zzdni d;
    private final Context e;

    @GuardedBy("this")
    private zzchc f;

    public zzdmi(String str, zzdma zzdmaVar, Context context, zzdlf zzdlfVar, zzdni zzdniVar) {
        this.c = str;
        this.a = zzdmaVar;
        this.b = zzdlfVar;
        this.d = zzdniVar;
        this.e = context;
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final synchronized void a(zzvk zzvkVar, zzavp zzavpVar) throws RemoteException {
        a(zzvkVar, zzavpVar, zzdnf.b);
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final synchronized void b(zzvk zzvkVar, zzavp zzavpVar) throws RemoteException {
        a(zzvkVar, zzavpVar, zzdnf.c);
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final synchronized void a(IObjectWrapper iObjectWrapper) throws RemoteException {
        a(iObjectWrapper, false);
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final synchronized void a(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        Preconditions.b("#008 Must be called on the main UI thread.");
        if (this.f == null) {
            zzd.e("Rewarded can not be shown before loaded");
            this.b.a(zzdoi.a(zzdok.NOT_READY, null, null));
        } else {
            this.f.a(z, (Activity) ObjectWrapper.a(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final synchronized String b() throws RemoteException {
        if (this.f == null || this.f.k() == null) {
            return null;
        }
        return this.f.k().a();
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final boolean a() {
        Preconditions.b("#008 Must be called on the main UI thread.");
        return (this.f == null || this.f.a()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final void a(zzavi zzaviVar) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        this.b.a(zzaviVar);
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final void a(zzavq zzavqVar) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        this.b.a(zzavqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final void a(zzyh zzyhVar) {
        if (zzyhVar == null) {
            this.b.a((AdMetadataListener) null);
        } else {
            this.b.a(new aif(this, zzyhVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final Bundle c() {
        Preconditions.b("#008 Must be called on the main UI thread.");
        return this.f != null ? this.f.f() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final zzavc d() {
        Preconditions.b("#008 Must be called on the main UI thread.");
        if (this.f != null) {
            return this.f.c();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final synchronized void a(zzavy zzavyVar) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzdni zzdniVar = this.d;
        zzdniVar.a = zzavyVar.a;
        if (((Boolean) zzwq.e().a(zzabf.ap)).booleanValue()) {
            zzdniVar.b = zzavyVar.b;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final zzyn e() {
        if (((Boolean) zzwq.e().a(zzabf.dT)).booleanValue() && this.f != null) {
            return this.f.k();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final void a(zzym zzymVar) {
        Preconditions.b("setOnPaidEventListener must be called on the main UI thread.");
        this.b.a(zzymVar);
    }

    private final synchronized void a(zzvk zzvkVar, zzavp zzavpVar, int i) throws RemoteException {
        Preconditions.b("#008 Must be called on the main UI thread.");
        this.b.a(zzavpVar);
        zzp.c();
        if (com.google.android.gms.ads.internal.util.zzm.o(this.e) && zzvkVar.s == null) {
            zzd.c("Failed to load the ad because app ID is missing.");
            this.b.a_(zzdoi.a(zzdok.APP_ID_MISSING, null, null));
        } else {
            if (this.f != null) {
                return;
            }
            zzdmb zzdmbVar = new zzdmb(null);
            this.a.a(i);
            this.a.a(zzvkVar, this.c, zzdmbVar, new aie(this));
        }
    }
}
