package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class amx implements Runnable {
    private final /* synthetic */ zzdwl a;
    private final /* synthetic */ amw b;

    amx(amw amwVar, zzdwl zzdwlVar) {
        this.b = amwVar;
        this.a = zzdwlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.a);
    }
}
