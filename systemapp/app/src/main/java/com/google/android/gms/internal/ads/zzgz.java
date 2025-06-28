package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzgz extends zzgu implements zzgy {
    zzgz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.clearcut.IClearcut");
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    public final void a(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        y.writeString(str);
        b(2, y);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    public final void a() throws RemoteException {
        b(3, y());
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    public final void a(int[] iArr) throws RemoteException {
        Parcel y = y();
        y.writeIntArray(null);
        b(4, y);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    public final void a(byte[] bArr) throws RemoteException {
        Parcel y = y();
        y.writeByteArray(bArr);
        b(5, y);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    public final void a(int i) throws RemoteException {
        Parcel y = y();
        y.writeInt(i);
        b(6, y);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    public final void b(int i) throws RemoteException {
        Parcel y = y();
        y.writeInt(i);
        b(7, y);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    public final void a(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        y.writeString(str);
        y.writeString(null);
        b(8, y);
    }
}
