package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class alc implements Runnable {
    private final /* synthetic */ zzdp a;

    alc(zzdp zzdpVar) {
        this.a = zzdpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean z;
        zzdsi zzdsiVar;
        Object obj2;
        obj = this.a.l;
        synchronized (obj) {
            z = this.a.m;
            if (z) {
                return;
            }
            this.a.m = true;
            try {
                this.a.c();
            } catch (Exception e) {
                zzdsiVar = this.a.g;
                zzdsiVar.a(2023, -1L, e);
            }
            obj2 = this.a.l;
            synchronized (obj2) {
                this.a.m = false;
            }
        }
    }
}
