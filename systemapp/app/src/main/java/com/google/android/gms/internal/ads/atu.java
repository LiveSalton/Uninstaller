package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class atu<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzekt> a;

    /* JADX INFO: Access modifiers changed from: private */
    atu(Map.Entry<K, zzekt> entry) {
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
        return zzekt.a();
    }

    public final zzekt a() {
        return this.a.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof zzels)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        return this.a.getValue().a((zzels) obj);
    }

    /* synthetic */ atu(Map.Entry entry, atv atvVar) {
        this(entry);
    }
}
