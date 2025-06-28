package com.google.android.gms.internal.ads;

import android.os.Trace;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzpq {
    public static void a(String str) {
        if (zzpt.a >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void a() {
        if (zzpt.a >= 18) {
            Trace.endSection();
        }
    }
}
