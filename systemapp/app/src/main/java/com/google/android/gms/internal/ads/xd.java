package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
final /* synthetic */ class xd implements Callable {
    private final zzcpp a;

    private xd(zzcpp zzcppVar) {
        this.a = zzcppVar;
    }

    static Callable a(zzcpp zzcppVar) {
        return new xd(zzcppVar);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.a.getWritableDatabase();
    }
}
