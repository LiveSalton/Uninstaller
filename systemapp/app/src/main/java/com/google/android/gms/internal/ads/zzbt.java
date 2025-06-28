package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbt extends zzeoo {
    private ByteBuffer b;

    public zzbt(String str) {
        super(str);
    }

    @Override // com.google.android.gms.internal.ads.zzeoo
    public final void a(ByteBuffer byteBuffer) {
        this.b = byteBuffer;
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
    }
}
