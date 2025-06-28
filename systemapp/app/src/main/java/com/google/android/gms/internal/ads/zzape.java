package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzape extends zzgu implements zzapc {
    zzape(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzapc
    public final void a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(1, y);
    }

    @Override // com.google.android.gms.internal.ads.zzapc
    public final void a(String str) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        b(2, y);
    }

    @Override // com.google.android.gms.internal.ads.zzapc
    public final void a(zzve zzveVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzveVar);
        b(3, y);
    }
}
