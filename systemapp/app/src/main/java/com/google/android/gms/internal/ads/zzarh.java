package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzarh extends RemoteCreator<zzark> {
    public zzarh() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public final zzarj a(Activity activity) {
        try {
            IBinder a = a((Context) activity).a(ObjectWrapper.a(activity));
            if (a == null) {
                return null;
            }
            IInterface queryLocalInterface = a.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            if (queryLocalInterface instanceof zzarj) {
                return (zzarj) queryLocalInterface;
            }
            return new zzarl(a);
        } catch (RemoteException e) {
            zzaza.d("Could not create remote AdOverlay.", e);
            return null;
        } catch (RemoteCreator.RemoteCreatorException e2) {
            zzaza.d("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzark a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        if (queryLocalInterface instanceof zzark) {
            return (zzark) queryLocalInterface;
        }
        return new zzarn(iBinder);
    }
}
