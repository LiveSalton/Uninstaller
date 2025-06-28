package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbyx extends zzboc {
    private final Context c;
    private final WeakReference<zzbdv> d;
    private final zzbxm e;
    private final zzcaf f;
    private final zzbov g;
    private final zzdst h;
    private final zzbsb i;
    private boolean j;

    zzbyx(zzbob zzbobVar, Context context, @Nullable zzbdv zzbdvVar, zzbxm zzbxmVar, zzcaf zzcafVar, zzbov zzbovVar, zzdst zzdstVar, zzbsb zzbsbVar) {
        super(zzbobVar);
        this.j = false;
        this.c = context;
        this.d = new WeakReference<>(zzbdvVar);
        this.e = zzbxmVar;
        this.f = zzcafVar;
        this.g = zzbovVar;
        this.h = zzdstVar;
        this.i = zzbsbVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0052 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(boolean r5) {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.af
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.e()
            java.lang.Object r0 = r1.a(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L49
            com.google.android.gms.ads.internal.zzp.c()
            android.content.Context r0 = r4.c
            boolean r0 = com.google.android.gms.ads.internal.util.zzm.g(r0)
            if (r0 == 0) goto L49
            java.lang.String r0 = "Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies"
            com.google.android.gms.ads.internal.util.zzd.e(r0)
            com.google.android.gms.internal.ads.zzbsb r0 = r4.i
            r0.a()
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.ag
            com.google.android.gms.internal.ads.zzabb r3 = com.google.android.gms.internal.ads.zzwq.e()
            java.lang.Object r0 = r3.a(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L4f
            com.google.android.gms.internal.ads.zzdst r0 = r4.h
            com.google.android.gms.internal.ads.zzdnj r3 = r4.a
            com.google.android.gms.internal.ads.zzdnh r3 = r3.b
            com.google.android.gms.internal.ads.zzdmz r3 = r3.b
            java.lang.String r3 = r3.b
            r0.a(r3)
            goto L4f
        L49:
            boolean r0 = r4.j
            if (r0 != 0) goto L4f
            r0 = r1
            goto L50
        L4f:
            r0 = r2
        L50:
            if (r0 != 0) goto L53
            return r2
        L53:
            com.google.android.gms.internal.ads.zzbxm r0 = r4.e
            r0.a()
            com.google.android.gms.internal.ads.zzcaf r0 = r4.f     // Catch: com.google.android.gms.internal.ads.zzcai -> L67
            android.content.Context r3 = r4.c     // Catch: com.google.android.gms.internal.ads.zzcai -> L67
            r0.a(r5, r3)     // Catch: com.google.android.gms.internal.ads.zzcai -> L67
            com.google.android.gms.internal.ads.zzbxm r5 = r4.e     // Catch: com.google.android.gms.internal.ads.zzcai -> L67
            r5.b()     // Catch: com.google.android.gms.internal.ads.zzcai -> L67
            r4.j = r1
            return r1
        L67:
            r5 = move-exception
            com.google.android.gms.internal.ads.zzbsb r0 = r4.i
            r0.a(r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbyx.a(boolean):boolean");
    }

    public final boolean a() {
        return this.g.a();
    }

    public final void finalize() throws Throwable {
        try {
            zzbdv zzbdvVar = this.d.get();
            if (((Boolean) zzwq.e().a(zzabf.dR)).booleanValue()) {
                if (!this.j && zzbdvVar != null) {
                    zzdzc zzdzcVar = zzazj.e;
                    zzbdvVar.getClass();
                    zzdzcVar.execute(qf.a(zzbdvVar));
                }
            } else if (zzbdvVar != null) {
                zzbdvVar.destroy();
            }
        } finally {
            super.finalize();
        }
    }
}
