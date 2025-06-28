package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzdfj;

/* compiled from: source */
/* loaded from: classes.dex */
final class acz<S extends zzdfj<?>> {
    public final zzdyz<S> a;
    private final long b;
    private final Clock c;

    public acz(zzdyz<S> zzdyzVar, long j, Clock clock) {
        this.a = zzdyzVar;
        this.c = clock;
        this.b = clock.b() + j;
    }

    public final boolean a() {
        return this.b < this.c.b();
    }
}
