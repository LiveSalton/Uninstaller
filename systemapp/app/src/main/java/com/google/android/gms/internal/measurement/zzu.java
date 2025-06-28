package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzu extends zza implements zzs {
    zzu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.zzs
    public final void a(String str, String str2, Bundle bundle, long j) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeString(str2);
        zzb.a(a, bundle);
        a.writeLong(j);
        b(1, a);
    }

    @Override // com.google.android.gms.internal.measurement.zzs
    public final int r_() throws RemoteException {
        Parcel a = a(2, a());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }
}
