package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzn extends zza implements zzl {
    public zzn() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static zzl a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        if (queryLocalInterface instanceof zzl) {
            return (zzl) queryLocalInterface;
        }
        return new zzm(iBinder);
    }

    @Override // com.google.android.gms.internal.common.zza
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                IObjectWrapper a = a();
                parcel2.writeNoException();
                com.google.android.gms.internal.common.zzd.a(parcel2, a);
                return true;
            case 2:
                int b = b();
                parcel2.writeNoException();
                parcel2.writeInt(b);
                return true;
            default:
                return false;
        }
    }
}
