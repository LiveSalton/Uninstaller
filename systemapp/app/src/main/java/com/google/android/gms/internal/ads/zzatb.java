package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzatb extends zzgw implements zzasy {
    public zzatb() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzatd zzatdVar = null;
        zzatf zzatfVar = null;
        zzatf zzatfVar2 = null;
        zzatf zzatfVar3 = null;
        zzatf zzatfVar4 = null;
        switch (i) {
            case 1:
                zzasu a = a((zzass) zzgv.a(parcel, zzass.CREATOR));
                parcel2.writeNoException();
                zzgv.b(parcel2, a);
                return true;
            case 2:
                zzass zzassVar = (zzass) zzgv.a(parcel, zzass.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    if (queryLocalInterface instanceof zzatd) {
                        zzatdVar = (zzatd) queryLocalInterface;
                    } else {
                        zzatdVar = new zzatc(readStrongBinder);
                    }
                }
                a(zzassVar, zzatdVar);
                parcel2.writeNoException();
                return true;
            case 3:
            default:
                return false;
            case 4:
                zzatl zzatlVar = (zzatl) zzgv.a(parcel, zzatl.CREATOR);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (queryLocalInterface2 instanceof zzatf) {
                        zzatfVar4 = (zzatf) queryLocalInterface2;
                    } else {
                        zzatfVar4 = new zzath(readStrongBinder2);
                    }
                }
                a(zzatlVar, zzatfVar4);
                parcel2.writeNoException();
                return true;
            case 5:
                zzatl zzatlVar2 = (zzatl) zzgv.a(parcel, zzatl.CREATOR);
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (queryLocalInterface3 instanceof zzatf) {
                        zzatfVar3 = (zzatf) queryLocalInterface3;
                    } else {
                        zzatfVar3 = new zzath(readStrongBinder3);
                    }
                }
                b(zzatlVar2, zzatfVar3);
                parcel2.writeNoException();
                return true;
            case 6:
                zzatl zzatlVar3 = (zzatl) zzgv.a(parcel, zzatl.CREATOR);
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (queryLocalInterface4 instanceof zzatf) {
                        zzatfVar2 = (zzatf) queryLocalInterface4;
                    } else {
                        zzatfVar2 = new zzath(readStrongBinder4);
                    }
                }
                c(zzatlVar3, zzatfVar2);
                parcel2.writeNoException();
                return true;
            case 7:
                String readString = parcel.readString();
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    if (queryLocalInterface5 instanceof zzatf) {
                        zzatfVar = (zzatf) queryLocalInterface5;
                    } else {
                        zzatfVar = new zzath(readStrongBinder5);
                    }
                }
                a(readString, zzatfVar);
                parcel2.writeNoException();
                return true;
        }
    }
}
