package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzdsd extends zzgw implements zzdse {
    public static zzdse a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.omid.IOmid");
        if (queryLocalInterface instanceof zzdse) {
            return (zzdse) queryLocalInterface;
        }
        return new zzdsf(iBinder);
    }
}
