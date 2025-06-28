package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdsf extends zzgu implements zzdse {
    zzdsf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.omid.IOmid");
    }

    @Override // com.google.android.gms.internal.ads.zzdse
    public final boolean a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        Parcel a = a(2, y);
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzdse
    public final void b(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(4, y);
    }

    @Override // com.google.android.gms.internal.ads.zzdse
    public final void a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, iObjectWrapper2);
        b(5, y);
    }

    @Override // com.google.android.gms.internal.ads.zzdse
    public final String a() throws RemoteException {
        Parcel a = a(6, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzdse
    public final void c(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(7, y);
    }

    @Override // com.google.android.gms.internal.ads.zzdse
    public final void b(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        zzgv.a(y, iObjectWrapper2);
        b(8, y);
    }

    @Override // com.google.android.gms.internal.ads.zzdse
    public final IObjectWrapper a(String str, IObjectWrapper iObjectWrapper, String str2, String str3, String str4, String str5) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        zzgv.a(y, iObjectWrapper);
        y.writeString(str2);
        y.writeString(str3);
        y.writeString(str4);
        y.writeString(str5);
        Parcel a = a(9, y);
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzdse
    public final IObjectWrapper a(String str, IObjectWrapper iObjectWrapper, String str2, String str3, String str4, String str5, String str6, String str7, String str8) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        zzgv.a(y, iObjectWrapper);
        y.writeString(str2);
        y.writeString(str3);
        y.writeString(str4);
        y.writeString(str5);
        y.writeString(str6);
        y.writeString(str7);
        y.writeString(str8);
        Parcel a = a(10, y);
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzdse
    public final IObjectWrapper b(String str, IObjectWrapper iObjectWrapper, String str2, String str3, String str4, String str5, String str6, String str7, String str8) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        zzgv.a(y, iObjectWrapper);
        y.writeString(str2);
        y.writeString(str3);
        y.writeString(str4);
        y.writeString(str5);
        y.writeString(str6);
        y.writeString(str7);
        y.writeString(str8);
        Parcel a = a(11, y);
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
