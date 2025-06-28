package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzqb {
    public final List<byte[]> a;
    public final int b;

    public static zzqb a(zzpn zzpnVar) throws zzhw {
        try {
            zzpnVar.d(21);
            int f = zzpnVar.f() & 3;
            int f2 = zzpnVar.f();
            int d = zzpnVar.d();
            int i = 0;
            int i2 = 0;
            while (i < f2) {
                zzpnVar.d(1);
                int g = zzpnVar.g();
                int i3 = i2;
                for (int i4 = 0; i4 < g; i4++) {
                    int g2 = zzpnVar.g();
                    i3 += g2 + 4;
                    zzpnVar.d(g2);
                }
                i++;
                i2 = i3;
            }
            zzpnVar.c(d);
            byte[] bArr = new byte[i2];
            int i5 = 0;
            int i6 = 0;
            while (i5 < f2) {
                zzpnVar.d(1);
                int g3 = zzpnVar.g();
                int i7 = i6;
                for (int i8 = 0; i8 < g3; i8++) {
                    int g4 = zzpnVar.g();
                    System.arraycopy(zzpi.a, 0, bArr, i7, zzpi.a.length);
                    int length = i7 + zzpi.a.length;
                    System.arraycopy(zzpnVar.a, zzpnVar.d(), bArr, length, g4);
                    i7 = length + g4;
                    zzpnVar.d(g4);
                }
                i5++;
                i6 = i7;
            }
            return new zzqb(i2 == 0 ? null : Collections.singletonList(bArr), f + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzhw("Error parsing HEVC config", e);
        }
    }

    private zzqb(List<byte[]> list, int i) {
        this.a = list;
        this.b = i;
    }
}
