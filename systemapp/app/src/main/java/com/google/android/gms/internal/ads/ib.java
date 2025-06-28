package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: source */
/* loaded from: classes.dex */
final class ib implements DialogInterface.OnCancelListener {
    private final /* synthetic */ JsResult a;

    ib(JsResult jsResult) {
        this.a = jsResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.a.cancel();
    }
}
