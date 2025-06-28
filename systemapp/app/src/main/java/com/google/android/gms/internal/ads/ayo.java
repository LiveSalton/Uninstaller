package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
final class ayo implements zzif {
    private int[] d;
    private boolean e;
    private int[] f;
    private boolean i;
    private ByteBuffer g = a;
    private ByteBuffer h = a;
    private int b = -1;
    private int c = -1;

    @Override // com.google.android.gms.internal.ads.zzif
    public final int c() {
        return 2;
    }

    public final void a(int[] iArr) {
        this.d = iArr;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final boolean a(int i, int i2, int i3) throws zzii {
        boolean z = !Arrays.equals(this.d, this.f);
        this.f = this.d;
        if (this.f == null) {
            this.e = false;
            return z;
        }
        if (i3 != 2) {
            throw new zzii(i, i2, i3);
        }
        if (!z && this.c == i && this.b == i2) {
            return false;
        }
        this.c = i;
        this.b = i2;
        this.e = i2 != this.f.length;
        int i4 = 0;
        while (i4 < this.f.length) {
            int i5 = this.f[i4];
            if (i5 >= i2) {
                throw new zzii(i, i2, i3);
            }
            this.e = (i5 != i4) | this.e;
            i4++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final boolean a() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final int b() {
        return this.f == null ? this.b : this.f.length;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final void a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = (((limit - position) / (this.b * 2)) * this.f.length) << 1;
        if (this.g.capacity() < length) {
            this.g = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.g.clear();
        }
        while (position < limit) {
            for (int i : this.f) {
                this.g.putShort(byteBuffer.getShort((i * 2) + position));
            }
            position += this.b << 1;
        }
        byteBuffer.position(limit);
        this.g.flip();
        this.h = this.g;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final void d() {
        this.i = true;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final ByteBuffer e() {
        ByteBuffer byteBuffer = this.h;
        this.h = a;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final boolean f() {
        return this.i && this.h == a;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final void g() {
        this.h = a;
        this.i = false;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final void h() {
        g();
        this.g = a;
        this.b = -1;
        this.c = -1;
        this.f = null;
        this.e = false;
    }
}
