package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaq;

/* compiled from: source */
/* loaded from: classes.dex */
final class w implements Runnable {
    private final /* synthetic */ String a;
    private final /* synthetic */ long b;
    private final /* synthetic */ zzaa c;

    w(zzaa zzaaVar, String str, long j) {
        this.c = zzaaVar;
        this.a = str;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaq.a aVar;
        zzaq.a aVar2;
        aVar = this.c.a;
        aVar.a(this.a, this.b);
        aVar2 = this.c.a;
        aVar2.a(this.c.toString());
    }
}
