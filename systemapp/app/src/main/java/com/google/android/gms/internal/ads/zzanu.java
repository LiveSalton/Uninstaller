package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzanu extends zzgw implements zzanv {
    public zzanu() {
        super("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
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
                double f = f();
                parcel2.writeNoException();
                parcel2.writeDouble(f);
                return true;
            case 8:
                String g = g();
                parcel2.writeNoException();
                parcel2.writeString(g);
                return true;
            case 9:
                String h = h();
                parcel2.writeNoException();
                parcel2.writeString(h);
                return true;
            case 10:
                i();
                parcel2.writeNoException();
                return true;
            case 11:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 12:
                b(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 13:
                boolean j = j();
                parcel2.writeNoException();
                zzgv.a(parcel2, j);
                return true;
            case 14:
                boolean k = k();
                parcel2.writeNoException();
                zzgv.a(parcel2, k);
                return true;
            case 15:
                Bundle l = l();
                parcel2.writeNoException();
                zzgv.b(parcel2, l);
                return true;
            case 16:
                c(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 17:
                zzys m = m();
                parcel2.writeNoException();
                zzgv.a(parcel2, m);
                return true;
            case 18:
                IObjectWrapper n = n();
                parcel2.writeNoException();
                zzgv.a(parcel2, n);
                return true;
            case 19:
                zzaeb o = o();
                parcel2.writeNoException();
                zzgv.a(parcel2, o);
                return true;
            case 20:
                IObjectWrapper p = p();
                parcel2.writeNoException();
                zzgv.a(parcel2, p);
                return true;
            case 21:
                IObjectWrapper q = q();
                parcel2.writeNoException();
                zzgv.a(parcel2, q);
                return true;
            case 22:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()), IObjectWrapper.Stub.a(parcel.readStrongBinder()), IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
