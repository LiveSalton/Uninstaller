package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public interface IAccountAccessor extends IInterface {

    /* compiled from: source */
    public static abstract class Stub extends com.google.android.gms.internal.common.zza implements IAccountAccessor {
        public Stub() {
            super("com.google.android.gms.common.internal.IAccountAccessor");
        }

        /* compiled from: source */
        public static class zza extends com.google.android.gms.internal.common.zzb implements IAccountAccessor {
            zza(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            @Override // com.google.android.gms.common.internal.IAccountAccessor
            public final Account a() throws RemoteException {
                Parcel a = a(2, s());
                Account account = (Account) com.google.android.gms.internal.common.zzd.a(a, Account.CREATOR);
                a.recycle();
                return account;
            }
        }

        public static IAccountAccessor a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if (queryLocalInterface instanceof IAccountAccessor) {
                return (IAccountAccessor) queryLocalInterface;
            }
            return new zza(iBinder);
        }

        @Override // com.google.android.gms.internal.common.zza
        protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 2) {
                return false;
            }
            Account a = a();
            parcel2.writeNoException();
            com.google.android.gms.internal.common.zzd.b(parcel2, a);
            return true;
        }
    }

    Account a() throws RemoteException;
}
