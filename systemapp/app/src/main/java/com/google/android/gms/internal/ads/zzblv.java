package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzblv extends zzboc {
    private final zzbdv c;
    private final int d;
    private final zzble e;
    private final zzcaf f;
    private boolean g;

    zzblv(zzbob zzbobVar, zzbdv zzbdvVar, int i, zzble zzbleVar, zzcaf zzcafVar) {
        super(zzbobVar);
        this.g = false;
        this.c = zzbdvVar;
        this.d = i;
        this.e = zzbleVar;
        this.f = zzcafVar;
    }

    public final void a(zzsc zzscVar) {
        if (this.c != null) {
            this.c.a(zzscVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x006c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.app.Activity r6, com.google.android.gms.internal.ads.zzsq r7) throws android.os.RemoteException {
        /*
            r5 = this;
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.af
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.e()
            java.lang.Object r0 = r1.a(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L5c
            com.google.android.gms.ads.internal.zzp.c()
            boolean r0 = com.google.android.gms.ads.internal.util.zzm.g(r6)
            if (r0 == 0) goto L5c
            java.lang.String r0 = "Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies"
            com.google.android.gms.ads.internal.util.zzd.e(r0)
            com.google.android.gms.internal.ads.zzdok r0 = com.google.android.gms.internal.ads.zzdok.APP_NOT_FOREGROUND
            r3 = 0
            com.google.android.gms.internal.ads.zzve r0 = com.google.android.gms.internal.ads.zzdoi.a(r0, r3, r3)
            r7.a(r0)
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.ag
            com.google.android.gms.internal.ads.zzabb r3 = com.google.android.gms.internal.ads.zzwq.e()
            java.lang.Object r0 = r3.a(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L5a
            com.google.android.gms.internal.ads.zzdst r0 = new com.google.android.gms.internal.ads.zzdst
            android.content.Context r3 = r6.getApplicationContext()
            com.google.android.gms.ads.internal.util.zzbo r4 = com.google.android.gms.ads.internal.zzp.q()
            android.os.Looper r4 = r4.a()
            r0.<init>(r3, r4)
            com.google.android.gms.internal.ads.zzdnj r3 = r5.a
            com.google.android.gms.internal.ads.zzdnh r3 = r3.b
            com.google.android.gms.internal.ads.zzdmz r3 = r3.b
            java.lang.String r3 = r3.b
            r0.a(r3)
        L5a:
            r0 = r2
            goto L6a
        L5c:
            boolean r0 = r5.g
            if (r0 == 0) goto L65
            java.lang.String r0 = "App open interstitial ad is already visible."
            com.google.android.gms.ads.internal.util.zzd.e(r0)
        L65:
            boolean r0 = r5.g
            if (r0 != 0) goto L5a
            r0 = r1
        L6a:
            if (r0 != 0) goto L6d
            return
        L6d:
            com.google.android.gms.internal.ads.zzcaf r0 = r5.f     // Catch: com.google.android.gms.internal.ads.zzcai -> L75
            r0.a(r2, r6)     // Catch: com.google.android.gms.internal.ads.zzcai -> L75
            r5.g = r1
            return
        L75:
            r6 = move-exception
            com.google.android.gms.internal.ads.zzve r6 = com.google.android.gms.internal.ads.zzdoi.a(r6)
            r7.a(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzblv.a(android.app.Activity, com.google.android.gms.internal.ads.zzsq):void");
    }

    public final int a() {
        return this.d;
    }

    public final void a(long j, int i) {
        this.e.a(j, i);
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void b() {
        super.b();
        if (this.c != null) {
            this.c.destroy();
        }
    }
}
