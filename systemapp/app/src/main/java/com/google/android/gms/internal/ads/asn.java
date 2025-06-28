package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class asn {
    private static final Class<?> a = a("libcore.io.Memory");
    private static final boolean b;

    static boolean a() {
        return (a == null || b) ? false : true;
    }

    static Class<?> b() {
        return a;
    }

    private static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static {
        b = a("org.robolectric.Robolectric") != null;
    }
}
