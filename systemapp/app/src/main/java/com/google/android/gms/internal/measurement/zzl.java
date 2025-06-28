package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzl extends zzc implements zzm {
    public zzl() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static zzm a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        if (queryLocalInterface instanceof zzm) {
            return (zzm) queryLocalInterface;
        }
        return new zzo(iBinder);
    }

    @Override // com.google.android.gms.internal.measurement.zzc
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzn zznVar = null;
        zzn zznVar2 = null;
        zzn zznVar3 = null;
        zzs zzsVar = null;
        zzs zzsVar2 = null;
        zzs zzsVar3 = null;
        zzn zznVar4 = null;
        zzn zznVar5 = null;
        zzn zznVar6 = null;
        zzn zznVar7 = null;
        zzn zznVar8 = null;
        zzn zznVar9 = null;
        zzt zztVar = null;
        zzn zznVar10 = null;
        zzn zznVar11 = null;
        zzn zznVar12 = null;
        zzn zznVar13 = null;
        zzn zznVar14 = null;
        switch (i) {
            case 1:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()), (zzv) zzb.a(parcel, zzv.CREATOR), parcel.readLong());
                break;
            case 2:
                a(parcel.readString(), parcel.readString(), (Bundle) zzb.a(parcel, Bundle.CREATOR), zzb.a(parcel), zzb.a(parcel), parcel.readLong());
                break;
            case 3:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                Bundle bundle = (Bundle) zzb.a(parcel, Bundle.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface instanceof zzn) {
                        zznVar = (zzn) queryLocalInterface;
                    } else {
                        zznVar = new zzp(readStrongBinder);
                    }
                }
                a(readString, readString2, bundle, zznVar, parcel.readLong());
                break;
            case 4:
                a(parcel.readString(), parcel.readString(), IObjectWrapper.Stub.a(parcel.readStrongBinder()), zzb.a(parcel), parcel.readLong());
                break;
            case 5:
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                boolean a = zzb.a(parcel);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface2 instanceof zzn) {
                        zznVar14 = (zzn) queryLocalInterface2;
                    } else {
                        zznVar14 = new zzp(readStrongBinder2);
                    }
                }
                a(readString3, readString4, a, zznVar14);
                break;
            case 6:
                String readString5 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface3 instanceof zzn) {
                        zznVar13 = (zzn) queryLocalInterface3;
                    } else {
                        zznVar13 = new zzp(readStrongBinder3);
                    }
                }
                a(readString5, zznVar13);
                break;
            case 7:
                a(parcel.readString(), parcel.readLong());
                break;
            case 8:
                a((Bundle) zzb.a(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 9:
                a(parcel.readString(), parcel.readString(), (Bundle) zzb.a(parcel, Bundle.CREATOR));
                break;
            case 10:
                String readString6 = parcel.readString();
                String readString7 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface4 instanceof zzn) {
                        zznVar12 = (zzn) queryLocalInterface4;
                    } else {
                        zznVar12 = new zzp(readStrongBinder4);
                    }
                }
                a(readString6, readString7, zznVar12);
                break;
            case 11:
                a(zzb.a(parcel), parcel.readLong());
                break;
            case 12:
                a(parcel.readLong());
                break;
            case 13:
                b(parcel.readLong());
                break;
            case 14:
                c(parcel.readLong());
                break;
            case 15:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readLong());
                break;
            case 16:
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface5 instanceof zzn) {
                        zznVar11 = (zzn) queryLocalInterface5;
                    } else {
                        zznVar11 = new zzp(readStrongBinder5);
                    }
                }
                a(zznVar11);
                break;
            case 17:
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface6 instanceof zzn) {
                        zznVar10 = (zzn) queryLocalInterface6;
                    } else {
                        zznVar10 = new zzp(readStrongBinder6);
                    }
                }
                b(zznVar10);
                break;
            case 18:
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    if (queryLocalInterface7 instanceof zzt) {
                        zztVar = (zzt) queryLocalInterface7;
                    } else {
                        zztVar = new zzw(readStrongBinder7);
                    }
                }
                a(zztVar);
                break;
            case 19:
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface8 instanceof zzn) {
                        zznVar9 = (zzn) queryLocalInterface8;
                    } else {
                        zznVar9 = new zzp(readStrongBinder8);
                    }
                }
                c(zznVar9);
                break;
            case 20:
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                if (readStrongBinder9 != null) {
                    IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface9 instanceof zzn) {
                        zznVar8 = (zzn) queryLocalInterface9;
                    } else {
                        zznVar8 = new zzp(readStrongBinder9);
                    }
                }
                d(zznVar8);
                break;
            case 21:
                IBinder readStrongBinder10 = parcel.readStrongBinder();
                if (readStrongBinder10 != null) {
                    IInterface queryLocalInterface10 = readStrongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface10 instanceof zzn) {
                        zznVar7 = (zzn) queryLocalInterface10;
                    } else {
                        zznVar7 = new zzp(readStrongBinder10);
                    }
                }
                e(zznVar7);
                break;
            case 22:
                IBinder readStrongBinder11 = parcel.readStrongBinder();
                if (readStrongBinder11 != null) {
                    IInterface queryLocalInterface11 = readStrongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface11 instanceof zzn) {
                        zznVar6 = (zzn) queryLocalInterface11;
                    } else {
                        zznVar6 = new zzp(readStrongBinder11);
                    }
                }
                f(zznVar6);
                break;
            case 23:
                b(parcel.readString(), parcel.readLong());
                break;
            case 24:
                c(parcel.readString(), parcel.readLong());
                break;
            case 25:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 26:
                b(IObjectWrapper.Stub.a(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 27:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()), (Bundle) zzb.a(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 28:
                c(IObjectWrapper.Stub.a(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 29:
                d(IObjectWrapper.Stub.a(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 30:
                e(IObjectWrapper.Stub.a(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 31:
                IObjectWrapper a2 = IObjectWrapper.Stub.a(parcel.readStrongBinder());
                IBinder readStrongBinder12 = parcel.readStrongBinder();
                if (readStrongBinder12 != null) {
                    IInterface queryLocalInterface12 = readStrongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface12 instanceof zzn) {
                        zznVar5 = (zzn) queryLocalInterface12;
                    } else {
                        zznVar5 = new zzp(readStrongBinder12);
                    }
                }
                a(a2, zznVar5, parcel.readLong());
                break;
            case 32:
                Bundle bundle2 = (Bundle) zzb.a(parcel, Bundle.CREATOR);
                IBinder readStrongBinder13 = parcel.readStrongBinder();
                if (readStrongBinder13 != null) {
                    IInterface queryLocalInterface13 = readStrongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface13 instanceof zzn) {
                        zznVar4 = (zzn) queryLocalInterface13;
                    } else {
                        zznVar4 = new zzp(readStrongBinder13);
                    }
                }
                a(bundle2, zznVar4, parcel.readLong());
                break;
            case 33:
                a(parcel.readInt(), parcel.readString(), IObjectWrapper.Stub.a(parcel.readStrongBinder()), IObjectWrapper.Stub.a(parcel.readStrongBinder()), IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                break;
            case 34:
                IBinder readStrongBinder14 = parcel.readStrongBinder();
                if (readStrongBinder14 != null) {
                    IInterface queryLocalInterface14 = readStrongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface14 instanceof zzs) {
                        zzsVar3 = (zzs) queryLocalInterface14;
                    } else {
                        zzsVar3 = new zzu(readStrongBinder14);
                    }
                }
                a(zzsVar3);
                break;
            case 35:
                IBinder readStrongBinder15 = parcel.readStrongBinder();
                if (readStrongBinder15 != null) {
                    IInterface queryLocalInterface15 = readStrongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface15 instanceof zzs) {
                        zzsVar2 = (zzs) queryLocalInterface15;
                    } else {
                        zzsVar2 = new zzu(readStrongBinder15);
                    }
                }
                b(zzsVar2);
                break;
            case 36:
                IBinder readStrongBinder16 = parcel.readStrongBinder();
                if (readStrongBinder16 != null) {
                    IInterface queryLocalInterface16 = readStrongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface16 instanceof zzs) {
                        zzsVar = (zzs) queryLocalInterface16;
                    } else {
                        zzsVar = new zzu(readStrongBinder16);
                    }
                }
                c(zzsVar);
                break;
            case 37:
                a(zzb.b(parcel));
                break;
            case 38:
                IBinder readStrongBinder17 = parcel.readStrongBinder();
                if (readStrongBinder17 != null) {
                    IInterface queryLocalInterface17 = readStrongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface17 instanceof zzn) {
                        zznVar3 = (zzn) queryLocalInterface17;
                    } else {
                        zznVar3 = new zzp(readStrongBinder17);
                    }
                }
                a(zznVar3, parcel.readInt());
                break;
            case 39:
                a(zzb.a(parcel));
                break;
            case 40:
                IBinder readStrongBinder18 = parcel.readStrongBinder();
                if (readStrongBinder18 != null) {
                    IInterface queryLocalInterface18 = readStrongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface18 instanceof zzn) {
                        zznVar2 = (zzn) queryLocalInterface18;
                    } else {
                        zznVar2 = new zzp(readStrongBinder18);
                    }
                }
                g(zznVar2);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
