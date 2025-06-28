package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzckq {
    private final zzckv a;
    private final Executor b;
    private final Map<String, String> c;

    public zzckq(zzckv zzckvVar, Executor executor) {
        this.a = zzckvVar;
        this.c = zzckvVar.a();
        this.b = executor;
    }

    public final zzckp a() {
        zzckp d;
        d = new zzckp(this).d();
        return d;
    }
}
