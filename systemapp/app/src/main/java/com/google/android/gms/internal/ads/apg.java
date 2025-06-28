package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/* compiled from: source */
/* loaded from: classes.dex */
final class apg implements Runnable {
    private final /* synthetic */ Context a;
    private final /* synthetic */ View b;
    private final /* synthetic */ Activity c;

    apg(zzdx zzdxVar, Context context, View view, Activity activity) {
        this.a = context;
        this.b = view;
        this.c = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdsi zzdsiVar;
        zzdp zzdpVar;
        try {
            zzdpVar = zzdx.s;
            zzdpVar.a(this.a, this.b, this.c);
        } catch (Exception e) {
            zzdsiVar = zzdx.u;
            zzdsiVar.a(2020, -1L, e);
        }
    }
}
