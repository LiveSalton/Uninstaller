package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.lang.ref.WeakReference;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzchc extends zzboc {
    private final Context c;
    private final WeakReference<zzbdv> d;
    private final zzcaf e;
    private final zzbxm f;
    private final zzbsb g;
    private final zzbti h;
    private final zzbov i;
    private final zzavc j;
    private final zzdst k;
    private boolean l;

    zzchc(zzbob zzbobVar, Context context, zzbdv zzbdvVar, zzcaf zzcafVar, zzbxm zzbxmVar, zzbsb zzbsbVar, zzbti zzbtiVar, zzbov zzbovVar, zzdmu zzdmuVar, zzdst zzdstVar) {
        super(zzbobVar);
        this.l = false;
        this.c = context;
        this.e = zzcafVar;
        this.d = new WeakReference<>(zzbdvVar);
        this.f = zzbxmVar;
        this.g = zzbsbVar;
        this.h = zzbtiVar;
        this.i = zzbovVar;
        this.k = zzdstVar;
        this.j = new zzawd(zzdmuVar.l);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.content.Context] */
    public final boolean a(boolean z, Activity activity) {
        if (((Boolean) zzwq.e().a(zzabf.af)).booleanValue()) {
            zzp.c();
            if (com.google.android.gms.ads.internal.util.zzm.g(this.c)) {
                zzd.e("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.g.a();
                if (((Boolean) zzwq.e().a(zzabf.ag)).booleanValue()) {
                    this.k.a(this.a.b.b.b);
                }
                return false;
            }
        }
        if (this.l) {
            zzd.e("The rewarded ad have been showed.");
            this.g.a(zzdoi.a(zzdok.AD_REUSED, null, null));
            return false;
        }
        this.l = true;
        this.f.a();
        Activity activity2 = activity;
        if (activity == null) {
            activity2 = this.c;
        }
        try {
            this.e.a(z, activity2);
            this.f.b();
            return true;
        } catch (zzcai e) {
            this.g.a(e);
            return false;
        }
    }

    public final boolean a() {
        return this.l;
    }

    public final zzavc c() {
        return this.j;
    }

    public final boolean d() {
        return this.i.a();
    }

    public final boolean e() {
        zzbdv zzbdvVar = this.d.get();
        return (zzbdvVar == null || zzbdvVar.P()) ? false : true;
    }

    public final Bundle f() {
        return this.h.a();
    }

    public final void finalize() throws Throwable {
        try {
            zzbdv zzbdvVar = this.d.get();
            if (((Boolean) zzwq.e().a(zzabf.dR)).booleanValue()) {
                if (!this.l && zzbdvVar != null) {
                    zzdzc zzdzcVar = zzazj.e;
                    zzbdvVar.getClass();
                    zzdzcVar.execute(tf.a(zzbdvVar));
                }
            } else if (zzbdvVar != null) {
                zzbdvVar.destroy();
            }
        } finally {
            super.finalize();
        }
    }
}
