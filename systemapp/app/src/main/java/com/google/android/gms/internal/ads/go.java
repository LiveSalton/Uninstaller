package com.google.android.gms.internal.ads;

import android.os.Looper;

/* compiled from: source */
/* loaded from: classes.dex */
final class go implements Runnable {
    go(gp gpVar) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Looper.myLooper().quit();
    }
}
