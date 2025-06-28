package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class qm implements zzbod<zzboi> {
    private final Map<String, zzcqz<zzboi>> a;
    private final Map<String, zzcqz<zzcbt>> b;
    private final Map<String, zzcto<zzcbt>> c;
    private final zzeps<zzbod<zzbme>> d;
    private final zzccl e;

    qm(Map<String, zzcqz<zzboi>> map, Map<String, zzcqz<zzcbt>> map2, Map<String, zzcto<zzcbt>> map3, zzeps<zzbod<zzbme>> zzepsVar, zzccl zzcclVar) {
        this.a = map;
        this.b = map2;
        this.c = map3;
        this.d = zzepsVar;
        this.e = zzcclVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbod
    public final zzcqz<zzboi> a(int i, String str) {
        zzcqz<zzbme> a;
        zzcqz<zzboi> zzcqzVar = this.a.get(str);
        if (zzcqzVar != null) {
            return zzcqzVar;
        }
        if (i == 1) {
            if (this.e.d() == null || (a = this.d.b().a(i, str)) == null) {
                return null;
            }
            return zzboi.a(a);
        }
        if (i != 4) {
            return null;
        }
        zzcto<zzcbt> zzctoVar = this.c.get(str);
        if (zzctoVar != null) {
            return zzboi.a((zzcto<? extends zzboc>) zzctoVar);
        }
        zzcqz<zzcbt> zzcqzVar2 = this.b.get(str);
        if (zzcqzVar2 != null) {
            return zzboi.a(zzcqzVar2);
        }
        return null;
    }
}
