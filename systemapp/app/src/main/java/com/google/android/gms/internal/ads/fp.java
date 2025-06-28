package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: source */
/* loaded from: classes.dex */
final class fp implements ThreadFactory {
    private final AtomicInteger a = new AtomicInteger(1);
    private final /* synthetic */ String b;

    fp(String str) {
        this.b = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        String str = this.b;
        int andIncrement = this.a.getAndIncrement();
        StringBuilder sb = new StringBuilder(23 + String.valueOf(str).length());
        sb.append("AdWorker(");
        sb.append(str);
        sb.append(") #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
