package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzid {
    private static final int[] a = {1, 2, 3, 6};
    private static final int[] b = {48000, 44100, 32000};
    private static final int[] c = {24000, 22050, 16000};
    private static final int[] d = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] f = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int a() {
        return 1536;
    }

    public static zzhp a(zzpn zzpnVar, String str, String str2, zzjo zzjoVar) {
        int i = b[(zzpnVar.f() & 192) >> 6];
        int f2 = zzpnVar.f();
        int i2 = d[(f2 & 56) >> 3];
        if ((f2 & 4) != 0) {
            i2++;
        }
        return zzhp.a(str, "audio/ac3", null, -1, -1, i2, i, null, zzjoVar, 0, str2);
    }

    public static zzhp b(zzpn zzpnVar, String str, String str2, zzjo zzjoVar) {
        zzpnVar.d(2);
        int i = b[(zzpnVar.f() & 192) >> 6];
        int f2 = zzpnVar.f();
        int i2 = d[(f2 & 14) >> 1];
        if ((f2 & 1) != 0) {
            i2++;
        }
        return zzhp.a(str, "audio/eac3", null, -1, -1, i2, i, null, zzjoVar, 0, str2);
    }

    public static int a(ByteBuffer byteBuffer) {
        return 256 * (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? a[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4] : 6);
    }
}
