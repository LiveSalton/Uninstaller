package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaje extends zzgu implements zzajc {
    zzaje(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzajc
    public final void a(List<zzaiz> list) throws RemoteException {
        Parcel y = y();
        y.writeTypedList(list);
        b(1, y);
    }
}
