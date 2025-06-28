package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
final class fo implements Executor {
    private final Handler a = new zzg(Looper.getMainLooper());

    fo() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            try {
                runnable.run();
                return;
            } catch (Throwable th) {
                zzp.c();
                com.google.android.gms.ads.internal.util.zzm.a(zzp.g().i(), th);
                throw th;
            }
        }
        this.a.post(runnable);
    }
}
