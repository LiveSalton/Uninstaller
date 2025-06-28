package com.google.android.gms.common.util;

import android.os.SystemClock;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public class DefaultClock implements Clock {
    private static final DefaultClock a = new DefaultClock();

    @KeepForSdk
    public static Clock d() {
        return a;
    }

    @Override // com.google.android.gms.common.util.Clock
    public long a() {
        return System.currentTimeMillis();
    }

    @Override // com.google.android.gms.common.util.Clock
    public long b() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.gms.common.util.Clock
    public long c() {
        return System.nanoTime();
    }

    private DefaultClock() {
    }
}
