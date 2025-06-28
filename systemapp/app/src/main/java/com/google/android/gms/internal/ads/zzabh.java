package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.regex.Pattern;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzabh {
    public static boolean a(String str) {
        return a((String) zzwq.e().a(zzabf.cH), str);
    }

    private static boolean a(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        try {
            return Pattern.matches(str, str2);
        } catch (RuntimeException e) {
            zzp.g().a(e, "NonagonUtil.isPatternMatched");
            return false;
        }
    }
}
