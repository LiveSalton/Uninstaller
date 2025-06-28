package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Collections;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzzu extends zzxv {
    private zzajc a;

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void a(float f) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void a(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void a(zzaae zzaaeVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void a(zzani zzaniVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void a(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void a(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void a(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final float b() throws RemoteException {
        return 1.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void b(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final boolean c() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final String d() {
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void f() {
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void a() throws RemoteException {
        zzaza.c("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        zzayr.a.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.bes
            private final zzzu a;

            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.g();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void a(zzajc zzajcVar) throws RemoteException {
        this.a = zzajcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final List<zzaiz> e() throws RemoteException {
        return Collections.emptyList();
    }

    final /* synthetic */ void g() {
        if (this.a != null) {
            try {
                this.a.a(Collections.emptyList());
            } catch (RemoteException e) {
                zzaza.d("Could not notify onComplete event.", e);
            }
        }
    }
}
