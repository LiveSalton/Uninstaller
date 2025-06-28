package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.Wrappers;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public class ClientLibraryUtils {
    private ClientLibraryUtils() {
    }

    @KeepForSdk
    public static boolean a() {
        return false;
    }

    public static boolean a(Context context, String str) {
        "com.google.android.gms".equals(str);
        try {
            return (Wrappers.a(context).a(str, 0).flags & 2097152) != 0;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
