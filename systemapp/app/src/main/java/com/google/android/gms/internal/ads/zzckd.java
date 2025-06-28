package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzckd implements zzepf<zzcke> {
    private final zzeps<Context> a;
    private final zzeps<zzdoa> b;
    private final zzeps<zzckq> c;
    private final zzeps<zzdnj> d;
    private final zzeps<zzdmu> e;
    private final zzeps<zzcqo> f;

    private zzckd(zzeps<Context> zzepsVar, zzeps<zzdoa> zzepsVar2, zzeps<zzckq> zzepsVar3, zzeps<zzdnj> zzepsVar4, zzeps<zzdmu> zzepsVar5, zzeps<zzcqo> zzepsVar6) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
        this.f = zzepsVar6;
    }

    public static zzckd a(zzeps<Context> zzepsVar, zzeps<zzdoa> zzepsVar2, zzeps<zzckq> zzepsVar3, zzeps<zzdnj> zzepsVar4, zzeps<zzdmu> zzepsVar5, zzeps<zzcqo> zzepsVar6) {
        return new zzckd(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4, zzepsVar5, zzepsVar6);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcke(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b(), this.f.b());
    }
}
