package com.google.android.gms.common.util.concurrent;

import android.os.Handler;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.Executor;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public class HandlerExecutor implements Executor {
    private final Handler a;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}
