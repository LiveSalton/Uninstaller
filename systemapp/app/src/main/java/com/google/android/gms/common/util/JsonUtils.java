package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.regex.Pattern;

/* compiled from: source */
@VisibleForTesting
@KeepForSdk
/* loaded from: classes.dex */
public final class JsonUtils {
    private static final Pattern a = Pattern.compile("\\\\.");
    private static final Pattern b = Pattern.compile("[\\\\\"/\b\f\n\r\t]");

    private JsonUtils() {
    }
}
