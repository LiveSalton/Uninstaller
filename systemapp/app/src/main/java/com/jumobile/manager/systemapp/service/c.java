package com.jumobile.manager.systemapp.service;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.jumobile.manager.systemapp.service.b;

/* compiled from: source */
/* loaded from: classes.dex */
public interface c extends IInterface {
    int a(DownloadEntry downloadEntry) throws RemoteException;

    int a(DownloadEntry downloadEntry, PendingIntent pendingIntent) throws RemoteException;

    int a(DownloadEntry downloadEntry, b bVar) throws RemoteException;

    int a(DownloadEntry downloadEntry, boolean z, String str, PendingIntent pendingIntent) throws RemoteException;

    int b(DownloadEntry downloadEntry) throws RemoteException;

    DownloadEntry b(DownloadEntry downloadEntry, b bVar) throws RemoteException;

    int c(DownloadEntry downloadEntry, b bVar) throws RemoteException;

    DownloadEntry c(DownloadEntry downloadEntry) throws RemoteException;

    /* compiled from: source */
    public static abstract class a extends Binder implements c {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public a() {
            attachInterface(this, "com.jumobile.manager.systemapp.service.IDownloadService");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.jumobile.manager.systemapp.service.IDownloadService");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.jumobile.manager.systemapp.service.IDownloadService");
                    int a = a(parcel.readInt() != 0 ? DownloadEntry.CREATOR.createFromParcel(parcel) : null, b.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(a);
                    return true;
                case 2:
                    parcel.enforceInterface("com.jumobile.manager.systemapp.service.IDownloadService");
                    DownloadEntry c = c(parcel.readInt() != 0 ? DownloadEntry.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (c != null) {
                        parcel2.writeInt(1);
                        c.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 3:
                    parcel.enforceInterface("com.jumobile.manager.systemapp.service.IDownloadService");
                    int a2 = a(parcel.readInt() != 0 ? DownloadEntry.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(a2);
                    return true;
                case 4:
                    parcel.enforceInterface("com.jumobile.manager.systemapp.service.IDownloadService");
                    int b = b(parcel.readInt() != 0 ? DownloadEntry.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(b);
                    return true;
                case 5:
                    parcel.enforceInterface("com.jumobile.manager.systemapp.service.IDownloadService");
                    DownloadEntry b2 = b(parcel.readInt() != 0 ? DownloadEntry.CREATOR.createFromParcel(parcel) : null, b.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    if (b2 != null) {
                        parcel2.writeInt(1);
                        b2.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 6:
                    parcel.enforceInterface("com.jumobile.manager.systemapp.service.IDownloadService");
                    int c2 = c(parcel.readInt() != 0 ? DownloadEntry.CREATOR.createFromParcel(parcel) : null, b.a.a(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(c2);
                    return true;
                case 7:
                    parcel.enforceInterface("com.jumobile.manager.systemapp.service.IDownloadService");
                    int a3 = a(parcel.readInt() != 0 ? DownloadEntry.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(a3);
                    return true;
                case 8:
                    parcel.enforceInterface("com.jumobile.manager.systemapp.service.IDownloadService");
                    int a4 = a(parcel.readInt() != 0 ? DownloadEntry.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(a4);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }
}
