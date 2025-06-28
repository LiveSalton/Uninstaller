package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: source */
/* loaded from: classes.dex */
final class bcf implements Runnable {
    private final /* synthetic */ View a;
    private final /* synthetic */ zzrk b;

    bcf(zzrk zzrkVar, View view) {
        this.b = zzrkVar;
        this.a = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.a);
    }
}
