package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzeng extends RuntimeException {
    private final List<String> a;

    public zzeng(zzels zzelsVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.a = null;
    }
}
