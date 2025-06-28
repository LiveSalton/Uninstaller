package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
abstract class awd {
    awd() {
    }

    abstract int a(int i, byte[] bArr, int i2, int i3);

    abstract int a(CharSequence charSequence, byte[] bArr, int i, int i2);

    abstract String b(byte[] bArr, int i, int i2) throws zzeks;

    final boolean a(byte[] bArr, int i, int i2) {
        return a(0, bArr, i, i2) == 0;
    }
}
