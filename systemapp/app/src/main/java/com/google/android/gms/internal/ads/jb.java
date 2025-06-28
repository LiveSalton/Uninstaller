package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: source */
/* loaded from: classes.dex */
final class jb implements Runnable {
    private final /* synthetic */ View a;
    private final /* synthetic */ zzawq b;
    private final /* synthetic */ int c;
    private final /* synthetic */ zzbfm d;

    jb(zzbfm zzbfmVar, View view, zzawq zzawqVar, int i) {
        this.d = zzbfmVar;
        this.a = view;
        this.b = zzawqVar;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.a(this.a, this.b, this.c - 1);
    }
}
