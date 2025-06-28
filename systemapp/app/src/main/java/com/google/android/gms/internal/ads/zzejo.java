package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzejo extends zzeiv {
    private static final Logger b = Logger.getLogger(zzejo.class.getName());
    private static final boolean c = avz.a();
    ath a;

    public static zzejo a(byte[] bArr) {
        return new a(bArr, 0, bArr.length);
    }

    public static int b(double d) {
        return 8;
    }

    public static int b(float f) {
        return 4;
    }

    public static int b(boolean z) {
        return 1;
    }

    public static int e(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static int g(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int g(long j) {
        return 8;
    }

    public static int h(long j) {
        return 8;
    }

    public static int i(int i) {
        return 4;
    }

    private static long i(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int j(int i) {
        return 4;
    }

    private static int m(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public abstract int a();

    public abstract void a(byte b2) throws IOException;

    public abstract void a(int i) throws IOException;

    public abstract void a(int i, int i2) throws IOException;

    public abstract void a(int i, long j) throws IOException;

    public abstract void a(int i, zzeiu zzeiuVar) throws IOException;

    public abstract void a(int i, zzels zzelsVar) throws IOException;

    abstract void a(int i, zzels zzelsVar, avd avdVar) throws IOException;

    public abstract void a(int i, String str) throws IOException;

    public abstract void a(int i, boolean z) throws IOException;

    public abstract void a(long j) throws IOException;

    public abstract void a(zzeiu zzeiuVar) throws IOException;

    public abstract void a(zzels zzelsVar) throws IOException;

    public abstract void a(String str) throws IOException;

    public abstract void b(int i) throws IOException;

    public abstract void b(int i, int i2) throws IOException;

    public abstract void b(int i, zzeiu zzeiuVar) throws IOException;

    abstract void b(byte[] bArr, int i, int i2) throws IOException;

    public abstract void c(int i, int i2) throws IOException;

    public abstract void c(int i, long j) throws IOException;

    public abstract void c(long j) throws IOException;

    public abstract void d(int i) throws IOException;

    public abstract void e(int i, int i2) throws IOException;

    /* compiled from: source */
    public static class zzb extends IOException {
        zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        zzb(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r0 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                java.lang.String r0 = java.lang.String.valueOf(r0)
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r1 = r3.length()
                if (r1 == 0) goto L15
                java.lang.String r3 = r0.concat(r3)
                goto L1a
            L15:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r0)
            L1a:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzejo.zzb.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private zzejo() {
    }

    public final void d(int i, int i2) throws IOException {
        c(i, m(i2));
    }

    public final void b(int i, long j) throws IOException {
        a(i, i(j));
    }

    public final void a(int i, float f) throws IOException {
        e(i, Float.floatToRawIntBits(f));
    }

    public final void a(int i, double d) throws IOException {
        c(i, Double.doubleToRawLongBits(d));
    }

    public final void c(int i) throws IOException {
        b(m(i));
    }

    /* compiled from: source */
    static class a extends zzejo {
        private final byte[] b;
        private final int c;
        private final int d;
        private int e;

        a(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            if ((0 | i2 | (bArr.length - i2)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)));
            }
            this.b = bArr;
            this.c = 0;
            this.e = 0;
            this.d = i2;
        }

        @Override // com.google.android.gms.internal.ads.zzejo
        public final void a(int i, int i2) throws IOException {
            b((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.ads.zzejo
        public final void b(int i, int i2) throws IOException {
            a(i, 0);
            a(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzejo
        public final void c(int i, int i2) throws IOException {
            a(i, 0);
            b(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzejo
        public final void e(int i, int i2) throws IOException {
            a(i, 5);
            d(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzejo
        public final void a(int i, long j) throws IOException {
            a(i, 0);
            a(j);
        }

        @Override // com.google.android.gms.internal.ads.zzejo
        public final void c(int i, long j) throws IOException {
            a(i, 1);
            c(j);
        }

        @Override // com.google.android.gms.internal.ads.zzejo
        public final void a(int i, boolean z) throws IOException {
            a(i, 0);
            a(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.ads.zzejo
        public final void a(int i, String str) throws IOException {
            a(i, 2);
            a(str);
        }

        @Override // com.google.android.gms.internal.ads.zzejo
        public final void a(int i, zzeiu zzeiuVar) throws IOException {
            a(i, 2);
            a(zzeiuVar);
        }

        @Override // com.google.android.gms.internal.ads.zzejo
        public final void a(zzeiu zzeiuVar) throws IOException {
            b(zzeiuVar.b());
            zzeiuVar.a(this);
        }

        @Override // com.google.android.gms.internal.ads.zzejo
        public final void b(byte[] bArr, int i, int i2) throws IOException {
            b(i2);
            c(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzejo
        final void a(int i, zzels zzelsVar, avd avdVar) throws IOException {
            a(i, 2);
            zzeik zzeikVar = (zzeik) zzelsVar;
            int m = zzeikVar.m();
            if (m == -1) {
                m = avdVar.b(zzeikVar);
                zzeikVar.a(m);
            }
            b(m);
            avdVar.a((avd) zzelsVar, (awo) this.a);
        }

        @Override // com.google.android.gms.internal.ads.zzejo
        public final void a(int i, zzels zzelsVar) throws IOException {
            a(1, 3);
            c(2, i);
            a(3, 2);
            a(zzelsVar);
            a(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzejo
        public final void b(int i, zzeiu zzeiuVar) throws IOException {
            a(1, 3);
            c(2, i);
            a(3, zzeiuVar);
            a(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzejo
        public final void a(zzels zzelsVar) throws IOException {
            b(zzelsVar.q());
            zzelsVar.a(this);
        }

        @Override // com.google.android.gms.internal.ads.zzejo
        public final void a(byte b) throws IOException {
            try {
                byte[] bArr = this.b;
                int i = this.e;
                this.e = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzejo
        public final void a(int i) throws IOException {
            if (i >= 0) {
                b(i);
            } else {
                a(i);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzejo
        public final void b(int i) throws IOException {
            if (!zzejo.c || asn.a() || a() < 5) {
                while ((i & (-128)) != 0) {
                    try {
                        byte[] bArr = this.b;
                        int i2 = this.e;
                        this.e = i2 + 1;
                        bArr[i2] = (byte) ((i & 127) | 128);
                        i >>>= 7;
                    } catch (IndexOutOfBoundsException e) {
                        throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
                    }
                }
                byte[] bArr2 = this.b;
                int i3 = this.e;
                this.e = i3 + 1;
                bArr2[i3] = (byte) i;
                return;
            }
            if ((i & (-128)) == 0) {
                byte[] bArr3 = this.b;
                int i4 = this.e;
                this.e = i4 + 1;
                avz.a(bArr3, i4, (byte) i);
                return;
            }
            byte[] bArr4 = this.b;
            int i5 = this.e;
            this.e = i5 + 1;
            avz.a(bArr4, i5, (byte) (i | 128));
            int i6 = i >>> 7;
            if ((i6 & (-128)) == 0) {
                byte[] bArr5 = this.b;
                int i7 = this.e;
                this.e = i7 + 1;
                avz.a(bArr5, i7, (byte) i6);
                return;
            }
            byte[] bArr6 = this.b;
            int i8 = this.e;
            this.e = i8 + 1;
            avz.a(bArr6, i8, (byte) (i6 | 128));
            int i9 = i6 >>> 7;
            if ((i9 & (-128)) == 0) {
                byte[] bArr7 = this.b;
                int i10 = this.e;
                this.e = i10 + 1;
                avz.a(bArr7, i10, (byte) i9);
                return;
            }
            byte[] bArr8 = this.b;
            int i11 = this.e;
            this.e = i11 + 1;
            avz.a(bArr8, i11, (byte) (i9 | 128));
            int i12 = i9 >>> 7;
            if ((i12 & (-128)) == 0) {
                byte[] bArr9 = this.b;
                int i13 = this.e;
                this.e = i13 + 1;
                avz.a(bArr9, i13, (byte) i12);
                return;
            }
            byte[] bArr10 = this.b;
            int i14 = this.e;
            this.e = i14 + 1;
            avz.a(bArr10, i14, (byte) (i12 | 128));
            byte[] bArr11 = this.b;
            int i15 = this.e;
            this.e = i15 + 1;
            avz.a(bArr11, i15, (byte) (i12 >>> 7));
        }

        @Override // com.google.android.gms.internal.ads.zzejo
        public final void d(int i) throws IOException {
            try {
                byte[] bArr = this.b;
                int i2 = this.e;
                this.e = i2 + 1;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.b;
                int i3 = this.e;
                this.e = i3 + 1;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.b;
                int i4 = this.e;
                this.e = i4 + 1;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.b;
                int i5 = this.e;
                this.e = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzejo
        public final void a(long j) throws IOException {
            if (zzejo.c && a() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.b;
                    int i = this.e;
                    this.e = i + 1;
                    avz.a(bArr, i, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.b;
                int i2 = this.e;
                this.e = i2 + 1;
                avz.a(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.b;
                    int i3 = this.e;
                    this.e = i3 + 1;
                    bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
                }
            }
            byte[] bArr4 = this.b;
            int i4 = this.e;
            this.e = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        @Override // com.google.android.gms.internal.ads.zzejo
        public final void c(long j) throws IOException {
            try {
                byte[] bArr = this.b;
                int i = this.e;
                this.e = i + 1;
                bArr[i] = (byte) j;
                byte[] bArr2 = this.b;
                int i2 = this.e;
                this.e = i2 + 1;
                bArr2[i2] = (byte) (j >> 8);
                byte[] bArr3 = this.b;
                int i3 = this.e;
                this.e = i3 + 1;
                bArr3[i3] = (byte) (j >> 16);
                byte[] bArr4 = this.b;
                int i4 = this.e;
                this.e = i4 + 1;
                bArr4[i4] = (byte) (j >> 24);
                byte[] bArr5 = this.b;
                int i5 = this.e;
                this.e = i5 + 1;
                bArr5[i5] = (byte) (j >> 32);
                byte[] bArr6 = this.b;
                int i6 = this.e;
                this.e = i6 + 1;
                bArr6[i6] = (byte) (j >> 40);
                byte[] bArr7 = this.b;
                int i7 = this.e;
                this.e = i7 + 1;
                bArr7[i7] = (byte) (j >> 48);
                byte[] bArr8 = this.b;
                int i8 = this.e;
                this.e = i8 + 1;
                bArr8[i8] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), 1), e);
            }
        }

        private final void c(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.b, this.e, i2);
                this.e += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.e), Integer.valueOf(this.d), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzeiv
        public final void a(byte[] bArr, int i, int i2) throws IOException {
            c(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzejo
        public final void a(String str) throws IOException {
            int i = this.e;
            try {
                int g = g(str.length() * 3);
                int g2 = g(str.length());
                if (g2 == g) {
                    this.e = i + g2;
                    int a = awc.a(str, this.b, this.e, a());
                    this.e = i;
                    b((a - i) - g2);
                    this.e = a;
                    return;
                }
                b(awc.a(str));
                this.e = awc.a(str, this.b, this.e, a());
            } catch (awf e) {
                this.e = i;
                a(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzejo
        public final int a() {
            return this.d - this.e;
        }
    }

    public final void b(long j) throws IOException {
        a(i(j));
    }

    public final void a(float f) throws IOException {
        d(Float.floatToRawIntBits(f));
    }

    public final void a(double d) throws IOException {
        c(Double.doubleToRawLongBits(d));
    }

    public final void a(boolean z) throws IOException {
        a(z ? (byte) 1 : (byte) 0);
    }

    public static int f(int i, int i2) {
        return g(i << 3) + f(i2);
    }

    public static int g(int i, int i2) {
        return g(i << 3) + g(i2);
    }

    public static int h(int i, int i2) {
        return g(i << 3) + g(m(i2));
    }

    public static int i(int i, int i2) {
        return g(i << 3) + 4;
    }

    public static int j(int i, int i2) {
        return g(i << 3) + 4;
    }

    public static int d(int i, long j) {
        return g(i << 3) + e(j);
    }

    public static int e(int i, long j) {
        return g(i << 3) + e(j);
    }

    public static int f(int i, long j) {
        return g(i << 3) + e(i(j));
    }

    public static int g(int i, long j) {
        return g(i << 3) + 8;
    }

    public static int h(int i, long j) {
        return g(i << 3) + 8;
    }

    public static int b(int i, float f) {
        return g(i << 3) + 4;
    }

    public static int b(int i, double d) {
        return g(i << 3) + 8;
    }

    public static int b(int i, boolean z) {
        return g(i << 3) + 1;
    }

    public static int k(int i, int i2) {
        return g(i << 3) + f(i2);
    }

    public static int b(int i, String str) {
        return g(i << 3) + b(str);
    }

    public static int c(int i, zzeiu zzeiuVar) {
        int g = g(i << 3);
        int b2 = zzeiuVar.b();
        return g + g(b2) + b2;
    }

    public static int a(int i, zzekx zzekxVar) {
        int g = g(i << 3);
        int b2 = zzekxVar.b();
        return g + g(b2) + b2;
    }

    static int b(int i, zzels zzelsVar, avd avdVar) {
        return g(i << 3) + a(zzelsVar, avdVar);
    }

    public static int b(int i, zzels zzelsVar) {
        return (g(8) << 1) + g(2, i) + g(24) + b(zzelsVar);
    }

    public static int d(int i, zzeiu zzeiuVar) {
        return (g(8) << 1) + g(2, i) + c(3, zzeiuVar);
    }

    public static int b(int i, zzekx zzekxVar) {
        return (g(8) << 1) + g(2, i) + a(3, zzekxVar);
    }

    public static int e(int i) {
        return g(i << 3);
    }

    public static int f(int i) {
        if (i >= 0) {
            return g(i);
        }
        return 10;
    }

    public static int h(int i) {
        return g(m(i));
    }

    public static int d(long j) {
        return e(j);
    }

    public static int f(long j) {
        return e(i(j));
    }

    public static int k(int i) {
        return f(i);
    }

    public static int b(String str) {
        int length;
        try {
            length = awc.a(str);
        } catch (awf unused) {
            length = str.getBytes(zzekk.a).length;
        }
        return g(length) + length;
    }

    public static int a(zzekx zzekxVar) {
        int b2 = zzekxVar.b();
        return g(b2) + b2;
    }

    public static int b(zzeiu zzeiuVar) {
        int b2 = zzeiuVar.b();
        return g(b2) + b2;
    }

    public static int b(byte[] bArr) {
        int length = bArr.length;
        return g(length) + length;
    }

    public static int b(zzels zzelsVar) {
        int q = zzelsVar.q();
        return g(q) + q;
    }

    static int a(zzels zzelsVar, avd avdVar) {
        zzeik zzeikVar = (zzeik) zzelsVar;
        int m = zzeikVar.m();
        if (m == -1) {
            m = avdVar.b(zzeikVar);
            zzeikVar.a(m);
        }
        return g(m) + m;
    }

    public final void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    final void a(String str, awf awfVar) throws IOException {
        b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) awfVar);
        byte[] bytes = str.getBytes(zzekk.a);
        try {
            b(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (zzb e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzb(e2);
        }
    }

    @Deprecated
    static int c(int i, zzels zzelsVar, avd avdVar) {
        int g = g(i << 3) << 1;
        zzeik zzeikVar = (zzeik) zzelsVar;
        int m = zzeikVar.m();
        if (m == -1) {
            m = avdVar.b(zzeikVar);
            zzeikVar.a(m);
        }
        return g + m;
    }

    @Deprecated
    public static int c(zzels zzelsVar) {
        return zzelsVar.q();
    }

    @Deprecated
    public static int l(int i) {
        return g(i);
    }

    /* synthetic */ zzejo(atg atgVar) {
        this();
    }
}
