package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzyj extends zzgu implements zzyh {
    zzyj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOnAdMetadataChangedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzyh
    public final void a() throws RemoteException {
        b(1, y());
    }
}
