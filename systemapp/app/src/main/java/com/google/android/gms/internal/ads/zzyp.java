package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzyp extends zzgu implements zzyn {
    zzyp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IResponseInfo");
    }

    @Override // com.google.android.gms.internal.ads.zzyn
    public final String a() throws RemoteException {
        Parcel a = a(1, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzyn
    public final String b() throws RemoteException {
        Parcel a = a(2, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzyn
    public final List<zzvr> c() throws RemoteException {
        Parcel a = a(3, y());
        ArrayList createTypedArrayList = a.createTypedArrayList(zzvr.CREATOR);
        a.recycle();
        return createTypedArrayList;
    }
}
