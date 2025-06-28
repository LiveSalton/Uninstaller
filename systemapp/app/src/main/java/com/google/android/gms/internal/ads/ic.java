package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* compiled from: source */
/* loaded from: classes.dex */
final class ic implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsResult a;

    ic(JsResult jsResult) {
        this.a = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.confirm();
    }
}
