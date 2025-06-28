package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzafa extends zzgw implements zzafb {
    public zzafa() {
        super("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
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
                String g = g();
                parcel2.writeNoException();
                parcel2.writeString(g);
                return true;
            case 9:
                Bundle h = h();
                parcel2.writeNoException();
                zzgv.b(parcel2, h);
                return true;
            case 10:
                i();
                parcel2.writeNoException();
                return true;
            case 11:
                zzys j = j();
                parcel2.writeNoException();
                zzgv.a(parcel2, j);
                return true;
            case 12:
                a((Bundle) zzgv.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                boolean b2 = b((Bundle) zzgv.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzgv.a(parcel2, b2);
                return true;
            case 14:
                c((Bundle) zzgv.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 15:
                zzaeb k = k();
                parcel2.writeNoException();
                zzgv.a(parcel2, k);
                return true;
            case 16:
                IObjectWrapper l = l();
                parcel2.writeNoException();
                zzgv.a(parcel2, l);
                return true;
            case 17:
                String m = m();
                parcel2.writeNoException();
                parcel2.writeString(m);
                return true;
            default:
                return false;
        }
    }
}
