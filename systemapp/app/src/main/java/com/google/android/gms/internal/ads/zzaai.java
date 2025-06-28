package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.formats.ShouldDelayBannerRenderingListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaai extends zzagc {
    private final ShouldDelayBannerRenderingListener a;

    @Override // com.google.android.gms.internal.ads.zzagd
    public final boolean a(IObjectWrapper iObjectWrapper) throws RemoteException {
        return this.a.shouldDelayBannerRendering((Runnable) ObjectWrapper.a(iObjectWrapper));
    }
}
