package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeph<K, V> extends axb<K, V, V> {
    private static final zzeps<Map<Object, Object>> a = zzepi.a(Collections.emptyMap());

    public static <K, V> zzepj<K, V> a(int i) {
        return new zzepj<>(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    zzeph(Map<K, zzeps<V>> map) {
        super(map);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        LinkedHashMap c = zzepe.c(a().size());
        for (Map.Entry<K, zzeps<V>> entry : a().entrySet()) {
            c.put(entry.getKey(), entry.getValue().b());
        }
        return Collections.unmodifiableMap(c);
    }

    /* synthetic */ zzeph(Map map, axc axcVar) {
        this(map);
    }
}
