package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzxr extends zzgu implements zzxp {
    zzxr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzxg a(IObjectWrapper iObjectWrapper, zzvn zzvnVar, String str, zzani zzaniVar, int i) throws RemoteException {
        zzxg zzxiVar;
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzvnVar);
        y.writeString(str);
        zzgv.a(y, zzaniVar);
        y.writeInt(i);
        Parcel a = a(1, y);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzxiVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzxg) {
                zzxiVar = (zzxg) queryLocalInterface;
            } else {
                zzxiVar = new zzxi(readStrongBinder);
            }
        }
        a.recycle();
        return zzxiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzxg b(IObjectWrapper iObjectWrapper, zzvn zzvnVar, String str, zzani zzaniVar, int i) throws RemoteException {
        zzxg zzxiVar;
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzvnVar);
        y.writeString(str);
        zzgv.a(y, zzaniVar);
        y.writeInt(i);
        Parcel a = a(2, y);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzxiVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzxg) {
                zzxiVar = (zzxg) queryLocalInterface;
            } else {
                zzxiVar = new zzxi(readStrongBinder);
            }
        }
        a.recycle();
        return zzxiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzwz a(IObjectWrapper iObjectWrapper, String str, zzani zzaniVar, int i) throws RemoteException {
        zzwz zzxbVar;
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        y.writeString(str);
        zzgv.a(y, zzaniVar);
        y.writeInt(i);
        Parcel a = a(3, y);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzxbVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzwz) {
                zzxbVar = (zzwz) queryLocalInterface;
            } else {
                zzxbVar = new zzxb(readStrongBinder);
            }
        }
        a.recycle();
        return zzxbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzxw b(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzxw zzxyVar;
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        Parcel a = a(4, y);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzxyVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzxw) {
                zzxyVar = (zzxw) queryLocalInterface;
            } else {
                zzxyVar = new zzxy(readStrongBinder);
            }
        }
        a.recycle();
        return zzxyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzaen a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, iObjectWrapper2);
        Parcel a = a(5, y);
        zzaen a2 = zzaem.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzaui a(IObjectWrapper iObjectWrapper, zzani zzaniVar, int i) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzaniVar);
        y.writeInt(i);
        Parcel a = a(6, y);
        zzaui a2 = zzaul.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzaru c(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        Parcel a = a(7, y);
        zzaru a2 = zzarx.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzarj a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        Parcel a = a(8, y);
        zzarj a2 = zzari.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzxw a(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzxw zzxyVar;
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        y.writeInt(i);
        Parcel a = a(9, y);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzxyVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzxw) {
                zzxyVar = (zzxw) queryLocalInterface;
            } else {
                zzxyVar = new zzxy(readStrongBinder);
            }
        }
        a.recycle();
        return zzxyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzxg a(IObjectWrapper iObjectWrapper, zzvn zzvnVar, String str, int i) throws RemoteException {
        zzxg zzxiVar;
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzvnVar);
        y.writeString(str);
        y.writeInt(i);
        Parcel a = a(10, y);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzxiVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzxg) {
                zzxiVar = (zzxg) queryLocalInterface;
            } else {
                zzxiVar = new zzxi(readStrongBinder);
            }
        }
        a.recycle();
        return zzxiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzaeq a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, iObjectWrapper2);
        zzgv.a(y, iObjectWrapper3);
        Parcel a = a(11, y);
        zzaeq a2 = zzaet.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzavh b(IObjectWrapper iObjectWrapper, String str, zzani zzaniVar, int i) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        y.writeString(str);
        zzgv.a(y, zzaniVar);
        y.writeInt(i);
        Parcel a = a(12, y);
        zzavh a2 = zzavg.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzxg c(IObjectWrapper iObjectWrapper, zzvn zzvnVar, String str, zzani zzaniVar, int i) throws RemoteException {
        zzxg zzxiVar;
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzvnVar);
        y.writeString(str);
        zzgv.a(y, zzaniVar);
        y.writeInt(i);
        Parcel a = a(13, y);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzxiVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzxg) {
                zzxiVar = (zzxg) queryLocalInterface;
            } else {
                zzxiVar = new zzxi(readStrongBinder);
            }
        }
        a.recycle();
        return zzxiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzaxq b(IObjectWrapper iObjectWrapper, zzani zzaniVar, int i) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzaniVar);
        y.writeInt(i);
        Parcel a = a(14, y);
        zzaxq a2 = zzaxt.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzaqw c(IObjectWrapper iObjectWrapper, zzani zzaniVar, int i) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, zzaniVar);
        y.writeInt(i);
        Parcel a = a(15, y);
        zzaqw a2 = zzaqz.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
