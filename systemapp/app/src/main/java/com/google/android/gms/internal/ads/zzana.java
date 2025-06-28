package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzana extends zzbge {
    private final AppMeasurementSdk a;

    zzana(AppMeasurementSdk appMeasurementSdk) {
        this.a = appMeasurementSdk;
    }

    @Override // com.google.android.gms.internal.ads.zzbgf
    public final void a(Bundle bundle) throws RemoteException {
        this.a.c(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbgf
    public final Bundle b(Bundle bundle) throws RemoteException {
        return this.a.b(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbgf
    public final void a(String str, String str2, Bundle bundle) throws RemoteException {
        this.a.a(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbgf
    public final void a(String str, String str2, IObjectWrapper iObjectWrapper) throws RemoteException {
        this.a.a(str, str2, iObjectWrapper != null ? ObjectWrapper.a(iObjectWrapper) : null);
    }

    @Override // com.google.android.gms.internal.ads.zzbgf
    public final Map a(String str, String str2, boolean z) throws RemoteException {
        return this.a.a(str, str2, z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgf
    public final int a(String str) throws RemoteException {
        return this.a.c(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgf
    public final void c(Bundle bundle) throws RemoteException {
        this.a.a(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbgf
    public final void b(String str, String str2, Bundle bundle) throws RemoteException {
        this.a.b(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbgf
    public final List a(String str, String str2) throws RemoteException {
        return this.a.a(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbgf
    public final String a() throws RemoteException {
        return this.a.c();
    }

    @Override // com.google.android.gms.internal.ads.zzbgf
    public final String b() throws RemoteException {
        return this.a.d();
    }

    @Override // com.google.android.gms.internal.ads.zzbgf
    public final long c() throws RemoteException {
        return this.a.e();
    }

    @Override // com.google.android.gms.internal.ads.zzbgf
    public final void b(String str) throws RemoteException {
        this.a.a(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgf
    public final void c(String str) throws RemoteException {
        this.a.b(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgf
    public final void a(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        this.a.a(iObjectWrapper != null ? (Activity) ObjectWrapper.a(iObjectWrapper) : null, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbgf
    public final String d() throws RemoteException {
        return this.a.a();
    }

    @Override // com.google.android.gms.internal.ads.zzbgf
    public final String e() throws RemoteException {
        return this.a.b();
    }

    @Override // com.google.android.gms.internal.ads.zzbgf
    public final String f() throws RemoteException {
        return this.a.f();
    }
}
