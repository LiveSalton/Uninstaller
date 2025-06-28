package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzzy extends zzavg {
    @Override // com.google.android.gms.internal.ads.zzavh
    public final void a(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final void a(IObjectWrapper iObjectWrapper, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final void a(zzavi zzaviVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final void a(zzavq zzavqVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final void a(zzavy zzavyVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final void a(zzyh zzyhVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final void a(zzym zzymVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final boolean a() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final String b() throws RemoteException {
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final zzavc d() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final zzyn e() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final void a(zzvk zzvkVar, zzavp zzavpVar) throws RemoteException {
        a(zzavpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final void b(zzvk zzvkVar, zzavp zzavpVar) throws RemoteException {
        a(zzavpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzavh
    public final Bundle c() throws RemoteException {
        return new Bundle();
    }

    private static void a(zzavp zzavpVar) {
        zzaza.c("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzayr.a.post(new Runnable(zzavpVar) { // from class: com.google.android.gms.internal.ads.b
            private final zzavp a;

            {
                this.a = zzavpVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzavp zzavpVar2 = this.a;
                if (zzavpVar2 != null) {
                    try {
                        zzavpVar2.a(1);
                    } catch (RemoteException e) {
                        zzaza.e("#007 Could not call remote method.", e);
                    }
                }
            }
        });
    }
}
