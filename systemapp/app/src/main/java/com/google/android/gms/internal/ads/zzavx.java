package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzavx {
    public static zzavh a(Context context, String str, zzani zzaniVar) {
        try {
            IBinder a = ((zzavn) zzazd.a(context, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", ea.a)).a(ObjectWrapper.a(context), str, zzaniVar, 203404000);
            if (a == null) {
                return null;
            }
            IInterface queryLocalInterface = a.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            return queryLocalInterface instanceof zzavh ? (zzavh) queryLocalInterface : new zzavj(a);
        } catch (RemoteException | zzazf e) {
            zzaza.e("#007 Could not call remote method.", e);
            return null;
        }
    }
}
