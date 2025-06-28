package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class asv extends asx {
    private final int c;
    private final int d;

    asv(byte[] bArr, int i, int i2) {
        super(bArr);
        c(i, i + i2, bArr.length);
        this.c = i;
        this.d = i2;
    }

    @Override // com.google.android.gms.internal.ads.asx, com.google.android.gms.internal.ads.zzeiu
    public final byte a(int i) {
        b(i, b());
        return this.b[this.c + i];
    }

    @Override // com.google.android.gms.internal.ads.asx, com.google.android.gms.internal.ads.zzeiu
    final byte b(int i) {
        return this.b[this.c + i];
    }

    @Override // com.google.android.gms.internal.ads.asx, com.google.android.gms.internal.ads.zzeiu
    public final int b() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.asx
    protected final int l() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.asx, com.google.android.gms.internal.ads.zzeiu
    protected final void b(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.b, l() + i, bArr, i2, i3);
    }
}
