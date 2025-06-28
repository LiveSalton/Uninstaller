package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzyb extends zzgu implements zzxz {
    zzyb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMuteThisAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzxz
    public final void a() throws RemoteException {
        b(1, y());
    }
}
