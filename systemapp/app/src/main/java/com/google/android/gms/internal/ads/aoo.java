package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/* compiled from: source */
/* loaded from: classes.dex */
final class aoo implements Runnable {
    private final /* synthetic */ Context a;
    private final /* synthetic */ String b;
    private final /* synthetic */ View c;
    private final /* synthetic */ Activity d;

    aoo(zzdx zzdxVar, Context context, String str, View view, Activity activity) {
        this.a = context;
        this.b = str;
        this.c = view;
        this.d = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdsi zzdsiVar;
        zzdp zzdpVar;
        try {
            zzdpVar = zzdx.s;
            zzdpVar.a(this.a, this.b, this.c, this.d);
        } catch (Exception e) {
            zzdsiVar = zzdx.u;
            zzdsiVar.a(2021, -1L, e);
        }
    }
}
