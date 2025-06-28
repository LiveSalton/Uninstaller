package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzox {
    private final Map<String, String> a = new HashMap();
    private Map<String, String> b;

    public final synchronized Map<String, String> a() {
        if (this.b == null) {
            this.b = Collections.unmodifiableMap(new HashMap(this.a));
        }
        return this.b;
    }
}
