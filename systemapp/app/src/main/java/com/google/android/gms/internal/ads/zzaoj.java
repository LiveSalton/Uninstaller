package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaoj implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener {
    private final zzano a;
    private NativeAdMapper b;
    private UnifiedNativeAdMapper c;
    private NativeCustomTemplateAd d;

    public zzaoj(zzano zzanoVar) {
        this.a = zzanoVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void a(MediationBannerAdapter mediationBannerAdapter, String str, String str2) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzaza.b("Adapter called onAppEvent.");
        try {
            this.a.a(str, str2);
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void e(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzaza.b("Adapter called onAdClicked.");
        try {
            this.a.a();
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void c(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzaza.b("Adapter called onAdClosed.");
        try {
            this.a.b();
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void a(MediationBannerAdapter mediationBannerAdapter, int i) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        StringBuilder sb = new StringBuilder(55);
        sb.append("Adapter called onAdFailedToLoad with error. ");
        sb.append(i);
        zzaza.b(sb.toString());
        try {
            this.a.a(i);
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void a(MediationBannerAdapter mediationBannerAdapter, AdError adError) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        int a = adError.a();
        String b = adError.b();
        String c = adError.c();
        StringBuilder sb = new StringBuilder(97 + String.valueOf(b).length() + String.valueOf(c).length());
        sb.append("Adapter called onAdFailedToLoad with error. ErrorCode: ");
        sb.append(a);
        sb.append(". ErrorMessage: ");
        sb.append(b);
        sb.append(". ErrorDomain: ");
        sb.append(c);
        zzaza.b(sb.toString());
        try {
            this.a.a(adError.d());
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void d(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzaza.b("Adapter called onAdLeftApplication.");
        try {
            this.a.c();
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void b(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzaza.b("Adapter called onAdOpened.");
        try {
            this.a.d();
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void a(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzaza.b("Adapter called onAdLoaded.");
        try {
            this.a.e();
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void e(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzaza.b("Adapter called onAdClicked.");
        try {
            this.a.a();
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void c(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzaza.b("Adapter called onAdClosed.");
        try {
            this.a.b();
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void a(MediationInterstitialAdapter mediationInterstitialAdapter, int i) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        StringBuilder sb = new StringBuilder(55);
        sb.append("Adapter called onAdFailedToLoad with error ");
        sb.append(i);
        sb.append(".");
        zzaza.b(sb.toString());
        try {
            this.a.a(i);
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void a(MediationInterstitialAdapter mediationInterstitialAdapter, AdError adError) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        int a = adError.a();
        String b = adError.b();
        String c = adError.c();
        StringBuilder sb = new StringBuilder(97 + String.valueOf(b).length() + String.valueOf(c).length());
        sb.append("Adapter called onAdFailedToLoad with error. ErrorCode: ");
        sb.append(a);
        sb.append(". ErrorMessage: ");
        sb.append(b);
        sb.append(". ErrorDomain: ");
        sb.append(c);
        zzaza.b(sb.toString());
        try {
            this.a.a(adError.d());
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void d(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzaza.b("Adapter called onAdLeftApplication.");
        try {
            this.a.c();
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void b(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzaza.b("Adapter called onAdOpened.");
        try {
            this.a.d();
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void a(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzaza.b("Adapter called onAdLoaded.");
        try {
            this.a.e();
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void a(MediationNativeAdapter mediationNativeAdapter, NativeAdMapper nativeAdMapper) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzaza.b("Adapter called onAdLoaded.");
        this.b = nativeAdMapper;
        this.c = null;
        a(mediationNativeAdapter, this.c, this.b);
        try {
            this.a.e();
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void a(MediationNativeAdapter mediationNativeAdapter, UnifiedNativeAdMapper unifiedNativeAdMapper) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzaza.b("Adapter called onAdLoaded.");
        this.c = unifiedNativeAdMapper;
        this.b = null;
        a(mediationNativeAdapter, this.c, this.b);
        try {
            this.a.e();
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    private static void a(MediationNativeAdapter mediationNativeAdapter, UnifiedNativeAdMapper unifiedNativeAdMapper, NativeAdMapper nativeAdMapper) {
        if (mediationNativeAdapter instanceof AdMobAdapter) {
            return;
        }
        VideoController videoController = new VideoController();
        videoController.a(new zzaoc());
        if (unifiedNativeAdMapper != null && unifiedNativeAdMapper.k()) {
            unifiedNativeAdMapper.a(videoController);
        }
        if (nativeAdMapper == null || !nativeAdMapper.h()) {
            return;
        }
        nativeAdMapper.a(videoController);
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void a(MediationNativeAdapter mediationNativeAdapter, NativeCustomTemplateAd nativeCustomTemplateAd) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        String valueOf = String.valueOf(nativeCustomTemplateAd.a());
        zzaza.b(valueOf.length() != 0 ? "Adapter called onAdLoaded with template id ".concat(valueOf) : new String("Adapter called onAdLoaded with template id "));
        this.d = nativeCustomTemplateAd;
        try {
            this.a.e();
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void a(MediationNativeAdapter mediationNativeAdapter, NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
        if (nativeCustomTemplateAd instanceof zzafg) {
            try {
                this.a.a(((zzafg) nativeCustomTemplateAd).b(), str);
                return;
            } catch (RemoteException e) {
                zzaza.e("#007 Could not call remote method.", e);
                return;
            }
        }
        zzaza.e("Unexpected native custom template ad type.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void a(MediationNativeAdapter mediationNativeAdapter, int i) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        StringBuilder sb = new StringBuilder(55);
        sb.append("Adapter called onAdFailedToLoad with error ");
        sb.append(i);
        sb.append(".");
        zzaza.b(sb.toString());
        try {
            this.a.a(i);
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void a(MediationNativeAdapter mediationNativeAdapter, AdError adError) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        int a = adError.a();
        String b = adError.b();
        String c = adError.c();
        StringBuilder sb = new StringBuilder(97 + String.valueOf(b).length() + String.valueOf(c).length());
        sb.append("Adapter called onAdFailedToLoad with error. ErrorCode: ");
        sb.append(a);
        sb.append(". ErrorMessage: ");
        sb.append(b);
        sb.append(". ErrorDomain: ");
        sb.append(c);
        zzaza.b(sb.toString());
        try {
            this.a.a(adError.d());
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void a(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzaza.b("Adapter called onAdOpened.");
        try {
            this.a.d();
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void b(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzaza.b("Adapter called onAdClosed.");
        try {
            this.a.b();
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void c(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        zzaza.b("Adapter called onAdLeftApplication.");
        try {
            this.a.c();
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void d(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        NativeAdMapper nativeAdMapper = this.b;
        UnifiedNativeAdMapper unifiedNativeAdMapper = this.c;
        if (this.d == null) {
            if (nativeAdMapper == null && unifiedNativeAdMapper == null) {
                zzaza.e("#007 Could not call remote method.", null);
                return;
            }
            if (unifiedNativeAdMapper != null && !unifiedNativeAdMapper.t()) {
                zzaza.b("Could not call onAdClicked since setOverrideClickHandling is not set to true");
                return;
            } else if (nativeAdMapper != null && !nativeAdMapper.b()) {
                zzaza.b("Could not call onAdClicked since setOverrideClickHandling is not set to true");
                return;
            }
        }
        zzaza.b("Adapter called onAdClicked.");
        try {
            this.a.a();
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void e(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.b("#008 Must be called on the main UI thread.");
        NativeAdMapper nativeAdMapper = this.b;
        UnifiedNativeAdMapper unifiedNativeAdMapper = this.c;
        if (this.d == null) {
            if (nativeAdMapper == null && unifiedNativeAdMapper == null) {
                zzaza.e("#007 Could not call remote method.", null);
                return;
            }
            if (unifiedNativeAdMapper != null && !unifiedNativeAdMapper.s()) {
                zzaza.b("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
                return;
            } else if (nativeAdMapper != null && !nativeAdMapper.a()) {
                zzaza.b("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
                return;
            }
        }
        zzaza.b("Adapter called onAdImpression.");
        try {
            this.a.f();
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }

    public final NativeAdMapper a() {
        return this.b;
    }

    public final UnifiedNativeAdMapper b() {
        return this.c;
    }

    public final NativeCustomTemplateAd c() {
        return this.d;
    }
}
