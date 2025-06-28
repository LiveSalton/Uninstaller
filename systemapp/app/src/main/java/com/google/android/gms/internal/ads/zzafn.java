package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzafn extends zzgw implements zzafk {
    public zzafn() {
        super("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    public static zzafk a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
        if (queryLocalInterface instanceof zzafk) {
            return (zzafk) queryLocalInterface;
        }
        return new zzafm(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzafb zzafdVar;
        if (i != 1) {
            return false;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            zzafdVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
            if (queryLocalInterface instanceof zzafb) {
                zzafdVar = (zzafb) queryLocalInterface;
            } else {
                zzafdVar = new zzafd(readStrongBinder);
            }
        }
        a(zzafdVar);
        parcel2.writeNoException();
        return true;
    }
}
