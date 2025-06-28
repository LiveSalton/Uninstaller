package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaiq extends zzgu implements zzair {
    zzaiq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    @Override // com.google.android.gms.internal.ads.zzair
    public final void a(zzail zzailVar, zzaip zzaipVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzailVar);
        zzgv.a(y, zzaipVar);
        c(2, y);
    }
}
