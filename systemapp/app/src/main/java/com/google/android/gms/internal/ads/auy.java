package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class auy implements aul {
    private final zzels a;
    private final String b;
    private final Object[] c;
    private final int d;

    auy(zzels zzelsVar, String str, Object[] objArr) {
        this.a = zzelsVar;
        this.b = str;
        this.c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.d = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 < 55296) {
                this.d = i | (charAt2 << i2);
                return;
            } else {
                i |= (charAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    final String d() {
        return this.b;
    }

    final Object[] e() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.aul
    public final zzels c() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.ads.aul
    public final int a() {
        return (this.d & 1) == 1 ? zzemd.a : zzemd.b;
    }

    @Override // com.google.android.gms.internal.ads.aul
    public final boolean b() {
        return (this.d & 2) == 2;
    }
}
