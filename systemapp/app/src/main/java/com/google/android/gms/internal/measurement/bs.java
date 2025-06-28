package com.google.android.gms.internal.measurement;

/* compiled from: source */
/* loaded from: classes.dex */
final class bs {
    private static final br a = c();
    private static final br b = new bq();

    static br a() {
        return a;
    }

    static br b() {
        return b;
    }

    private static br c() {
        try {
            return (br) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
