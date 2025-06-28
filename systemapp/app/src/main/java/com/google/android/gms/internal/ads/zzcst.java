package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcst extends zzanr implements zzbtc {

    @GuardedBy("this")
    private zzano a;

    @GuardedBy("this")
    private zzbtf b;

    public final synchronized void a(zzano zzanoVar) {
        this.a = zzanoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final synchronized void a(zzbtf zzbtfVar) {
        this.b = zzbtfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final synchronized void a() throws RemoteException {
        if (this.a != null) {
            this.a.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final synchronized void b() throws RemoteException {
        if (this.a != null) {
            this.a.b();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final synchronized void a(int i) throws RemoteException {
        if (this.a != null) {
            this.a.a(i);
        }
        if (this.b != null) {
            this.b.a(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final synchronized void a(int i, String str) throws RemoteException {
        if (this.a != null) {
            this.a.a(i, str);
        }
        if (this.b != null) {
            this.b.a(i, str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final synchronized void a(zzve zzveVar) throws RemoteException {
        if (this.a != null) {
            this.a.a(zzveVar);
        }
        if (this.b != null) {
            this.b.a(zzveVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final synchronized void c() throws RemoteException {
        if (this.a != null) {
            this.a.c();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final synchronized void d() throws RemoteException {
        if (this.a != null) {
            this.a.d();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final synchronized void e() throws RemoteException {
        if (this.a != null) {
            this.a.e();
        }
        if (this.b != null) {
            this.b.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final synchronized void a(zzant zzantVar) throws RemoteException {
        if (this.a != null) {
            this.a.a(zzantVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final synchronized void f() throws RemoteException {
        if (this.a != null) {
            this.a.f();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final synchronized void a(String str, String str2) throws RemoteException {
        if (this.a != null) {
            this.a.a(str, str2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final synchronized void a(zzaff zzaffVar, String str) throws RemoteException {
        if (this.a != null) {
            this.a.a(zzaffVar, str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final synchronized void g() throws RemoteException {
        if (this.a != null) {
            this.a.g();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final synchronized void a(String str) throws RemoteException {
        if (this.a != null) {
            this.a.a(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final synchronized void h() throws RemoteException {
        if (this.a != null) {
            this.a.h();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final synchronized void k() throws RemoteException {
        if (this.a != null) {
            this.a.k();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final synchronized void a(zzava zzavaVar) throws RemoteException {
        if (this.a != null) {
            this.a.a(zzavaVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final synchronized void i() throws RemoteException {
        if (this.a != null) {
            this.a.i();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final synchronized void a(Bundle bundle) throws RemoteException {
        if (this.a != null) {
            this.a.a(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final synchronized void j() throws RemoteException {
        if (this.a != null) {
            this.a.j();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final synchronized void b(int i) throws RemoteException {
        if (this.a != null) {
            this.a.b(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final synchronized void b(String str) throws RemoteException {
        if (this.a != null) {
            this.a.b(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final synchronized void b(zzve zzveVar) throws RemoteException {
        if (this.a != null) {
            this.a.b(zzveVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final synchronized void a(zzavc zzavcVar) throws RemoteException {
        if (this.a != null) {
            this.a.a(zzavcVar);
        }
    }
}
