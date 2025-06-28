package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbsj implements zzepf<zzbsb> {
    private final zzeps<zzbsf> a;
    private final zzeps<Set<zzbxy<zzbry>>> b;
    private final zzeps<Executor> c;

    private zzbsj(zzeps<zzbsf> zzepsVar, zzeps<Set<zzbxy<zzbry>>> zzepsVar2, zzeps<Executor> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    public static zzbsj a(zzeps<zzbsf> zzepsVar, zzeps<Set<zzbxy<zzbry>>> zzepsVar2, zzeps<Executor> zzepsVar3) {
        return new zzbsj(zzepsVar, zzepsVar2, zzepsVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbsb(this.a.b(), this.b.b(), this.c.b());
    }
}
