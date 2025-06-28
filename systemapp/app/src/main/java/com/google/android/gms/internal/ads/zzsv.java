package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzsv {
    private zzxg a;
    private final Context b;
    private final String c;
    private final zzza d;

    @AppOpenAd.AppOpenAdOrientation
    private final int e;
    private final AppOpenAd.AppOpenAdLoadCallback f;
    private final zzanj g = new zzanj();
    private final zzvl h = zzvl.a;

    public zzsv(Context context, String str, zzza zzzaVar, @AppOpenAd.AppOpenAdOrientation int i, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.b = context;
        this.c = str;
        this.d = zzzaVar;
        this.e = i;
        this.f = appOpenAdLoadCallback;
    }

    public final void a() {
        try {
            this.a = zzwq.b().a(this.b, zzvn.c(), this.c, this.g);
            this.a.a(new zzvw(this.e));
            this.a.a(new zzsf(this.f));
            this.a.a(zzvl.a(this.b, this.d));
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }
}
