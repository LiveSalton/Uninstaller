package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzpv {
    public final List<byte[]> a;
    public final int b;
    public final float c;
    private final int d;
    private final int e;

    public static zzpv a(zzpn zzpnVar) throws zzhw {
        float f;
        int i;
        int i2;
        try {
            zzpnVar.d(4);
            int f2 = (zzpnVar.f() & 3) + 1;
            if (f2 == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int f3 = zzpnVar.f() & 31;
            for (int i3 = 0; i3 < f3; i3++) {
                arrayList.add(b(zzpnVar));
            }
            int f4 = zzpnVar.f();
            for (int i4 = 0; i4 < f4; i4++) {
                arrayList.add(b(zzpnVar));
            }
            if (f3 > 0) {
                zzpl a = zzpi.a((byte[]) arrayList.get(0), f2, ((byte[]) arrayList.get(0)).length);
                int i5 = a.a;
                int i6 = a.b;
                f = a.c;
                i = i5;
                i2 = i6;
            } else {
                f = 1.0f;
                i = -1;
                i2 = -1;
            }
            return new zzpv(arrayList, f2, i, i2, f);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzhw("Error parsing AVC config", e);
        }
    }

    private zzpv(List<byte[]> list, int i, int i2, int i3, float f) {
        this.a = list;
        this.b = i;
        this.d = i2;
        this.e = i3;
        this.c = f;
    }

    private static byte[] b(zzpn zzpnVar) {
        int g = zzpnVar.g();
        int d = zzpnVar.d();
        zzpnVar.d(g);
        return zzpf.a(zzpnVar.a, d, g);
    }
}
