package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaxr extends zzgu implements zzaxp {
    zzaxr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzaxp
    public final void a(String str, String str2) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        y.writeString(str2);
        b(1, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaxp
    public final void a(String str) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        b(2, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaxp
    public final void a(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        y.writeString(str2);
        zzgv.a(y, bundle);
        b(3, y);
    }
}
