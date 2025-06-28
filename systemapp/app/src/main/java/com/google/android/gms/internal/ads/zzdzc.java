package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* compiled from: source */
/* loaded from: classes.dex */
public interface zzdzc extends ExecutorService {
    /* renamed from: a */
    zzdyz<?> submit(Runnable runnable);

    /* renamed from: a */
    <T> zzdyz<T> submit(Callable<T> callable);
}
