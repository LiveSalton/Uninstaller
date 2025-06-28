package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzjh {
    public byte[] a;
    public int[] b;
    public int[] c;
    private byte[] d;
    private int e;
    private int f;
    private int g;
    private int h;
    private final MediaCodec.CryptoInfo i;
    private final ayt j;

    public zzjh() {
        this.i = zzpt.a >= 16 ? new MediaCodec.CryptoInfo() : null;
        this.j = zzpt.a >= 24 ? new ayt(this.i) : null;
    }

    public final void a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2) {
        this.f = i;
        this.b = iArr;
        this.c = iArr2;
        this.d = bArr;
        this.a = bArr2;
        this.e = i2;
        this.g = 0;
        this.h = 0;
        if (zzpt.a >= 16) {
            this.i.numSubSamples = this.f;
            this.i.numBytesOfClearData = this.b;
            this.i.numBytesOfEncryptedData = this.c;
            this.i.key = this.d;
            this.i.iv = this.a;
            this.i.mode = this.e;
            if (zzpt.a >= 24) {
                this.j.a(0, 0);
            }
        }
    }

    @TargetApi(16)
    public final MediaCodec.CryptoInfo a() {
        return this.i;
    }
}
