package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzzp extends RemoteCreator<zzxx> {
    public zzzp() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    public final zzxw b(Context context) {
        try {
            IBinder a = a(context).a(ObjectWrapper.a(context), 203404000);
            if (a == null) {
                return null;
            }
            IInterface queryLocalInterface = a.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzxw) {
                return (zzxw) queryLocalInterface;
            }
            return new zzxy(a);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzaza.d("Could not get remote MobileAdsSettingManager.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzxx a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
        if (queryLocalInterface instanceof zzxx) {
            return (zzxx) queryLocalInterface;
        }
        return new zzya(iBinder);
    }
}
