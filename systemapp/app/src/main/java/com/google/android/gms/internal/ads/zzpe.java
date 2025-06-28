package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzpe {
    private boolean a;

    public final synchronized boolean a() {
        if (this.a) {
            return false;
        }
        this.a = true;
        notifyAll();
        return true;
    }

    public final synchronized boolean b() {
        boolean z;
        z = this.a;
        this.a = false;
        return z;
    }

    public final synchronized void c() throws InterruptedException {
        while (!this.a) {
            wait();
        }
    }
}
