package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzara extends zzgw implements zzarb {
    public static zzarb a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtilsCreator");
        if (queryLocalInterface instanceof zzarb) {
            return (zzarb) queryLocalInterface;
        }
        return new zzarc(iBinder);
    }
}
