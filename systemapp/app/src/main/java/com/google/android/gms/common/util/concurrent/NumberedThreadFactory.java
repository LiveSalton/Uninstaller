package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public class NumberedThreadFactory implements ThreadFactory {
    private final String a;
    private final AtomicInteger b;
    private final ThreadFactory c;

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.c.newThread(new a(runnable, 0));
        String str = this.a;
        int andIncrement = this.b.getAndIncrement();
        StringBuilder sb = new StringBuilder(13 + String.valueOf(str).length());
        sb.append(str);
        sb.append("[");
        sb.append(andIncrement);
        sb.append("]");
        newThread.setName(sb.toString());
        return newThread;
    }
}
