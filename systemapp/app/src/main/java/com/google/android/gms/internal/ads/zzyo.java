package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzyo extends zzgu implements zzym {
    zzyo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    @Override // com.google.android.gms.internal.ads.zzym
    public final void a(zzvp zzvpVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzvpVar);
        b(1, y);
    }
}
