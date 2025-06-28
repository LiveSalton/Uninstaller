package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaby extends zzgu implements zzabw {
    zzaby(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzabw
    public final String a() throws RemoteException {
        Parcel a = a(1, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzabw
    public final String b() throws RemoteException {
        Parcel a = a(2, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzabw
    public final void a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(3, y);
    }

    @Override // com.google.android.gms.internal.ads.zzabw
    public final void c() throws RemoteException {
        b(4, y());
    }

    @Override // com.google.android.gms.internal.ads.zzabw
    public final void d() throws RemoteException {
        b(5, y());
    }
}
