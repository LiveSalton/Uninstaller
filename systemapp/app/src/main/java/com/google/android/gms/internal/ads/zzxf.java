package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzxf extends zzgw implements zzxg {
    public zzxf() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzxg a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        if (queryLocalInterface instanceof zzxg) {
            return (zzxg) queryLocalInterface;
        }
        return new zzxi(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzwt zzwtVar = null;
        zzym zzymVar = null;
        zzxj zzxjVar = null;
        zzxu zzxuVar = null;
        zzws zzwsVar = null;
        zzxo zzxoVar = null;
        switch (i) {
            case 1:
                IObjectWrapper a = a();
                parcel2.writeNoException();
                zzgv.a(parcel2, a);
                return true;
            case 2:
                b();
                parcel2.writeNoException();
                return true;
            case 3:
                boolean c = c();
                parcel2.writeNoException();
                zzgv.a(parcel2, c);
                return true;
            case 4:
                boolean a2 = a((zzvk) zzgv.a(parcel, zzvk.CREATOR));
                parcel2.writeNoException();
                zzgv.a(parcel2, a2);
                return true;
            case 5:
                d();
                parcel2.writeNoException();
                return true;
            case 6:
                e();
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    if (queryLocalInterface instanceof zzwt) {
                        zzwtVar = (zzwt) queryLocalInterface;
                    } else {
                        zzwtVar = new zzwv(readStrongBinder);
                    }
                }
                a(zzwtVar);
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
                    if (queryLocalInterface2 instanceof zzxo) {
                        zzxoVar = (zzxo) queryLocalInterface2;
                    } else {
                        zzxoVar = new zzxq(readStrongBinder2);
                    }
                }
                a(zzxoVar);
                parcel2.writeNoException();
                return true;
            case 9:
                g();
                parcel2.writeNoException();
                return true;
            case 10:
                h();
                parcel2.writeNoException();
                return true;
            case 11:
                i();
                parcel2.writeNoException();
                return true;
            case 12:
                zzvn j = j();
                parcel2.writeNoException();
                zzgv.b(parcel2, j);
                return true;
            case 13:
                a((zzvn) zzgv.a(parcel, zzvn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                a(zzars.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                a(zzary.a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 16:
            case 17:
            case 27:
            case 28:
            default:
                return false;
            case 18:
                String k = k();
                parcel2.writeNoException();
                parcel2.writeString(k);
                return true;
            case 19:
                a(zzaca.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 20:
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
                    if (queryLocalInterface3 instanceof zzws) {
                        zzwsVar = (zzws) queryLocalInterface3;
                    } else {
                        zzwsVar = new zzwu(readStrongBinder3);
                    }
                }
                a(zzwsVar);
                parcel2.writeNoException();
                return true;
            case 21:
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    if (queryLocalInterface4 instanceof zzxu) {
                        zzxuVar = (zzxu) queryLocalInterface4;
                    } else {
                        zzxuVar = new zzxt(readStrongBinder4);
                    }
                }
                a(zzxuVar);
                parcel2.writeNoException();
                return true;
            case 22:
                a(zzgv.a(parcel));
                parcel2.writeNoException();
                return true;
            case 23:
                boolean q = q();
                parcel2.writeNoException();
                zzgv.a(parcel2, q);
                return true;
            case 24:
                a(zzauo.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 25:
                a(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 26:
                zzys r = r();
                parcel2.writeNoException();
                zzgv.a(parcel2, r);
                return true;
            case 29:
                a((zzaak) zzgv.a(parcel, zzaak.CREATOR));
                parcel2.writeNoException();
                return true;
            case 30:
                a((zzyy) zzgv.a(parcel, zzyy.CREATOR));
                parcel2.writeNoException();
                return true;
            case 31:
                String n = n();
                parcel2.writeNoException();
                parcel2.writeString(n);
                return true;
            case 32:
                zzxo o = o();
                parcel2.writeNoException();
                zzgv.a(parcel2, o);
                return true;
            case 33:
                zzwt p = p();
                parcel2.writeNoException();
                zzgv.a(parcel2, p);
                return true;
            case 34:
                b(zzgv.a(parcel));
                parcel2.writeNoException();
                return true;
            case 35:
                String l = l();
                parcel2.writeNoException();
                parcel2.writeString(l);
                return true;
            case 36:
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
                    if (queryLocalInterface5 instanceof zzxj) {
                        zzxjVar = (zzxj) queryLocalInterface5;
                    } else {
                        zzxjVar = new zzxl(readStrongBinder5);
                    }
                }
                a(zzxjVar);
                parcel2.writeNoException();
                return true;
            case 37:
                Bundle f = f();
                parcel2.writeNoException();
                zzgv.b(parcel2, f);
                return true;
            case 38:
                b(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 39:
                a((zzvw) zzgv.a(parcel, zzvw.CREATOR));
                parcel2.writeNoException();
                return true;
            case 40:
                a(zzsk.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 41:
                zzyn m = m();
                parcel2.writeNoException();
                zzgv.a(parcel2, m);
                return true;
            case 42:
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
                    if (queryLocalInterface6 instanceof zzym) {
                        zzymVar = (zzym) queryLocalInterface6;
                    } else {
                        zzymVar = new zzyo(readStrongBinder6);
                    }
                }
                a(zzymVar);
                parcel2.writeNoException();
                return true;
        }
    }
}
