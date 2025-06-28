package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: source */
@KeepForSdk
/* loaded from: classes.dex */
public final class GmsLogger {
    private static final int a = 15;
    private static final String b = null;
    private final String c;
    private final String d;

    public GmsLogger(String str, String str2) {
        Preconditions.a(str, (Object) "log tag cannot be null");
        Preconditions.a(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.c = str;
        if (str2 == null || str2.length() <= 0) {
            this.d = null;
        } else {
            this.d = str2;
        }
    }
}
