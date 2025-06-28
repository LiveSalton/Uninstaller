package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.Nullable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzccb extends zzyr {
    private final Object a = new Object();

    @Nullable
    private zzys b;

    @Nullable
    private final zzaob c;

    public zzccb(@Nullable zzys zzysVar, @Nullable zzaob zzaobVar) {
        this.b = zzysVar;
        this.c = zzaobVar;
    }

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
        if (this.c != null) {
            return this.c.t();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final float g() throws RemoteException {
        if (this.c != null) {
            return this.c.u();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final void a(zzyt zzytVar) throws RemoteException {
        synchronized (this.a) {
            if (this.b != null) {
                this.b.a(zzytVar);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final zzyt h() throws RemoteException {
        synchronized (this.a) {
            if (this.b == null) {
                return null;
            }
            return this.b.h();
        }
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
