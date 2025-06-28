package com.google.android.gms.common.util;

import android.util.Base64;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public final class Base64Utils {
    @KeepForSdk
    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 0);
    }
}
