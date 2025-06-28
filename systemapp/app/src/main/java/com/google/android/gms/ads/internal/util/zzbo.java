package com.google.android.gms.ads.internal.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzduw;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbo {
    private HandlerThread a = null;
    private Handler b = null;
    private int c = 0;
    private final Object d = new Object();

    public final Looper a() {
        Looper looper;
        synchronized (this.d) {
            if (this.c == 0) {
                if (this.a == null) {
                    zzd.a("Starting the looper thread.");
                    this.a = new HandlerThread("LooperProvider");
                    this.a.start();
                    this.b = new zzduw(this.a.getLooper());
                    zzd.a("Looper thread started.");
                } else {
                    zzd.a("Resuming the looper thread");
                    this.d.notifyAll();
                }
            } else {
                Preconditions.a(this.a, "Invalid state: mHandlerThread should already been initialized.");
            }
            this.c++;
            looper = this.a.getLooper();
        }
        return looper;
    }

    public final Handler b() {
        return this.b;
    }
}
