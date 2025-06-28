package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
final class ban implements Runnable {
    private final /* synthetic */ bam a;

    ban(bam bamVar) {
        this.a = bamVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        zznb zznbVar;
        z = this.a.H;
        if (z) {
            return;
        }
        zznbVar = this.a.q;
        zznbVar.a((zznb) this.a);
    }
}
