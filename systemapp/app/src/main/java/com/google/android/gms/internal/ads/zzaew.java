package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzaew extends zzgw implements zzaex {
    public zzaew() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                IObjectWrapper a = a();
                parcel2.writeNoException();
                zzgv.a(parcel2, a);
                return true;
            case 3:
                String b = b();
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            case 4:
                List c = c();
                parcel2.writeNoException();
                parcel2.writeList(c);
                return true;
            case 5:
                String d = d();
                parcel2.writeNoException();
                parcel2.writeString(d);
                return true;
            case 6:
                zzaej e = e();
                parcel2.writeNoException();
                zzgv.a(parcel2, e);
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
                Bundle j = j();
                parcel2.writeNoException();
                zzgv.b(parcel2, j);
                return true;
            case 12:
                k();
                parcel2.writeNoException();
                return true;
            case 13:
                zzys l = l();
                parcel2.writeNoException();
                zzgv.a(parcel2, l);
                return true;
            case 14:
                a((Bundle) zzgv.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 15:
                boolean b2 = b((Bundle) zzgv.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzgv.a(parcel2, b2);
                return true;
            case 16:
                c((Bundle) zzgv.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 17:
                zzaeb m = m();
                parcel2.writeNoException();
                zzgv.a(parcel2, m);
                return true;
            case 18:
                IObjectWrapper n = n();
                parcel2.writeNoException();
                zzgv.a(parcel2, n);
                return true;
            case 19:
                String o = o();
                parcel2.writeNoException();
                parcel2.writeString(o);
                return true;
            default:
                return false;
        }
    }
}
