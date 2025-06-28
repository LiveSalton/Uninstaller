package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdoa {
    private final Pattern a;

    @VisibleForTesting
    public zzdoa() {
        Pattern pattern;
        try {
            pattern = Pattern.compile((String) zzwq.e().a(zzabf.dW));
        } catch (PatternSyntaxException unused) {
            pattern = null;
        }
        this.a = pattern;
    }

    public final String a(String str) {
        if (this.a == null || str == null) {
            return null;
        }
        Matcher matcher = this.a.matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }
}
