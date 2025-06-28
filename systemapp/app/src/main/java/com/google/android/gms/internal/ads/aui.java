package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class aui {
    private static final auh a = c();
    private static final auh b = new auj();

    static auh a() {
        return a;
    }

    static auh b() {
        return b;
    }

    private static auh c() {
        try {
            return (auh) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
