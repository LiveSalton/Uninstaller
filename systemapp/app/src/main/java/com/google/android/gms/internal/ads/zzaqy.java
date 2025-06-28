package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaqy extends zzgu implements zzaqw {
    zzaqy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    @Override // com.google.android.gms.internal.ads.zzaqw
    public final void a(Intent intent) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, intent);
        b(1, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaqw
    public final void a(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        y.writeString(str);
        y.writeString(str2);
        b(2, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaqw
    public final void a() throws RemoteException {
        b(3, y());
    }
}
