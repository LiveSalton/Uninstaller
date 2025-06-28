package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class avn<K, V> implements Comparable<avn>, Map.Entry<K, V> {
    private final Comparable a;
    private V b;
    private final /* synthetic */ avi c;

    avn(avi aviVar, Map.Entry<K, V> entry) {
        this(aviVar, (Comparable) entry.getKey(), entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    avn(avi aviVar, K k, V v) {
        this.c = aviVar;
        this.a = k;
        this.b = v;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.b;
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.c.f();
        V v2 = this.b;
        this.b = v;
        return v2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return a(this.a, entry.getKey()) && a(this.b, entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return (this.a == null ? 0 : this.a.hashCode()) ^ (this.b != null ? this.b.hashCode() : 0);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.a);
        String valueOf2 = String.valueOf(this.b);
        StringBuilder sb = new StringBuilder(1 + String.valueOf(valueOf).length() + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.a;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(avn avnVar) {
        return ((Comparable) getKey()).compareTo((Comparable) avnVar.getKey());
    }
}
