package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
final class k implements Runnable {
    private final /* synthetic */ i a;
    private final /* synthetic */ Callable b;

    k(i iVar, Callable callable) {
        this.a = iVar;
        this.b = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.a((i) this.b.call());
        } catch (Exception e) {
            this.a.a(e);
        }
    }
}
