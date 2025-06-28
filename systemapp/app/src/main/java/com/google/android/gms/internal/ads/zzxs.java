package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzxs extends zzgw implements zzxp {
    public zzxs() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzxg a = a(IObjectWrapper.Stub.a(parcel.readStrongBinder()), (zzvn) zzgv.a(parcel, zzvn.CREATOR), parcel.readString(), zzanl.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgv.a(parcel2, a);
                return true;
            case 2:
                zzxg b = b(IObjectWrapper.Stub.a(parcel.readStrongBinder()), (zzvn) zzgv.a(parcel, zzvn.CREATOR), parcel.readString(), zzanl.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgv.a(parcel2, b);
                return true;
            case 3:
                zzwz a2 = a(IObjectWrapper.Stub.a(parcel.readStrongBinder()), parcel.readString(), zzanl.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgv.a(parcel2, a2);
                return true;
            case 4:
                zzxw b2 = b(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgv.a(parcel2, b2);
                return true;
            case 5:
                zzaen a3 = a(IObjectWrapper.Stub.a(parcel.readStrongBinder()), IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgv.a(parcel2, a3);
                return true;
            case 6:
                zzaui a4 = a(IObjectWrapper.Stub.a(parcel.readStrongBinder()), zzanl.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgv.a(parcel2, a4);
                return true;
            case 7:
                zzaru c = c(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgv.a(parcel2, c);
                return true;
            case 8:
                zzarj a5 = a(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgv.a(parcel2, a5);
                return true;
            case 9:
                zzxw a6 = a(IObjectWrapper.Stub.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgv.a(parcel2, a6);
                return true;
            case 10:
                zzxg a7 = a(IObjectWrapper.Stub.a(parcel.readStrongBinder()), (zzvn) zzgv.a(parcel, zzvn.CREATOR), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                zzgv.a(parcel2, a7);
                return true;
            case 11:
                zzaeq a8 = a(IObjectWrapper.Stub.a(parcel.readStrongBinder()), IObjectWrapper.Stub.a(parcel.readStrongBinder()), IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgv.a(parcel2, a8);
                return true;
            case 12:
                zzavh b3 = b(IObjectWrapper.Stub.a(parcel.readStrongBinder()), parcel.readString(), zzanl.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgv.a(parcel2, b3);
                return true;
            case 13:
                zzxg c2 = c(IObjectWrapper.Stub.a(parcel.readStrongBinder()), (zzvn) zzgv.a(parcel, zzvn.CREATOR), parcel.readString(), zzanl.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgv.a(parcel2, c2);
                return true;
            case 14:
                zzaxq b4 = b(IObjectWrapper.Stub.a(parcel.readStrongBinder()), zzanl.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgv.a(parcel2, b4);
                return true;
            case 15:
                zzaqw c3 = c(IObjectWrapper.Stub.a(parcel.readStrongBinder()), zzanl.a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzgv.a(parcel2, c3);
                return true;
            default:
                return false;
        }
    }
}
