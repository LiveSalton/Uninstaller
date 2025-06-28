package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzafs extends zzgu implements zzafq {
    zzafs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzafq
    public final void a(zzaff zzaffVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzaffVar);
        b(1, y);
    }
}
