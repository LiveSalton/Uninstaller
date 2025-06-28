package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import java.util.Iterator;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
final class bcc implements Runnable {
    private final /* synthetic */ bcd a;

    bcc(bcd bcdVar) {
        this.a = bcdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean z;
        boolean z2;
        List list;
        obj = this.a.c;
        synchronized (obj) {
            z = this.a.d;
            if (z) {
                z2 = this.a.e;
                if (z2) {
                    bcd.a(this.a, false);
                    zzd.b("App went background");
                    list = this.a.f;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            ((zzrl) it.next()).a(false);
                        } catch (Exception e) {
                            zzaza.c("", e);
                        }
                    }
                }
            }
            zzd.b("App is still foreground");
        }
    }
}
