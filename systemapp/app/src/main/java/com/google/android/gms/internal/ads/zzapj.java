package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzapj extends zzgu implements zzaph {
    zzapj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final void a() throws RemoteException {
        b(2, y());
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final void a(String str) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        b(3, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    public final void a(zzve zzveVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzveVar);
        b(4, y);
    }
}
