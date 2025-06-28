package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzbgg extends zzgw implements zzbgh {
    public static zzbgh a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.measurement.IMeasurementManager");
        if (queryLocalInterface instanceof zzbgh) {
            return (zzbgh) queryLocalInterface;
        }
        return new zzbgi(iBinder);
    }
}
