package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzhy {
    private static final zzhy a = new zzhy(0, new int[0], new Object[0], false);
    private int b;
    private int[] c;
    private Object[] d;
    private int e;
    private boolean f;

    public static zzhy a() {
        return a;
    }

    static zzhy a(zzhy zzhyVar, zzhy zzhyVar2) {
        int i = zzhyVar.b + zzhyVar2.b;
        int[] copyOf = Arrays.copyOf(zzhyVar.c, i);
        System.arraycopy(zzhyVar2.c, 0, copyOf, zzhyVar.b, zzhyVar2.b);
        Object[] copyOf2 = Arrays.copyOf(zzhyVar.d, i);
        System.arraycopy(zzhyVar2.d, 0, copyOf2, zzhyVar.b, zzhyVar2.b);
        return new zzhy(i, copyOf, copyOf2, true);
    }

    private zzhy() {
        this(0, new int[8], new Object[8], true);
    }

    private zzhy(int i, int[] iArr, Object[] objArr, boolean z) {
        this.e = -1;
        this.b = i;
        this.c = iArr;
        this.d = objArr;
        this.f = z;
    }

    public final void b() {
        this.f = false;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzhy)) {
            return false;
        }
        zzhy zzhyVar = (zzhy) obj;
        if (this.b == zzhyVar.b) {
            int[] iArr = this.c;
            int[] iArr2 = zzhyVar.c;
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
                Object[] objArr2 = zzhyVar.d;
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
            bn.a(sb, i, String.valueOf(this.c[i2] >>> 3), this.d[i2]);
        }
    }
}
