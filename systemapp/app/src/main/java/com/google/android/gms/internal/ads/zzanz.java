package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzanz extends zzgw implements zzanw {
    public zzanz() {
        super("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
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
                g();
                parcel2.writeNoException();
                return true;
            case 9:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 10:
                b(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 11:
                boolean h = h();
                parcel2.writeNoException();
                zzgv.a(parcel2, h);
                return true;
            case 12:
                boolean i3 = i();
                parcel2.writeNoException();
                zzgv.a(parcel2, i3);
                return true;
            case 13:
                Bundle j = j();
                parcel2.writeNoException();
                zzgv.b(parcel2, j);
                return true;
            case 14:
                c(IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                IObjectWrapper k = k();
                parcel2.writeNoException();
                zzgv.a(parcel2, k);
                return true;
            case 16:
                zzys l = l();
                parcel2.writeNoException();
                zzgv.a(parcel2, l);
                return true;
            case 17:
            case 18:
            default:
                return false;
            case 19:
                zzaeb m = m();
                parcel2.writeNoException();
                zzgv.a(parcel2, m);
                return true;
            case 20:
                IObjectWrapper n = n();
                parcel2.writeNoException();
                zzgv.a(parcel2, n);
                return true;
            case 21:
                IObjectWrapper o = o();
                parcel2.writeNoException();
                zzgv.a(parcel2, o);
                return true;
            case 22:
                a(IObjectWrapper.Stub.a(parcel.readStrongBinder()), IObjectWrapper.Stub.a(parcel.readStrongBinder()), IObjectWrapper.Stub.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
        }
    }
}
