package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcfz extends zzafa {
    private final String a;
    private final zzcbt b;
    private final zzcce c;

    public zzcfz(String str, zzcbt zzcbtVar, zzcce zzcceVar) {
        this.a = str;
        this.b = zzcbtVar;
        this.c = zzcceVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final IObjectWrapper a() throws RemoteException {
        return ObjectWrapper.a(this.b);
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final String b() throws RemoteException {
        return this.c.e();
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final List<?> c() throws RemoteException {
        return this.c.f();
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final String d() throws RemoteException {
        return this.c.j();
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final zzaej e() throws RemoteException {
        return this.c.t();
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final String f() throws RemoteException {
        return this.c.l();
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final String g() throws RemoteException {
        return this.c.s();
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final Bundle h() throws RemoteException {
        return this.c.k();
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final void i() throws RemoteException {
        this.b.b();
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final zzys j() throws RemoteException {
        return this.c.b();
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final void a(Bundle bundle) throws RemoteException {
        this.b.a(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final boolean b(Bundle bundle) throws RemoteException {
        return this.b.b(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final void c(Bundle bundle) throws RemoteException {
        this.b.c(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final zzaeb k() throws RemoteException {
        return this.c.c();
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final IObjectWrapper l() throws RemoteException {
        return this.c.n();
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final String m() throws RemoteException {
        return this.a;
    }
}
