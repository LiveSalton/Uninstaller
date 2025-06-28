package com.google.android.gms.internal.ads;

import android.app.Activity;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.zzp;

/* compiled from: source */
/* loaded from: classes.dex */
final class dj implements Runnable {
    private final /* synthetic */ AdOverlayInfoParcel a;
    private final /* synthetic */ zzaqe b;

    dj(zzaqe zzaqeVar, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.b = zzaqeVar;
        this.a = adOverlayInfoParcel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Activity activity;
        zzp.b();
        activity = this.b.a;
        zzo.a(activity, this.a, true);
    }
}
