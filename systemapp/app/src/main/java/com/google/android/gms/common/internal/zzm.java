package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzm extends com.google.android.gms.internal.common.zzb implements zzl {
    zzm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // com.google.android.gms.common.internal.zzl
    public final IObjectWrapper a() throws RemoteException {
        Parcel a = a(1, s());
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.common.internal.zzl
    public final int b() throws RemoteException {
        Parcel a = a(2, s());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }
}
