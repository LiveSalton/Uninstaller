package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzanm extends zzgw implements zzann {
    public zzanm() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzano zzanoVar = null;
        switch (i) {
            case 1:
                IObjectWrapper a = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                zzvn zzvnVar = (zzvn) zzgv.a(parcel, zzvn.CREATOR);
                zzvk zzvkVar = (zzvk) zzgv.a(parcel, zzvk.CREATOR);
                String readString = parcel.readString();
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface instanceof zzano) {
                        zzanoVar = (zzano) queryLocalInterface;
                    } else {
                        zzanoVar = new zzanq(readStrongBinder);
                    }
                }
                a(a, zzvnVar, zzvkVar, readString, zzanoVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IObjectWrapper a2 = a();
                parcel2.writeNoException();
                zzgv.a(parcel2, a2);
                return true;
            case 3:
                IObjectWrapper a3 = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                zzvk zzvkVar2 = (zzvk) zzgv.a(parcel, zzvk.CREATOR);
                String readString2 = parcel.readString();
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface2 instanceof zzano) {
                        zzanoVar = (zzano) queryLocalInterface2;
                    } else {
                        zzanoVar = new zzanq(readStrongBinder2);
                    }
                }
                a(a3, zzvkVar2, readString2, zzanoVar);
                parcel2.writeNoException();
                return true;
            case 4:
                b();
                parcel2.writeNoException();
                return true;
            case 5:
                c();
                parcel2.writeNoException();
                return true;
            case 6:
                IObjectWrapper a4 = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                zzvn zzvnVar2 = (zzvn) zzgv.a(parcel, zzvn.CREATOR);
                zzvk zzvkVar3 = (zzvk) zzgv.a(parcel, zzvk.CREATOR);
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface3 instanceof zzano) {
                        zzanoVar = (zzano) queryLocalInterface3;
                    } else {
                        zzanoVar = new zzanq(readStrongBinder3);
                    }
                }
                a(a4, zzvnVar2, zzvkVar3, readString3, readString4, zzanoVar);
                parcel2.writeNoException();
                return true;
            case 7:
                IObjectWrapper a5 = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                zzvk zzvkVar4 = (zzvk) zzgv.a(parcel, zzvk.CREATOR);
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface4 instanceof zzano) {
                        zzanoVar = (zzano) queryLocalInterface4;
                    } else {
                        zzanoVar = new zzanq(readStrongBinder4);
                    }
                }
                a(a5, zzvkVar4, readString5, readString6, zzanoVar);
                parcel2.writeNoException();
                return true;
            case 8:
                d();
                parcel2.writeNoException();
                return true;
            case 9:
                e();
                parcel2.writeNoException();
                return true;
            case 10:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()), (zzvk) zzgv.a(parcel, zzvk.CREATOR), parcel.readString(), zzauz.a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                a((zzvk) zzgv.a(parcel, zzvk.CREATOR), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 12:
                f();
                parcel2.writeNoException();
                return true;
            case 13:
                boolean g = g();
                parcel2.writeNoException();
                zzgv.a(parcel2, g);
                return true;
            case 14:
                IObjectWrapper a6 = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                zzvk zzvkVar5 = (zzvk) zzgv.a(parcel, zzvk.CREATOR);
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface5 instanceof zzano) {
                        zzanoVar = (zzano) queryLocalInterface5;
                    } else {
                        zzanoVar = new zzanq(readStrongBinder5);
                    }
                }
                a(a6, zzvkVar5, readString7, readString8, zzanoVar, (zzadz) zzgv.a(parcel, zzadz.CREATOR), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 15:
                zzanv h = h();
                parcel2.writeNoException();
                zzgv.a(parcel2, h);
                return true;
            case 16:
                zzanw i3 = i();
                parcel2.writeNoException();
                zzgv.a(parcel2, i3);
                return true;
            case 17:
                Bundle j = j();
                parcel2.writeNoException();
                zzgv.b(parcel2, j);
                return true;
            case 18:
                Bundle k = k();
                parcel2.writeNoException();
                zzgv.b(parcel2, k);
                return true;
            case 19:
                Bundle l = l();
                parcel2.writeNoException();
                zzgv.b(parcel2, l);
                return true;
            case 20:
                a((zzvk) zzgv.a(parcel, zzvk.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 21:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 22:
                boolean m = m();
                parcel2.writeNoException();
                zzgv.a(parcel2, m);
                return true;
            case 23:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()), zzauz.a(parcel.readStrongBinder()), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 24:
                zzaff n = n();
                parcel2.writeNoException();
                zzgv.a(parcel2, n);
                return true;
            case 25:
                a(zzgv.a(parcel));
                parcel2.writeNoException();
                return true;
            case 26:
                zzys o = o();
                parcel2.writeNoException();
                zzgv.a(parcel2, o);
                return true;
            case 27:
                zzaob p = p();
                parcel2.writeNoException();
                zzgv.a(parcel2, p);
                return true;
            case 28:
                IObjectWrapper a7 = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                zzvk zzvkVar6 = (zzvk) zzgv.a(parcel, zzvk.CREATOR);
                String readString9 = parcel.readString();
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface6 instanceof zzano) {
                        zzanoVar = (zzano) queryLocalInterface6;
                    } else {
                        zzanoVar = new zzanq(readStrongBinder6);
                    }
                }
                b(a7, zzvkVar6, readString9, zzanoVar);
                parcel2.writeNoException();
                return true;
            case 29:
            default:
                return false;
            case 30:
                b(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 31:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()), zzaja.a(parcel.readStrongBinder()), parcel.createTypedArrayList(zzajj.CREATOR));
                parcel2.writeNoException();
                return true;
            case 32:
                IObjectWrapper a8 = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                zzvk zzvkVar7 = (zzvk) zzgv.a(parcel, zzvk.CREATOR);
                String readString10 = parcel.readString();
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    if (queryLocalInterface7 instanceof zzano) {
                        zzanoVar = (zzano) queryLocalInterface7;
                    } else {
                        zzanoVar = new zzanq(readStrongBinder7);
                    }
                }
                c(a8, zzvkVar7, readString10, zzanoVar);
                parcel2.writeNoException();
                return true;
            case 33:
                zzaqc q = q();
                parcel2.writeNoException();
                zzgv.b(parcel2, q);
                return true;
            case 34:
                zzaqc r = r();
                parcel2.writeNoException();
                zzgv.b(parcel2, r);
                return true;
        }
    }
}
