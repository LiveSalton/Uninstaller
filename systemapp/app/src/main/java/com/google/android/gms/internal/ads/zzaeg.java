package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaeg extends zzgu implements zzaee {
    zzaeg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final float a() throws RemoteException {
        Parcel a = a(2, y());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final void a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, iObjectWrapper);
        b(3, y);
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final IObjectWrapper b() throws RemoteException {
        Parcel a = a(4, y());
        IObjectWrapper a2 = IObjectWrapper.Stub.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final float c() throws RemoteException {
        Parcel a = a(5, y());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final float d() throws RemoteException {
        Parcel a = a(6, y());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final zzys e() throws RemoteException {
        Parcel a = a(7, y());
        zzys a2 = zzyr.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final boolean f() throws RemoteException {
        Parcel a = a(8, y());
        boolean a2 = zzgv.a(a);
        a.recycle();
        return a2;
    }

    @Override // com.google.android.gms.internal.ads.zzaee
    public final void a(zzafv zzafvVar) throws RemoteException {
        Parcel y = y();
        zzgv.a(y, zzafvVar);
        b(9, y);
    }
}
