package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaes extends zzgu implements zzaeq {
    zzaes(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzaeq
    public final void a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(1, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaeq
    public final void a() throws RemoteException {
        b(2, y());
    }

    @Override // com.google.android.gms.internal.ads.zzaeq
    public final void b(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(3, y);
    }
}
