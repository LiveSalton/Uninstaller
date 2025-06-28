package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
final class bck implements Executor {
    private final /* synthetic */ Handler a;

    bck(zzt zztVar, Handler handler) {
        this.a = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}
