package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzxy extends zzgu implements zzxw {
    zzxy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void a() throws RemoteException {
        b(1, y());
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void a(float f) throws RemoteException {
        Parcel y = y();
        y.writeFloat(f);
        b(2, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void a(String str) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        b(3, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void a(boolean z) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, z);
        b(4, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void a(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        y.writeString(str);
        b(5, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void a(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        zzgv.a(y, iObjectWrapper);
        b(6, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final float b() throws RemoteException {
        Parcel a = a(7, y());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final boolean c() throws RemoteException {
        Parcel a = a(8, y());
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final String d() throws RemoteException {
        Parcel a = a(9, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void b(String str) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        b(10, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void a(zzani zzaniVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzaniVar);
        b(11, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void a(zzajc zzajcVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzajcVar);
        b(12, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final List<zzaiz> e() throws RemoteException {
        Parcel a = a(13, y());
        ArrayList createTypedArrayList = a.createTypedArrayList(zzaiz.CREATOR);
        a.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void a(zzaae zzaaeVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzaaeVar);
        b(14, y);
    }

    @Override // com.google.android.gms.internal.ads.zzxw
    public final void f() throws RemoteException {
        b(15, y());
    }
}
