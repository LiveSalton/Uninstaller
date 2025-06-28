package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbjo implements zzdyb<zzdnj, zzdnj> {
    private Map<String, zzbjn> a;

    public zzbjo(Map<String, zzbjn> map) {
        this.a = map;
    }

    @Override // com.google.android.gms.internal.ads.zzdyb
    public final /* synthetic */ zzdyz<zzdnj> a(zzdnj zzdnjVar) throws Exception {
        zzdnj zzdnjVar2 = zzdnjVar;
        for (zzdng zzdngVar : zzdnjVar2.b.c) {
            if (this.a.containsKey(zzdngVar.a)) {
                this.a.get(zzdngVar.a).a(zzdngVar.b);
            }
        }
        return zzdyr.a(zzdnjVar2);
    }
}
