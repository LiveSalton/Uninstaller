package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzarx extends zzgw implements zzaru {
    public static zzaru a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
        if (queryLocalInterface instanceof zzaru) {
            return (zzaru) queryLocalInterface;
        }
        return new zzarw(iBinder);
    }
}
