package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzf;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbqn implements zzepf<zzbqo> {
    private final zzeps<Context> a;
    private final zzeps<zzdnn> b;
    private final zzeps<zzazh> c;
    private final zzeps<zzf> d;
    private final zzeps<zzclp> e;

    private zzbqn(zzeps<Context> zzepsVar, zzeps<zzdnn> zzepsVar2, zzeps<zzazh> zzepsVar3, zzeps<zzf> zzepsVar4, zzeps<zzclp> zzepsVar5) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
    }

    public static zzbqn a(zzeps<Context> zzepsVar, zzeps<zzdnn> zzepsVar2, zzeps<zzazh> zzepsVar3, zzeps<zzf> zzepsVar4, zzeps<zzclp> zzepsVar5) {
        return new zzbqn(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4, zzepsVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbqo(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b());
    }
}
