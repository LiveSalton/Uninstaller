package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;

/* compiled from: source */
/* loaded from: classes.dex */
final class aa implements Runnable {
    private final /* synthetic */ PublisherAdView a;
    private final /* synthetic */ zzxg b;
    private final /* synthetic */ zzagv c;

    aa(zzagv zzagvVar, PublisherAdView publisherAdView, zzxg zzxgVar) {
        this.c = zzagvVar;
        this.a = publisherAdView;
        this.b = zzxgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener;
        if (!this.a.a(this.b)) {
            zzaza.e("Could not bind.");
        } else {
            onPublisherAdViewLoadedListener = this.c.a;
            onPublisherAdViewLoadedListener.a(this.a);
        }
    }
}
