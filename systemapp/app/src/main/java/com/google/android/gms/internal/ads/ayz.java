package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Stack;

/* compiled from: source */
/* loaded from: classes.dex */
final class ayz implements aza {
    private final byte[] a = new byte[8];
    private final Stack<azb> b = new Stack<>();
    private final azi c = new azi();
    private azc d;
    private int e;
    private int f;
    private long g;

    ayz() {
    }

    @Override // com.google.android.gms.internal.ads.aza
    public final void a(azc azcVar) {
        this.d = azcVar;
    }

    @Override // com.google.android.gms.internal.ads.aza
    public final void a() {
        this.e = 0;
        this.b.clear();
        this.c.a();
    }

    @Override // com.google.android.gms.internal.ads.aza
    public final boolean a(zzjz zzjzVar) throws IOException, InterruptedException {
        String str;
        double longBitsToDouble;
        long j;
        int i;
        zzpc.b(this.d != null);
        while (true) {
            if (!this.b.isEmpty()) {
                long b = zzjzVar.b();
                j = this.b.peek().b;
                if (b >= j) {
                    azc azcVar = this.d;
                    i = this.b.pop().a;
                    azcVar.c(i);
                    return true;
                }
            }
            if (this.e == 0) {
                long a = this.c.a(zzjzVar, true, false, 4);
                if (a == -2) {
                    zzjzVar.a();
                    while (true) {
                        zzjzVar.c(this.a, 0, 4);
                        int a2 = azi.a(this.a[0]);
                        if (a2 != -1 && a2 <= 4) {
                            int a3 = (int) azi.a(this.a, a2, false);
                            if (this.d.b(a3)) {
                                zzjzVar.b(a2);
                                a = a3;
                            }
                        }
                        zzjzVar.b(1);
                    }
                }
                if (a == -1) {
                    return false;
                }
                this.f = (int) a;
                this.e = 1;
            }
            if (this.e == 1) {
                this.g = this.c.a(zzjzVar, false, true, 8);
                this.e = 2;
            }
            int a4 = this.d.a(this.f);
            switch (a4) {
                case 0:
                    zzjzVar.b((int) this.g);
                    this.e = 0;
                case 1:
                    long b2 = zzjzVar.b();
                    this.b.add(new azb(this.f, this.g + b2));
                    this.d.a(this.f, b2, this.g);
                    this.e = 0;
                    return true;
                case 2:
                    if (this.g > 8) {
                        long j2 = this.g;
                        StringBuilder sb = new StringBuilder(42);
                        sb.append("Invalid integer size: ");
                        sb.append(j2);
                        throw new zzhw(sb.toString());
                    }
                    this.d.a(this.f, a(zzjzVar, (int) this.g));
                    this.e = 0;
                    return true;
                case 3:
                    if (this.g > 2147483647L) {
                        long j3 = this.g;
                        StringBuilder sb2 = new StringBuilder(41);
                        sb2.append("String element size: ");
                        sb2.append(j3);
                        throw new zzhw(sb2.toString());
                    }
                    azc azcVar2 = this.d;
                    int i2 = this.f;
                    int i3 = (int) this.g;
                    if (i3 == 0) {
                        str = "";
                    } else {
                        byte[] bArr = new byte[i3];
                        zzjzVar.b(bArr, 0, i3);
                        str = new String(bArr);
                    }
                    azcVar2.a(i2, str);
                    this.e = 0;
                    return true;
                case 4:
                    this.d.a(this.f, (int) this.g, zzjzVar);
                    this.e = 0;
                    return true;
                case 5:
                    if (this.g != 4 && this.g != 8) {
                        long j4 = this.g;
                        StringBuilder sb3 = new StringBuilder(40);
                        sb3.append("Invalid float size: ");
                        sb3.append(j4);
                        throw new zzhw(sb3.toString());
                    }
                    azc azcVar3 = this.d;
                    int i4 = this.f;
                    int i5 = (int) this.g;
                    long a5 = a(zzjzVar, i5);
                    if (i5 == 4) {
                        longBitsToDouble = Float.intBitsToFloat((int) a5);
                    } else {
                        longBitsToDouble = Double.longBitsToDouble(a5);
                    }
                    azcVar3.a(i4, longBitsToDouble);
                    this.e = 0;
                    return true;
                default:
                    StringBuilder sb4 = new StringBuilder(32);
                    sb4.append("Invalid element type ");
                    sb4.append(a4);
                    throw new zzhw(sb4.toString());
            }
        }
    }

    private final long a(zzjz zzjzVar, int i) throws IOException, InterruptedException {
        zzjzVar.b(this.a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.a[i2] & 255);
        }
        return j;
    }
}
