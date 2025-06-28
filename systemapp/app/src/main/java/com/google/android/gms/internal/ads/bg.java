package com.google.android.gms.internal.ads;

import android.webkit.JavascriptInterface;

/* compiled from: source */
/* loaded from: classes.dex */
final class bg {
    private final zzakk a;

    /* JADX INFO: Access modifiers changed from: private */
    bg(zzakk zzakkVar) {
        this.a = zzakkVar;
    }

    @JavascriptInterface
    public final void notify(String str) {
        this.a.h(str);
    }

    /* synthetic */ bg(zzakk zzakkVar, bd bdVar) {
        this(zzakkVar);
    }
}
