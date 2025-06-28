package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAdViewHolder;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzayr;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzbgj;
import com.google.android.gms.internal.ads.zzva;
import com.google.android.gms.internal.ads.zzwq;
import com.google.android.gms.internal.ads.zzys;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class AbstractAdViewAdapter implements com.google.android.gms.ads.mediation.MediationBannerAdapter, MediationNativeAdapter, OnImmersiveModeUpdatedListener, zza, MediationRewardedVideoAdAdapter, zzbgj {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    private AdView a;
    private InterstitialAd b;
    private AdLoader c;
    private Context d;
    private InterstitialAd e;
    private MediationRewardedVideoAdListener f;

    @VisibleForTesting
    private final RewardedVideoAdListener g = new h(this);

    protected abstract Bundle a(Bundle bundle, Bundle bundle2);

    private final AdRequest a(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Date a2 = mediationAdRequest.a();
        if (a2 != null) {
            builder.a(a2);
        }
        int b2 = mediationAdRequest.b();
        if (b2 != 0) {
            builder.a(b2);
        }
        Set<String> c2 = mediationAdRequest.c();
        if (c2 != null) {
            Iterator<String> it = c2.iterator();
            while (it.hasNext()) {
                builder.a(it.next());
            }
        }
        Location d2 = mediationAdRequest.d();
        if (d2 != null) {
            builder.a(d2);
        }
        if (mediationAdRequest.f()) {
            zzwq.a();
            builder.b(zzayr.a(context));
        }
        if (mediationAdRequest.e() != -1) {
            builder.a(mediationAdRequest.e() == 1);
        }
        builder.b(mediationAdRequest.g());
        builder.a(AdMobAdapter.class, a(bundle, bundle2));
        return builder.a();
    }

    /* compiled from: source */
    @VisibleForTesting
    static final class c extends AdListener implements AppEventListener, zzva {

        @VisibleForTesting
        private final AbstractAdViewAdapter a;

        @VisibleForTesting
        private final MediationBannerListener b;

        public c(AbstractAdViewAdapter abstractAdViewAdapter, MediationBannerListener mediationBannerListener) {
            this.a = abstractAdViewAdapter;
            this.b = mediationBannerListener;
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void a() {
            this.b.a(this.a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void a(int i) {
            this.b.a(this.a, i);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void b() {
            this.b.b(this.a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void c() {
            this.b.c(this.a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void d() {
            this.b.d(this.a);
        }

        @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.internal.ads.zzva
        public final void e() {
            this.b.e(this.a);
        }

        @Override // com.google.android.gms.ads.doubleclick.AppEventListener
        public final void a(String str, String str2) {
            this.b.a(this.a, str, str2);
        }
    }

    /* compiled from: source */
    @VisibleForTesting
    static final class f extends AdListener implements zzva {

        @VisibleForTesting
        private final AbstractAdViewAdapter a;

        @VisibleForTesting
        private final MediationInterstitialListener b;

        public f(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.a = abstractAdViewAdapter;
            this.b = mediationInterstitialListener;
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void a() {
            this.b.a(this.a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void a(int i) {
            this.b.a(this.a, i);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void b() {
            this.b.b(this.a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void c() {
            this.b.c(this.a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void d() {
            this.b.d(this.a);
        }

        @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.internal.ads.zzva
        public final void e() {
            this.b.e(this.a);
        }
    }

    /* compiled from: source */
    @VisibleForTesting
    static final class e extends AdListener implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener, UnifiedNativeAd.OnUnifiedNativeAdLoadedListener {

        @VisibleForTesting
        private final AbstractAdViewAdapter a;

        @VisibleForTesting
        private final MediationNativeListener b;

        public e(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
            this.a = abstractAdViewAdapter;
            this.b = mediationNativeListener;
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void a() {
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void a(int i) {
            this.b.a(this.a, i);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void b() {
            this.b.a(this.a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void c() {
            this.b.b(this.a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void d() {
            this.b.c(this.a);
        }

        @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.internal.ads.zzva
        public final void e() {
            this.b.d(this.a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void f() {
            this.b.e(this.a);
        }

        @Override // com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener
        public final void a(NativeAppInstallAd nativeAppInstallAd) {
            this.b.a(this.a, new b(nativeAppInstallAd));
        }

        @Override // com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener
        public final void a(UnifiedNativeAd unifiedNativeAd) {
            this.b.a(this.a, new d(unifiedNativeAd));
        }

        @Override // com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener
        public final void a(NativeContentAd nativeContentAd) {
            this.b.a(this.a, new a(nativeContentAd));
        }

        @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener
        public final void a(NativeCustomTemplateAd nativeCustomTemplateAd) {
            this.b.a(this.a, nativeCustomTemplateAd);
        }

        @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener
        public final void a(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
            this.b.a(this.a, nativeCustomTemplateAd, str);
        }
    }

    /* compiled from: source */
    static class a extends NativeContentAdMapper {
        private final NativeContentAd e;

        public a(NativeContentAd nativeContentAd) {
            this.e = nativeContentAd;
            a(nativeContentAd.b().toString());
            a(nativeContentAd.c());
            b(nativeContentAd.d().toString());
            if (nativeContentAd.e() != null) {
                a(nativeContentAd.e());
            }
            c(nativeContentAd.f().toString());
            d(nativeContentAd.g().toString());
            a(true);
            b(true);
            a(nativeContentAd.h());
        }

        @Override // com.google.android.gms.ads.mediation.NativeAdMapper
        public final void a(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.e);
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.a.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.a(this.e);
            }
        }
    }

    /* compiled from: source */
    static class d extends UnifiedNativeAdMapper {
        private final UnifiedNativeAd a;

        public d(UnifiedNativeAd unifiedNativeAd) {
            this.a = unifiedNativeAd;
            a(unifiedNativeAd.a());
            a(unifiedNativeAd.b());
            b(unifiedNativeAd.c());
            a(unifiedNativeAd.d());
            c(unifiedNativeAd.e());
            d(unifiedNativeAd.f());
            a(unifiedNativeAd.g());
            e(unifiedNativeAd.h());
            f(unifiedNativeAd.i());
            a(unifiedNativeAd.l());
            a(true);
            b(true);
            a(unifiedNativeAd.j());
        }

        @Override // com.google.android.gms.ads.mediation.UnifiedNativeAdMapper
        public final void a(View view, Map<String, View> map, Map<String, View> map2) {
            if (view instanceof UnifiedNativeAdView) {
                ((UnifiedNativeAdView) view).setNativeAd(this.a);
                return;
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.a.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.a(this.a);
            }
        }
    }

    /* compiled from: source */
    static class b extends NativeAppInstallAdMapper {
        private final NativeAppInstallAd e;

        public b(NativeAppInstallAd nativeAppInstallAd) {
            this.e = nativeAppInstallAd;
            a(nativeAppInstallAd.b().toString());
            a(nativeAppInstallAd.c());
            b(nativeAppInstallAd.d().toString());
            a(nativeAppInstallAd.e());
            c(nativeAppInstallAd.f().toString());
            if (nativeAppInstallAd.g() != null) {
                a(nativeAppInstallAd.g().doubleValue());
            }
            if (nativeAppInstallAd.h() != null) {
                d(nativeAppInstallAd.h().toString());
            }
            if (nativeAppInstallAd.i() != null) {
                e(nativeAppInstallAd.i().toString());
            }
            a(true);
            b(true);
            a(nativeAppInstallAd.j());
        }

        @Override // com.google.android.gms.ads.mediation.NativeAdMapper
        public final void a(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.e);
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.a.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.a(this.e);
            }
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onDestroy() {
        if (this.a != null) {
            this.a.c();
            this.a = null;
        }
        if (this.b != null) {
            this.b = null;
        }
        if (this.c != null) {
            this.c = null;
        }
        if (this.e != null) {
            this.e = null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onPause() {
        if (this.a != null) {
            this.a.b();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onResume() {
        if (this.a != null) {
            this.a.a();
        }
    }

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.a = new AdView(context);
        this.a.setAdSize(new AdSize(adSize.b(), adSize.a()));
        this.a.setAdUnitId(getAdUnitId(bundle));
        this.a.setAdListener(new c(this, mediationBannerListener));
        this.a.a(a(context, mediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public View getBannerView() {
        return this.a;
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.b = new InterstitialAd(context);
        this.b.a(getAdUnitId(bundle));
        this.b.a(new f(this, mediationInterstitialListener));
        this.b.a(a(context, mediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener
    public void onImmersiveModeUpdated(boolean z) {
        if (this.b != null) {
            this.b.b(z);
        }
        if (this.e != null) {
            this.e.b(z);
        }
    }

    @Override // com.google.android.gms.ads.mediation.zza
    public zzys getVideoController() {
        VideoController videoController;
        if (this.a == null || (videoController = this.a.getVideoController()) == null) {
            return null;
        }
        return videoController.a();
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void showInterstitial() {
        this.b.b();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public Bundle getInterstitialAdapterInfo() {
        return new MediationAdapter.zza().a(1).a();
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        e eVar = new e(this, mediationNativeListener);
        AdLoader.Builder a2 = new AdLoader.Builder(context, bundle.getString(AD_UNIT_ID_PARAMETER)).a((AdListener) eVar);
        NativeAdOptions h = nativeMediationAdRequest.h();
        if (h != null) {
            a2.a(h);
        }
        if (nativeMediationAdRequest.j()) {
            a2.a((UnifiedNativeAd.OnUnifiedNativeAdLoadedListener) eVar);
        }
        if (nativeMediationAdRequest.i()) {
            a2.a((NativeAppInstallAd.OnAppInstallAdLoadedListener) eVar);
        }
        if (nativeMediationAdRequest.k()) {
            a2.a((NativeContentAd.OnContentAdLoadedListener) eVar);
        }
        if (nativeMediationAdRequest.l()) {
            for (String str : nativeMediationAdRequest.m().keySet()) {
                a2.a(str, eVar, nativeMediationAdRequest.m().get(str).booleanValue() ? eVar : null);
            }
        }
        this.c = a2.a();
        this.c.a(a(context, nativeMediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public void initialize(Context context, MediationAdRequest mediationAdRequest, String str, MediationRewardedVideoAdListener mediationRewardedVideoAdListener, Bundle bundle, Bundle bundle2) {
        this.d = context.getApplicationContext();
        this.f = mediationRewardedVideoAdListener;
        this.f.a(this);
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public void loadAd(MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        if (this.d == null || this.f == null) {
            zzaza.c("AdMobAdapter.loadAd called before initialize.");
            return;
        }
        this.e = new InterstitialAd(this.d);
        this.e.a(true);
        this.e.a(getAdUnitId(bundle));
        this.e.a(this.g);
        this.e.a(new g(this));
        this.e.a(a(this.d, mediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public void showVideo() {
        this.e.b();
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public boolean isInitialized() {
        return this.f != null;
    }

    static /* synthetic */ InterstitialAd a(AbstractAdViewAdapter abstractAdViewAdapter, InterstitialAd interstitialAd) {
        abstractAdViewAdapter.e = null;
        return null;
    }
}
