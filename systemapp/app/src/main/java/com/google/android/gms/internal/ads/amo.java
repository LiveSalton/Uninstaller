package com.google.android.gms.internal.ads;

import java.io.OutputStream;

/* compiled from: source */
/* loaded from: classes.dex */
final class amo extends OutputStream {
    amo() {
    }

    public final String toString() {
        return "ByteStreams.nullOutputStream()";
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        zzdvv.a(bArr);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        zzdvv.a(bArr);
    }
}
