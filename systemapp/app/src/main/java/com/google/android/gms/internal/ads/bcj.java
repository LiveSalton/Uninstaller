package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: source */
@VisibleForTesting
/* loaded from: classes.dex */
final class bcj {

    @VisibleForTesting
    private ByteArrayOutputStream a = new ByteArrayOutputStream(4096);

    @VisibleForTesting
    private Base64OutputStream b = new Base64OutputStream(this.a, 10);

    public final void a(byte[] bArr) throws IOException {
        this.b.write(bArr);
    }

    public final String toString() {
        try {
            this.b.close();
        } catch (IOException e) {
            zzd.c("HashManager: Unable to convert to Base64.", e);
        }
        try {
            this.a.close();
            return this.a.toString();
        } catch (IOException e2) {
            zzd.c("HashManager: Unable to convert to Base64.", e2);
            return "";
        } finally {
            this.a = null;
            this.b = null;
        }
    }
}
