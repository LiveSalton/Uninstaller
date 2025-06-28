package com.google.android.gms.internal.ads;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
final class anu<V> extends zzdyp<V> implements zzdyz<V>, ScheduledFuture<V> {
    private final ScheduledFuture<?> a;

    public anu(zzdyz<V> zzdyzVar, ScheduledFuture<?> scheduledFuture) {
        super(zzdyzVar);
        this.a = scheduledFuture;
    }

    @Override // com.google.android.gms.internal.ads.zzdyn, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        boolean cancel = super.cancel(z);
        if (cancel) {
            this.a.cancel(z);
        }
        return cancel;
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.a.getDelay(timeUnit);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Delayed delayed) {
        return this.a.compareTo(delayed);
    }
}
