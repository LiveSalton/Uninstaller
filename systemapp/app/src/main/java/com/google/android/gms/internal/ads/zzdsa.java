package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdsa implements zzepf<zzdrx> {
    private final zzeps<zzcum> a;
    private final zzeps<zzazh> b;
    private final zzeps<String> c;
    private final zzeps<String> d;
    private final zzeps<Context> e;
    private final zzeps<zzdni> f;
    private final zzeps<Clock> g;
    private final zzeps<zzef> h;

    private zzdsa(zzeps<zzcum> zzepsVar, zzeps<zzazh> zzepsVar2, zzeps<String> zzepsVar3, zzeps<String> zzepsVar4, zzeps<Context> zzepsVar5, zzeps<zzdni> zzepsVar6, zzeps<Clock> zzepsVar7, zzeps<zzef> zzepsVar8) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
        this.f = zzepsVar6;
        this.g = zzepsVar7;
        this.h = zzepsVar8;
    }

    public static zzdsa a(zzeps<zzcum> zzepsVar, zzeps<zzazh> zzepsVar2, zzeps<String> zzepsVar3, zzeps<String> zzepsVar4, zzeps<Context> zzepsVar5, zzeps<zzdni> zzepsVar6, zzeps<Clock> zzepsVar7, zzeps<zzef> zzepsVar8) {
        return new zzdsa(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4, zzepsVar5, zzepsVar6, zzepsVar7, zzepsVar8);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdrx(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b(), this.f.b(), this.g.b(), this.h.b());
    }
}
