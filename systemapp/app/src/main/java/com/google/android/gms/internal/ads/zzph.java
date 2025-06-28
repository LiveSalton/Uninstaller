package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzph {
    private int a;
    private long[] b;

    public zzph() {
        this(32);
    }

    private zzph(int i) {
        this.b = new long[32];
    }

    public final void a(long j) {
        if (this.a == this.b.length) {
            this.b = Arrays.copyOf(this.b, this.a << 1);
        }
        long[] jArr = this.b;
        int i = this.a;
        this.a = i + 1;
        jArr[i] = j;
    }

    public final long a(int i) {
        if (i < 0 || i >= this.a) {
            int i2 = this.a;
            StringBuilder sb = new StringBuilder(46);
            sb.append("Invalid index ");
            sb.append(i);
            sb.append(", size is ");
            sb.append(i2);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        return this.b[i];
    }

    public final int a() {
        return this.a;
    }
}
