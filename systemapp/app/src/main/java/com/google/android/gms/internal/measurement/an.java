package com.google.android.gms.internal.measurement;

/* compiled from: source */
/* loaded from: classes.dex */
final class an extends zzeg {
    private final byte[] b;
    private final boolean c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    /* JADX INFO: Access modifiers changed from: private */
    an(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.h = Integer.MAX_VALUE;
        this.b = bArr;
        this.d = i2 + i;
        this.f = i;
        this.g = this.f;
        this.c = z;
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int a(int i) throws zzfo {
        if (i < 0) {
            throw zzfo.b();
        }
        int a = i + a();
        int i2 = this.h;
        if (a > i2) {
            throw zzfo.a();
        }
        this.h = a;
        b();
        return i2;
    }

    private final void b() {
        this.d += this.e;
        int i = this.d - this.g;
        if (i > this.h) {
            this.e = i - this.h;
            this.d -= this.e;
        } else {
            this.e = 0;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzeg
    public final int a() {
        return this.f - this.g;
    }

    /* synthetic */ an(byte[] bArr, int i, int i2, boolean z, ao aoVar) {
        this(bArr, i, i2, z);
    }
}
