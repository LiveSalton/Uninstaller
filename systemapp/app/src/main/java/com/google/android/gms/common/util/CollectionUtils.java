package com.google.android.gms.common.util;

import androidx.b.a;
import androidx.b.b;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public final class CollectionUtils {
    private CollectionUtils() {
    }

    private static <T> Set<T> a(int i, boolean z) {
        float f = z ? 0.75f : 1.0f;
        if (i <= (z ? 128 : 256)) {
            return new b(i);
        }
        return new HashSet(i, f);
    }

    @KeepForSdk
    @Deprecated
    public static <T> Set<T> a(T t, T t2, T t3) {
        Set a = a(3, false);
        a.add(t);
        a.add(t2);
        a.add(t3);
        return Collections.unmodifiableSet(a);
    }

    @KeepForSdk
    @Deprecated
    public static <T> Set<T> a(T... tArr) {
        switch (tArr.length) {
            case 0:
                return Collections.emptySet();
            case 1:
                return Collections.singleton(tArr[0]);
            case 2:
                T t = tArr[0];
                T t2 = tArr[1];
                Set a = a(2, false);
                a.add(t);
                a.add(t2);
                return Collections.unmodifiableSet(a);
            case 3:
                return a(tArr[0], tArr[1], tArr[2]);
            case 4:
                T t3 = tArr[0];
                T t4 = tArr[1];
                T t5 = tArr[2];
                T t6 = tArr[3];
                Set a2 = a(4, false);
                a2.add(t3);
                a2.add(t4);
                a2.add(t5);
                a2.add(t6);
                return Collections.unmodifiableSet(a2);
            default:
                Set a3 = a(tArr.length, false);
                Collections.addAll(a3, tArr);
                return Collections.unmodifiableSet(a3);
        }
    }

    private static <K, V> Map<K, V> b(int i, boolean z) {
        if (i <= 256) {
            return new a(i);
        }
        return new HashMap(i, 1.0f);
    }

    @KeepForSdk
    public static <K, V> Map<K, V> a(K k, V v, K k2, V v2, K k3, V v3) {
        Map b = b(3, false);
        b.put(k, v);
        b.put(k2, v2);
        b.put(k3, v3);
        return Collections.unmodifiableMap(b);
    }

    @KeepForSdk
    public static <K, V> Map<K, V> a(K[] kArr, V[] vArr) {
        if (kArr.length != vArr.length) {
            int length = kArr.length;
            int length2 = vArr.length;
            StringBuilder sb = new StringBuilder(66);
            sb.append("Key and values array lengths not equal: ");
            sb.append(length);
            sb.append(" != ");
            sb.append(length2);
            throw new IllegalArgumentException(sb.toString());
        }
        switch (kArr.length) {
            case 0:
                return Collections.emptyMap();
            case 1:
                return Collections.singletonMap(kArr[0], vArr[0]);
            default:
                Map b = b(kArr.length, false);
                for (int i = 0; i < kArr.length; i++) {
                    b.put(kArr[i], vArr[i]);
                }
                return Collections.unmodifiableMap(b);
        }
    }
}
