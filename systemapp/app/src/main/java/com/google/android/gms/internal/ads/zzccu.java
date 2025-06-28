package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzccu implements zzepf<zzawu> {
    private final zzccq a;
    private final zzeps<Context> b;
    private final zzeps<zzdnn> c;

    private zzccu(zzccq zzccqVar, zzeps<Context> zzepsVar, zzeps<zzdnn> zzepsVar2) {
        this.a = zzccqVar;
        this.b = zzepsVar;
        this.c = zzepsVar2;
    }

    public static zzccu a(zzccq zzccqVar, zzeps<Context> zzepsVar, zzeps<zzdnn> zzepsVar2) {
        return new zzccu(zzccqVar, zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzawu) zzepl.a(new zzawu(this.b.b(), this.c.b().f), "Cannot return null from a non-@Nullable @Provides method");
    }
}
