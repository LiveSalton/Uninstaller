package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzafu extends zzgu implements zzafv {
    zzafu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnMediaContentChangedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzafv
    public final void a() throws RemoteException {
        b(2, y());
    }
}
