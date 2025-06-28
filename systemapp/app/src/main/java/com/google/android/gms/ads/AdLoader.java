package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzadz;
import com.google.android.gms.internal.ads.zzagp;
import com.google.android.gms.internal.ads.zzags;
import com.google.android.gms.internal.ads.zzagt;
import com.google.android.gms.internal.ads.zzagx;
import com.google.android.gms.internal.ads.zzanj;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzvg;
import com.google.android.gms.internal.ads.zzvl;
import com.google.android.gms.internal.ads.zzwq;
import com.google.android.gms.internal.ads.zzwy;
import com.google.android.gms.internal.ads.zzwz;
import com.google.android.gms.internal.ads.zzza;

/* compiled from: source */
/* loaded from: classes.dex */
public class AdLoader {
    private final zzvl a;
    private final Context b;
    private final zzwy c;

    /* compiled from: source */
    public static class Builder {
        private final Context a;
        private final zzwz b;

        public Builder(Context context, String str) {
            this((Context) Preconditions.a(context, "context cannot be null"), zzwq.b().a(context, str, new zzanj()));
        }

        private Builder(Context context, zzwz zzwzVar) {
            this.a = context;
            this.b = zzwzVar;
        }

        @Deprecated
        public Builder a(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.b.a(new zzags(onContentAdLoadedListener));
            } catch (RemoteException e) {
                zzaza.d("Failed to add content ad listener", e);
            }
            return this;
        }

        @Deprecated
        public Builder a(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.b.a(new zzagt(onAppInstallAdLoadedListener));
            } catch (RemoteException e) {
                zzaza.d("Failed to add app install ad listener", e);
            }
            return this;
        }

        public Builder a(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
            try {
                this.b.a(new zzagx(onUnifiedNativeAdLoadedListener));
            } catch (RemoteException e) {
                zzaza.d("Failed to add google native ad listener", e);
            }
            return this;
        }

        public Builder a(String str, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
            zzagp zzagpVar = new zzagp(onCustomTemplateAdLoadedListener, onCustomClickListener);
            try {
                this.b.a(str, zzagpVar.a(), zzagpVar.b());
            } catch (RemoteException e) {
                zzaza.d("Failed to add custom template ad listener", e);
            }
            return this;
        }

        public Builder a(AdListener adListener) {
            try {
                this.b.a(new zzvg(adListener));
            } catch (RemoteException e) {
                zzaza.d("Failed to set AdListener.", e);
            }
            return this;
        }

        public Builder a(NativeAdOptions nativeAdOptions) {
            try {
                this.b.a(new zzadz(nativeAdOptions));
            } catch (RemoteException e) {
                zzaza.d("Failed to specify native ad options", e);
            }
            return this;
        }

        public AdLoader a() {
            try {
                return new AdLoader(this.a, this.b.a());
            } catch (RemoteException e) {
                zzaza.c("Failed to build AdLoader.", e);
                return null;
            }
        }
    }

    AdLoader(Context context, zzwy zzwyVar) {
        this(context, zzwyVar, zzvl.a);
    }

    private AdLoader(Context context, zzwy zzwyVar, zzvl zzvlVar) {
        this.b = context;
        this.c = zzwyVar;
        this.a = zzvlVar;
    }

    private final void a(zzza zzzaVar) {
        try {
            this.c.a(zzvl.a(this.b, zzzaVar));
        } catch (RemoteException e) {
            zzaza.c("Failed to load ad.", e);
        }
    }

    public void a(AdRequest adRequest) {
        a(adRequest.a());
    }
}
