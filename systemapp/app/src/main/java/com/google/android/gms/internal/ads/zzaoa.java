package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzaoa extends zzgw implements zzaob {
    public zzaoa() {
        super("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    public static zzaob a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
        if (queryLocalInterface instanceof zzaob) {
            return (zzaob) queryLocalInterface;
        }
        return new zzaod(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                String a = a();
                parcel2.writeNoException();
                parcel2.writeString(a);
                return true;
            case 3:
                List b = b();
                parcel2.writeNoException();
                parcel2.writeList(b);
                return true;
            case 4:
                String c = c();
                parcel2.writeNoException();
                parcel2.writeString(c);
                return true;
            case 5:
                zzaej d = d();
                parcel2.writeNoException();
                zzgv.a(parcel2, d);
                return true;
            case 6:
                String e = e();
                parcel2.writeNoException();
                parcel2.writeString(e);
                return true;
            case 7:
                String f = f();
                parcel2.writeNoException();
                parcel2.writeString(f);
                return true;
            case 8:
                double g = g();
                parcel2.writeNoException();
                parcel2.writeDouble(g);
                return true;
            case 9:
                String h = h();
                parcel2.writeNoException();
                parcel2.writeString(h);
                return true;
            case 10:
                String i3 = i();
                parcel2.writeNoException();
                parcel2.writeString(i3);
                return true;
            case 11:
                zzys j = j();
                parcel2.writeNoException();
                zzgv.a(parcel2, j);
                return true;
            case 12:
                zzaeb k = k();
                parcel2.writeNoException();
                zzgv.a(parcel2, k);
                return true;
            case 13:
                IObjectWrapper l = l();
                parcel2.writeNoException();
                zzgv.a(parcel2, l);
                return true;
            case 14:
                IObjectWrapper m = m();
                parcel2.writeNoException();
                zzgv.a(parcel2, m);
                return true;
            case 15:
                IObjectWrapper n = n();
                parcel2.writeNoException();
                zzgv.a(parcel2, n);
                return true;
            case 16:
                Bundle o = o();
                parcel2.writeNoException();
                zzgv.b(parcel2, o);
                return true;
            case 17:
                boolean p = p();
                parcel2.writeNoException();
                zzgv.a(parcel2, p);
                return true;
            case 18:
                boolean q = q();
                parcel2.writeNoException();
                zzgv.a(parcel2, q);
                return true;
            case 19:
                r();
                parcel2.writeNoException();
                return true;
            case 20:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 21:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()), IObjectWrapper.Stub.a(parcel.readStrongBinder()), IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 22:
                b(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 23:
                float s = s();
                parcel2.writeNoException();
                parcel2.writeFloat(s);
                return true;
            case 24:
                float t = t();
                parcel2.writeNoException();
                parcel2.writeFloat(t);
                return true;
            case 25:
                float u = u();
                parcel2.writeNoException();
                parcel2.writeFloat(u);
                return true;
            default:
                return false;
        }
    }
}
