package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdvv {
    public static void a(boolean z, @NullableDecl Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @NonNullDecl
    public static <T> T a(@NonNullDecl T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        return t;
    }

    @NonNullDecl
    public static <T> T a(@NonNullDecl T t, @NullableDecl Object obj) {
        if (t == null) {
            throw new NullPointerException(String.valueOf(obj));
        }
        return t;
    }

    @NonNullDecl
    public static <T> T a(@NonNullDecl T t, @NullableDecl String str, @NullableDecl Object obj) {
        if (t == null) {
            throw new NullPointerException(zzdwc.a(str, obj));
        }
        return t;
    }

    public static int a(int i, int i2) {
        String a;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            a = zzdwc.a("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else {
            if (i2 < 0) {
                StringBuilder sb = new StringBuilder(26);
                sb.append("negative size: ");
                sb.append(i2);
                throw new IllegalArgumentException(sb.toString());
            }
            a = zzdwc.a("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(a);
    }

    public static int b(int i, int i2) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(b(i, i2, "index"));
        }
        return i;
    }

    public static int a(int i, int i2, @NullableDecl String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(b(i, i2, str));
        }
        return i;
    }

    private static String b(int i, int i2, @NullableDecl String str) {
        if (i < 0) {
            return zzdwc.a("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return zzdwc.a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    public static void a(int i, int i2, int i3) {
        String b;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                b = b(i, i3, "start index");
            } else if (i2 < 0 || i2 > i3) {
                b = b(i2, i3, "end index");
            } else {
                b = zzdwc.a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(b);
        }
    }
}
