package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzsr extends AppOpenAd {
    private final zzsg a;

    public zzsr(zzsg zzsgVar) {
        this.a = zzsgVar;
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final void a(Activity activity, FullScreenContentCallback fullScreenContentCallback) {
        try {
            this.a.a(ObjectWrapper.a(activity), new zzsh(fullScreenContentCallback));
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    protected final zzxg a() {
        try {
            return this.a.a();
        } catch (RemoteException e) {
            zzaza.c("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    protected final void a(zzsm zzsmVar) {
        try {
            this.a.a(zzsmVar);
        } catch (RemoteException e) {
            zzaza.c("", e);
        }
    }
}
