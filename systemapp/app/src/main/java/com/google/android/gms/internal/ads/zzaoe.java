package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaoe extends zzanm {
    private final Object a;
    private zzaoj b;
    private zzauw c;
    private IObjectWrapper d;
    private MediationRewardedAd e;

    public zzaoe(MediationAdapter mediationAdapter) {
        this.a = mediationAdapter;
    }

    public zzaoe(Adapter adapter) {
        this.a = adapter;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final IObjectWrapper a() throws RemoteException {
        if (!(this.a instanceof MediationBannerAdapter)) {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = this.a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(22 + String.valueOf(canonicalName).length() + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.e(sb.toString());
            throw new RemoteException();
        }
        try {
            return ObjectWrapper.a(((MediationBannerAdapter) this.a).getBannerView());
        } catch (Throwable th) {
            zzaza.c("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(IObjectWrapper iObjectWrapper, zzvn zzvnVar, zzvk zzvkVar, String str, zzano zzanoVar) throws RemoteException {
        a(iObjectWrapper, zzvnVar, zzvkVar, str, null, zzanoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(IObjectWrapper iObjectWrapper, zzvn zzvnVar, zzvk zzvkVar, String str, String str2, zzano zzanoVar) throws RemoteException {
        AdSize a;
        if (!(this.a instanceof MediationBannerAdapter)) {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = this.a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(22 + String.valueOf(canonicalName).length() + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.e(sb.toString());
            throw new RemoteException();
        }
        zzaza.b("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.a;
            zzaof zzaofVar = new zzaof(zzvkVar.b == -1 ? null : new Date(zzvkVar.b), zzvkVar.d, zzvkVar.e != null ? new HashSet(zzvkVar.e) : null, zzvkVar.k, a(zzvkVar), zzvkVar.g, zzvkVar.r, zzvkVar.t, a(str, zzvkVar));
            Bundle bundle = zzvkVar.m != null ? zzvkVar.m.getBundle(mediationBannerAdapter.getClass().getName()) : null;
            if (zzvnVar.m) {
                a = com.google.android.gms.ads.zzb.a(zzvnVar.e, zzvnVar.b);
            } else {
                a = com.google.android.gms.ads.zzb.a(zzvnVar.e, zzvnVar.b, zzvnVar.a);
            }
            mediationBannerAdapter.requestBannerAd((Context) ObjectWrapper.a(iObjectWrapper), new zzaoj(zzanoVar), a(str, zzvkVar, str2), a, zzaofVar, bundle);
        } catch (Throwable th) {
            zzaza.c("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final Bundle j() {
        if (!(this.a instanceof zzbgk)) {
            String canonicalName = zzbgk.class.getCanonicalName();
            String canonicalName2 = this.a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(22 + String.valueOf(canonicalName).length() + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.e(sb.toString());
            return new Bundle();
        }
        return ((zzbgk) this.a).zzug();
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(IObjectWrapper iObjectWrapper, zzvk zzvkVar, String str, zzano zzanoVar) throws RemoteException {
        a(iObjectWrapper, zzvkVar, str, (String) null, zzanoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(IObjectWrapper iObjectWrapper, zzvk zzvkVar, String str, String str2, zzano zzanoVar) throws RemoteException {
        if (!(this.a instanceof MediationInterstitialAdapter)) {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = this.a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(22 + String.valueOf(canonicalName).length() + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.e(sb.toString());
            throw new RemoteException();
        }
        zzaza.b("Requesting interstitial ad from adapter.");
        try {
            MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.a;
            mediationInterstitialAdapter.requestInterstitialAd((Context) ObjectWrapper.a(iObjectWrapper), new zzaoj(zzanoVar), a(str, zzvkVar, str2), new zzaof(zzvkVar.b == -1 ? null : new Date(zzvkVar.b), zzvkVar.d, zzvkVar.e != null ? new HashSet(zzvkVar.e) : null, zzvkVar.k, a(zzvkVar), zzvkVar.g, zzvkVar.r, zzvkVar.t, a(str, zzvkVar)), zzvkVar.m != null ? zzvkVar.m.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
        } catch (Throwable th) {
            zzaza.c("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final Bundle k() {
        if (!(this.a instanceof zzbgj)) {
            String canonicalName = zzbgj.class.getCanonicalName();
            String canonicalName2 = this.a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(22 + String.valueOf(canonicalName).length() + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.e(sb.toString());
            return new Bundle();
        }
        return ((zzbgj) this.a).getInterstitialAdapterInfo();
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(IObjectWrapper iObjectWrapper, zzvk zzvkVar, String str, String str2, zzano zzanoVar, zzadz zzadzVar, List<String> list) throws RemoteException {
        if (!(this.a instanceof MediationNativeAdapter)) {
            String canonicalName = MediationNativeAdapter.class.getCanonicalName();
            String canonicalName2 = this.a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(22 + String.valueOf(canonicalName).length() + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.e(sb.toString());
            throw new RemoteException();
        }
        try {
            MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) this.a;
            zzaon zzaonVar = new zzaon(zzvkVar.b == -1 ? null : new Date(zzvkVar.b), zzvkVar.d, zzvkVar.e != null ? new HashSet(zzvkVar.e) : null, zzvkVar.k, a(zzvkVar), zzvkVar.g, zzadzVar, list, zzvkVar.r, zzvkVar.t, a(str, zzvkVar));
            Bundle bundle = zzvkVar.m != null ? zzvkVar.m.getBundle(mediationNativeAdapter.getClass().getName()) : null;
            this.b = new zzaoj(zzanoVar);
            mediationNativeAdapter.requestNativeAd((Context) ObjectWrapper.a(iObjectWrapper), this.b, a(str, zzvkVar, str2), zzaonVar, bundle);
        } catch (Throwable th) {
            zzaza.c("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final Bundle l() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final zzanv h() {
        NativeAdMapper a = this.b.a();
        if (a instanceof NativeAppInstallAdMapper) {
            return new zzaol((NativeAppInstallAdMapper) a);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final zzaob p() {
        UnifiedNativeAdMapper b = this.b.b();
        if (b != null) {
            return new zzapd(b);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final zzanw i() {
        NativeAdMapper a = this.b.a();
        if (a instanceof NativeContentAdMapper) {
            return new zzaok((NativeContentAdMapper) a);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final zzaff n() {
        NativeCustomTemplateAd c = this.b.c();
        if (c instanceof zzafg) {
            return ((zzafg) c).b();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final boolean m() {
        return this.a instanceof InitializableMediationRewardedVideoAdAdapter;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(IObjectWrapper iObjectWrapper, zzvk zzvkVar, String str, zzauw zzauwVar, String str2) throws RemoteException {
        zzaof zzaofVar;
        Bundle bundle;
        if (this.a instanceof MediationRewardedVideoAdAdapter) {
            zzaza.b("Initialize rewarded video adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.a;
                Bundle a = a(str2, zzvkVar, (String) null);
                if (zzvkVar != null) {
                    zzaof zzaofVar2 = new zzaof(zzvkVar.b == -1 ? null : new Date(zzvkVar.b), zzvkVar.d, zzvkVar.e != null ? new HashSet(zzvkVar.e) : null, zzvkVar.k, a(zzvkVar), zzvkVar.g, zzvkVar.r, zzvkVar.t, a(str2, zzvkVar));
                    bundle = zzvkVar.m != null ? zzvkVar.m.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null;
                    zzaofVar = zzaofVar2;
                } else {
                    zzaofVar = null;
                    bundle = null;
                }
                mediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.a(iObjectWrapper), zzaofVar, str, new zzavb(zzauwVar), a, bundle);
                return;
            } catch (Throwable th) {
                zzaza.c("", th);
                throw new RemoteException();
            }
        }
        if (!(this.a instanceof Adapter)) {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(26 + String.valueOf(canonicalName).length() + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzaza.e(sb.toString());
            throw new RemoteException();
        }
        this.d = iObjectWrapper;
        this.c = zzauwVar;
        zzauwVar.a(ObjectWrapper.a(this.a));
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(IObjectWrapper iObjectWrapper, zzauw zzauwVar, List<String> list) throws RemoteException {
        if (!(this.a instanceof InitializableMediationRewardedVideoAdAdapter)) {
            String canonicalName = InitializableMediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = this.a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(22 + String.valueOf(canonicalName).length() + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.e(sb.toString());
            throw new RemoteException();
        }
        zzaza.b("Initialize rewarded video adapter.");
        try {
            InitializableMediationRewardedVideoAdAdapter initializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter) this.a;
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(a(it.next(), (zzvk) null, (String) null));
            }
            initializableMediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.a(iObjectWrapper), new zzavb(zzauwVar), arrayList);
        } catch (Throwable th) {
            zzaza.d("Could not initialize rewarded video adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(zzvk zzvkVar, String str) throws RemoteException {
        a(zzvkVar, str, (String) null);
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(zzvk zzvkVar, String str, String str2) throws RemoteException {
        if (this.a instanceof MediationRewardedVideoAdAdapter) {
            zzaza.b("Requesting rewarded video ad from adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.a;
                mediationRewardedVideoAdAdapter.loadAd(new zzaof(zzvkVar.b == -1 ? null : new Date(zzvkVar.b), zzvkVar.d, zzvkVar.e != null ? new HashSet(zzvkVar.e) : null, zzvkVar.k, a(zzvkVar), zzvkVar.g, zzvkVar.r, zzvkVar.t, a(str, zzvkVar)), a(str, zzvkVar, str2), zzvkVar.m != null ? zzvkVar.m.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
                return;
            } catch (Throwable th) {
                zzaza.c("", th);
                throw new RemoteException();
            }
        }
        if (!(this.a instanceof Adapter)) {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(26 + String.valueOf(canonicalName).length() + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzaza.e(sb.toString());
            throw new RemoteException();
        }
        b(this.d, zzvkVar, str, new zzaoi((Adapter) this.a, this.c));
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void f() throws RemoteException {
        if (this.a instanceof MediationRewardedVideoAdAdapter) {
            zzaza.b("Show rewarded video ad from adapter.");
            try {
                ((MediationRewardedVideoAdAdapter) this.a).showVideo();
                return;
            } catch (Throwable th) {
                zzaza.c("", th);
                throw new RemoteException();
            }
        }
        if (!(this.a instanceof Adapter)) {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(26 + String.valueOf(canonicalName).length() + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzaza.e(sb.toString());
            throw new RemoteException();
        }
        if (this.e != null) {
            this.e.a((Context) ObjectWrapper.a(this.d));
        } else {
            zzaza.c("Can not show null mediated rewarded ad.");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final boolean g() throws RemoteException {
        if (this.a instanceof MediationRewardedVideoAdAdapter) {
            zzaza.b("Check if adapter is initialized.");
            try {
                return ((MediationRewardedVideoAdAdapter) this.a).isInitialized();
            } catch (Throwable th) {
                zzaza.c("", th);
                throw new RemoteException();
            }
        }
        if (this.a instanceof Adapter) {
            return this.c != null;
        }
        String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
        String canonicalName2 = Adapter.class.getCanonicalName();
        String canonicalName3 = this.a.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(26 + String.valueOf(canonicalName).length() + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
        sb.append(canonicalName);
        sb.append(" or ");
        sb.append(canonicalName2);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName3);
        zzaza.e(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void b(IObjectWrapper iObjectWrapper, zzvk zzvkVar, String str, zzano zzanoVar) throws RemoteException {
        if (!(this.a instanceof Adapter)) {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(22 + String.valueOf(canonicalName).length() + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.e(sb.toString());
            throw new RemoteException();
        }
        zzaza.b("Requesting rewarded ad from adapter.");
        try {
            ((Adapter) this.a).loadRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.a(iObjectWrapper), "", a(str, zzvkVar, (String) null), b(zzvkVar), a(zzvkVar), zzvkVar.k, zzvkVar.g, zzvkVar.t, a(str, zzvkVar), ""), a(zzanoVar));
        } catch (Exception e) {
            zzaza.c("", e);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void c(IObjectWrapper iObjectWrapper, zzvk zzvkVar, String str, zzano zzanoVar) throws RemoteException {
        if (!(this.a instanceof Adapter)) {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(22 + String.valueOf(canonicalName).length() + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.e(sb.toString());
            throw new RemoteException();
        }
        zzaza.b("Requesting rewarded interstitial ad from adapter.");
        try {
            ((Adapter) this.a).loadRewardedInterstitialAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.a(iObjectWrapper), "", a(str, zzvkVar, (String) null), b(zzvkVar), a(zzvkVar), zzvkVar.k, zzvkVar.g, zzvkVar.t, a(str, zzvkVar), ""), a(zzanoVar));
        } catch (Exception e) {
            zzaza.c("", e);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void b(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (!(this.a instanceof Adapter)) {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(22 + String.valueOf(canonicalName).length() + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.e(sb.toString());
            throw new RemoteException();
        }
        zzaza.b("Show rewarded ad from adapter.");
        if (this.e != null) {
            this.e.a((Context) ObjectWrapper.a(iObjectWrapper));
        } else {
            zzaza.c("Can not show null mediation rewarded ad.");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(boolean z) throws RemoteException {
        if (!(this.a instanceof OnImmersiveModeUpdatedListener)) {
            String canonicalName = OnImmersiveModeUpdatedListener.class.getCanonicalName();
            String canonicalName2 = this.a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(22 + String.valueOf(canonicalName).length() + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.b(sb.toString());
            return;
        }
        try {
            ((OnImmersiveModeUpdatedListener) this.a).onImmersiveModeUpdated(z);
        } catch (Throwable th) {
            zzaza.c("", th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final zzys o() {
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

    @Override // com.google.android.gms.internal.ads.zzann
    public final void b() throws RemoteException {
        if (!(this.a instanceof MediationInterstitialAdapter)) {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = this.a.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(22 + String.valueOf(canonicalName).length() + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.e(sb.toString());
            throw new RemoteException();
        }
        zzaza.b("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.a).showInterstitial();
        } catch (Throwable th) {
            zzaza.c("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void c() throws RemoteException {
        if (this.a instanceof MediationAdapter) {
            try {
                ((MediationAdapter) this.a).onDestroy();
            } catch (Throwable th) {
                zzaza.c("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void d() throws RemoteException {
        if (this.a instanceof MediationAdapter) {
            try {
                ((MediationAdapter) this.a).onPause();
            } catch (Throwable th) {
                zzaza.c("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void e() throws RemoteException {
        if (this.a instanceof MediationAdapter) {
            try {
                ((MediationAdapter) this.a).onResume();
            } catch (Throwable th) {
                zzaza.c("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Context context = (Context) ObjectWrapper.a(iObjectWrapper);
        if (this.a instanceof OnContextChangedListener) {
            ((OnContextChangedListener) this.a).a(context);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(IObjectWrapper iObjectWrapper, zzajb zzajbVar, List<zzajj> list) throws RemoteException {
        AdFormat adFormat;
        if (!(this.a instanceof Adapter)) {
            throw new RemoteException();
        }
        da daVar = new da(this, zzajbVar);
        ArrayList arrayList = new ArrayList();
        for (zzajj zzajjVar : list) {
            String str = zzajjVar.a;
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
                    throw new RemoteException();
            }
            arrayList.add(new MediationConfiguration(adFormat, zzajjVar.b));
        }
        ((Adapter) this.a).initialize((Context) ObjectWrapper.a(iObjectWrapper), daVar, arrayList);
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final zzaqc q() {
        if (this.a instanceof Adapter) {
            return zzaqc.a(((Adapter) this.a).getVersionInfo());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final zzaqc r() {
        if (this.a instanceof Adapter) {
            return zzaqc.a(((Adapter) this.a).getSDKVersionInfo());
        }
        return null;
    }

    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> a(zzano zzanoVar) {
        return new cz(this, zzanoVar);
    }

    private final Bundle a(String str, zzvk zzvkVar, String str2) throws RemoteException {
        Bundle bundle;
        String valueOf = String.valueOf(str);
        zzaza.b(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle2 = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                bundle = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle.putString(next, jSONObject.getString(next));
                }
            } else {
                bundle = bundle2;
            }
            if (this.a instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzvkVar != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzvkVar.g);
                }
            }
            bundle.remove("max_ad_content_rating");
            return bundle;
        } catch (Throwable th) {
            zzaza.c("", th);
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
