package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzepe {
    private static int d(int i) {
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static <T> List<T> a(int i) {
        return i == 0 ? Collections.emptyList() : new ArrayList(i);
    }

    static <T> HashSet<T> b(int i) {
        return new HashSet<>(d(i));
    }

    public static <K, V> LinkedHashMap<K, V> c(int i) {
        return new LinkedHashMap<>(d(i));
    }
}
