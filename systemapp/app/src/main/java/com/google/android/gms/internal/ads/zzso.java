package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzso extends zzgu implements zzsm {
    zzso(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdPresentationCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzsm
    public final void a() throws RemoteException {
        b(1, y());
    }
}
