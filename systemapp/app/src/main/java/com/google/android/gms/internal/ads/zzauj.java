package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzauj extends zzgu implements zzaug {
    zzauj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
    }

    @Override // com.google.android.gms.internal.ads.zzaug
    public final void a(zzauf zzaufVar, String str, String str2) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzaufVar);
        y.writeString(str);
        y.writeString(str2);
        b(2, y);
    }
}
