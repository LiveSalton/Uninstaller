package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbxz implements zzepf<zzbxx> {
    private final zzeps<Context> a;
    private final zzeps<Set<zzbxy<zzqu>>> b;
    private final zzeps<zzdmu> c;

    private zzbxz(zzeps<Context> zzepsVar, zzeps<Set<zzbxy<zzqu>>> zzepsVar2, zzeps<zzdmu> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    public static zzbxz a(zzeps<Context> zzepsVar, zzeps<Set<zzbxy<zzqu>>> zzepsVar2, zzeps<zzdmu> zzepsVar3) {
        return new zzbxz(zzepsVar, zzepsVar2, zzepsVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbxx(this.a.b(), this.b.b(), this.c.b());
    }
}
