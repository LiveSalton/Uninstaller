package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzagg extends zzgu implements zzage {
    zzagg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final void a(String str) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        b(1, y);
    }

    @Override // com.google.android.gms.internal.ads.zzage
    public final void a() throws RemoteException {
        b(2, y());
    }
}
