package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzjf implements zzif {
    private ays d;
    private long j;
    private long k;
    private boolean l;
    private float e = 1.0f;
    private float f = 1.0f;
    private int b = -1;
    private int c = -1;
    private ByteBuffer g = a;
    private ShortBuffer h = this.g.asShortBuffer();
    private ByteBuffer i = a;

    @Override // com.google.android.gms.internal.ads.zzif
    public final int c() {
        return 2;
    }

    public final float a(float f) {
        this.e = zzpt.a(f, 0.1f, 8.0f);
        return this.e;
    }

    public final float b(float f) {
        this.f = zzpt.a(f, 0.1f, 8.0f);
        return f;
    }

    public final long i() {
        return this.j;
    }

    public final long j() {
        return this.k;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final boolean a(int i, int i2, int i3) throws zzii {
        if (i3 != 2) {
            throw new zzii(i, i2, i3);
        }
        if (this.c == i && this.b == i2) {
            return false;
        }
        this.c = i;
        this.b = i2;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final boolean a() {
        return Math.abs(this.e - 1.0f) >= 0.01f || Math.abs(this.f - 1.0f) >= 0.01f;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final int b() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final void a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.j += remaining;
            this.d.a(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int b = (this.d.b() * this.b) << 1;
        if (b > 0) {
            if (this.g.capacity() < b) {
                this.g = ByteBuffer.allocateDirect(b).order(ByteOrder.nativeOrder());
                this.h = this.g.asShortBuffer();
            } else {
                this.g.clear();
                this.h.clear();
            }
            this.d.b(this.h);
            this.k += b;
            this.g.limit(b);
            this.i = this.g;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final void d() {
        this.d.a();
        this.l = true;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final ByteBuffer e() {
        ByteBuffer byteBuffer = this.i;
        this.i = a;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final boolean f() {
        if (this.l) {
            return this.d == null || this.d.b() == 0;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final void g() {
        this.d = new ays(this.c, this.b);
        this.d.a(this.e);
        this.d.b(this.f);
        this.i = a;
        this.j = 0L;
        this.k = 0L;
        this.l = false;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final void h() {
        this.d = null;
        this.g = a;
        this.h = this.g.asShortBuffer();
        this.i = a;
        this.b = -1;
        this.c = -1;
        this.j = 0L;
        this.k = 0L;
        this.l = false;
    }
}
