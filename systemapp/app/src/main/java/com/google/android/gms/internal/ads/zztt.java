package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zztt {
    private final InputStream a;
    private final boolean b;
    private final boolean c;
    private final long d;
    private final boolean e;

    private zztt(InputStream inputStream, boolean z, boolean z2, long j, boolean z3) {
        this.a = inputStream;
        this.b = z;
        this.c = z2;
        this.d = j;
        this.e = z3;
    }

    public static zztt a(InputStream inputStream, boolean z, boolean z2, long j, boolean z3) {
        return new zztt(inputStream, z, z2, j, z3);
    }

    public final InputStream a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public final boolean c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public final boolean e() {
        return this.e;
    }
}
