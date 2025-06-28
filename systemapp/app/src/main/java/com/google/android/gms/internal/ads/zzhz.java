package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzhz {
    public static final zzhz a = new ayc();

    public abstract int a(Object obj);

    public abstract zzib a(int i, zzib zzibVar, boolean z);

    public abstract zzie a(int i, zzie zzieVar, boolean z, long j);

    public abstract int b();

    public abstract int c();

    public final boolean a() {
        return b() == 0;
    }

    public final zzie a(int i, zzie zzieVar, boolean z) {
        return a(i, zzieVar, false, 0L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
        if ((b() - 1) == 0) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0027 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(int r2, com.google.android.gms.internal.ads.zzib r3, com.google.android.gms.internal.ads.zzie r4, int r5) {
        /*
            r1 = this;
            r0 = 0
            r1.a(r2, r3, r0)
            r1.a(r0, r4, r0)
            r3 = 1
            if (r2 != 0) goto L2c
            r2 = -1
            switch(r5) {
                case 0: goto L1d;
                case 1: goto L1b;
                case 2: goto L14;
                default: goto Le;
            }
        Le:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            r2.<init>()
            throw r2
        L14:
            int r5 = r1.b()
            int r5 = r5 - r3
            if (r5 != 0) goto L25
        L1b:
            r3 = r0
            goto L25
        L1d:
            int r5 = r1.b()
            int r5 = r5 - r3
            if (r5 != 0) goto L25
            r3 = r2
        L25:
            if (r3 != r2) goto L28
            return r2
        L28:
            r1.a(r3, r4, r0)
            return r0
        L2c:
            int r2 = r2 + r3
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhz.a(int, com.google.android.gms.internal.ads.zzib, com.google.android.gms.internal.ads.zzie, int):int");
    }
}
