package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzae;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzazq;
import com.google.android.gms.internal.ads.zzdyz;
import com.google.android.gms.internal.ads.zzl;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzax {
    private static zzae a;
    private static final Object b = new Object();

    @Deprecated
    private static final zzbb<Void> c = new l();

    public zzax(Context context) {
        a(context.getApplicationContext() != null ? context.getApplicationContext() : context);
    }

    public static zzdyz<com.google.android.gms.internal.ads.zzy> a(String str) {
        zzazq zzazqVar = new zzazq();
        a.a(new zzbd(str, zzazqVar));
        return zzazqVar;
    }

    public final zzdyz<String> a(int i, String str, Map<String, String> map, byte[] bArr) {
        n nVar = new n(null);
        k kVar = new k(this, str, nVar);
        zzayu zzayuVar = new zzayu(null);
        m mVar = new m(this, i, str, nVar, kVar, bArr, map, zzayuVar);
        if (zzayu.c()) {
            try {
                zzayuVar.a(str, "GET", mVar.b(), mVar.a());
            } catch (zzl e) {
                zzd.e(e.getMessage());
            }
        }
        a.a(mVar);
        return nVar;
    }

    public final zzdyz<String> a(String str, Map<String, String> map) {
        return a(0, str, map, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0027 A[Catch: all -> 0x0036, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0010, B:12:0x0027, B:13:0x0030, B:14:0x002c, B:16:0x0032, B:17:0x0034), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002c A[Catch: all -> 0x0036, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0010, B:12:0x0027, B:13:0x0030, B:14:0x002c, B:16:0x0032, B:17:0x0034), top: B:3:0x0003 }] */
    @com.google.android.gms.common.util.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.gms.internal.ads.zzae a(android.content.Context r3) {
        /*
            java.lang.Object r0 = com.google.android.gms.ads.internal.util.zzax.b
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzae r1 = com.google.android.gms.ads.internal.util.zzax.a     // Catch: java.lang.Throwable -> L36
            if (r1 != 0) goto L32
            com.google.android.gms.internal.ads.zzabf.a(r3)     // Catch: java.lang.Throwable -> L36
            boolean r1 = com.google.android.gms.common.util.ClientLibraryUtils.a()     // Catch: java.lang.Throwable -> L36
            if (r1 != 0) goto L24
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzabf.cb     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.internal.ads.zzabb r2 = com.google.android.gms.internal.ads.zzwq.e()     // Catch: java.lang.Throwable -> L36
            java.lang.Object r1 = r2.a(r1)     // Catch: java.lang.Throwable -> L36
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L36
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L36
            if (r1 == 0) goto L24
            r1 = 1
            goto L25
        L24:
            r1 = 0
        L25:
            if (r1 == 0) goto L2c
            com.google.android.gms.internal.ads.zzae r3 = com.google.android.gms.ads.internal.util.zzaq.a(r3)     // Catch: java.lang.Throwable -> L36
            goto L30
        L2c:
            com.google.android.gms.internal.ads.zzae r3 = com.google.android.gms.internal.ads.zzbk.a(r3)     // Catch: java.lang.Throwable -> L36
        L30:
            com.google.android.gms.ads.internal.util.zzax.a = r3     // Catch: java.lang.Throwable -> L36
        L32:
            com.google.android.gms.internal.ads.zzae r3 = com.google.android.gms.ads.internal.util.zzax.a     // Catch: java.lang.Throwable -> L36
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L36
            return r3
        L36:
            r3 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L36
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzax.a(android.content.Context):com.google.android.gms.internal.ads.zzae");
    }
}
