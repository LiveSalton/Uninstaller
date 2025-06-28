package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
final class ale implements zzdul {
    /* JADX INFO: Access modifiers changed from: private */
    ale() {
    }

    @Override // com.google.android.gms.internal.ads.zzdul
    public final ExecutorService a(int i) {
        return Executors.unconfigurableExecutorService(Executors.newCachedThreadPool());
    }

    @Override // com.google.android.gms.internal.ads.zzdul
    public final ExecutorService a(ThreadFactory threadFactory, int i) {
        return Executors.unconfigurableExecutorService(Executors.newCachedThreadPool(threadFactory));
    }

    @Override // com.google.android.gms.internal.ads.zzdul
    public final ExecutorService a(int i, ThreadFactory threadFactory, int i2) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    @Override // com.google.android.gms.internal.ads.zzdul
    public final ExecutorService b(int i) {
        return a(1, Executors.defaultThreadFactory(), i);
    }

    @Override // com.google.android.gms.internal.ads.zzdul
    public final ExecutorService b(ThreadFactory threadFactory, int i) {
        return a(1, threadFactory, i);
    }

    @Override // com.google.android.gms.internal.ads.zzdul
    public final ScheduledExecutorService b(int i, ThreadFactory threadFactory, int i2) {
        return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, threadFactory));
    }

    /* synthetic */ ale(ald aldVar) {
        this();
    }
}
