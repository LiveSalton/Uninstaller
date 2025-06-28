package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: source */
/* loaded from: classes.dex */
final class ayq implements zzif {
    private int b = -1;
    private int c = -1;
    private int d = 0;
    private ByteBuffer e = a;
    private ByteBuffer f = a;
    private boolean g;

    @Override // com.google.android.gms.internal.ads.zzif
    public final int c() {
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final boolean a(int i, int i2, int i3) throws zzii {
        if (i3 != 3 && i3 != 2 && i3 != Integer.MIN_VALUE && i3 != 1073741824) {
            throw new zzii(i, i2, i3);
        }
        if (this.b == i && this.c == i2 && this.d == i3) {
            return false;
        }
        this.b = i;
        this.c = i2;
        this.d = i3;
        if (i3 != 2) {
            return true;
        }
        this.e = a;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final boolean a() {
        return (this.d == 0 || this.d == 2) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final int b() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final void a(ByteBuffer byteBuffer) {
        int i;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        int i3 = this.d;
        if (i3 == Integer.MIN_VALUE) {
            i = (i2 / 3) << 1;
        } else if (i3 == 3) {
            i = i2 << 1;
        } else if (i3 == 1073741824) {
            i = i2 / 2;
        } else {
            throw new IllegalStateException();
        }
        if (this.e.capacity() < i) {
            this.e = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.e.clear();
        }
        int i4 = this.d;
        if (i4 == Integer.MIN_VALUE) {
            while (position < limit) {
                this.e.put(byteBuffer.get(position + 1));
                this.e.put(byteBuffer.get(position + 2));
                position += 3;
            }
        } else if (i4 == 3) {
            while (position < limit) {
                this.e.put((byte) 0);
                this.e.put((byte) ((byteBuffer.get(position) & 255) - 128));
                position++;
            }
        } else {
            if (i4 != 1073741824) {
                throw new IllegalStateException();
            }
            while (position < limit) {
                this.e.put(byteBuffer.get(position + 2));
                this.e.put(byteBuffer.get(position + 3));
                position += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        this.e.flip();
        this.f = this.e;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final void d() {
        this.g = true;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final ByteBuffer e() {
        ByteBuffer byteBuffer = this.f;
        this.f = a;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final boolean f() {
        return this.g && this.f == a;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final void g() {
        this.f = a;
        this.g = false;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final void h() {
        g();
        this.e = a;
        this.b = -1;
        this.c = -1;
        this.d = 0;
    }
}
