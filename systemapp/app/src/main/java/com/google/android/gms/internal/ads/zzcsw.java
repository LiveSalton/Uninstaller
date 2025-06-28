package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcsw extends zzauz implements zzbtc {

    @GuardedBy("this")
    private zzauw a;

    @GuardedBy("this")
    private zzbtf b;

    @GuardedBy("this")
    private zzbyl c;

    public final synchronized void a(zzauw zzauwVar) {
        this.a = zzauwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final synchronized void a(zzbtf zzbtfVar) {
        this.b = zzbtfVar;
    }

    public final synchronized void a(zzbyl zzbylVar) {
        this.c = zzbylVar;
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final synchronized void a(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.a != null) {
            this.a.a(iObjectWrapper);
        }
        if (this.c != null) {
            this.c.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final synchronized void a(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        if (this.a != null) {
            this.a.a(iObjectWrapper, i);
        }
        if (this.c != null) {
            this.c.a(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final synchronized void d(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.a != null) {
            this.a.d(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final synchronized void a(IObjectWrapper iObjectWrapper, zzava zzavaVar) throws RemoteException {
        if (this.a != null) {
            this.a.a(iObjectWrapper, zzavaVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final synchronized void f(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.a != null) {
            this.a.f(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final synchronized void e(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.a != null) {
            this.a.e(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final synchronized void b(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        if (this.a != null) {
            this.a.b(iObjectWrapper, i);
        }
        if (this.b != null) {
            this.b.a(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final synchronized void g(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.a != null) {
            this.a.g(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final synchronized void h(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.a != null) {
            this.a.h(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final synchronized void c(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.a != null) {
            this.a.c(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final synchronized void b(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.a != null) {
            this.a.b(iObjectWrapper);
        }
        if (this.b != null) {
            this.b.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauw
    public final synchronized void a(Bundle bundle) throws RemoteException {
        if (this.a != null) {
            this.a.a(bundle);
        }
    }
}
