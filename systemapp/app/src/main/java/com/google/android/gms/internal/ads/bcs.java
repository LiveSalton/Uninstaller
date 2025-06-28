package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* compiled from: source */
/* loaded from: classes.dex */
final class bcs extends PushbackInputStream {
    private final /* synthetic */ bcr a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    bcs(bcr bcrVar, InputStream inputStream, int i) {
        super(inputStream, 1);
        this.a = bcrVar;
    }

    @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        this.a.a.a();
        super.close();
    }
}
