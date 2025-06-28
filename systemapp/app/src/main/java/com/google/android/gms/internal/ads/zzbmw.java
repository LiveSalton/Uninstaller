package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbmw implements zzepf<zzawu> {
    private final zzbmh a;
    private final zzeps<Context> b;
    private final zzeps<zzdnn> c;

    public zzbmw(zzbmh zzbmhVar, zzeps<Context> zzepsVar, zzeps<zzdnn> zzepsVar2) {
        this.a = zzbmhVar;
        this.b = zzepsVar;
        this.c = zzepsVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzawu) zzepl.a(new zzawu(this.b.b(), this.c.b().f), "Cannot return null from a non-@Nullable @Provides method");
    }
}
