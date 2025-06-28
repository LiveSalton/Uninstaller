package com.google.android.gms.internal.measurement;

/* compiled from: source */
/* loaded from: classes.dex */
final class aq {
    private static final ap<?> a = new ar();
    private static final ap<?> b = c();

    private static ap<?> c() {
        try {
            return (ap) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static ap<?> a() {
        return a;
    }

    static ap<?> b() {
        if (b == null) {
            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
        }
        return b;
    }
}
