package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzchp {
    private final zzbed a;
    private final Context b;
    private final zzef c;
    private final zzacg d;
    private final zzazh e;
    private final com.google.android.gms.ads.internal.zzb f;
    private final zzts g;
    private final zzbua h;
    private final zzsu i;

    public zzchp(zzbed zzbedVar, Context context, zzef zzefVar, zzacg zzacgVar, zzazh zzazhVar, com.google.android.gms.ads.internal.zzb zzbVar, zzts zztsVar, zzbua zzbuaVar, zzbyw zzbywVar) {
        this.a = zzbedVar;
        this.b = context;
        this.c = zzefVar;
        this.d = zzacgVar;
        this.e = zzazhVar;
        this.f = zzbVar;
        this.g = zztsVar;
        this.h = zzbuaVar;
        this.i = zzbywVar;
    }

    public final zzbdv a(zzvn zzvnVar) throws zzbeh {
        return a(zzvnVar, null, null, false);
    }

    public final zzbdv a(zzvn zzvnVar, zzdmu zzdmuVar, zzdmz zzdmzVar, boolean z) throws zzbeh {
        return zzbed.a(this.b, zzbfn.a(zzvnVar), zzvnVar.a, false, false, this.c, this.d, this.e, null, new tj(this), this.f, this.g, this.i, z, zzdmuVar, zzdmzVar);
    }
}
