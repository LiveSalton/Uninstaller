package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzasc extends zzgu implements zzasa {
    zzasc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.query.IUpdateUrlsCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzasa
    public final void a(List<Uri> list) throws RemoteException {
        Parcel y = y();
        y.writeTypedList(list);
        b(1, y);
    }

    @Override // com.google.android.gms.internal.ads.zzasa
    public final void a(String str) throws RemoteException {
        Parcel y = y();
        y.writeString(str);
        b(2, y);
    }
}
