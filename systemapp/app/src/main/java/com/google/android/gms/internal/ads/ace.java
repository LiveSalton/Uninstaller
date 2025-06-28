package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: source */
/* loaded from: classes.dex */
final class ace implements qi {
    private final ByteBuffer a;

    public ace(ByteBuffer byteBuffer) {
        this.a = byteBuffer.slice();
    }

    @Override // com.google.android.gms.internal.ads.qi
    public final long a() {
        return this.a.capacity();
    }

    @Override // com.google.android.gms.internal.ads.qi
    public final void a(MessageDigest[] messageDigestArr, long j, int i) throws IOException {
        ByteBuffer slice;
        synchronized (this.a) {
            int i2 = (int) j;
            this.a.position(i2);
            this.a.limit(i2 + i);
            slice = this.a.slice();
        }
        for (MessageDigest messageDigest : messageDigestArr) {
            slice.position(0);
            messageDigest.update(slice);
        }
    }
}
