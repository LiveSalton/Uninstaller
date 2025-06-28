package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzafr extends zzgu implements zzafp {
    zzafr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzafp
    public final void a(zzaff zzaffVar, String str) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzaffVar);
        y.writeString(str);
        b(1, y);
    }
}
