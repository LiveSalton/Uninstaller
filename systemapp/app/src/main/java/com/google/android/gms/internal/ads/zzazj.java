package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.ClientLibraryUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzazj {
    public static final zzdzc a;
    public static final zzdzc b;
    public static final zzdzc c;
    public static final ScheduledExecutorService d;
    public static final zzdzc e;
    public static final zzdzc f;

    private static ThreadFactory a(String str) {
        return new fp(str);
    }

    private static zzdzc a(Executor executor) {
        return new fq(executor, null);
    }

    static {
        ExecutorService threadPoolExecutor;
        ExecutorService threadPoolExecutor2;
        ExecutorService threadPoolExecutor3;
        if (ClientLibraryUtils.a()) {
            threadPoolExecutor = zzduo.a().a(a("Default"), zzdut.b);
        } else {
            threadPoolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), a("Default"));
        }
        a = a(threadPoolExecutor);
        if (ClientLibraryUtils.a()) {
            threadPoolExecutor2 = zzduo.a().a(5, a("Loader"), zzdut.a);
        } else {
            threadPoolExecutor2 = new ThreadPoolExecutor(5, 5, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), a("Loader"));
            ((ThreadPoolExecutor) threadPoolExecutor2).allowCoreThreadTimeOut(true);
        }
        b = a(threadPoolExecutor2);
        if (ClientLibraryUtils.a()) {
            threadPoolExecutor3 = zzduo.a().b(a("Activeview"), zzdut.a);
        } else {
            threadPoolExecutor3 = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), a("Activeview"));
            ((ThreadPoolExecutor) threadPoolExecutor3).allowCoreThreadTimeOut(true);
        }
        c = a(threadPoolExecutor3);
        d = new fn(3, a("Schedule"));
        e = a(new fo());
        f = a(zzdzb.a());
    }
}
