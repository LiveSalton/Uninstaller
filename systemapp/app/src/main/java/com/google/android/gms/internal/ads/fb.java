package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.util.Clock;

/* compiled from: source */
/* loaded from: classes.dex */
final class fb {
    private long a = -1;
    private long b = -1;
    private final /* synthetic */ zzayf c;

    public fb(zzayf zzayfVar) {
        this.c = zzayfVar;
    }

    public final long a() {
        return this.b;
    }

    public final void b() {
        Clock clock;
        clock = this.c.a;
        this.b = clock.b();
    }

    public final void c() {
        Clock clock;
        clock = this.c.a;
        this.a = clock.b();
    }

    public final Bundle d() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.a);
        bundle.putLong("tclose", this.b);
        return bundle;
    }
}
