package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcwi implements zzg {
    private final zzbrt a;
    private final zzbsl b;
    private final zzbyc c;
    private final zzbxx d;
    private final zzbki e;
    private AtomicBoolean f = new AtomicBoolean(false);

    zzcwi(zzbrt zzbrtVar, zzbsl zzbslVar, zzbyc zzbycVar, zzbxx zzbxxVar, zzbki zzbkiVar) {
        this.a = zzbrtVar;
        this.b = zzbslVar;
        this.c = zzbycVar;
        this.d = zzbxxVar;
        this.e = zzbkiVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void a(View view) {
        if (this.f.compareAndSet(false, true)) {
            this.e.b();
            this.d.a(view);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void a() {
        if (this.f.get()) {
            this.a.e();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void b() {
        if (this.f.get()) {
            this.b.a();
            this.c.a();
        }
    }
}
