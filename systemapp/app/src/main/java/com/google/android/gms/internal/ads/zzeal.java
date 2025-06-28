package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeal<P> {
    private final P a;
    private final byte[] b;
    private final zzefl c;
    private final zzegd d;
    private final int e;

    zzeal(P p, byte[] bArr, zzefl zzeflVar, zzegd zzegdVar, int i) {
        this.a = p;
        this.b = Arrays.copyOf(bArr, bArr.length);
        this.c = zzeflVar;
        this.d = zzegdVar;
        this.e = i;
    }

    public final P a() {
        return this.a;
    }

    public final zzefl b() {
        return this.c;
    }

    public final zzegd c() {
        return this.d;
    }

    public final byte[] d() {
        if (this.b == null) {
            return null;
        }
        return Arrays.copyOf(this.b, this.b.length);
    }
}
