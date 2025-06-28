package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzwu extends zzgu implements zzws {
    zzwu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final void a() throws RemoteException {
        b(1, y());
    }
}
