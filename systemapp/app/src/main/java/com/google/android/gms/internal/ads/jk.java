package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

/* compiled from: source */
/* loaded from: classes.dex */
final class jk extends FilterInputStream {
    private final HttpURLConnection a;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    jk(java.net.HttpURLConnection r2) {
        /*
            r1 = this;
            java.io.InputStream r0 = com.google.android.gms.internal.ads.zzbd.a(r2)
            r1.<init>(r0)
            r1.a = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.jk.<init>(java.net.HttpURLConnection):void");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        super.close();
        this.a.disconnect();
    }
}
