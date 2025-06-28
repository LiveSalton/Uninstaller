package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzars extends zzgw implements zzart {
    public static zzart a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
        if (queryLocalInterface instanceof zzart) {
            return (zzart) queryLocalInterface;
        }
        return new zzarv(iBinder);
    }
}
