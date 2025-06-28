package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

/* compiled from: source */
@Deprecated
/* loaded from: classes.dex */
public abstract class NativeAppInstallAd extends NativeAd {

    /* compiled from: source */
    public interface OnAppInstallAdLoadedListener {
        void a(NativeAppInstallAd nativeAppInstallAd);
    }

    public abstract CharSequence b();

    public abstract List<NativeAd.Image> c();

    public abstract CharSequence d();

    public abstract NativeAd.Image e();

    public abstract CharSequence f();

    public abstract Double g();

    public abstract CharSequence h();

    public abstract CharSequence i();

    public abstract VideoController j();
}
