package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzo extends com.google.android.gms.internal.common.zzb implements IGmsCallbacks {
    zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void a(int i, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel s = s();
        s.writeInt(i);
        s.writeStrongBinder(iBinder);
        com.google.android.gms.internal.common.zzd.a(s, bundle);
        b(1, s);
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void a(int i, Bundle bundle) throws RemoteException {
        Parcel s = s();
        s.writeInt(i);
        com.google.android.gms.internal.common.zzd.a(s, bundle);
        b(2, s);
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void a(int i, IBinder iBinder, zzc zzcVar) throws RemoteException {
        Parcel s = s();
        s.writeInt(i);
        s.writeStrongBinder(iBinder);
        com.google.android.gms.internal.common.zzd.a(s, zzcVar);
        b(3, s);
    }
}
