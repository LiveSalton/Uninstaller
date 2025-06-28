package com.google.android.gms.internal.ads;

import android.view.Surface;

/* compiled from: source */
/* loaded from: classes.dex */
final class bbr implements Runnable {
    private final /* synthetic */ Surface a;
    private final /* synthetic */ zzqj b;

    bbr(zzqj zzqjVar, Surface surface) {
        this.b = zzqjVar;
        this.a = surface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqg zzqgVar;
        zzqgVar = this.b.b;
        zzqgVar.a(this.a);
    }
}
