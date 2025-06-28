package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

/* compiled from: source */
/* loaded from: classes.dex */
final class ie implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsPromptResult a;

    ie(JsPromptResult jsPromptResult) {
        this.a = jsPromptResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.cancel();
    }
}
