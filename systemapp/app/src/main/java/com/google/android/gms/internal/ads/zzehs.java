package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzehs {
    private final byte[] a;

    public static zzehs a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new zzehs(bArr, 0, bArr.length);
    }

    public final byte[] a() {
        byte[] bArr = new byte[this.a.length];
        System.arraycopy(this.a, 0, bArr, 0, this.a.length);
        return bArr;
    }

    private zzehs(byte[] bArr, int i, int i2) {
        this.a = new byte[i2];
        System.arraycopy(bArr, 0, this.a, 0, i2);
    }
}
