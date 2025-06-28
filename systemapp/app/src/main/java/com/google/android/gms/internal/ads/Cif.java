package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

/* compiled from: source */
/* renamed from: com.google.android.gms.internal.ads.if */
/* loaded from: classes.dex */
final class Cif implements DialogInterface.OnCancelListener {
    private final /* synthetic */ JsPromptResult a;

    Cif(JsPromptResult jsPromptResult) {
        this.a = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.a.cancel();
    }
}
