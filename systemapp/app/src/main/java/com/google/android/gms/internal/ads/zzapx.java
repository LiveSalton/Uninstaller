package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzapx extends zzapr {
    private final RtbAdapter a;
    private MediationInterstitialAd b;
    private MediationRewardedAd c;
    private String d = "";

    public zzapx(RtbAdapter rtbAdapter) {
        this.a = rtbAdapter;
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final void a(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final void a(String[] strArr, Bundle[] bundleArr) {
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final void a(String str, String str2, zzvk zzvkVar, IObjectWrapper iObjectWrapper, zzapc zzapcVar, zzano zzanoVar, zzvn zzvnVar) throws RemoteException {
        try {
            this.a.loadBannerAd(new MediationBannerAdConfiguration((Context) ObjectWrapper.a(iObjectWrapper), str, b(str2), b(zzvkVar), a(zzvkVar), zzvkVar.k, zzvkVar.g, zzvkVar.t, a(str2, zzvkVar), com.google.android.gms.ads.zzb.a(zzvnVar.e, zzvnVar.b, zzvnVar.a), this.d), new de(this, zzapcVar, zzanoVar));
        } catch (Throwable th) {
            zzaza.c("Adapter failed to render banner ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final void a(String str, String str2, zzvk zzvkVar, IObjectWrapper iObjectWrapper, zzaph zzaphVar, zzano zzanoVar) throws RemoteException {
        try {
            this.a.loadInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.a(iObjectWrapper), str, b(str2), b(zzvkVar), a(zzvkVar), zzvkVar.k, zzvkVar.g, zzvkVar.t, a(str2, zzvkVar), this.d), new dg(this, zzaphVar, zzanoVar));
        } catch (Throwable th) {
            zzaza.c("Adapter failed to render interstitial ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final void a(String str, String str2, zzvk zzvkVar, IObjectWrapper iObjectWrapper, zzapn zzapnVar, zzano zzanoVar) throws RemoteException {
        try {
            this.a.loadRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.a(iObjectWrapper), str, b(str2), b(zzvkVar), a(zzvkVar), zzvkVar.k, zzvkVar.g, zzvkVar.t, a(str2, zzvkVar), this.d), a(zzapnVar, zzanoVar));
        } catch (Throwable th) {
            zzaza.c("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final void b(String str, String str2, zzvk zzvkVar, IObjectWrapper iObjectWrapper, zzapn zzapnVar, zzano zzanoVar) throws RemoteException {
        try {
            this.a.loadRewardedInterstitialAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.a(iObjectWrapper), str, b(str2), b(zzvkVar), a(zzvkVar), zzvkVar.k, zzvkVar.g, zzvkVar.t, a(str2, zzvkVar), this.d), a(zzapnVar, zzanoVar));
        } catch (Throwable th) {
            zzaza.c("Adapter failed to render rewarded interstitial ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final void a(String str, String str2, zzvk zzvkVar, IObjectWrapper iObjectWrapper, zzapi zzapiVar, zzano zzanoVar) throws RemoteException {
        try {
            this.a.loadNativeAd(new MediationNativeAdConfiguration((Context) ObjectWrapper.a(iObjectWrapper), str, b(str2), b(zzvkVar), a(zzvkVar), zzvkVar.k, zzvkVar.g, zzvkVar.t, a(str2, zzvkVar), this.d), new df(this, zzapiVar, zzanoVar));
        } catch (Throwable th) {
            zzaza.c("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final boolean b(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.b == null) {
            return false;
        }
        try {
            this.b.a((Context) ObjectWrapper.a(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzaza.c("", th);
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final boolean c(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (this.c == null) {
            return false;
        }
        try {
            this.c.a((Context) ObjectWrapper.a(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzaza.c("", th);
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final zzys c() {
        if (!(this.a instanceof zza)) {
            return null;
        }
        try {
            return ((zza) this.a).getVideoController();
        } catch (Throwable th) {
            zzaza.c("", th);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final void a(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzvn zzvnVar, zzapt zzaptVar) throws RemoteException {
        AdFormat adFormat;
        try {
            di diVar = new di(this, zzaptVar);
            RtbAdapter rtbAdapter = this.a;
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1396342996) {
                if (hashCode != -1052618729) {
                    if (hashCode != -239580146) {
                        if (hashCode == 604727084 && str.equals("interstitial")) {
                            c = 1;
                        }
                    } else if (str.equals("rewarded")) {
                        c = 2;
                    }
                } else if (str.equals("native")) {
                    c = 3;
                }
            } else if (str.equals("banner")) {
                c = 0;
            }
            switch (c) {
                case 0:
                    adFormat = AdFormat.BANNER;
                    break;
                case 1:
                    adFormat = AdFormat.INTERSTITIAL;
                    break;
                case 2:
                    adFormat = AdFormat.REWARDED;
                    break;
                case 3:
                    adFormat = AdFormat.NATIVE;
                    break;
                default:
                    throw new IllegalArgumentException("Internal Error");
            }
            MediationConfiguration mediationConfiguration = new MediationConfiguration(adFormat, bundle2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(mediationConfiguration);
            rtbAdapter.collectSignals(new RtbSignalData((Context) ObjectWrapper.a(iObjectWrapper), arrayList, bundle, com.google.android.gms.ads.zzb.a(zzvnVar.e, zzvnVar.b, zzvnVar.a)), diVar);
        } catch (Throwable th) {
            zzaza.c("Error generating signals for RTB", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final zzaqc a() throws RemoteException {
        return zzaqc.a(this.a.getVersionInfo());
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final zzaqc b() throws RemoteException {
        return zzaqc.a(this.a.getSDKVersionInfo());
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final void a(String str) {
        this.d = str;
    }

    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> a(zzapn zzapnVar, zzano zzanoVar) {
        return new dh(this, zzapnVar, zzanoVar);
    }

    private static Bundle b(String str) throws RemoteException {
        String valueOf = String.valueOf(str);
        zzaza.e(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle2.putString(next, jSONObject.getString(next));
            }
            return bundle2;
        } catch (JSONException e) {
            zzaza.c("", e);
            throw new RemoteException();
        }
    }

    private static boolean a(zzvk zzvkVar) {
        if (zzvkVar.f) {
            return true;
        }
        zzwq.a();
        return zzayr.a();
    }

    private static String a(String str, zzvk zzvkVar) {
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return zzvkVar.u;
        }
    }

    private final Bundle b(zzvk zzvkVar) {
        Bundle bundle;
        return (zzvkVar.m == null || (bundle = zzvkVar.m.getBundle(this.a.getClass().getName())) == null) ? new Bundle() : bundle;
    }
}
