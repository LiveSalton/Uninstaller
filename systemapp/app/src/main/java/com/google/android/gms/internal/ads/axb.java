package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
abstract class axb<K, V, V2> implements zzepf<Map<K, V2>> {
    private final Map<K, zzeps<V>> a;

    axb(Map<K, zzeps<V>> map) {
        this.a = Collections.unmodifiableMap(map);
    }

    final Map<K, zzeps<V>> a() {
        return this.a;
    }
}
