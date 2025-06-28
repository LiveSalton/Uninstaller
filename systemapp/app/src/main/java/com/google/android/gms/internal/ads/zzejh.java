package com.google.android.gms.internal.ads;

import java.io.OutputStream;
import java.util.ArrayList;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzejh extends OutputStream {
    private static final byte[] a = new byte[0];
    private int d;
    private int f;
    private final int b = 128;
    private final ArrayList<zzeiu> c = new ArrayList<>();
    private byte[] e = new byte[128];

    zzejh(int i) {
    }

    @Override // java.io.OutputStream
    public final synchronized void write(int i) {
        if (this.f == this.e.length) {
            a(1);
        }
        byte[] bArr = this.e;
        int i2 = this.f;
        this.f = i2 + 1;
        bArr[i2] = (byte) i;
    }

    @Override // java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i, int i2) {
        if (i2 <= this.e.length - this.f) {
            System.arraycopy(bArr, i, this.e, this.f, i2);
            this.f += i2;
            return;
        }
        int length = this.e.length - this.f;
        System.arraycopy(bArr, i, this.e, this.f, length);
        int i3 = i2 - length;
        a(i3);
        System.arraycopy(bArr, i + length, this.e, 0, i3);
        this.f = i3;
    }

    public final synchronized zzeiu a() {
        if (this.f < this.e.length) {
            if (this.f > 0) {
                byte[] bArr = this.e;
                int i = this.f;
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
                this.c.add(new asx(bArr2));
            }
        } else {
            this.c.add(new asx(this.e));
            this.e = a;
        }
        this.d += this.f;
        this.f = 0;
        return zzeiu.a(this.c);
    }

    private final synchronized int b() {
        return this.d + this.f;
    }

    public final String toString() {
        return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(b()));
    }

    private final void a(int i) {
        this.c.add(new asx(this.e));
        this.d += this.e.length;
        this.e = new byte[Math.max(this.b, Math.max(i, this.d >>> 1))];
        this.f = 0;
    }
}
