package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdpr {
    private HashMap<zzdpj, zzdpu<? extends zzboc>> a = new HashMap<>();

    public final <AdT extends zzboc> zzdpu<AdT> a(zzdpj zzdpjVar, Context context, zzdpa zzdpaVar, zzdqc<AdT> zzdqcVar) {
        zzdpu<AdT> zzdpuVar = (zzdpu) this.a.get(zzdpjVar);
        if (zzdpuVar != null) {
            return zzdpuVar;
        }
        aiy aiyVar = new aiy(zzdpk.a(zzdpjVar, context));
        zzdpu<AdT> zzdpuVar2 = new zzdpu<>(aiyVar, new zzdpv(aiyVar, zzdpaVar, zzdqcVar));
        this.a.put(zzdpjVar, zzdpuVar2);
        return zzdpuVar2;
    }
}
