package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcod implements zzcoi {
    private final Map<String, zzeps<zzcoi>> a;
    private final zzdzc b;
    private final zzbuh c;

    public zzcod(Map<String, zzeps<zzcoi>> map, zzdzc zzdzcVar, zzbuh zzbuhVar) {
        this.a = map;
        this.b = zzdzcVar;
        this.c = zzbuhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcoi
    public final zzdyz<zzdnj> a(zzatl zzatlVar) {
        this.c.a(zzatlVar);
        zzdyz<zzdnj> a = zzdyr.a((Throwable) new zzcme(zzdok.NO_FILL));
        for (String str : ((String) zzwq.e().a(zzabf.et)).split(",")) {
            zzeps<zzcoi> zzepsVar = this.a.get(str.trim());
            if (zzepsVar != null) {
                a = zzdyr.a(a, zzcme.class, new zzdyb(zzepsVar, zzatlVar) { // from class: com.google.android.gms.internal.ads.we
                    private final zzeps a;
                    private final zzatl b;

                    {
                        this.a = zzepsVar;
                        this.b = zzatlVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdyb
                    public final zzdyz a(Object obj) {
                        zzeps zzepsVar2 = this.a;
                        return ((zzcoi) zzepsVar2.b()).a(this.b);
                    }
                }, this.b);
            }
        }
        zzdyr.a(a, new wd(this), zzazj.f);
        return a;
    }
}
