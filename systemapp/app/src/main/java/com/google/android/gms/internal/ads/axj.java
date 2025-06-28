package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/* compiled from: source */
/* loaded from: classes.dex */
final class axj implements qi {
    private final FileChannel a;
    private final long b;
    private final long c;

    public axj(FileChannel fileChannel, long j, long j2) {
        this.a = fileChannel;
        this.b = j;
        this.c = j2;
    }

    @Override // com.google.android.gms.internal.ads.qi
    public final long a() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.qi
    public final void a(MessageDigest[] messageDigestArr, long j, int i) throws IOException {
        MappedByteBuffer map = this.a.map(FileChannel.MapMode.READ_ONLY, this.b + j, i);
        map.load();
        for (MessageDigest messageDigest : messageDigestArr) {
            map.position(0);
            messageDigest.update(map);
        }
    }
}
