package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbi extends ByteArrayOutputStream {
    private final zzat a;

    public zzbi(zzat zzatVar, int i) {
        this.a = zzatVar;
        this.buf = this.a.a(Math.max(i, 256));
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.a.a(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.a.a(this.buf);
    }

    private final void a(int i) {
        if (this.count + i <= this.buf.length) {
            return;
        }
        byte[] a = this.a.a((this.count + i) << 1);
        System.arraycopy(this.buf, 0, a, 0, this.count);
        this.a.a(this.buf);
        this.buf = a;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i, int i2) {
        a(i2);
        super.write(bArr, i, i2);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(int i) {
        a(1);
        super.write(i);
    }
}
