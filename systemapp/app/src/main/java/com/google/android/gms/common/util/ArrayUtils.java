package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;

/* compiled from: source */
@VisibleForTesting
@KeepForSdk
/* loaded from: classes.dex */
public final class ArrayUtils {
    @KeepForSdk
    public static <T> boolean a(T[] tArr, T t) {
        int length = tArr != null ? tArr.length : 0;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            if (Objects.a(tArr[i], t)) {
                break;
            }
            i++;
        }
        return i >= 0;
    }

    private ArrayUtils() {
    }
}
