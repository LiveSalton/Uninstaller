package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: source */
/* loaded from: classes.dex */
public interface zzdul {
    ExecutorService a(int i);

    ExecutorService a(int i, ThreadFactory threadFactory, int i2);

    ExecutorService a(ThreadFactory threadFactory, int i);

    ExecutorService b(int i);

    ExecutorService b(ThreadFactory threadFactory, int i);

    ScheduledExecutorService b(int i, ThreadFactory threadFactory, int i2);
}
