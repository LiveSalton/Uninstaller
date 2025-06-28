package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.a;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzaza;

/* compiled from: source */
@KeepName
/* loaded from: classes.dex */
public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, d>, MediationInterstitialAdapter<CustomEventExtras, d> {
    private View a;

    @VisibleForTesting
    private CustomEventBanner b;

    @VisibleForTesting
    private CustomEventInterstitial c;

    /* compiled from: source */
    @VisibleForTesting
    static final class a implements com.google.ads.mediation.customevent.b {
        private final CustomEventAdapter a;
        private final com.google.ads.mediation.c b;

        public a(CustomEventAdapter customEventAdapter, com.google.ads.mediation.c cVar) {
            this.a = customEventAdapter;
            this.b = cVar;
        }
    }

    /* compiled from: source */
    @VisibleForTesting
    class b implements c {
        private final CustomEventAdapter a;
        private final com.google.ads.mediation.d b;

        public b(CustomEventAdapter customEventAdapter, com.google.ads.mediation.d dVar) {
            this.a = customEventAdapter;
            this.b = dVar;
        }
    }

    private static <T> T a(String str) {
        try {
            return (T) Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(46 + String.valueOf(str).length() + String.valueOf(message).length());
            sb.append("Could not instantiate custom event adapter: ");
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzaza.e(sb.toString());
            return null;
        }
    }

    @Override // com.google.ads.mediation.b
    public final void destroy() {
        if (this.b != null) {
            this.b.a();
        }
        if (this.c != null) {
            this.c.a();
        }
    }

    @Override // com.google.ads.mediation.b
    public final Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    @Override // com.google.ads.mediation.MediationBannerAdapter
    public final View getBannerView() {
        return this.a;
    }

    @Override // com.google.ads.mediation.b
    public final Class<d> getServerParametersType() {
        return d.class;
    }

    @Override // com.google.ads.mediation.MediationBannerAdapter
    public final void requestBannerAd(com.google.ads.mediation.c cVar, Activity activity, d dVar, com.google.ads.b bVar, com.google.ads.mediation.a aVar, CustomEventExtras customEventExtras) {
        this.b = (CustomEventBanner) a(dVar.b);
        if (this.b == null) {
            cVar.a(this, a.EnumC0056a.INTERNAL_ERROR);
        } else {
            this.b.requestBannerAd(new a(this, cVar), activity, dVar.a, dVar.c, bVar, aVar, customEventExtras == null ? null : customEventExtras.a(dVar.a));
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(com.google.ads.mediation.d dVar, Activity activity, d dVar2, com.google.ads.mediation.a aVar, CustomEventExtras customEventExtras) {
        this.c = (CustomEventInterstitial) a(dVar2.b);
        if (this.c == null) {
            dVar.a(this, a.EnumC0056a.INTERNAL_ERROR);
        } else {
            this.c.requestInterstitialAd(new b(this, dVar), activity, dVar2.a, dVar2.c, aVar, customEventExtras == null ? null : customEventExtras.a(dVar2.a));
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        this.c.showInterstitial();
    }
}
