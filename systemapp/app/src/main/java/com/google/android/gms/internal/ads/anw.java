package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxo;

/* compiled from: source */
/* loaded from: classes.dex */
final class anw extends zzdxo.j<Void> implements Runnable {
    private final Runnable a;

    public anw(Runnable runnable) {
        this.a = (Runnable) zzdvv.a(runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.run();
        } catch (Throwable th) {
            a(th);
            throw zzdwe.b(th);
        }
    }
}
