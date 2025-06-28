package com.google.android.gms.internal.ads;

import java.io.PrintWriter;

/* compiled from: source */
/* loaded from: classes.dex */
final class ask extends ash {
    ask() {
    }

    @Override // com.google.android.gms.internal.ads.ash
    public final void a(Throwable th, Throwable th2) {
        th.addSuppressed(th2);
    }

    @Override // com.google.android.gms.internal.ads.ash
    public final void a(Throwable th, PrintWriter printWriter) {
        th.printStackTrace(printWriter);
    }
}
