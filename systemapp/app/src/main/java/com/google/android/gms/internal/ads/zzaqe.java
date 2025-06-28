package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.c;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.PlatformVersion;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaqe implements MediationInterstitialAdapter {
    private Activity a;
    private MediationInterstitialListener b;
    private Uri c;

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.b = mediationInterstitialListener;
        if (this.b == null) {
            zzaza.e("Listener not set for mediation. Returning.");
            return;
        }
        if (!(context instanceof Activity)) {
            zzaza.e("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.b.a(this, 0);
            return;
        }
        if (!(PlatformVersion.a() && zzacf.a(context))) {
            zzaza.e("Default browser does not support custom tabs. Bailing out.");
            this.b.a(this, 0);
            return;
        }
        String string = bundle.getString("tab_url");
        if (TextUtils.isEmpty(string)) {
            zzaza.e("The tab_url retrieved from mediation metadata is empty. Bailing out.");
            this.b.a(this, 0);
        } else {
            this.a = (Activity) context;
            this.c = Uri.parse(string);
            this.b.a(this);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        androidx.browser.customtabs.c a = new c.a().a();
        a.a.setData(this.c);
        com.google.android.gms.ads.internal.util.zzm.a.post(new dj(this, new AdOverlayInfoParcel(new com.google.android.gms.ads.internal.overlay.zzb(a.a), null, new dk(this), null, new zzazh(0, 0, false))));
        zzp.g().c();
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onDestroy() {
        zzaza.b("Destroying AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onPause() {
        zzaza.b("Pausing AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onResume() {
        zzaza.b("Resuming AdMobCustomTabsAdapter adapter.");
    }
}
