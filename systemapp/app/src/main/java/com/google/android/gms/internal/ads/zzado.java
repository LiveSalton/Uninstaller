package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzado {
    private static final AtomicReference<zzadp> b = new AtomicReference<>();
    static final AtomicBoolean a = new AtomicBoolean();

    static zzadp a() {
        return b.get();
    }

    public static void a(zzadp zzadpVar) {
        b.set(zzadpVar);
    }
}
