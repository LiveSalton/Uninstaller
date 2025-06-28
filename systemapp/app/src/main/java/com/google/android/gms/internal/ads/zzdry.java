package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdry implements zzepf<zzaml> {
    private final zzdrv a;
    private final zzeps<Context> b;
    private final zzeps<zzazh> c;

    public zzdry(zzdrv zzdrvVar, zzeps<Context> zzepsVar, zzeps<zzazh> zzepsVar2) {
        this.a = zzdrvVar;
        this.b = zzepsVar;
        this.c = zzepsVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzaml) zzepl.a(new zzamc().b(this.b.b(), this.c.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
