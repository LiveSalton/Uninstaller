package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

/* compiled from: source */
/* loaded from: classes.dex */
final class amv implements Runnable {
    private final /* synthetic */ zzdyz a;
    private final /* synthetic */ int b;
    private final /* synthetic */ amw c;

    amv(amw amwVar, zzdyz zzdyzVar, int i) {
        this.c = amwVar;
        this.a = zzdyzVar;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.a.isCancelled()) {
                amw.a(this.c, (zzdwl) null);
                this.c.cancel(false);
            } else {
                this.c.a(this.b, (Future) this.a);
            }
        } finally {
            this.c.a((zzdwl) null);
        }
    }
}
