package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* compiled from: source */
/* loaded from: classes.dex */
final class dm implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzaqj a;

    dm(zzaqj zzaqjVar) {
        this.a = zzaqjVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.a("Operation denied by user.");
    }
}
