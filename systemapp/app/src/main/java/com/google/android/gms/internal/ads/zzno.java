package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzno extends zzhz {
    private static final Object b = new Object();
    private final long c;
    private final long d;
    private final long e;
    private final long f;
    private final boolean g;
    private final boolean h;

    public zzno(long j, boolean z) {
        this(j, j, 0L, 0L, z, false);
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final int b() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final int c() {
        return 1;
    }

    private zzno(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.c = j;
        this.d = j2;
        this.e = 0L;
        this.f = 0L;
        this.g = z;
        this.h = false;
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final zzie a(int i, zzie zzieVar, boolean z, long j) {
        zzpc.a(i, 0, 1);
        boolean z2 = this.g;
        long j2 = this.d;
        zzieVar.a = null;
        zzieVar.b = -9223372036854775807L;
        zzieVar.c = -9223372036854775807L;
        zzieVar.d = z2;
        zzieVar.e = false;
        zzieVar.h = 0L;
        zzieVar.i = j2;
        zzieVar.f = 0;
        zzieVar.g = 0;
        zzieVar.j = 0L;
        return zzieVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final zzib a(int i, zzib zzibVar, boolean z) {
        zzpc.a(i, 0, 1);
        Object obj = z ? b : null;
        return zzibVar.a(obj, obj, 0, this.c, 0L, false);
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final int a(Object obj) {
        return b.equals(obj) ? 0 : -1;
    }
}
