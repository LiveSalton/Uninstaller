package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* compiled from: source */
/* loaded from: classes.dex */
final class fn extends ScheduledThreadPoolExecutor {
    fn(int i, ThreadFactory threadFactory) {
        super(3, threadFactory);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        super.execute(zzdus.a().a(runnable));
    }
}
