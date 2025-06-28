package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzmd;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
final class azm {
    private static final int a = zzpt.c("vide");
    private static final int b = zzpt.c("soun");
    private static final int c = zzpt.c("text");
    private static final int d = zzpt.c("sbtl");
    private static final int e = zzpt.c("subt");
    private static final int f = zzpt.c("clcp");
    private static final int g = zzpt.c("cenc");
    private static final int h = zzpt.c("meta");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0774  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x07ae  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0855 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0856  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzlo a(com.google.android.gms.internal.ads.azk r57, com.google.android.gms.internal.ads.azj r58, long r59, com.google.android.gms.internal.ads.zzjo r61, boolean r62) throws com.google.android.gms.internal.ads.zzhw {
        /*
            Method dump skipped, instructions count: 2202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.azm.a(com.google.android.gms.internal.ads.azk, com.google.android.gms.internal.ads.azj, long, com.google.android.gms.internal.ads.zzjo, boolean):com.google.android.gms.internal.ads.zzlo");
    }

    public static bac a(zzlo zzloVar, azk azkVar, zzka zzkaVar) throws zzhw {
        azo azpVar;
        boolean z;
        int i;
        int i2;
        int i3;
        long[] jArr;
        int[] iArr;
        long[] jArr2;
        int[] iArr2;
        int i4;
        long j;
        boolean z2;
        long[] jArr3;
        long[] jArr4;
        long[] jArr5;
        int[] iArr3;
        int[] iArr4;
        int i5;
        int[] iArr5;
        int[] iArr6;
        zzpn zzpnVar;
        zzlo zzloVar2 = zzloVar;
        azj d2 = azkVar.d(azh.ap);
        if (d2 != null) {
            azpVar = new azq(d2);
        } else {
            azj d3 = azkVar.d(azh.aq);
            if (d3 == null) {
                throw new zzhw("Track has no sample table size information");
            }
            azpVar = new azp(d3);
        }
        int a2 = azpVar.a();
        if (a2 == 0) {
            return new bac(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        azj d4 = azkVar.d(azh.ar);
        if (d4 == null) {
            d4 = azkVar.d(azh.as);
            z = true;
        } else {
            z = false;
        }
        zzpn zzpnVar2 = d4.aP;
        zzpn zzpnVar3 = azkVar.d(azh.ao).aP;
        zzpn zzpnVar4 = azkVar.d(azh.al).aP;
        azj d5 = azkVar.d(azh.am);
        zzpn zzpnVar5 = d5 != null ? d5.aP : null;
        azj d6 = azkVar.d(azh.an);
        zzpn zzpnVar6 = d6 != null ? d6.aP : null;
        azl azlVar = new azl(zzpnVar3, zzpnVar2, z);
        zzpnVar4.c(12);
        int o = zzpnVar4.o() - 1;
        int o2 = zzpnVar4.o();
        int o3 = zzpnVar4.o();
        if (zzpnVar6 != null) {
            zzpnVar6.c(12);
            i = zzpnVar6.o();
        } else {
            i = 0;
        }
        int i6 = -1;
        if (zzpnVar5 != null) {
            zzpnVar5.c(12);
            i2 = zzpnVar5.o();
            if (i2 > 0) {
                i6 = zzpnVar5.o() - 1;
            } else {
                zzpnVar5 = null;
            }
        } else {
            i2 = 0;
        }
        long j2 = 0;
        if (!(azpVar.c() && "audio/raw".equals(zzloVar2.f.d) && o == 0 && i == 0 && i2 == 0)) {
            jArr = new long[a2];
            iArr = new int[a2];
            jArr2 = new long[a2];
            int i7 = i2;
            iArr2 = new int[a2];
            zzpn zzpnVar7 = zzpnVar4;
            int i8 = i;
            int i9 = i6;
            long j3 = 0;
            int i10 = i7;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = o;
            long j4 = 0;
            int i16 = 0;
            int i17 = o2;
            int i18 = o3;
            while (i16 < a2) {
                while (i13 == 0) {
                    zzpc.b(azlVar.a());
                    int i19 = i18;
                    long j5 = azlVar.d;
                    i13 = azlVar.c;
                    j4 = j5;
                    a2 = a2;
                    i18 = i19;
                    i15 = i15;
                }
                int i20 = a2;
                int i21 = i18;
                int i22 = i15;
                if (zzpnVar6 != null) {
                    while (i14 == 0 && i8 > 0) {
                        i14 = zzpnVar6.o();
                        i12 = zzpnVar6.l();
                        i8--;
                    }
                    i14--;
                }
                int i23 = i12;
                jArr[i16] = j4;
                iArr[i16] = azpVar.b();
                if (iArr[i16] > i11) {
                    i11 = iArr[i16];
                }
                jArr2[i16] = j3 + i23;
                iArr2[i16] = zzpnVar5 == null ? 1 : 0;
                if (i16 == i9) {
                    iArr2[i16] = 1;
                    i10--;
                    if (i10 > 0) {
                        i9 = zzpnVar5.o() - 1;
                    }
                }
                int i24 = i10;
                int i25 = i9;
                int i26 = i21;
                j3 += i26;
                i17--;
                if (i17 != 0 || i22 <= 0) {
                    zzpnVar = zzpnVar7;
                    i15 = i22;
                } else {
                    zzpnVar = zzpnVar7;
                    i15 = i22 - 1;
                    i17 = zzpnVar.o();
                    i26 = zzpnVar.o();
                }
                zzpn zzpnVar8 = zzpnVar;
                j4 += iArr[i16];
                i13--;
                i16++;
                a2 = i20;
                i12 = i23;
                i9 = i25;
                zzpnVar7 = zzpnVar8;
                i18 = i26;
                i10 = i24;
            }
            i3 = a2;
            int i27 = i15;
            zzpc.a(i14 == 0);
            while (i8 > 0) {
                zzpc.a(zzpnVar6.o() == 0);
                zzpnVar6.l();
                i8--;
            }
            if (i10 == 0 && i17 == 0 && i13 == 0 && i27 == 0) {
                zzloVar2 = zzloVar;
            } else {
                int i28 = i10;
                zzloVar2 = zzloVar;
                int i29 = zzloVar2.a;
                StringBuilder sb = new StringBuilder(215);
                sb.append("Inconsistent stbl box for track ");
                sb.append(i29);
                sb.append(": remainingSynchronizationSamples ");
                sb.append(i28);
                sb.append(", remainingSamplesAtTimestampDelta ");
                sb.append(i17);
                sb.append(", remainingSamplesInChunk ");
                sb.append(i13);
                sb.append(", remainingTimestampDeltaChanges ");
                sb.append(i27);
                Log.w("AtomParsers", sb.toString());
            }
            j = j3;
            i4 = i11;
        } else {
            i3 = a2;
            long[] jArr6 = new long[azlVar.a];
            int[] iArr7 = new int[azlVar.a];
            while (azlVar.a()) {
                jArr6[azlVar.b] = azlVar.d;
                iArr7[azlVar.b] = azlVar.c;
            }
            int b2 = azpVar.b();
            long j6 = o3;
            int i30 = 8192 / b2;
            int i31 = 0;
            for (int i32 : iArr7) {
                i31 += zzpt.a(i32, i30);
            }
            long[] jArr7 = new long[i31];
            int[] iArr8 = new int[i31];
            long[] jArr8 = new long[i31];
            int[] iArr9 = new int[i31];
            int i33 = 0;
            int i34 = 0;
            int i35 = 0;
            for (int i36 = 0; i36 < iArr7.length; i36++) {
                int i37 = iArr7[i36];
                long j7 = jArr6[i36];
                while (i37 > 0) {
                    int min = Math.min(i30, i37);
                    jArr7[i34] = j7;
                    iArr8[i34] = b2 * min;
                    i35 = Math.max(i35, iArr8[i34]);
                    jArr8[i34] = i33 * j6;
                    iArr9[i34] = 1;
                    j7 += iArr8[i34];
                    i33 += min;
                    i37 -= min;
                    i34++;
                    jArr6 = jArr6;
                    iArr7 = iArr7;
                }
            }
            zzle zzleVar = new zzle(jArr7, iArr8, i35, jArr8, iArr9);
            jArr = zzleVar.a;
            iArr = zzleVar.b;
            int i38 = zzleVar.c;
            jArr2 = zzleVar.d;
            iArr2 = zzleVar.e;
            i4 = i38;
            j = 0;
        }
        if (zzloVar2.i == null || zzkaVar.a()) {
            int[] iArr10 = iArr;
            zzpt.a(jArr2, 1000000L, zzloVar2.c);
            return new bac(jArr, iArr10, i4, jArr2, iArr2);
        }
        if (zzloVar2.i.length == 1 && zzloVar2.b == 1 && jArr2.length >= 2) {
            long j8 = zzloVar2.j[0];
            long a3 = zzpt.a(zzloVar2.i[0], zzloVar2.c, zzloVar2.d) + j8;
            if (jArr2[0] <= j8 && j8 < jArr2[1] && jArr2[jArr2.length - 1] < a3 && a3 <= j) {
                long j9 = j - a3;
                long a4 = zzpt.a(j8 - jArr2[0], zzloVar2.f.n, zzloVar2.c);
                long a5 = zzpt.a(j9, zzloVar2.f.n, zzloVar2.c);
                if ((a4 != 0 || a5 != 0) && a4 <= 2147483647L && a5 <= 2147483647L) {
                    zzkaVar.a = (int) a4;
                    zzkaVar.b = (int) a5;
                    zzpt.a(jArr2, 1000000L, zzloVar2.c);
                    return new bac(jArr, iArr, i4, jArr2, iArr2);
                }
            }
        }
        if (zzloVar2.i.length == 1) {
            char c2 = 0;
            if (zzloVar2.i[0] == 0) {
                int i39 = 0;
                while (i39 < jArr2.length) {
                    jArr2[i39] = zzpt.a(jArr2[i39] - zzloVar2.j[c2], 1000000L, zzloVar2.c);
                    i39++;
                    c2 = 0;
                }
                return new bac(jArr, iArr, i4, jArr2, iArr2);
            }
        }
        boolean z3 = zzloVar2.b == 1;
        int i40 = 0;
        boolean z4 = false;
        int i41 = 0;
        int i42 = 0;
        while (i40 < zzloVar2.i.length) {
            long j10 = zzloVar2.j[i40];
            if (j10 != -1) {
                iArr6 = iArr;
                long a6 = zzpt.a(zzloVar2.i[i40], zzloVar2.c, zzloVar2.d);
                int b3 = zzpt.b(jArr2, j10, true, true);
                int b4 = zzpt.b(jArr2, j10 + a6, z3, false);
                i41 += b4 - b3;
                z4 |= i42 != b3;
                i42 = b4;
            } else {
                iArr6 = iArr;
            }
            i40++;
            iArr = iArr6;
        }
        int[] iArr11 = iArr;
        boolean z5 = (i41 != i3) | z4;
        long[] jArr9 = z5 ? new long[i41] : jArr;
        int[] iArr12 = z5 ? new int[i41] : iArr11;
        if (z5) {
            i4 = 0;
        }
        int[] iArr13 = z5 ? new int[i41] : iArr2;
        long[] jArr10 = new long[i41];
        int i43 = i4;
        int i44 = 0;
        int i45 = 0;
        while (i44 < zzloVar2.i.length) {
            long j11 = zzloVar2.j[i44];
            long j12 = zzloVar2.i[i44];
            if (j11 != -1) {
                int[] iArr14 = iArr13;
                i5 = i44;
                long[] jArr11 = jArr9;
                jArr4 = jArr10;
                long a7 = zzpt.a(j12, zzloVar2.c, zzloVar2.d) + j11;
                int b5 = zzpt.b(jArr2, j11, true, true);
                int b6 = zzpt.b(jArr2, a7, z3, false);
                if (z5) {
                    int i46 = b6 - b5;
                    jArr3 = jArr11;
                    System.arraycopy(jArr, b5, jArr3, i45, i46);
                    iArr5 = iArr11;
                    System.arraycopy(iArr5, b5, iArr12, i45, i46);
                    z2 = z3;
                    iArr4 = iArr14;
                    System.arraycopy(iArr2, b5, iArr4, i45, i46);
                } else {
                    z2 = z3;
                    iArr5 = iArr11;
                    iArr4 = iArr14;
                    jArr3 = jArr11;
                }
                int i47 = i43;
                while (b5 < b6) {
                    long[] jArr12 = jArr;
                    int[] iArr15 = iArr2;
                    long j13 = j11;
                    jArr4[i45] = zzpt.a(j2, 1000000L, zzloVar2.d) + zzpt.a(jArr2[b5] - j11, 1000000L, zzloVar2.c);
                    if (z5 && iArr12[i45] > i47) {
                        i47 = iArr5[b5];
                    }
                    i45++;
                    b5++;
                    jArr = jArr12;
                    iArr2 = iArr15;
                    j11 = j13;
                }
                jArr5 = jArr;
                iArr3 = iArr2;
                i43 = i47;
            } else {
                z2 = z3;
                jArr3 = jArr9;
                jArr4 = jArr10;
                jArr5 = jArr;
                iArr3 = iArr2;
                iArr4 = iArr13;
                i5 = i44;
                iArr5 = iArr11;
            }
            j2 += j12;
            i44 = i5 + 1;
            iArr11 = iArr5;
            jArr9 = jArr3;
            jArr10 = jArr4;
            jArr = jArr5;
            iArr2 = iArr3;
            iArr13 = iArr4;
            z3 = z2;
        }
        long[] jArr13 = jArr9;
        long[] jArr14 = jArr10;
        int[] iArr16 = iArr13;
        boolean z6 = false;
        for (int i48 = 0; i48 < iArr16.length && !z6; i48++) {
            z6 |= (iArr16[i48] & 1) != 0;
        }
        if (!z6) {
            throw new zzhw("The edited sample sequence does not contain a sync sample.");
        }
        return new bac(jArr13, iArr12, i43, jArr14, iArr16);
    }

    public static zzmd a(azj azjVar, boolean z) {
        if (z) {
            return null;
        }
        zzpn zzpnVar = azjVar.aP;
        zzpnVar.c(8);
        while (zzpnVar.b() >= 8) {
            int d2 = zzpnVar.d();
            int l = zzpnVar.l();
            if (zzpnVar.l() == azh.aA) {
                zzpnVar.c(d2);
                int i = d2 + l;
                zzpnVar.d(12);
                while (true) {
                    if (zzpnVar.d() >= i) {
                        break;
                    }
                    int d3 = zzpnVar.d();
                    int l2 = zzpnVar.l();
                    if (zzpnVar.l() == azh.aB) {
                        zzpnVar.c(d3);
                        int i2 = d3 + l2;
                        zzpnVar.d(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzpnVar.d() < i2) {
                            zzmd.zza a2 = azx.a(zzpnVar);
                            if (a2 != null) {
                                arrayList.add(a2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            return new zzmd(arrayList);
                        }
                    } else {
                        zzpnVar.d(l2 - 8);
                    }
                }
                return null;
            }
            zzpnVar.d(l - 8);
        }
        return null;
    }

    private static Pair<String, byte[]> a(zzpn zzpnVar, int i) {
        zzpnVar.c(i + 8 + 4);
        zzpnVar.d(1);
        a(zzpnVar);
        zzpnVar.d(2);
        int f2 = zzpnVar.f();
        if ((f2 & 128) != 0) {
            zzpnVar.d(2);
        }
        if ((f2 & 64) != 0) {
            zzpnVar.d(zzpnVar.g());
        }
        if ((f2 & 32) != 0) {
            zzpnVar.d(2);
        }
        zzpnVar.d(1);
        a(zzpnVar);
        String str = null;
        switch (zzpnVar.f()) {
            case 32:
                str = "video/mp4v-es";
                break;
            case 33:
                str = "video/avc";
                break;
            case 35:
                str = "video/hevc";
                break;
            case 64:
            case 102:
            case 103:
            case 104:
                str = "audio/mp4a-latm";
                break;
            case 107:
                return Pair.create("audio/mpeg", null);
            case 165:
                str = "audio/ac3";
                break;
            case 166:
                str = "audio/eac3";
                break;
            case 169:
            case 172:
                return Pair.create("audio/vnd.dts", null);
            case 170:
            case 171:
                return Pair.create("audio/vnd.dts.hd", null);
        }
        zzpnVar.d(12);
        zzpnVar.d(1);
        int a2 = a(zzpnVar);
        byte[] bArr = new byte[a2];
        zzpnVar.a(bArr, 0, a2);
        return Pair.create(str, bArr);
    }

    private static int a(zzpn zzpnVar, int i, int i2, azn aznVar, int i3) {
        zzlr zzlrVar;
        int d2 = zzpnVar.d();
        while (true) {
            if (d2 - i >= i2) {
                return 0;
            }
            zzpnVar.c(d2);
            int l = zzpnVar.l();
            zzpc.a(l > 0, "childAtomSize should be positive");
            if (zzpnVar.l() == azh.V) {
                int i4 = d2 + 8;
                Pair pair = null;
                boolean z = false;
                Integer num = null;
                zzlr zzlrVar2 = null;
                while (i4 - d2 < l) {
                    zzpnVar.c(i4);
                    int l2 = zzpnVar.l();
                    int l3 = zzpnVar.l();
                    if (l3 == azh.ab) {
                        num = Integer.valueOf(zzpnVar.l());
                    } else if (l3 == azh.W) {
                        zzpnVar.d(4);
                        z = zzpnVar.l() == g;
                    } else if (l3 == azh.X) {
                        int i5 = i4 + 8;
                        while (true) {
                            if (i5 - i4 >= l2) {
                                zzlrVar = null;
                                break;
                            }
                            zzpnVar.c(i5);
                            int l4 = zzpnVar.l();
                            if (zzpnVar.l() == azh.Y) {
                                zzpnVar.d(6);
                                boolean z2 = zzpnVar.f() == 1;
                                int f2 = zzpnVar.f();
                                byte[] bArr = new byte[16];
                                zzpnVar.a(bArr, 0, 16);
                                zzlrVar = new zzlr(z2, f2, bArr);
                            } else {
                                i5 += l4;
                            }
                        }
                        zzlrVar2 = zzlrVar;
                    }
                    i4 += l2;
                }
                if (z) {
                    zzpc.a(num != null, "frma atom is mandatory");
                    zzpc.a(zzlrVar2 != null, "schi->tenc atom is mandatory");
                    pair = Pair.create(num, zzlrVar2);
                }
                if (pair != null) {
                    aznVar.a[i3] = (zzlr) pair.second;
                    return ((Integer) pair.first).intValue();
                }
            }
            d2 += l;
        }
    }

    private static int a(zzpn zzpnVar) {
        int f2 = zzpnVar.f();
        int i = f2 & 127;
        while ((f2 & 128) == 128) {
            f2 = zzpnVar.f();
            i = (i << 7) | (f2 & 127);
        }
        return i;
    }
}
