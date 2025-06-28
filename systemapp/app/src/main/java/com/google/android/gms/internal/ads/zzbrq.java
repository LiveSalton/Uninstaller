package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbrq implements zzepf<zzawq> {
    private final zzbrr a;
    private final zzeps<Context> b;
    private final zzeps<zzazh> c;
    private final zzeps<zzdmu> d;
    private final zzeps<zzaws> e;

    private zzbrq(zzbrr zzbrrVar, zzeps<Context> zzepsVar, zzeps<zzazh> zzepsVar2, zzeps<zzdmu> zzepsVar3, zzeps<zzaws> zzepsVar4) {
        this.a = zzbrrVar;
        this.b = zzepsVar;
        this.c = zzepsVar2;
        this.d = zzepsVar3;
        this.e = zzepsVar4;
    }

    public static zzbrq a(zzbrr zzbrrVar, zzeps<Context> zzepsVar, zzeps<zzazh> zzepsVar2, zzeps<zzdmu> zzepsVar3, zzeps<zzaws> zzepsVar4) {
        return new zzbrq(zzbrrVar, zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        Context b = this.b.b();
        zzazh b2 = this.c.b();
        zzdmu b3 = this.d.b();
        zzaws b4 = this.e.b();
        if (b3.z != null) {
            return new zzawh(b, b2, b3.z, b3.r.b, b4);
        }
        return null;
    }
}
