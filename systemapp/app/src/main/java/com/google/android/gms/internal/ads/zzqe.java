package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.WindowManager;

/* compiled from: source */
@TargetApi(16)
/* loaded from: classes.dex */
public final class zzqe {
    private final bbk a;
    private final boolean b;
    private final long c;
    private final long d;
    private long e;
    private long f;
    private long g;
    private boolean h;
    private long i;
    private long j;
    private long k;

    public zzqe() {
        this(-1.0d);
    }

    public zzqe(Context context) {
        this(((WindowManager) context.getSystemService("window")).getDefaultDisplay() != null ? r3.getDefaultDisplay().getRefreshRate() : -1.0d);
    }

    private zzqe(double d) {
        this.b = d != -1.0d;
        if (this.b) {
            this.a = bbk.a();
            this.c = (long) (1.0E9d / d);
            this.d = (this.c * 80) / 100;
        } else {
            this.a = null;
            this.c = -1L;
            this.d = -1L;
        }
    }

    public final void a() {
        this.h = false;
        if (this.b) {
            this.a.b();
        }
    }

    public final void b() {
        if (this.b) {
            this.a.c();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long a(long r12, long r14) {
        /*
            r11 = this;
            r0 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r12
            boolean r2 = r11.h
            if (r2 == 0) goto L43
            long r2 = r11.e
            int r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r2 == 0) goto L18
            long r2 = r11.k
            r4 = 1
            long r2 = r2 + r4
            r11.k = r2
            long r2 = r11.g
            r11.f = r2
        L18:
            long r2 = r11.k
            r4 = 6
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r3 = 0
            if (r2 < 0) goto L3b
            long r4 = r11.j
            long r4 = r0 - r4
            long r6 = r11.k
            long r4 = r4 / r6
            long r6 = r11.f
            long r4 = r4 + r6
            boolean r2 = r11.b(r4, r14)
            if (r2 == 0) goto L34
            r11.h = r3
            goto L43
        L34:
            long r2 = r11.i
            long r2 = r2 + r4
            long r6 = r11.j
            long r2 = r2 - r6
            goto L45
        L3b:
            boolean r2 = r11.b(r0, r14)
            if (r2 == 0) goto L43
            r11.h = r3
        L43:
            r2 = r14
            r4 = r0
        L45:
            boolean r6 = r11.h
            r7 = 0
            if (r6 != 0) goto L54
            r11.j = r0
            r11.i = r14
            r11.k = r7
            r14 = 1
            r11.h = r14
        L54:
            r11.e = r12
            r11.g = r4
            com.google.android.gms.internal.ads.bbk r12 = r11.a
            if (r12 == 0) goto L88
            com.google.android.gms.internal.ads.bbk r12 = r11.a
            long r12 = r12.a
            int r12 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r12 != 0) goto L65
            goto L88
        L65:
            com.google.android.gms.internal.ads.bbk r12 = r11.a
            long r12 = r12.a
            long r14 = r11.c
            long r0 = r2 - r12
            long r0 = r0 / r14
            long r0 = r0 * r14
            long r12 = r12 + r0
            int r0 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r0 > 0) goto L77
            long r14 = r12 - r14
            goto L7b
        L77:
            long r14 = r14 + r12
            r9 = r12
            r12 = r14
            r14 = r9
        L7b:
            long r0 = r12 - r2
            long r2 = r2 - r14
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L83
            goto L84
        L83:
            r12 = r14
        L84:
            long r14 = r11.d
            long r12 = r12 - r14
            return r12
        L88:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqe.a(long, long):long");
    }

    private final boolean b(long j, long j2) {
        return Math.abs((j2 - this.i) - (j - this.j)) > 20000000;
    }
}
