package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbco implements zzbdf {
    @Override // com.google.android.gms.internal.ads.zzbdf
    public final zzbcx a(zzbbe zzbbeVar, int i, String str, zzbbf zzbbfVar) {
        if (i > 0) {
            int c = zzbca.c();
            if (c < zzbbfVar.g) {
                return new zzbdi(zzbbeVar, zzbbfVar);
            }
            if (c < zzbbfVar.b) {
                return new zzbdj(zzbbeVar, zzbbfVar);
            }
            return new zzbdh(zzbbeVar);
        }
        return new zzbde(zzbbeVar);
    }
}
