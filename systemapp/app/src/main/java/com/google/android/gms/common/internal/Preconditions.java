package com.google.android.gms.common.internal;

import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public final class Preconditions {
    @EnsuresNonNull({"#1"})
    @KeepForSdk
    public static <T> T a(T t) {
        if (t == null) {
            throw new NullPointerException("null reference");
        }
        return t;
    }

    @KeepForSdk
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        return str;
    }

    @KeepForSdk
    public static String a(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }

    @EnsuresNonNull({"#1"})
    @KeepForSdk
    public static <T> T a(T t, Object obj) {
        if (t == null) {
            throw new NullPointerException(String.valueOf(obj));
        }
        return t;
    }

    @KeepForSdk
    public static void a(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    @KeepForSdk
    public static void a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    @KeepForSdk
    public static void a(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    @KeepForSdk
    public static void b(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    private Preconditions() {
        throw new AssertionError("Uninstantiable");
    }

    @KeepForSdk
    public static void b(String str) {
        if (!com.google.android.gms.common.util.zzc.a()) {
            throw new IllegalStateException(str);
        }
    }

    @KeepForSdk
    public static void c(String str) {
        if (com.google.android.gms.common.util.zzc.a()) {
            throw new IllegalStateException(str);
        }
    }
}
