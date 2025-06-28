package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzari;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzv extends zzari {
    private AdOverlayInfoParcel a;
    private Activity b;
    private boolean c = false;
    private boolean d = false;

    public zzv(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.a = adOverlayInfoParcel;
        this.b = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void a(int i, int i2, Intent intent) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void a(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void d() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final boolean f() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void g() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void h() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void m() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void a(Bundle bundle) {
        boolean z = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z = true;
        }
        if (this.a == null) {
            this.b.finish();
            return;
        }
        if (z) {
            this.b.finish();
            return;
        }
        if (bundle == null) {
            if (this.a.b != null) {
                this.a.b.e();
            }
            if (this.b.getIntent() != null && this.b.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) && this.a.c != null) {
                this.a.c.e_();
            }
        }
        com.google.android.gms.ads.internal.zzp.a();
        if (zza.a(this.b, this.a.a, this.a.i)) {
            return;
        }
        this.b.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void i() throws RemoteException {
        if (this.c) {
            this.b.finish();
            return;
        }
        this.c = true;
        if (this.a.c != null) {
            this.a.c.g_();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void b(Bundle bundle) throws RemoteException {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.c);
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void j() throws RemoteException {
        if (this.a.c != null) {
            this.a.c.b_();
        }
        if (this.b.isFinishing()) {
            a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void e() throws RemoteException {
        if (this.a.c != null) {
            this.a.c.f_();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void k() throws RemoteException {
        if (this.b.isFinishing()) {
            a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzarj
    public final void l() throws RemoteException {
        if (this.b.isFinishing()) {
            a();
        }
    }

    private final synchronized void a() {
        if (!this.d) {
            if (this.a.c != null) {
                this.a.c.a(zzl.OTHER);
            }
            this.d = true;
        }
    }
}
