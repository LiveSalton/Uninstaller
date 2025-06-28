package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class UnifiedNativeAd {

    /* compiled from: source */
    public interface OnUnifiedNativeAdLoadedListener {
        void a(UnifiedNativeAd unifiedNativeAd);
    }

    /* compiled from: source */
    public interface UnconfirmedClickListener {
        void a();

        void a(String str);
    }

    public abstract String a();

    public abstract List<NativeAd.Image> b();

    public abstract String c();

    public abstract NativeAd.Image d();

    public abstract String e();

    public abstract String f();

    public abstract Double g();

    public abstract String h();

    public abstract String i();

    @Deprecated
    public abstract VideoController j();

    protected abstract Object k();

    public abstract Object l();
}
