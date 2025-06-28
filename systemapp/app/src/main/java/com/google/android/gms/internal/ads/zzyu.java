package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzyu extends zzgu implements zzys {
    zzyu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final void a() throws RemoteException {
        b(1, y());
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final void b() throws RemoteException {
        b(2, y());
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final void a(boolean z) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, z);
        b(3, y);
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final boolean d() throws RemoteException {
        Parcel a = a(4, y());
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final int e() throws RemoteException {
        Parcel a = a(5, y());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final float f() throws RemoteException {
        Parcel a = a(6, y());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final float g() throws RemoteException {
        Parcel a = a(7, y());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final void a(zzyt zzytVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzytVar);
        b(8, y);
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final float i() throws RemoteException {
        Parcel a = a(9, y());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final boolean j() throws RemoteException {
        Parcel a = a(10, y());
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final zzyt h() throws RemoteException {
        zzyt zzyvVar;
        Parcel a = a(11, y());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzyvVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
            if (queryLocalInterface instanceof zzyt) {
                zzyvVar = (zzyt) queryLocalInterface;
            } else {
                zzyvVar = new zzyv(readStrongBinder);
            }
        }
        a.recycle();
        return zzyvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final boolean k() throws RemoteException {
        Parcel a = a(12, y());
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzys
    public final void c() throws RemoteException {
        b(13, y());
    }
}
