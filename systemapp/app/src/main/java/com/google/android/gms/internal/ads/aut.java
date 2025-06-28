package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class aut {
    private static final aus a = c();
    private static final aus b = new auq();

    static aus a() {
        return a;
    }

    static aus b() {
        return b;
    }

    private static aus c() {
        try {
            return (aus) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
