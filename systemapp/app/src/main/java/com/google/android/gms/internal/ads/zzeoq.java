package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class zzeoq extends zzeoo implements zzbp {
    private int b;
    private int c;

    protected zzeoq(String str) {
        super(str);
    }

    public final int e() {
        if (!this.a) {
            d();
        }
        return this.b;
    }

    protected final long b(ByteBuffer byteBuffer) {
        this.b = zzbq.a(byteBuffer.get());
        this.c = 0 + (zzbq.b(byteBuffer) << 8) + zzbq.a(byteBuffer.get());
        return 4L;
    }
}
