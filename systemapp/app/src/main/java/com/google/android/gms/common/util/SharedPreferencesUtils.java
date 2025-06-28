package com.google.android.gms.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public class SharedPreferencesUtils {
    private SharedPreferencesUtils() {
    }

    @KeepForSdk
    @Deprecated
    public static void a(Context context, SharedPreferences.Editor editor, String str) {
        throw new IllegalStateException("world-readable shared preferences should only be used by apk");
    }
}
