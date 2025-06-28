package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

/* compiled from: source */
/* loaded from: classes.dex */
final class bch implements ValueCallback<String> {
    private final /* synthetic */ bce a;

    bch(bce bceVar) {
        this.a = bceVar;
    }

    @Override // android.webkit.ValueCallback
    public final /* synthetic */ void onReceiveValue(String str) {
        this.a.d.a(this.a.a, this.a.b, str, this.a.c);
    }
}
