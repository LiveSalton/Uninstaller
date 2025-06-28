package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.e;
import com.google.ads.mediation.f;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaom<NETWORK_EXTRAS extends com.google.ads.mediation.f, SERVER_PARAMETERS extends com.google.ads.mediation.e> extends zzanm {
    private final com.google.ads.mediation.b<NETWORK_EXTRAS, SERVER_PARAMETERS> a;
    private final NETWORK_EXTRAS b;

    public zzaom(com.google.ads.mediation.b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar, NETWORK_EXTRAS network_extras) {
        this.a = bVar;
        this.b = network_extras;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(IObjectWrapper iObjectWrapper, zzajb zzajbVar, List<zzajj> list) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(IObjectWrapper iObjectWrapper, zzauw zzauwVar, List<String> list) {
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(IObjectWrapper iObjectWrapper, zzvk zzvkVar, String str, zzauw zzauwVar, String str2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(IObjectWrapper iObjectWrapper, zzvk zzvkVar, String str, String str2, zzano zzanoVar, zzadz zzadzVar, List<String> list) {
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(zzvk zzvkVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(zzvk zzvkVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void b(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void b(IObjectWrapper iObjectWrapper, zzvk zzvkVar, String str, zzano zzanoVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void c(IObjectWrapper iObjectWrapper, zzvk zzvkVar, String str, zzano zzanoVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void f() {
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final boolean g() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final zzanv h() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final zzanw i() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final boolean m() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final zzaff n() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final zzys o() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final zzaob p() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final zzaqc q() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final zzaqc r() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final IObjectWrapper a() throws RemoteException {
        if (!(this.a instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(this.a.getClass().getCanonicalName());
            zzaza.e(valueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(valueOf) : new String("Not a MediationBannerAdapter: "));
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
        com.google.ads.b bVar;
        if (!(this.a instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(this.a.getClass().getCanonicalName());
            zzaza.e(valueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(valueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        zzaza.b("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.a;
            zzaop zzaopVar = new zzaop(zzanoVar);
            Activity activity = (Activity) ObjectWrapper.a(iObjectWrapper);
            SERVER_PARAMETERS a = a(str);
            int i = 0;
            com.google.ads.b[] bVarArr = {com.google.ads.b.a, com.google.ads.b.b, com.google.ads.b.c, com.google.ads.b.d, com.google.ads.b.e, com.google.ads.b.f};
            while (true) {
                if (i < 6) {
                    if (bVarArr[i].a() == zzvnVar.e && bVarArr[i].b() == zzvnVar.b) {
                        bVar = bVarArr[i];
                        break;
                    }
                    i++;
                } else {
                    bVar = new com.google.ads.b(com.google.android.gms.ads.zzb.a(zzvnVar.e, zzvnVar.b, zzvnVar.a));
                    break;
                }
            }
            mediationBannerAdapter.requestBannerAd(zzaopVar, activity, a, bVar, zzapb.a(zzvkVar, a(zzvkVar)), this.b);
        } catch (Throwable th) {
            zzaza.c("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final Bundle j() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(IObjectWrapper iObjectWrapper, zzvk zzvkVar, String str, zzano zzanoVar) throws RemoteException {
        a(iObjectWrapper, zzvkVar, str, (String) null, zzanoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void a(IObjectWrapper iObjectWrapper, zzvk zzvkVar, String str, String str2, zzano zzanoVar) throws RemoteException {
        if (!(this.a instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(this.a.getClass().getCanonicalName());
            zzaza.e(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzaza.b("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.a).requestInterstitialAd(new zzaop(zzanoVar), (Activity) ObjectWrapper.a(iObjectWrapper), a(str), zzapb.a(zzvkVar, a(zzvkVar)), this.b);
        } catch (Throwable th) {
            zzaza.c("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final Bundle k() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void b() throws RemoteException {
        if (!(this.a instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(this.a.getClass().getCanonicalName());
            zzaza.e(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
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
    public final Bundle l() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void c() throws RemoteException {
        try {
            this.a.destroy();
        } catch (Throwable th) {
            zzaza.c("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void d() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzann
    public final void e() throws RemoteException {
        throw new RemoteException();
    }

    private final SERVER_PARAMETERS a(String str) throws RemoteException {
        HashMap hashMap;
        try {
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            } else {
                hashMap = new HashMap(0);
            }
            Class<SERVER_PARAMETERS> serverParametersType = this.a.getServerParametersType();
            if (serverParametersType == null) {
                return null;
            }
            SERVER_PARAMETERS newInstance = serverParametersType.newInstance();
            newInstance.a(hashMap);
            return newInstance;
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
}
