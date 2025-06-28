package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
final class anq implements Runnable {
    private final /* synthetic */ Context a;

    anq(zzdx zzdxVar, Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdsi zzdsiVar;
        zzdp zzdpVar;
        try {
            zzdpVar = zzdx.s;
            zzdpVar.a(this.a);
        } catch (Exception e) {
            zzdsiVar = zzdx.u;
            zzdsiVar.a(2019, -1L, e);
        }
    }
}
