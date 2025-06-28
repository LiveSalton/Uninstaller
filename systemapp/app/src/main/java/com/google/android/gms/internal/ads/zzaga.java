package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaga extends zzgu implements zzafy {
    zzaga(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void a(zzagj zzagjVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzagjVar);
        b(1, y);
    }
}
