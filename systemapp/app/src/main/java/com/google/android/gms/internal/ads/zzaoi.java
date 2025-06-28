package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaoi extends zzanr {
    private final Adapter a;
    private final zzauw b;

    zzaoi(Adapter adapter, zzauw zzauwVar) {
        this.a = adapter;
        this.b = zzauwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void a(int i, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void a(Bundle bundle) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void a(zzaff zzaffVar, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void a(zzant zzantVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void a(zzava zzavaVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void a(zzve zzveVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void a(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void a(String str, String str2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void b(int i) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void b(zzve zzveVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void b(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void c() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void f() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void g() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void i() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void k() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void e() throws RemoteException {
        if (this.b != null) {
            this.b.b(ObjectWrapper.a(this.a));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void d() throws RemoteException {
        if (this.b != null) {
            this.b.c(ObjectWrapper.a(this.a));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void b() throws RemoteException {
        if (this.b != null) {
            this.b.e(ObjectWrapper.a(this.a));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void a(zzavc zzavcVar) throws RemoteException {
        if (this.b != null) {
            this.b.a(ObjectWrapper.a(this.a), new zzava(zzavcVar.a(), zzavcVar.b()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void h() throws RemoteException {
        if (this.b != null) {
            this.b.d(ObjectWrapper.a(this.a));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void j() throws RemoteException {
        if (this.b != null) {
            this.b.h(ObjectWrapper.a(this.a));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void a() throws RemoteException {
        if (this.b != null) {
            this.b.f(ObjectWrapper.a(this.a));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void a(int i) throws RemoteException {
        if (this.b != null) {
            this.b.b(ObjectWrapper.a(this.a), i);
        }
    }
}
