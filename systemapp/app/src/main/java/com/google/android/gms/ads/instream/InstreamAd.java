package com.google.android.gms.ads.instream;

import com.google.android.gms.ads.LoadAdError;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class InstreamAd {

    /* compiled from: source */
    public static abstract class InstreamAdLoadCallback {
        @Deprecated
        public void a(int i) {
        }

        public void a(LoadAdError loadAdError) {
        }

        public void a(InstreamAd instreamAd) {
        }
    }

    protected abstract void a(InstreamAdView instreamAdView);
}
