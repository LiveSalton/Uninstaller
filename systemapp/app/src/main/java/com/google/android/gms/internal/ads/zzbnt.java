package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbnt implements zzbtj, zzqu {
    private final zzdmu a;
    private final zzbsl b;
    private final zzbtn c;
    private final AtomicBoolean d = new AtomicBoolean();
    private final AtomicBoolean e = new AtomicBoolean();

    public zzbnt(zzdmu zzdmuVar, zzbsl zzbslVar, zzbtn zzbtnVar) {
        this.a = zzdmuVar;
        this.b = zzbslVar;
        this.c = zzbtnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final synchronized void a() {
        if (this.a.e != 1) {
            b();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void a(zzqv zzqvVar) {
        if (this.a.e == 1 && zzqvVar.j) {
            b();
        }
        if (zzqvVar.j && this.e.compareAndSet(false, true)) {
            this.c.a();
        }
    }

    private final void b() {
        if (this.d.compareAndSet(false, true)) {
            this.b.a();
        }
    }
}
