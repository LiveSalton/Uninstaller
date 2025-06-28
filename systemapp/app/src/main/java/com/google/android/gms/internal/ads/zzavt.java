package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzavt extends zzgu implements zzavq {
    zzavt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
    }

    @Override // com.google.android.gms.internal.ads.zzavq
    public final void a(zzavc zzavcVar, String str, String str2) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzavcVar);
        y.writeString(str);
        y.writeString(str2);
        b(2, y);
    }
}
