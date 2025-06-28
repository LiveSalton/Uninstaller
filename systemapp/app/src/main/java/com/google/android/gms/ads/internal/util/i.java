package com.google.android.gms.ads.internal.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/* compiled from: source */
/* loaded from: classes.dex */
final class i implements Runnable {
    final /* synthetic */ Context a;
    private final /* synthetic */ String b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ boolean d;

    i(zzal zzalVar, Context context, String str, boolean z, boolean z2) {
        this.a = context;
        this.b = str;
        this.c = z;
        this.d = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
        builder.setMessage(this.b);
        if (this.c) {
            builder.setTitle("Error");
        } else {
            builder.setTitle("Info");
        }
        if (this.d) {
            builder.setNeutralButton("Dismiss", (DialogInterface.OnClickListener) null);
        } else {
            builder.setPositiveButton("Learn More", new h(this));
            builder.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
        }
        builder.create().show();
    }
}
