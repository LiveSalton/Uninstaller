package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeil {
    private final byte[] a = new byte[256];
    private int b;
    private int c;

    public zzeil(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.a[i] = (byte) i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            i2 = (i2 + this.a[i3] + bArr[i3 % bArr.length]) & 255;
            byte b = this.a[i3];
            this.a[i3] = this.a[i2];
            this.a[i2] = b;
        }
        this.b = 0;
        this.c = 0;
    }

    public final void a(byte[] bArr) {
        int i = this.b;
        int i2 = this.c;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            i2 = (i2 + this.a[i]) & 255;
            byte b = this.a[i];
            this.a[i] = this.a[i2];
            this.a[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.a[(this.a[i] + this.a[i2]) & 255]);
        }
        this.b = i;
        this.c = i2;
    }
}
