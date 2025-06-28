package com.google.android.gms.internal.measurement;

/* compiled from: source */
/* loaded from: classes.dex */
final class bj {
    private static final bi a = c();
    private static final bi b = new bk();

    static bi a() {
        return a;
    }

    static bi b() {
        return b;
    }

    private static bi c() {
        try {
            return (bi) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
