package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: source */
/* loaded from: classes.dex */
final class fv extends FilterInputStream {
    private final long a;
    private long b;

    fv(InputStream inputStream, long j) {
        super(inputStream);
        this.a = j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int read = super.read();
        if (read != -1) {
            this.b++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.b += read;
        }
        return read;
    }

    final long a() {
        return this.a - this.b;
    }
}
