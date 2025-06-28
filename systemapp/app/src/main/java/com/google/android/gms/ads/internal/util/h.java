package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzp;

/* compiled from: source */
/* loaded from: classes.dex */
final class h implements DialogInterface.OnClickListener {
    private final /* synthetic */ i a;

    h(i iVar) {
        this.a = iVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        zzp.c();
        zzm.b(this.a.a, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
