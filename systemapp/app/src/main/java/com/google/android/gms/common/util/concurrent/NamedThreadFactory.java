package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ThreadFactory;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public class NamedThreadFactory implements ThreadFactory {
    private final String a;
    private final ThreadFactory b;

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.b.newThread(new a(runnable, 0));
        newThread.setName(this.a);
        return newThread;
    }
}
