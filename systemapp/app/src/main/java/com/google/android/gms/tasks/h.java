package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
final class h implements Executor {
    h() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
