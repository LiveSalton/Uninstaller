package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzjx implements zzjz {
    private static final byte[] a = new byte[4096];
    private final zzon b;
    private final long c;
    private long d;
    private byte[] e = new byte[65536];
    private int f;
    private int g;

    public zzjx(zzon zzonVar, long j, long j2) {
        this.b = zzonVar;
        this.d = j;
        this.c = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final int a(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        int d = d(bArr, i, i2);
        if (d == 0) {
            d = a(bArr, i, i2, 0, true);
        }
        f(d);
        return d;
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final boolean a(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        int d = d(bArr, i, i2);
        while (d < i2 && d != -1) {
            d = a(bArr, i, i2, d, z);
        }
        f(d);
        return d != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final void b(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        a(bArr, i, i2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final int a(int i) throws IOException, InterruptedException {
        int d = d(i);
        if (d == 0) {
            d = a(a, 0, Math.min(i, a.length), 0, true);
        }
        f(d);
        return d;
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final void b(int i) throws IOException, InterruptedException {
        int d = d(i);
        while (d < i && d != -1) {
            d = a(a, -d, Math.min(i, a.length + d), d, false);
        }
        f(d);
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final void c(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        if (a(i2, false)) {
            System.arraycopy(this.e, this.f - i2, bArr, i, i2);
        }
    }

    private final boolean a(int i, boolean z) throws IOException, InterruptedException {
        int i2 = this.f + i;
        if (i2 > this.e.length) {
            this.e = Arrays.copyOf(this.e, zzpt.a(this.e.length << 1, 65536 + i2, i2 + 524288));
        }
        int min = Math.min(this.g - this.f, i);
        while (min < i) {
            min = a(this.e, this.f, i, min, false);
            if (min == -1) {
                return false;
            }
        }
        this.f += i;
        this.g = Math.max(this.g, this.f);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final void c(int i) throws IOException, InterruptedException {
        a(i, false);
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final void a() {
        this.f = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final long b() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final long c() {
        return this.c;
    }

    private final int d(int i) {
        int min = Math.min(this.g, i);
        e(min);
        return min;
    }

    private final int d(byte[] bArr, int i, int i2) {
        if (this.g == 0) {
            return 0;
        }
        int min = Math.min(this.g, i2);
        System.arraycopy(this.e, 0, bArr, i, min);
        e(min);
        return min;
    }

    private final void e(int i) {
        this.g -= i;
        this.f = 0;
        byte[] bArr = this.e;
        if (this.g < this.e.length - 524288) {
            bArr = new byte[this.g + 65536];
        }
        System.arraycopy(this.e, i, bArr, 0, this.g);
        this.e = bArr;
    }

    private final int a(byte[] bArr, int i, int i2, int i3, boolean z) throws InterruptedException, IOException {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        int a2 = this.b.a(bArr, i + i3, i2 - i3);
        if (a2 != -1) {
            return i3 + a2;
        }
        if (i3 == 0 && z) {
            return -1;
        }
        throw new EOFException();
    }

    private final void f(int i) {
        if (i != -1) {
            this.d += i;
        }
    }
}
