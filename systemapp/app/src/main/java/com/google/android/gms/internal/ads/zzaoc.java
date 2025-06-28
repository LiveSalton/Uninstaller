package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaoc extends zzyr {
    private final Object a = new Object();
    private volatile zzyt b;

    @Override // com.google.android.gms.internal.ads.zzys
    public final void a() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final void b() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final void c() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final void a(boolean z) throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final boolean d() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final int e() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final float f() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final float g() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final void a(zzyt zzytVar) throws RemoteException {
        synchronized (this.a) {
            this.b = zzytVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final zzyt h() throws RemoteException {
        zzyt zzytVar;
        synchronized (this.a) {
            zzytVar = this.b;
        }
        return zzytVar;
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final float i() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final boolean j() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final boolean k() throws RemoteException {
        throw new RemoteException();
    }
}
