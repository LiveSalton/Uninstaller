package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
final class azg {
    public float A;
    public float B;
    public float C;
    public float D;
    public float E;
    public float F;
    public int G;
    public int H;
    public int I;
    public long J;
    public long K;
    public boolean L;
    public boolean M;
    public zzkh N;
    public int O;
    private String P;
    public String a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public byte[] f;
    public zzkg g;
    public byte[] h;
    public zzjo i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public byte[] o;
    public int p;
    public boolean q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public float w;
    public float x;
    public float y;
    public float z;

    private azg() {
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = 0;
        this.o = null;
        this.p = -1;
        this.q = false;
        this.r = -1;
        this.s = -1;
        this.t = -1;
        this.u = 1000;
        this.v = 200;
        this.w = -1.0f;
        this.x = -1.0f;
        this.y = -1.0f;
        this.z = -1.0f;
        this.A = -1.0f;
        this.B = -1.0f;
        this.C = -1.0f;
        this.D = -1.0f;
        this.E = -1.0f;
        this.F = -1.0f;
        this.G = 1;
        this.H = -1;
        this.I = 8000;
        this.J = 0L;
        this.K = 0L;
        this.M = true;
        this.P = "eng";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x033c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.google.android.gms.internal.ads.zzjy r29, int r30) throws com.google.android.gms.internal.ads.zzhw {
        /*
            Method dump skipped, instructions count: 1438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.azg.a(com.google.android.gms.internal.ads.zzjy, int):void");
    }

    private static List<byte[]> a(zzpn zzpnVar) throws zzhw {
        try {
            zzpnVar.d(16);
            if (zzpnVar.k() != 826496599) {
                return null;
            }
            byte[] bArr = zzpnVar.a;
            for (int d = zzpnVar.d() + 20; d < bArr.length - 4; d++) {
                if (bArr[d] == 0 && bArr[d + 1] == 0 && bArr[d + 2] == 1 && bArr[d + 3] == 15) {
                    return Collections.singletonList(Arrays.copyOfRange(bArr, d, bArr.length));
                }
            }
            throw new zzhw("Failed to find FourCC VC1 initialization data");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhw("Error parsing FourCC VC1 codec private");
        }
    }

    private static List<byte[]> a(byte[] bArr) throws zzhw {
        try {
            if (bArr[0] != 2) {
                throw new zzhw("Error parsing vorbis codec private");
            }
            int i = 0;
            int i2 = 1;
            while (bArr[i2] == -1) {
                i += 255;
                i2++;
            }
            int i3 = i2 + 1;
            int i4 = i + bArr[i2];
            int i5 = 0;
            while (bArr[i3] == -1) {
                i5 += 255;
                i3++;
            }
            int i6 = i3 + 1;
            int i7 = i5 + bArr[i3];
            if (bArr[i6] != 1) {
                throw new zzhw("Error parsing vorbis codec private");
            }
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, i6, bArr2, 0, i4);
            int i8 = i6 + i4;
            if (bArr[i8] != 3) {
                throw new zzhw("Error parsing vorbis codec private");
            }
            int i9 = i8 + i7;
            if (bArr[i9] != 5) {
                throw new zzhw("Error parsing vorbis codec private");
            }
            byte[] bArr3 = new byte[bArr.length - i9];
            System.arraycopy(bArr, i9, bArr3, 0, bArr.length - i9);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(bArr2);
            arrayList.add(bArr3);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhw("Error parsing vorbis codec private");
        }
    }

    private static boolean b(zzpn zzpnVar) throws zzhw {
        try {
            int h = zzpnVar.h();
            if (h == 1) {
                return true;
            }
            if (h != 65534) {
                return false;
            }
            zzpnVar.c(24);
            if (zzpnVar.m() == zzkm.d.getMostSignificantBits()) {
                if (zzpnVar.m() == zzkm.d.getLeastSignificantBits()) {
                    return true;
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhw("Error parsing MS/ACM codec private");
        }
    }

    /* synthetic */ azg(aze azeVar) {
        this();
    }
}
