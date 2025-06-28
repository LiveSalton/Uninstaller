package com.google.android.gms.internal.ads;

import java.io.PrintWriter;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
final class asi extends ash {
    private final asg a = new asg();

    asi() {
    }

    @Override // com.google.android.gms.internal.ads.ash
    public final void a(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        }
        if (th2 == null) {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
        this.a.a(th, true).add(th2);
    }

    @Override // com.google.android.gms.internal.ads.ash
    public final void a(Throwable th, PrintWriter printWriter) {
        th.printStackTrace(printWriter);
        List<Throwable> a = this.a.a(th, false);
        if (a == null) {
            return;
        }
        synchronized (a) {
            for (Throwable th2 : a) {
                printWriter.print("Suppressed: ");
                th2.printStackTrace(printWriter);
            }
        }
    }
}
