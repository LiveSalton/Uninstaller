package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzanr extends zzgw implements zzano {
    public zzanr() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public static zzano a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        if (queryLocalInterface instanceof zzano) {
            return (zzano) queryLocalInterface;
        }
        return new zzanq(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzant zzansVar;
        switch (i) {
            case 1:
                a();
                break;
            case 2:
                b();
                break;
            case 3:
                a(parcel.readInt());
                break;
            case 4:
                c();
                break;
            case 5:
                d();
                break;
            case 6:
                e();
                break;
            case 7:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzansVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
                    if (queryLocalInterface instanceof zzant) {
                        zzansVar = (zzant) queryLocalInterface;
                    } else {
                        zzansVar = new zzans(readStrongBinder);
                    }
                }
                a(zzansVar);
                break;
            case 8:
                f();
                break;
            case 9:
                a(parcel.readString(), parcel.readString());
                break;
            case 10:
                a(zzafe.a(parcel.readStrongBinder()), parcel.readString());
                break;
            case 11:
                g();
                break;
            case 12:
                a(parcel.readString());
                break;
            case 13:
                h();
                break;
            case 14:
                a((zzava) zzgv.a(parcel, zzava.CREATOR));
                break;
            case 15:
                i();
                break;
            case 16:
                a(zzavf.a(parcel.readStrongBinder()));
                break;
            case 17:
                b(parcel.readInt());
                break;
            case 18:
                j();
                break;
            case 19:
                a((Bundle) zzgv.a(parcel, Bundle.CREATOR));
                break;
            case 20:
                k();
                break;
            case 21:
                b(parcel.readString());
                break;
            case 22:
                a(parcel.readInt(), parcel.readString());
                break;
            case 23:
                a((zzve) zzgv.a(parcel, zzve.CREATOR));
                break;
            case 24:
                b((zzve) zzgv.a(parcel, zzve.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
