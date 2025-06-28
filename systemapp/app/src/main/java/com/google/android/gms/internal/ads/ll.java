package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: source */
/* loaded from: classes.dex */
final class ll extends ThreadLocal<ByteBuffer> {
    ll(zzbm zzbmVar) {
    }

    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ ByteBuffer initialValue() {
        return ByteBuffer.allocate(32);
    }
}
