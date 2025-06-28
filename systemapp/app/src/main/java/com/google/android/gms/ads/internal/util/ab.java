package com.google.android.gms.ads.internal.util;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
final class ab implements Runnable {
    private final /* synthetic */ Context a;
    private final /* synthetic */ zzm b;

    ab(zzm zzmVar, Context context) {
        this.b = zzmVar;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Object obj2;
        obj = this.b.e;
        synchronized (obj) {
            this.b.f = zzm.c(this.a);
            obj2 = this.b.e;
            obj2.notifyAll();
        }
    }
}
