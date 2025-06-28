package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

/* compiled from: source */
/* loaded from: classes.dex */
final class axk implements Runnable {
    private final /* synthetic */ int a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ zzfa c;

    axk(zzfa zzfaVar, int i, boolean z) {
        this.c = zzfaVar;
        this.a = i;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean b;
        zzcf.zza b2 = this.c.b(this.a, this.b);
        this.c.k = b2;
        b = zzfa.b(this.a, b2);
        if (b) {
            this.c.a(this.a + 1, this.b);
        }
    }
}
