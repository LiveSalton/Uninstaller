package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzhw extends RuntimeException {
    private final List<String> a;

    public zzhw(zzgo zzgoVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.a = null;
    }
}
