package com.jumobile.manager.systemapp.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public interface b extends IInterface {
    void a(DownloadEntry downloadEntry) throws RemoteException;

    void a(DownloadEntry downloadEntry, int i) throws RemoteException;

    void b(DownloadEntry downloadEntry) throws RemoteException;

    /* compiled from: source */
    public static abstract class a extends Binder implements b {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.jumobile.manager.systemapp.service.IDownloadClient");
            if (queryLocalInterface != null && (queryLocalInterface instanceof b)) {
                return (b) queryLocalInterface;
            }
            return new C0093a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.jumobile.manager.systemapp.service.IDownloadClient");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.jumobile.manager.systemapp.service.IDownloadClient");
                    a(parcel.readInt() != 0 ? DownloadEntry.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.jumobile.manager.systemapp.service.IDownloadClient");
                    b(parcel.readInt() != 0 ? DownloadEntry.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.jumobile.manager.systemapp.service.IDownloadClient");
                    a(parcel.readInt() != 0 ? DownloadEntry.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* compiled from: source */
        /* renamed from: com.jumobile.manager.systemapp.service.b$a$a */
        private static class C0093a implements b {
            private IBinder a;

            C0093a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // com.jumobile.manager.systemapp.service.b
            public void a(DownloadEntry downloadEntry) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.jumobile.manager.systemapp.service.IDownloadClient");
                    if (downloadEntry != null) {
                        obtain.writeInt(1);
                        downloadEntry.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.jumobile.manager.systemapp.service.b
            public void b(DownloadEntry downloadEntry) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.jumobile.manager.systemapp.service.IDownloadClient");
                    if (downloadEntry != null) {
                        obtain.writeInt(1);
                        downloadEntry.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.jumobile.manager.systemapp.service.b
            public void a(DownloadEntry downloadEntry, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.jumobile.manager.systemapp.service.IDownloadClient");
                    if (downloadEntry != null) {
                        obtain.writeInt(1);
                        downloadEntry.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
