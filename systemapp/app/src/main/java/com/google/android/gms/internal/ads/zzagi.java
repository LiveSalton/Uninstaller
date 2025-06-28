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
public abstract class zzagi extends zzgw implements zzagj {
    public zzagi() {
        super("com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzage zzaggVar;
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
                String k = k();
                parcel2.writeNoException();
                parcel2.writeString(k);
                return true;
            case 13:
                l();
                parcel2.writeNoException();
                return true;
            case 14:
                zzaeb m = m();
                parcel2.writeNoException();
                zzgv.a(parcel2, m);
                return true;
            case 15:
                a((Bundle) zzgv.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 16:
                boolean b2 = b((Bundle) zzgv.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzgv.a(parcel2, b2);
                return true;
            case 17:
                c((Bundle) zzgv.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 18:
                IObjectWrapper n = n();
                parcel2.writeNoException();
                zzgv.a(parcel2, n);
                return true;
            case 19:
                IObjectWrapper o = o();
                parcel2.writeNoException();
                zzgv.a(parcel2, o);
                return true;
            case 20:
                Bundle p = p();
                parcel2.writeNoException();
                zzgv.b(parcel2, p);
                return true;
            case 21:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzaggVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
                    if (queryLocalInterface instanceof zzage) {
                        zzaggVar = (zzage) queryLocalInterface;
                    } else {
                        zzaggVar = new zzagg(readStrongBinder);
                    }
                }
                a(zzaggVar);
                parcel2.writeNoException();
                return true;
            case 22:
                q();
                parcel2.writeNoException();
                return true;
            case 23:
                List r = r();
                parcel2.writeNoException();
                parcel2.writeList(r);
                return true;
            case 24:
                boolean s = s();
                parcel2.writeNoException();
                zzgv.a(parcel2, s);
                return true;
            case 25:
                a(zzyg.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 26:
                a(zzyc.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 27:
                t();
                parcel2.writeNoException();
                return true;
            case 28:
                u();
                parcel2.writeNoException();
                return true;
            case 29:
                zzaee v = v();
                parcel2.writeNoException();
                zzgv.a(parcel2, v);
                return true;
            case 30:
                boolean w = w();
                parcel2.writeNoException();
                zzgv.a(parcel2, w);
                return true;
            case 31:
                zzyn x = x();
                parcel2.writeNoException();
                zzgv.a(parcel2, x);
                return true;
            case 32:
                a(zzyl.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
