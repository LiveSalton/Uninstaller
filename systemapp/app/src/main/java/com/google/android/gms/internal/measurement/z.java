package com.google.android.gms.internal.measurement;

import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: source */
/* loaded from: classes.dex */
final class z {
    private final ConcurrentHashMap<Object, List<Throwable>> a = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> b = new ReferenceQueue<>();

    z() {
    }
}
