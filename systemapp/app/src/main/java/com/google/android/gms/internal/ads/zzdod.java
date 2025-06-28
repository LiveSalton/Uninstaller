package com.google.android.gms.internal.ads;

import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdod<T> {

    @GuardedBy("this")
    private final Deque<zzdyz<T>> a = new LinkedBlockingDeque();
    private final Callable<T> b;
    private final zzdzc c;

    public zzdod(Callable<T> callable, zzdzc zzdzcVar) {
        this.b = callable;
        this.c = zzdzcVar;
    }

    public final synchronized void a(int i) {
        int size = i - this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.a.add(this.c.submit(this.b));
        }
    }

    public final synchronized zzdyz<T> a() {
        a(1);
        return this.a.poll();
    }

    public final synchronized void a(zzdyz<T> zzdyzVar) {
        this.a.addFirst(zzdyzVar);
    }
}
