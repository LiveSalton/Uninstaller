package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;

/* compiled from: source */
/* loaded from: classes.dex */
final class hs implements Runnable {
    private final /* synthetic */ zzbcs a;

    hs(zzbcs zzbcsVar) {
        this.a = zzbcsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzp.y().b(this.a);
    }
}
