package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaut extends RemoteCreator<zzaun> {
    public zzaut() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    public final zzaui a(Context context, zzani zzaniVar) {
        try {
            IBinder a = a(context).a(ObjectWrapper.a(context), zzaniVar, 203404000);
            if (a == null) {
                return null;
            }
            IInterface queryLocalInterface = a.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
            if (queryLocalInterface instanceof zzaui) {
                return (zzaui) queryLocalInterface;
            }
            return new zzauk(a);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzaza.d("Could not get remote RewardedVideoAd.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzaun a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
        if (queryLocalInterface instanceof zzaun) {
            return (zzaun) queryLocalInterface;
        }
        return new zzaum(iBinder);
    }
}
