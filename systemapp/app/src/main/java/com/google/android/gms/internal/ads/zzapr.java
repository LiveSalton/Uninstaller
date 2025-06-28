package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzapr extends zzgw implements zzapo {
    public zzapr() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzapo a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        if (queryLocalInterface instanceof zzapo) {
            return (zzapo) queryLocalInterface;
        }
        return new zzapq(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzapt zzaptVar = null;
        zzapn zzappVar = null;
        zzapi zzapkVar = null;
        zzapn zzappVar2 = null;
        zzaph zzapjVar = null;
        zzapc zzapeVar = null;
        switch (i) {
            case 1:
                IObjectWrapper a = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                String readString = parcel.readString();
                Bundle bundle = (Bundle) zzgv.a(parcel, Bundle.CREATOR);
                Bundle bundle2 = (Bundle) zzgv.a(parcel, Bundle.CREATOR);
                zzvn zzvnVar = (zzvn) zzgv.a(parcel, zzvn.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
                    if (queryLocalInterface instanceof zzapt) {
                        zzaptVar = (zzapt) queryLocalInterface;
                    } else {
                        zzaptVar = new zzapv(readStrongBinder);
                    }
                }
                a(a, readString, bundle, bundle2, zzvnVar, zzaptVar);
                parcel2.writeNoException();
                return true;
            case 2:
                zzaqc a2 = a();
                parcel2.writeNoException();
                zzgv.b(parcel2, a2);
                return true;
            case 3:
                zzaqc b = b();
                parcel2.writeNoException();
                zzgv.b(parcel2, b);
                return true;
            case 4:
            case 6:
            case 7:
            case 8:
            case 9:
            case 12:
            default:
                return false;
            case 5:
                zzys c = c();
                parcel2.writeNoException();
                zzgv.a(parcel2, c);
                return true;
            case 10:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
                a(parcel.createStringArray(), (Bundle[]) parcel.createTypedArray(Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                zzvk zzvkVar = (zzvk) zzgv.a(parcel, zzvk.CREATOR);
                IObjectWrapper a3 = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                    if (queryLocalInterface2 instanceof zzapc) {
                        zzapeVar = (zzapc) queryLocalInterface2;
                    } else {
                        zzapeVar = new zzape(readStrongBinder2);
                    }
                }
                a(readString2, readString3, zzvkVar, a3, zzapeVar, zzanr.a(parcel.readStrongBinder()), (zzvn) zzgv.a(parcel, zzvn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                zzvk zzvkVar2 = (zzvk) zzgv.a(parcel, zzvk.CREATOR);
                IObjectWrapper a4 = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
                    if (queryLocalInterface3 instanceof zzaph) {
                        zzapjVar = (zzaph) queryLocalInterface3;
                    } else {
                        zzapjVar = new zzapj(readStrongBinder3);
                    }
                }
                a(readString4, readString5, zzvkVar2, a4, zzapjVar, zzanr.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                boolean b2 = b(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgv.a(parcel2, b2);
                return true;
            case 16:
                String readString6 = parcel.readString();
                String readString7 = parcel.readString();
                zzvk zzvkVar3 = (zzvk) zzgv.a(parcel, zzvk.CREATOR);
                IObjectWrapper a5 = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                    if (queryLocalInterface4 instanceof zzapn) {
                        zzappVar2 = (zzapn) queryLocalInterface4;
                    } else {
                        zzappVar2 = new zzapp(readStrongBinder4);
                    }
                }
                a(readString6, readString7, zzvkVar3, a5, zzappVar2, zzanr.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 17:
                boolean c2 = c(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzgv.a(parcel2, c2);
                return true;
            case 18:
                String readString8 = parcel.readString();
                String readString9 = parcel.readString();
                zzvk zzvkVar4 = (zzvk) zzgv.a(parcel, zzvk.CREATOR);
                IObjectWrapper a6 = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                    if (queryLocalInterface5 instanceof zzapi) {
                        zzapkVar = (zzapi) queryLocalInterface5;
                    } else {
                        zzapkVar = new zzapk(readStrongBinder5);
                    }
                }
                a(readString8, readString9, zzvkVar4, a6, zzapkVar, zzanr.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 19:
                a(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 20:
                String readString10 = parcel.readString();
                String readString11 = parcel.readString();
                zzvk zzvkVar5 = (zzvk) zzgv.a(parcel, zzvk.CREATOR);
                IObjectWrapper a7 = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                    if (queryLocalInterface6 instanceof zzapn) {
                        zzappVar = (zzapn) queryLocalInterface6;
                    } else {
                        zzappVar = new zzapp(readStrongBinder6);
                    }
                }
                b(readString10, readString11, zzvkVar5, a7, zzappVar, zzanr.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
        }
    }
}
