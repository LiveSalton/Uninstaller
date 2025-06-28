package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzha extends zzgw implements zzgy {
    public static zzgy a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.clearcut.IClearcut");
        if (queryLocalInterface instanceof zzgy) {
            return (zzgy) queryLocalInterface;
        }
        return new zzgz(iBinder);
    }
}
