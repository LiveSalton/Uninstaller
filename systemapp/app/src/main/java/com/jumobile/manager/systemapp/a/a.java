package com.jumobile.manager.systemapp.a;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.jumobile.manager.systemapp.R;

/* compiled from: source */
/* loaded from: classes.dex */
public class a extends b {
    private static final String f = "a";
    private AdView g;
    private InterstitialAd h;
    private RewardedAd i;
    private UnifiedNativeAd j;

    @Override // com.jumobile.manager.systemapp.a.b
    protected void a() {
        super.a();
    }

    @Override // com.jumobile.manager.systemapp.a.b
    protected void b() {
        super.b();
        this.g = new AdView(this.a);
        this.g.setAdSize(w());
        this.g.setAdUnitId("ca-app-pub-4899137311407535/9488691339");
        this.b.addView(this.g, new FrameLayout.LayoutParams(-1, -2));
        Bundle bundle = new Bundle();
        if (this.d) {
            bundle.putString("npa", "1");
        }
        this.g.a(new AdRequest.Builder().a(AdMobAdapter.class, bundle).a());
        this.g.setAdListener(new AdListener() { // from class: com.jumobile.manager.systemapp.a.a.1
            AnonymousClass1() {
            }

            @Override // com.google.android.gms.ads.AdListener
            public void a() {
                a.this.b.setVisibility(0);
            }
        });
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.a.a$1 */
    class AnonymousClass1 extends AdListener {
        AnonymousClass1() {
        }

        @Override // com.google.android.gms.ads.AdListener
        public void a() {
            a.this.b.setVisibility(0);
        }
    }

    @Override // com.jumobile.manager.systemapp.a.b
    protected void c() {
        super.c();
        this.h = new InterstitialAd(this.a);
        this.h.a("ca-app-pub-4899137311407535/5409845522");
        Bundle bundle = new Bundle();
        if (this.d) {
            bundle.putString("npa", "1");
        }
        this.h.a(new AdRequest.Builder().a(AdMobAdapter.class, bundle).a());
        this.h.a(new AdListener() { // from class: com.jumobile.manager.systemapp.a.a.2
            @Override // com.google.android.gms.ads.AdListener
            public void a() {
            }

            AnonymousClass2() {
            }
        });
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.a.a$2 */
    class AnonymousClass2 extends AdListener {
        @Override // com.google.android.gms.ads.AdListener
        public void a() {
        }

        AnonymousClass2() {
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.a.a$3 */
    class AnonymousClass3 extends RewardedAdLoadCallback {
        @Override // com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
        public void a() {
        }

        @Override // com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
        public void a(LoadAdError loadAdError) {
        }

        AnonymousClass3() {
        }
    }

    @Override // com.jumobile.manager.systemapp.a.b
    protected void d() {
        this.i = new RewardedAd(this.a, "ca-app-pub-4899137311407535/2352151938");
        AnonymousClass3 anonymousClass3 = new RewardedAdLoadCallback() { // from class: com.jumobile.manager.systemapp.a.a.3
            @Override // com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
            public void a() {
            }

            @Override // com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
            public void a(LoadAdError loadAdError) {
            }

            AnonymousClass3() {
            }
        };
        Bundle bundle = new Bundle();
        if (this.d) {
            bundle.putString("npa", "1");
        }
        this.i.a(new AdRequest.Builder().a(AdMobAdapter.class, bundle).a(), anonymousClass3);
    }

    private void a(UnifiedNativeAd unifiedNativeAd, UnifiedNativeAdView unifiedNativeAdView) {
        VideoController j = unifiedNativeAd.j();
        j.a(new VideoController.VideoLifecycleCallbacks() { // from class: com.jumobile.manager.systemapp.a.a.4
            AnonymousClass4() {
            }

            @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
            public void d() {
                super.d();
            }
        });
        MediaView mediaView = (MediaView) unifiedNativeAdView.findViewById(R.id.ad_media);
        ImageView imageView = (ImageView) unifiedNativeAdView.findViewById(R.id.ad_image);
        if (j.b()) {
            unifiedNativeAdView.setMediaView(mediaView);
            imageView.setVisibility(8);
        } else {
            unifiedNativeAdView.setImageView(imageView);
            mediaView.setVisibility(8);
            imageView.setImageDrawable(unifiedNativeAd.b().get(0).a());
        }
        unifiedNativeAdView.setHeadlineView(unifiedNativeAdView.findViewById(R.id.ad_headline));
        unifiedNativeAdView.setBodyView(unifiedNativeAdView.findViewById(R.id.ad_body));
        unifiedNativeAdView.setCallToActionView(unifiedNativeAdView.findViewById(R.id.ad_call_to_action));
        unifiedNativeAdView.setIconView(unifiedNativeAdView.findViewById(R.id.ad_app_icon));
        unifiedNativeAdView.setPriceView(unifiedNativeAdView.findViewById(R.id.ad_price));
        unifiedNativeAdView.setStarRatingView(unifiedNativeAdView.findViewById(R.id.ad_stars));
        unifiedNativeAdView.setStoreView(unifiedNativeAdView.findViewById(R.id.ad_store));
        unifiedNativeAdView.setAdvertiserView(unifiedNativeAdView.findViewById(R.id.ad_advertiser));
        ((TextView) unifiedNativeAdView.getHeadlineView()).setText(unifiedNativeAd.a());
        ((TextView) unifiedNativeAdView.getBodyView()).setText(unifiedNativeAd.c());
        ((Button) unifiedNativeAdView.getCallToActionView()).setText(unifiedNativeAd.e());
        if (unifiedNativeAd.d() == null) {
            unifiedNativeAdView.getIconView().setVisibility(8);
        } else {
            ((ImageView) unifiedNativeAdView.getIconView()).setImageDrawable(unifiedNativeAd.d().a());
            unifiedNativeAdView.getIconView().setVisibility(0);
        }
        if (unifiedNativeAd.i() == null) {
            unifiedNativeAdView.getPriceView().setVisibility(4);
        } else {
            unifiedNativeAdView.getPriceView().setVisibility(0);
            ((TextView) unifiedNativeAdView.getPriceView()).setText(unifiedNativeAd.i());
        }
        if (unifiedNativeAd.h() == null) {
            unifiedNativeAdView.getStoreView().setVisibility(4);
        } else {
            unifiedNativeAdView.getStoreView().setVisibility(0);
            ((TextView) unifiedNativeAdView.getStoreView()).setText(unifiedNativeAd.h());
        }
        if (unifiedNativeAd.g() == null) {
            unifiedNativeAdView.getStarRatingView().setVisibility(4);
        } else {
            ((RatingBar) unifiedNativeAdView.getStarRatingView()).setRating(unifiedNativeAd.g().floatValue());
            unifiedNativeAdView.getStarRatingView().setVisibility(0);
        }
        if (unifiedNativeAd.f() == null) {
            unifiedNativeAdView.getAdvertiserView().setVisibility(4);
        } else {
            ((TextView) unifiedNativeAdView.getAdvertiserView()).setText(unifiedNativeAd.f());
            unifiedNativeAdView.getAdvertiserView().setVisibility(0);
        }
        unifiedNativeAdView.setNativeAd(unifiedNativeAd);
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.a.a$4 */
    class AnonymousClass4 extends VideoController.VideoLifecycleCallbacks {
        AnonymousClass4() {
        }

        @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
        public void d() {
            super.d();
        }
    }

    @Override // com.jumobile.manager.systemapp.a.b
    protected void e() {
        AdLoader.Builder builder = new AdLoader.Builder(this.a, "ca-app-pub-4899137311407535/3693153762");
        builder.a(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() { // from class: com.jumobile.manager.systemapp.a.a.5
            AnonymousClass5() {
            }

            @Override // com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener
            public void a(UnifiedNativeAd unifiedNativeAd) {
                Log.d(a.f, "onUnifiedNativeAdLoaded");
                if (a.this.a == null) {
                    return;
                }
                a.this.j = unifiedNativeAd;
                if (a.this.e != null) {
                    a.this.e.a();
                }
            }
        });
        builder.a(new NativeAdOptions.Builder().a(new VideoOptions.Builder().a(true).a()).a());
        AdLoader a = builder.a(new AdListener() { // from class: com.jumobile.manager.systemapp.a.a.6
            AnonymousClass6() {
            }

            @Override // com.google.android.gms.ads.AdListener
            public void a(int i) {
                Log.d(a.f, "Failed to load native ad: " + i);
            }
        }).a();
        Bundle bundle = new Bundle();
        if (this.d) {
            bundle.putString("npa", "1");
        }
        a.a(new AdRequest.Builder().a(AdMobAdapter.class, bundle).a());
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.a.a$5 */
    class AnonymousClass5 implements UnifiedNativeAd.OnUnifiedNativeAdLoadedListener {
        AnonymousClass5() {
        }

        @Override // com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener
        public void a(UnifiedNativeAd unifiedNativeAd) {
            Log.d(a.f, "onUnifiedNativeAdLoaded");
            if (a.this.a == null) {
                return;
            }
            a.this.j = unifiedNativeAd;
            if (a.this.e != null) {
                a.this.e.a();
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.jumobile.manager.systemapp.a.a$6 */
    class AnonymousClass6 extends AdListener {
        AnonymousClass6() {
        }

        @Override // com.google.android.gms.ads.AdListener
        public void a(int i) {
            Log.d(a.f, "Failed to load native ad: " + i);
        }
    }

    @Override // com.jumobile.manager.systemapp.a.b
    public boolean f() {
        if (!com.jumobile.manager.systemapp.a.b.booleanValue() || this.h == null || !this.h.a()) {
            return false;
        }
        this.h.b();
        com.jumobile.manager.systemapp.a.b = false;
        return true;
    }

    @Override // com.jumobile.manager.systemapp.a.b
    public View a(int i, boolean z) {
        if (this.j == null || this.a == null) {
            return null;
        }
        UnifiedNativeAdView unifiedNativeAdView = (UnifiedNativeAdView) this.a.getLayoutInflater().inflate(R.layout.ad_unified, (ViewGroup) null);
        a(this.j, unifiedNativeAdView);
        this.j = null;
        if (!com.jumobile.manager.systemapp.f.a.a(this.a.getApplicationContext(), "ads_enabled", true) || !z) {
            return unifiedNativeAdView;
        }
        e();
        return unifiedNativeAdView;
    }

    @Override // com.jumobile.manager.systemapp.a.b
    protected void g() {
        if (this.g != null) {
            this.g.c();
        }
        super.g();
    }

    @Override // com.jumobile.manager.systemapp.a.b
    public void h() {
        super.h();
        com.jumobile.manager.systemapp.a.b = false;
        if (this.b != null) {
            this.b.setVisibility(8);
        }
    }

    private AdSize w() {
        Display defaultDisplay = this.a.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return AdSize.a(this.a, (int) (displayMetrics.widthPixels / displayMetrics.density));
    }
}
