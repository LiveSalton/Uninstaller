package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class atm {
    private static final atk<?> a = new atj();
    private static final atk<?> b = c();

    private static atk<?> c() {
        try {
            return (atk) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static atk<?> a() {
        return a;
    }

    static atk<?> b() {
        if (b == null) {
            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
        }
        return b;
    }
}
