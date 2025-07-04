package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: source */
/* loaded from: classes.dex */
public interface zzeor extends Closeable {
    int a(ByteBuffer byteBuffer) throws IOException;

    long a() throws IOException;

    ByteBuffer a(long j, long j2) throws IOException;

    void a(long j) throws IOException;

    long b() throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;
}
