package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzagm extends RemoteCreator<zzaev> {
    @VisibleForTesting
    public zzagm() {
        super("com.google.android.gms.ads.NativeAdViewHolderDelegateCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzaev a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator");
        if (queryLocalInterface instanceof zzaev) {
            return (zzaev) queryLocalInterface;
        }
        return new zzaeu(iBinder);
    }
}
