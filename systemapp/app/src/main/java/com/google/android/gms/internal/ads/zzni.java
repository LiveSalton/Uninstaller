package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzni implements zzkh {
    private final zzol a;
    private final int b;
    private final baw c = new baw();
    private final zznj d = new zznj();
    private final zzpn e = new zzpn(32);
    private final AtomicInteger f = new AtomicInteger();
    private bax g;
    private bax h;
    private zzhp i;
    private boolean j;
    private zzhp k;
    private long l;
    private int m;
    private zznk n;

    public zzni(zzol zzolVar) {
        this.a = zzolVar;
        this.b = zzolVar.c();
        this.m = this.b;
        this.g = new bax(0L, this.b);
        this.h = this.g;
    }

    public final void a(boolean z) {
        int andSet = this.f.getAndSet(z ? 0 : 2);
        i();
        this.c.b();
        if (andSet == 2) {
            this.i = null;
        }
    }

    public final int a() {
        return this.c.c();
    }

    public final void b() {
        if (this.f.getAndSet(2) == 0) {
            i();
        }
    }

    public final boolean c() {
        return this.c.d();
    }

    public final zzhp d() {
        return this.c.e();
    }

    public final long e() {
        return this.c.f();
    }

    public final void f() {
        long g = this.c.g();
        if (g != -1) {
            a(g);
        }
    }

    public final boolean a(long j, boolean z) {
        long a = this.c.a(j, z);
        if (a == -1) {
            return false;
        }
        a(a);
        return true;
    }

    public final int a(zzhr zzhrVar, zzjl zzjlVar, boolean z, boolean z2, long j) {
        switch (this.c.a(zzhrVar, zzjlVar, z, z2, this.i, this.d)) {
            case -5:
                this.i = zzhrVar.a;
                return -5;
            case -4:
                if (zzjlVar.c()) {
                    return -4;
                }
                if (zzjlVar.c < j) {
                    zzjlVar.b(Integer.MIN_VALUE);
                }
                if (zzjlVar.e()) {
                    zznj zznjVar = this.d;
                    long j2 = zznjVar.b;
                    int i = 1;
                    this.e.a(1);
                    a(j2, this.e.a, 1);
                    long j3 = j2 + 1;
                    byte b = this.e.a[0];
                    boolean z3 = (b & 128) != 0;
                    int i2 = b & Byte.MAX_VALUE;
                    if (zzjlVar.a.a == null) {
                        zzjlVar.a.a = new byte[16];
                    }
                    a(j3, zzjlVar.a.a, i2);
                    long j4 = j3 + i2;
                    if (z3) {
                        this.e.a(2);
                        a(j4, this.e.a, 2);
                        j4 += 2;
                        i = this.e.g();
                    }
                    int i3 = i;
                    int[] iArr = zzjlVar.a.b;
                    if (iArr == null || iArr.length < i3) {
                        iArr = new int[i3];
                    }
                    int[] iArr2 = iArr;
                    int[] iArr3 = zzjlVar.a.c;
                    if (iArr3 == null || iArr3.length < i3) {
                        iArr3 = new int[i3];
                    }
                    int[] iArr4 = iArr3;
                    if (z3) {
                        int i4 = i3 * 6;
                        this.e.a(i4);
                        a(j4, this.e.a, i4);
                        j4 += i4;
                        this.e.c(0);
                        for (int i5 = 0; i5 < i3; i5++) {
                            iArr2[i5] = this.e.g();
                            iArr4[i5] = this.e.o();
                        }
                    } else {
                        iArr2[0] = 0;
                        iArr4[0] = zznjVar.a - ((int) (j4 - zznjVar.b));
                    }
                    zzkg zzkgVar = zznjVar.d;
                    zzjlVar.a.a(i3, iArr2, iArr4, zzkgVar.b, zzjlVar.a.a, zzkgVar.a);
                    int i6 = (int) (j4 - zznjVar.b);
                    zznjVar.b += i6;
                    zznjVar.a -= i6;
                }
                zzjlVar.d(this.d.a);
                long j5 = this.d.b;
                ByteBuffer byteBuffer = zzjlVar.b;
                int i7 = this.d.a;
                a(j5);
                while (i7 > 0) {
                    int i8 = (int) (j5 - this.g.a);
                    int min = Math.min(i7, this.b - i8);
                    zzoi zzoiVar = this.g.d;
                    byteBuffer.put(zzoiVar.a, i8 + 0, min);
                    j5 += min;
                    i7 -= min;
                    if (j5 == this.g.b) {
                        this.a.a(zzoiVar);
                        this.g = this.g.a();
                    }
                }
                a(this.d.c);
                return -4;
            case -3:
                return -3;
            default:
                throw new IllegalStateException();
        }
    }

    private final void a(long j, byte[] bArr, int i) {
        a(j);
        long j2 = j;
        int i2 = 0;
        while (i2 < i) {
            int i3 = (int) (j2 - this.g.a);
            int min = Math.min(i - i2, this.b - i3);
            zzoi zzoiVar = this.g.d;
            System.arraycopy(zzoiVar.a, i3 + 0, bArr, i2, min);
            j2 += min;
            i2 += min;
            if (j2 == this.g.b) {
                this.a.a(zzoiVar);
                this.g = this.g.a();
            }
        }
    }

    private final void a(long j) {
        while (j >= this.g.b) {
            this.a.a(this.g.d);
            this.g = this.g.a();
        }
    }

    public final void a(zznk zznkVar) {
        this.n = zznkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzkh
    public final void a(zzhp zzhpVar) {
        zzhp zzhpVar2 = zzhpVar == null ? null : zzhpVar;
        boolean a = this.c.a(zzhpVar2);
        this.k = zzhpVar;
        this.j = false;
        if (this.n == null || !a) {
            return;
        }
        this.n.a(zzhpVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzkh
    public final int a(zzjz zzjzVar, int i, boolean z) throws IOException, InterruptedException {
        if (!g()) {
            int a = zzjzVar.a(i);
            if (a == -1) {
                throw new EOFException();
            }
            return a;
        }
        try {
            int a2 = zzjzVar.a(this.h.d.a, this.m + 0, a(i));
            if (a2 == -1) {
                throw new EOFException();
            }
            this.m += a2;
            this.l += a2;
            return a2;
        } finally {
            h();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkh
    public final void a(zzpn zzpnVar, int i) {
        if (!g()) {
            zzpnVar.d(i);
            return;
        }
        while (i > 0) {
            int a = a(i);
            zzpnVar.a(this.h.d.a, this.m + 0, a);
            this.m += a;
            this.l += a;
            i -= a;
        }
        h();
    }

    @Override // com.google.android.gms.internal.ads.zzkh
    public final void a(long j, int i, int i2, int i3, zzkg zzkgVar) {
        if (!g()) {
            this.c.a(j);
            return;
        }
        try {
            this.c.a(j, i, (this.l - i2) - i3, i2, zzkgVar);
        } finally {
            h();
        }
    }

    private final boolean g() {
        return this.f.compareAndSet(0, 1);
    }

    private final void h() {
        if (this.f.compareAndSet(1, 0)) {
            return;
        }
        i();
    }

    private final void i() {
        this.c.a();
        bax baxVar = this.g;
        if (baxVar.c) {
            boolean z = this.h.c;
            zzoi[] zzoiVarArr = new zzoi[(z ? 1 : 0) + (((int) (this.h.a - baxVar.a)) / this.b)];
            for (int i = 0; i < zzoiVarArr.length; i++) {
                zzoiVarArr[i] = baxVar.d;
                baxVar = baxVar.a();
            }
            this.a.a(zzoiVarArr);
        }
        this.g = new bax(0L, this.b);
        this.h = this.g;
        this.l = 0L;
        this.m = this.b;
        this.a.b();
    }

    private final int a(int i) {
        if (this.m == this.b) {
            this.m = 0;
            if (this.h.c) {
                this.h = this.h.e;
            }
            bax baxVar = this.h;
            zzoi a = this.a.a();
            bax baxVar2 = new bax(this.h.b, this.b);
            baxVar.d = a;
            baxVar.e = baxVar2;
            baxVar.c = true;
        }
        return Math.min(i, this.b - this.m);
    }
}
