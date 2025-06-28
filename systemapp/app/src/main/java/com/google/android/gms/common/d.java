package com.google.android.gms.common;

import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
final class d extends b {
    private final byte[] a;

    d(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.a = bArr;
    }

    @Override // com.google.android.gms.common.b
    final byte[] c() {
        return this.a;
    }
}
