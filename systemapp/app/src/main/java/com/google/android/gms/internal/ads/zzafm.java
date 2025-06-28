package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzafm extends zzgu implements zzafk {
    zzafm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final void a(zzafb zzafbVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzafbVar);
        b(1, y);
    }
}
