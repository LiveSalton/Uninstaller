package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcgg extends zzagi {
    private final String a;
    private final zzcbt b;
    private final zzcce c;

    public zzcgg(String str, zzcbt zzcbtVar, zzcce zzcceVar) {
        this.a = str;
        this.b = zzcbtVar;
        this.c = zzcceVar;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final IObjectWrapper n() throws RemoteException {
        return ObjectWrapper.a(this.b);
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final String a() throws RemoteException {
        return this.c.e();
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final List<?> b() throws RemoteException {
        return this.c.f();
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final List<?> r() throws RemoteException {
        if (s()) {
            return this.c.h();
        }
        return Collections.emptyList();
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final boolean s() throws RemoteException {
        return (this.c.h().isEmpty() || this.c.i() == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final String c() throws RemoteException {
        return this.c.j();
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final zzaej d() throws RemoteException {
        return this.c.r();
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final String e() throws RemoteException {
        return this.c.l();
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final String f() throws RemoteException {
        return this.c.s();
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final double g() throws RemoteException {
        return this.c.q();
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final String h() throws RemoteException {
        return this.c.o();
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final String i() throws RemoteException {
        return this.c.p();
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final void l() throws RemoteException {
        this.b.b();
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final zzys j() throws RemoteException {
        return this.c.b();
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final void a(Bundle bundle) throws RemoteException {
        this.b.a(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final boolean b(Bundle bundle) throws RemoteException {
        return this.b.b(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final void c(Bundle bundle) throws RemoteException {
        this.b.c(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final zzaeb m() throws RemoteException {
        return this.c.c();
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final IObjectWrapper o() throws RemoteException {
        return this.c.n();
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final String k() throws RemoteException {
        return this.a;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final Bundle p() throws RemoteException {
        return this.c.k();
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final void a(zzage zzageVar) throws RemoteException {
        this.b.a(zzageVar);
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final void a(zzyd zzydVar) throws RemoteException {
        this.b.a(zzydVar);
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final void a(zzxz zzxzVar) throws RemoteException {
        this.b.a(zzxzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final void t() {
        this.b.d();
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final void u() {
        this.b.e();
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final boolean w() {
        return this.b.f();
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final void q() throws RemoteException {
        this.b.c();
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final zzaee v() throws RemoteException {
        return this.b.n().a();
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final zzyn x() throws RemoteException {
        if (((Boolean) zzwq.e().a(zzabf.dT)).booleanValue()) {
            return this.b.k();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final void a(zzym zzymVar) throws RemoteException {
        this.b.a(zzymVar);
    }
}
