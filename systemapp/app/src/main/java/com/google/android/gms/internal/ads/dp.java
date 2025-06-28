package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* compiled from: source */
/* loaded from: classes.dex */
final class dp implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzaqp a;

    dp(zzaqp zzaqpVar) {
        this.a = zzaqpVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.a("User canceled the download.");
    }
}
