package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdab implements zzepf<zzczz> {
    private final zzeps<zzdzc> a;
    private final zzeps<Context> b;
    private final zzeps<zzdnn> c;
    private final zzeps<ViewGroup> d;

    public zzdab(zzeps<zzdzc> zzepsVar, zzeps<Context> zzepsVar2, zzeps<zzdnn> zzepsVar3, zzeps<ViewGroup> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzczz(this.a.b(), this.b.b(), this.c.b(), this.d.b());
    }
}
