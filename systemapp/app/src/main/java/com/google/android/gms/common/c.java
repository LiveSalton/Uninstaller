package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* compiled from: source */
/* loaded from: classes.dex */
abstract class c extends b {
    private static final WeakReference<byte[]> b = new WeakReference<>(null);
    private WeakReference<byte[]> a;

    c(byte[] bArr) {
        super(bArr);
        this.a = b;
    }

    protected abstract byte[] d();

    @Override // com.google.android.gms.common.b
    final byte[] c() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.a.get();
            if (bArr == null) {
                bArr = d();
                this.a = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }
}
