package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzow {
    private final ExecutorService a;
    private bbc<? extends zzpb> b;
    private IOException c;

    public zzow(String str) {
        this.a = zzpt.a(str);
    }

    public final <T extends zzpb> long a(T t, zzoz<T> zzozVar, int i) {
        Looper myLooper = Looper.myLooper();
        zzpc.b(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new bbc(this, myLooper, t, zzozVar, i, elapsedRealtime).a(0L);
        return elapsedRealtime;
    }

    public final boolean a() {
        return this.b != null;
    }

    public final void b() {
        this.b.a(false);
    }

    public final void a(Runnable runnable) {
        if (this.b != null) {
            this.b.a(true);
        }
        this.a.execute(runnable);
        this.a.shutdown();
    }

    public final void a(int i) throws IOException {
        if (this.c != null) {
            throw this.c;
        }
        if (this.b != null) {
            this.b.a(this.b.a);
        }
    }
}
