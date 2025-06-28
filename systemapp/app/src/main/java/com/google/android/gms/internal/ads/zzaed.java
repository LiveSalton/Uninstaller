package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaed extends zzgu implements zzaeb {
    zzaed(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final String a() throws RemoteException {
        Parcel a = a(2, y());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final List<zzaej> b() throws RemoteException {
        Parcel a = a(3, y());
        ArrayList b = zzgv.b(a);
        a.recycle();
        return b;
    }
}
