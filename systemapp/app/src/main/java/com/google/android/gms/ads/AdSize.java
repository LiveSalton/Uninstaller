package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzayr;
import com.google.android.gms.internal.ads.zzvn;
import com.google.android.gms.internal.ads.zzwq;

/* compiled from: source */
@VisibleForTesting
/* loaded from: classes.dex */
public final class AdSize {
    public static final AdSize a = new AdSize(320, 50, "320x50_mb");
    public static final AdSize b = new AdSize(468, 60, "468x60_as");
    public static final AdSize c = new AdSize(320, 100, "320x100_as");
    public static final AdSize d = new AdSize(728, 90, "728x90_as");
    public static final AdSize e = new AdSize(300, 250, "300x250_as");
    public static final AdSize f = new AdSize(160, 600, "160x600_as");
    public static final AdSize g = new AdSize(-1, -2, "smart_banner");
    public static final AdSize h = new AdSize(-3, -4, "fluid");
    public static final AdSize i = new AdSize(0, 0, "invalid");
    public static final AdSize j = new AdSize(50, 50, "50x50_mb");
    public static final AdSize k = new AdSize(-3, 0, "search_v2");
    private final int l;
    private final int m;
    private final String n;
    private boolean o;
    private boolean p;
    private int q;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AdSize(int r5, int r6) {
        /*
            r4 = this;
            r0 = -1
            if (r5 != r0) goto L6
            java.lang.String r0 = "FULL"
            goto La
        L6:
            java.lang.String r0 = java.lang.String.valueOf(r5)
        La:
            r1 = -2
            if (r6 != r1) goto L10
            java.lang.String r1 = "AUTO"
            goto L14
        L10:
            java.lang.String r1 = java.lang.String.valueOf(r6)
        L14:
            r2 = 4
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            int r2 = r2 + r3
            java.lang.String r3 = java.lang.String.valueOf(r1)
            int r3 = r3.length()
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r0)
            java.lang.String r0 = "x"
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = "_as"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r4.<init>(r5, r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.AdSize.<init>(int, int):void");
    }

    AdSize(int i2, int i3, String str) {
        if (i2 < 0 && i2 != -1 && i2 != -3) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Invalid width for AdSize: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i3 < 0 && i3 != -2 && i3 != -4) {
            StringBuilder sb2 = new StringBuilder(38);
            sb2.append("Invalid height for AdSize: ");
            sb2.append(i3);
            throw new IllegalArgumentException(sb2.toString());
        }
        this.l = i2;
        this.m = i3;
        this.n = str;
    }

    public static AdSize a(Context context, int i2) {
        AdSize a2 = zzayr.a(context, i2, 50, 0);
        a2.o = true;
        return a2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.l == adSize.l && this.m == adSize.m && this.n.equals(adSize.n);
    }

    public final int a() {
        return this.m;
    }

    public final int a(Context context) {
        switch (this.m) {
            case -4:
            case -3:
                return -1;
            case -2:
                return zzvn.b(context.getResources().getDisplayMetrics());
            default:
                zzwq.a();
                return zzayr.a(context, this.m);
        }
    }

    public final int b() {
        return this.l;
    }

    public final int b(Context context) {
        int i2 = this.l;
        if (i2 == -1) {
            return zzvn.a(context.getResources().getDisplayMetrics());
        }
        switch (i2) {
            case -4:
            case -3:
                return -1;
            default:
                zzwq.a();
                return zzayr.a(context, this.l);
        }
    }

    public final int hashCode() {
        return this.n.hashCode();
    }

    public final boolean c() {
        return this.l == -3 && this.m == -4;
    }

    final boolean d() {
        return this.o;
    }

    final boolean e() {
        return this.p;
    }

    final void a(boolean z) {
        this.p = true;
    }

    final void a(int i2) {
        this.q = i2;
    }

    final int f() {
        return this.q;
    }

    public final String toString() {
        return this.n;
    }
}
