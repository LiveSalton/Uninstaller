package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzepb<K, V, V2> {
    final LinkedHashMap<K, zzeps<V>> a;

    zzepb(int i) {
        this.a = zzepe.c(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    zzepb<K, V, V2> a(K k, zzeps<V> zzepsVar) {
        this.a.put(zzepl.a(k, "key"), zzepl.a(zzepsVar, "provider"));
        return this;
    }
}
