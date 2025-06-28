package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: source */
/* loaded from: classes.dex */
final class id implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsResult a;

    id(JsResult jsResult) {
        this.a = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.cancel();
    }
}
