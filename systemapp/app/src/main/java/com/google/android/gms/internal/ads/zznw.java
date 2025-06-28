package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zznw extends zzob {
    private static final int[] a = new int[0];
    private final zzof b;
    private final AtomicReference<zznz> c;

    public zznw() {
        this(null);
    }

    private static int a(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    private static boolean b(int i, boolean z) {
        int i2 = i & 3;
        if (i2 != 3) {
            return z && i2 == 2;
        }
        return true;
    }

    private zznw(zzof zzofVar) {
        this.b = null;
        this.c = new AtomicReference<>(new zznz());
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x0182, code lost:
    
        if (r10.a <= r13) goto L358;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:143:0x026e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01ef A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01b4  */
    @Override // com.google.android.gms.internal.ads.zzob
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final com.google.android.gms.internal.ads.zzoc[] a(com.google.android.gms.internal.ads.zzhx[] r47, com.google.android.gms.internal.ads.zznq[] r48, int[][][] r49) throws com.google.android.gms.internal.ads.zzhe {
        /*
            Method dump skipped, instructions count: 1116
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznw.a(com.google.android.gms.internal.ads.zzhx[], com.google.android.gms.internal.ads.zznq[], int[][][]):com.google.android.gms.internal.ads.zzoc[]");
    }
}
