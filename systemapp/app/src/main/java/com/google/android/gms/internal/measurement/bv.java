package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;

/* compiled from: source */
/* loaded from: classes.dex */
final class bv implements bm {
    private final zzgo a;
    private final String b;
    private final Object[] c;
    private final int d;

    final String d() {
        return this.b;
    }

    final Object[] e() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.measurement.bm
    public final zzgo c() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.measurement.bm
    public final int a() {
        return (this.d & 1) == 1 ? zzfd.zze.h : zzfd.zze.i;
    }

    @Override // com.google.android.gms.internal.measurement.bm
    public final boolean b() {
        return (this.d & 2) == 2;
    }
}
