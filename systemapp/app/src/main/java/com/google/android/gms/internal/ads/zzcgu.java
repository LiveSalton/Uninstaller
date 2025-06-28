package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcgu implements Callable<zzcgh> {
    private final com.google.android.gms.ads.internal.zzb a;
    private final zzbed b;
    private final Context c;
    private final zzckq d;
    private final zzcqo e;
    private final Executor f;
    private final zzef g;
    private final zzazh h;
    private final zzdrz i;

    public zzcgu(Context context, Executor executor, zzef zzefVar, zzazh zzazhVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbed zzbedVar, zzcqo zzcqoVar, zzdrz zzdrzVar, zzckq zzckqVar) {
        this.c = context;
        this.f = executor;
        this.g = zzefVar;
        this.h = zzazhVar;
        this.a = zzbVar;
        this.b = zzbedVar;
        this.e = zzcqoVar;
        this.i = zzdrzVar;
        this.d = zzckqVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzcgh call() throws Exception {
        zzcgh zzcghVar = new zzcgh(this);
        zzcghVar.a();
        return zzcghVar;
    }
}
