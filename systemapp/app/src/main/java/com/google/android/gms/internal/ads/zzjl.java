package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzjl extends zzji {
    public ByteBuffer b;
    public long c;
    public final zzjh a = new zzjh();
    private final int d = 0;

    public zzjl(int i) {
    }

    public final void d(int i) throws IllegalStateException {
        if (this.b == null) {
            this.b = e(i);
            return;
        }
        int capacity = this.b.capacity();
        int position = this.b.position();
        int i2 = i + position;
        if (capacity >= i2) {
            return;
        }
        ByteBuffer e = e(i2);
        if (position > 0) {
            this.b.position(0);
            this.b.limit(position);
            e.put(this.b);
        }
        this.b = e;
    }

    public final boolean e() {
        return c(1073741824);
    }

    @Override // com.google.android.gms.internal.ads.zzji
    public final void a() {
        super.a();
        if (this.b != null) {
            this.b.clear();
        }
    }

    private final ByteBuffer e(int i) {
        int capacity = this.b == null ? 0 : this.b.capacity();
        StringBuilder sb = new StringBuilder(44);
        sb.append("Buffer too small (");
        sb.append(capacity);
        sb.append(" < ");
        sb.append(i);
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }
}
