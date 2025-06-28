package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzgo<T> {
    private final Map<String, AtomicReference<T>> a = new HashMap();

    public final AtomicReference<T> a(String str) {
        synchronized (this) {
            if (!this.a.containsKey(str)) {
                this.a.put(str, new AtomicReference<>());
            }
        }
        return this.a.get(str);
    }
}
