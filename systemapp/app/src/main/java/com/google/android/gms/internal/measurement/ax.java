package com.google.android.gms.internal.measurement;

import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class ax<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzfp> a;

    /* JADX INFO: Access modifiers changed from: private */
    ax(Map.Entry<K, zzfp> entry) {
        this.a = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.a.getValue() == null) {
            return null;
        }
        return zzfp.a();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof zzgo)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        return this.a.getValue().a((zzgo) obj);
    }

    /* synthetic */ ax(Map.Entry entry, ay ayVar) {
        this(entry);
    }
}
