package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzagn extends RemoteCreator<zzaeo> {
    @VisibleForTesting
    public zzagn() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    public final zzaen a(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        try {
            IBinder a = a(context).a(ObjectWrapper.a(context), ObjectWrapper.a(frameLayout), ObjectWrapper.a(frameLayout2), 203404000);
            if (a == null) {
                return null;
            }
            IInterface queryLocalInterface = a.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
            if (queryLocalInterface instanceof zzaen) {
                return (zzaen) queryLocalInterface;
            }
            return new zzaep(a);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzaza.d("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzaeo a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
        if (queryLocalInterface instanceof zzaeo) {
            return (zzaeo) queryLocalInterface;
        }
        return new zzaer(iBinder);
    }
}
