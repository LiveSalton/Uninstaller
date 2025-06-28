package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: source */
/* loaded from: classes.dex */
final class bap implements Runnable {
    private final /* synthetic */ IOException a;
    private final /* synthetic */ bam b;

    bap(bam bamVar, IOException iOException) {
        this.b = bamVar;
        this.a = iOException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzmz zzmzVar;
        zzmzVar = this.b.e;
        zzmzVar.a(this.a);
    }
}
