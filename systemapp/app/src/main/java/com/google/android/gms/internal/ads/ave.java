package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: source */
/* loaded from: classes.dex */
final class ave extends InputStream {
    private avb a;
    private asy b;
    private int c;
    private int d;
    private int e;
    private int f;
    private final /* synthetic */ ava g;

    public ave(ava avaVar) {
        this.g = avaVar;
        a();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException();
        }
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        int a = a(bArr, i, i2);
        if (a == 0) {
            return -1;
        }
        return a;
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        if (j < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (j > 2147483647L) {
            j = 2147483647L;
        }
        return a(null, 0, (int) j);
    }

    private final int a(byte[] bArr, int i, int i2) {
        int i3 = i;
        int i4 = i2;
        while (i4 > 0) {
            b();
            if (this.b == null) {
                break;
            }
            int min = Math.min(this.c - this.d, i4);
            if (bArr != null) {
                this.b.a(bArr, this.d, i3, min);
                i3 += min;
            }
            this.d += min;
            i4 -= min;
        }
        return i2 - i4;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        b();
        if (this.b == null) {
            return -1;
        }
        asy asyVar = this.b;
        int i = this.d;
        this.d = i + 1;
        return asyVar.a(i) & 255;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        return this.g.b() - (this.e + this.d);
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        this.f = this.e + this.d;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        a();
        a(null, 0, this.f);
    }

    private final void a() {
        this.a = new avb(this.g, null);
        this.b = (asy) this.a.next();
        this.c = this.b.b();
        this.d = 0;
        this.e = 0;
    }

    private final void b() {
        if (this.b == null || this.d != this.c) {
            return;
        }
        this.e += this.c;
        this.d = 0;
        if (this.a.hasNext()) {
            this.b = (asy) this.a.next();
            this.c = this.b.b();
        } else {
            this.b = null;
            this.c = 0;
        }
    }
}
