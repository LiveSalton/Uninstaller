package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.ads.internal.zzp;

/* compiled from: source */
/* loaded from: classes.dex */
final class dl implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzaqj a;

    dl(zzaqj zzaqjVar) {
        this.a = zzaqjVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Context context;
        Intent b = this.a.b();
        zzp.c();
        context = this.a.b;
        com.google.android.gms.ads.internal.util.zzm.a(context, b);
    }
}
