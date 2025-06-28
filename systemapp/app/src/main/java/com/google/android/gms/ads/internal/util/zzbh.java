package com.google.android.gms.ads.internal.util;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzgu;
import com.google.android.gms.internal.ads.zzgv;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbh extends zzgu implements zzbf {
    zzbh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.util.IWorkManagerUtil");
    }

    @Override // com.google.android.gms.ads.internal.util.zzbf
    public final boolean zzd(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        y.writeString(str);
        y.writeString(str2);
        Parcel a = a(1, y);
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.ads.internal.util.zzbf
    public final void zzap(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(2, y);
    }
}
