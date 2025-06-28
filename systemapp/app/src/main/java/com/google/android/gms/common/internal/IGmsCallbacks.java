package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public interface IGmsCallbacks extends IInterface {
    void a(int i, Bundle bundle) throws RemoteException;

    void a(int i, IBinder iBinder, Bundle bundle) throws RemoteException;

    void a(int i, IBinder iBinder, zzc zzcVar) throws RemoteException;

    /* compiled from: source */
    public static abstract class zza extends com.google.android.gms.internal.common.zza implements IGmsCallbacks {
        public zza() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        @Override // com.google.android.gms.internal.common.zza
        protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    a(parcel.readInt(), parcel.readStrongBinder(), (Bundle) com.google.android.gms.internal.common.zzd.a(parcel, Bundle.CREATOR));
                    break;
                case 2:
                    a(parcel.readInt(), (Bundle) com.google.android.gms.internal.common.zzd.a(parcel, Bundle.CREATOR));
                    break;
                case 3:
                    a(parcel.readInt(), parcel.readStrongBinder(), (zzc) com.google.android.gms.internal.common.zzd.a(parcel, zzc.CREATOR));
                    break;
                default:
                    return false;
            }
            parcel2.writeNoException();
            return true;
        }
    }
}
