package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzael extends zzgu implements zzaej {
    zzael(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    @Override // com.google.android.gms.internal.ads.zzaej
    public final IObjectWrapper a() throws RemoteException {
        Parcel a = a(1, y());
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaej
    public final Uri b() throws RemoteException {
        Parcel a = a(2, y());
        Uri uri = (Uri) zzgv.a(a, Uri.CREATOR);
        a.recycle();
        return uri;
    }

    @Override // com.google.android.gms.internal.ads.zzaej
    public final double c() throws RemoteException {
        Parcel a = a(3, y());
        double readDouble = a.readDouble();
        a.recycle();
        return readDouble;
    }

    @Override // com.google.android.gms.internal.ads.zzaej
    public final int d() throws RemoteException {
        Parcel a = a(4, y());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.ads.zzaej
    public final int e() throws RemoteException {
        Parcel a = a(5, y());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }
}
