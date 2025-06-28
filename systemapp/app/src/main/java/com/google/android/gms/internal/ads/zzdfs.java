package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdfs implements zzdfi<zzdft> {
    private final zzdzc a;
    private final Context b;

    public zzdfs(zzdzc zzdzcVar, Context context) {
        this.a = zzdzcVar;
        this.b = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdft> a() {
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.aem
            private final zzdfs a;

            {
                this.a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.b();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final /* synthetic */ com.google.android.gms.internal.ads.zzdft b() throws java.lang.Exception {
        /*
            r8 = this;
            android.content.Context r0 = r8.b
            java.lang.String r1 = "phone"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            java.lang.String r2 = r0.getNetworkOperator()
            boolean r1 = com.google.android.gms.common.util.PlatformVersion.m()
            r3 = 0
            if (r1 == 0) goto L29
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzabf.eE
            com.google.android.gms.internal.ads.zzabb r4 = com.google.android.gms.internal.ads.zzwq.e()
            java.lang.Object r1 = r4.a(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L29
            r4 = r3
            goto L2e
        L29:
            int r1 = r0.getNetworkType()
            r4 = r1
        L2e:
            int r5 = r0.getPhoneType()
            r0 = -2
            com.google.android.gms.ads.internal.zzp.c()
            android.content.Context r1 = r8.b
            java.lang.String r6 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r1 = com.google.android.gms.ads.internal.util.zzm.a(r1, r6)
            r6 = -1
            if (r1 == 0) goto L67
            android.content.Context r0 = r8.b
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            android.net.NetworkInfo r1 = r0.getActiveNetworkInfo()
            if (r1 == 0) goto L5e
            int r6 = r1.getType()
            android.net.NetworkInfo$DetailedState r1 = r1.getDetailedState()
            int r1 = r1.ordinal()
            goto L5f
        L5e:
            r1 = r6
        L5f:
            boolean r0 = r0.isActiveNetworkMetered()
            r7 = r1
            r3 = r6
            r6 = r0
            goto L6a
        L67:
            r7 = r6
            r6 = r3
            r3 = r0
        L6a:
            com.google.android.gms.internal.ads.zzdft r0 = new com.google.android.gms.internal.ads.zzdft
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdfs.b():com.google.android.gms.internal.ads.zzdft");
    }
}
