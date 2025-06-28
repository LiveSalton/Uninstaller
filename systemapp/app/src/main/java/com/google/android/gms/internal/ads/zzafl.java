package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzafl extends zzgu implements zzafj {
    zzafl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final void a(zzaex zzaexVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzaexVar);
        b(1, y);
    }
}
