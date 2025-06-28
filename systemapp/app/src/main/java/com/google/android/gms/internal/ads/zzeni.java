package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeni {
    private static final zzeni a = new zzeni(0, new int[0], new Object[0], false);
    private int b;
    private int[] c;
    private Object[] d;
    private int e;
    private boolean f;

    public static zzeni a() {
        return a;
    }

    static zzeni b() {
        return new zzeni();
    }

    static zzeni a(zzeni zzeniVar, zzeni zzeniVar2) {
        int i = zzeniVar.b + zzeniVar2.b;
        int[] copyOf = Arrays.copyOf(zzeniVar.c, i);
        System.arraycopy(zzeniVar2.c, 0, copyOf, zzeniVar.b, zzeniVar2.b);
        Object[] copyOf2 = Arrays.copyOf(zzeniVar.d, i);
        System.arraycopy(zzeniVar2.d, 0, copyOf2, zzeniVar.b, zzeniVar2.b);
        return new zzeni(i, copyOf, copyOf2, true);
    }

    private zzeni() {
        this(0, new int[8], new Object[8], true);
    }

    private zzeni(int i, int[] iArr, Object[] objArr, boolean z) {
        this.e = -1;
        this.b = i;
        this.c = iArr;
        this.d = objArr;
        this.f = z;
    }

    public final void c() {
        this.f = false;
    }

    final void a(awo awoVar) throws IOException {
        if (awoVar.a() == zzeob.b) {
            for (int i = this.b - 1; i >= 0; i--) {
                awoVar.a(this.c[i] >>> 3, this.d[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.b; i2++) {
            awoVar.a(this.c[i2] >>> 3, this.d[i2]);
        }
    }

    public final void b(awo awoVar) throws IOException {
        if (this.b == 0) {
            return;
        }
        if (awoVar.a() == zzeob.a) {
            for (int i = 0; i < this.b; i++) {
                a(this.c[i], this.d[i], awoVar);
            }
            return;
        }
        for (int i2 = this.b - 1; i2 >= 0; i2--) {
            a(this.c[i2], this.d[i2], awoVar);
        }
    }

    private static void a(int i, Object obj, awo awoVar) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 != 5) {
            switch (i3) {
                case 0:
                    awoVar.a(i2, ((Long) obj).longValue());
                    return;
                case 1:
                    awoVar.d(i2, ((Long) obj).longValue());
                    return;
                case 2:
                    awoVar.a(i2, (zzeiu) obj);
                    return;
                case 3:
                    if (awoVar.a() == zzeob.a) {
                        awoVar.a(i2);
                        ((zzeni) obj).b(awoVar);
                        awoVar.b(i2);
                        return;
                    } else {
                        awoVar.b(i2);
                        ((zzeni) obj).b(awoVar);
                        awoVar.a(i2);
                        return;
                    }
                default:
                    throw new RuntimeException(zzeks.f());
            }
        }
        awoVar.d(i2, ((Integer) obj).intValue());
    }

    public final int d() {
        int i = this.e;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.b; i3++) {
            i2 += zzejo.d(this.c[i3] >>> 3, (zzeiu) this.d[i3]);
        }
        this.e = i2;
        return i2;
    }

    public final int e() {
        int i;
        int i2 = this.e;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.b; i4++) {
            int i5 = this.c[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 != 5) {
                switch (i7) {
                    case 0:
                        i = zzejo.e(i6, ((Long) this.d[i4]).longValue());
                        break;
                    case 1:
                        i = zzejo.g(i6, ((Long) this.d[i4]).longValue());
                        break;
                    case 2:
                        i = zzejo.c(i6, (zzeiu) this.d[i4]);
                        break;
                    case 3:
                        i = (zzejo.e(i6) << 1) + ((zzeni) this.d[i4]).e();
                        break;
                    default:
                        throw new IllegalStateException(zzeks.f());
                }
            } else {
                i = zzejo.i(i6, ((Integer) this.d[i4]).intValue());
            }
            i3 += i;
        }
        this.e = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzeni)) {
            return false;
        }
        zzeni zzeniVar = (zzeni) obj;
        if (this.b == zzeniVar.b) {
            int[] iArr = this.c;
            int[] iArr2 = zzeniVar.c;
            int i = this.b;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                }
                if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                }
                i2++;
            }
            if (z) {
                Object[] objArr = this.d;
                Object[] objArr2 = zzeniVar.d;
                int i3 = this.b;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    }
                    if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    }
                    i4++;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (527 + this.b) * 31;
        int[] iArr = this.c;
        int i2 = this.b;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i2; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i + i4) * 31;
        Object[] objArr = this.d;
        int i7 = this.b;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    final void a(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.b; i2++) {
            aum.a(sb, i, String.valueOf(this.c[i2] >>> 3), this.d[i2]);
        }
    }

    final void a(int i, Object obj) {
        if (!this.f) {
            throw new UnsupportedOperationException();
        }
        if (this.b == this.c.length) {
            int i2 = this.b + (this.b < 4 ? 8 : this.b >> 1);
            this.c = Arrays.copyOf(this.c, i2);
            this.d = Arrays.copyOf(this.d, i2);
        }
        this.c[this.b] = i;
        this.d[this.b] = obj;
        this.b++;
    }
}
