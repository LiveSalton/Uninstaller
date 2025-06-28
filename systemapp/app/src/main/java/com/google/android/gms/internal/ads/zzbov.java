package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbov implements zzp {
    private final zzbsu a;
    private AtomicBoolean b = new AtomicBoolean(false);

    public zzbov(zzbsu zzbsuVar) {
        this.a = zzbsuVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void b_() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void f_() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void g_() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void a(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        this.b.set(true);
        this.a.a();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void e_() {
        this.a.c();
    }

    public final boolean a() {
        return this.b.get();
    }
}
