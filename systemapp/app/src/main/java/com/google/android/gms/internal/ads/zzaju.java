package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.instream.InstreamAd;
import com.google.android.gms.ads.instream.InstreamAdView;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaju extends InstreamAd {
    private final zzajn a;
    private VideoController b = a();
    private MediaContent c = b();

    public zzaju(zzajn zzajnVar) {
        this.a = zzajnVar;
    }

    @Override // com.google.android.gms.ads.instream.InstreamAd
    public final void a(InstreamAdView instreamAdView) {
        if (instreamAdView == null) {
            zzaza.c("showInView: parameter view must not be null.");
            return;
        }
        try {
            this.a.a(ObjectWrapper.a(instreamAdView));
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    private final VideoController a() {
        VideoController videoController = new VideoController();
        try {
            videoController.a(this.a.b());
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
        return videoController;
    }

    private final MediaContent b() {
        try {
            if (this.a.d() != null) {
                return new zzzm(this.a.d());
            }
            return null;
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
            return null;
        }
    }
}
