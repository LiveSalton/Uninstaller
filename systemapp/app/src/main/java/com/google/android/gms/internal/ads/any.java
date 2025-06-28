package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
final class any<V> extends ani<V> {

    @NullableDecl
    private zzdyz<V> a;

    @NullableDecl
    private ScheduledFuture<?> b;

    static <V> zzdyz<V> a(zzdyz<V> zzdyzVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        any anyVar = new any(zzdyzVar);
        aoa aoaVar = new aoa(anyVar);
        anyVar.b = scheduledExecutorService.schedule(aoaVar, j, timeUnit);
        zzdyzVar.a(aoaVar, anf.INSTANCE);
        return anyVar;
    }

    private any(zzdyz<V> zzdyzVar) {
        this.a = (zzdyz) zzdvv.a(zzdyzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxo
    protected final String a() {
        zzdyz<V> zzdyzVar = this.a;
        ScheduledFuture<?> scheduledFuture = this.b;
        if (zzdyzVar == null) {
            return null;
        }
        String valueOf = String.valueOf(zzdyzVar);
        StringBuilder sb = new StringBuilder(14 + String.valueOf(valueOf).length());
        sb.append("inputFuture=[");
        sb.append(valueOf);
        sb.append("]");
        String sb2 = sb.toString();
        if (scheduledFuture == null) {
            return sb2;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return sb2;
        }
        String valueOf2 = String.valueOf(sb2);
        StringBuilder sb3 = new StringBuilder(43 + String.valueOf(valueOf2).length());
        sb3.append(valueOf2);
        sb3.append(", remaining delay=[");
        sb3.append(delay);
        sb3.append(" ms]");
        return sb3.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzdxo
    protected final void b() {
        a((Future<?>) this.a);
        ScheduledFuture<?> scheduledFuture = this.b;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.a = null;
        this.b = null;
    }

    static /* synthetic */ ScheduledFuture a(any anyVar, ScheduledFuture scheduledFuture) {
        anyVar.b = null;
        return null;
    }
}
