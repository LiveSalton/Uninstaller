package com.google.android.gms.internal.ads;

import android.util.Pair;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzpf {
    private static final byte[] a = {0, 0, 0, 1};
    private static final int[] b = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] c = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static Pair<Integer, Integer> a(byte[] bArr) {
        zzpk zzpkVar = new zzpk(bArr);
        int a2 = a(zzpkVar);
        int b2 = b(zzpkVar);
        int a3 = zzpkVar.a(4);
        if (a2 == 5 || a2 == 29) {
            b2 = b(zzpkVar);
            if (a(zzpkVar) == 22) {
                a3 = zzpkVar.a(4);
            }
        }
        int i = c[a3];
        zzpc.a(i != -1);
        return Pair.create(Integer.valueOf(b2), Integer.valueOf(i));
    }

    public static byte[] a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[a.length + i2];
        System.arraycopy(a, 0, bArr2, 0, a.length);
        System.arraycopy(bArr, i, bArr2, a.length, i2);
        return bArr2;
    }

    private static int a(zzpk zzpkVar) {
        int a2 = zzpkVar.a(5);
        return a2 == 31 ? 32 + zzpkVar.a(6) : a2;
    }

    private static int b(zzpk zzpkVar) {
        int a2 = zzpkVar.a(4);
        if (a2 == 15) {
            return zzpkVar.a(24);
        }
        zzpc.a(a2 < 13);
        return b[a2];
    }
}
