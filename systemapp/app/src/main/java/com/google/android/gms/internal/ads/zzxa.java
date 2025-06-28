package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzxa extends zzgu implements zzwy {
    zzxa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // com.google.android.gms.internal.ads.zzwy
    public final void a(zzvk zzvkVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzvkVar);
        b(1, y);
    }

    @Override // com.google.android.gms.internal.ads.zzwy
    public final String b() throws RemoteException {
        Parcel a = a(2, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzwy
    public final boolean a() throws RemoteException {
        Parcel a = a(3, y());
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzwy
    public final String c() throws RemoteException {
        Parcel a = a(4, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzwy
    public final void a(zzvk zzvkVar, int i) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzvkVar);
        y.writeInt(i);
        b(5, y);
    }
}
