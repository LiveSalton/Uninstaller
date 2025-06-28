package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: source */
/* loaded from: classes.dex */
final class hp implements zzeor {
    private final ByteBuffer a;

    hp(ByteBuffer byteBuffer) {
        this.a = byteBuffer.duplicate();
    }

    @Override // com.google.android.gms.internal.ads.zzeor, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // com.google.android.gms.internal.ads.zzeor
    public final int a(ByteBuffer byteBuffer) throws IOException {
        if (this.a.remaining() == 0 && byteBuffer.remaining() > 0) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), this.a.remaining());
        byte[] bArr = new byte[min];
        this.a.get(bArr);
        byteBuffer.put(bArr);
        return min;
    }

    @Override // com.google.android.gms.internal.ads.zzeor
    public final long a() throws IOException {
        return this.a.limit();
    }

    @Override // com.google.android.gms.internal.ads.zzeor
    public final long b() throws IOException {
        return this.a.position();
    }

    @Override // com.google.android.gms.internal.ads.zzeor
    public final void a(long j) throws IOException {
        this.a.position((int) j);
    }

    @Override // com.google.android.gms.internal.ads.zzeor
    public final ByteBuffer a(long j, long j2) throws IOException {
        int position = this.a.position();
        this.a.position((int) j);
        ByteBuffer slice = this.a.slice();
        slice.limit((int) j2);
        this.a.position(position);
        return slice;
    }
}
