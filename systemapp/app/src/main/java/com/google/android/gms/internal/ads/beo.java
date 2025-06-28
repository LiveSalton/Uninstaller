package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
final class beo extends zzwx {
    final /* synthetic */ zzzo a;

    /* JADX INFO: Access modifiers changed from: private */
    beo(zzzo zzzoVar) {
        this.a = zzzoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwy
    public final boolean a() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzwy
    public final String b() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzwy
    public final String c() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzwy
    public final void a(zzvk zzvkVar) throws RemoteException {
        a(zzvkVar, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzwy
    public final void a(zzvk zzvkVar, int i) throws RemoteException {
        zzaza.c("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzayr.a.post(new beq(this));
    }

    /* synthetic */ beo(zzzo zzzoVar, bep bepVar) {
        this(zzzoVar);
    }
}
