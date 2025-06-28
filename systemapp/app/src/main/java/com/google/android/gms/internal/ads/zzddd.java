package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzddd implements zzepf<zzddb> {
    private final zzeps<zzdzc> a;
    private final zzeps<ViewGroup> b;
    private final zzeps<Context> c;
    private final zzeps<Set<String>> d;

    private zzddd(zzeps<zzdzc> zzepsVar, zzeps<ViewGroup> zzepsVar2, zzeps<Context> zzepsVar3, zzeps<Set<String>> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    public static zzddd a(zzeps<zzdzc> zzepsVar, zzeps<ViewGroup> zzepsVar2, zzeps<Context> zzepsVar3, zzeps<Set<String>> zzepsVar4) {
        return new zzddd(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzddb(this.a.b(), this.b.b(), this.c.b(), this.d.b());
    }
}
