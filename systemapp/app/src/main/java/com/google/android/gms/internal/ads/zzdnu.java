package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdnu {
    public static <T extends zzbdk & zzakb & zzbeq & zzbex & zzbff & zzbfe & zzbfh> zzahv<T> a(zzcqo zzcqoVar, zzdrz zzdrzVar) {
        return new zzahv(zzdrzVar, zzcqoVar) { // from class: com.google.android.gms.internal.ads.aio
            private final zzdrz a;
            private final zzcqo b;

            {
                this.a = zzdrzVar;
                this.b = zzcqoVar;
            }

            /* JADX WARN: Type inference failed for: r9v1, types: [com.google.android.gms.internal.ads.zzbdk, com.google.android.gms.internal.ads.zzbex] */
            @Override // com.google.android.gms.internal.ads.zzahv
            public final void a(Object obj, Map map) {
                zzdrz zzdrzVar2 = this.a;
                zzcqo zzcqoVar2 = this.b;
                ?? r9 = (zzbdk) obj;
                String str = (String) map.get("u");
                if (str == null) {
                    zzd.e("URL missing from click GMSG.");
                    return;
                }
                String a = zzahc.a(r9, str);
                if (!r9.q().ae) {
                    zzdrzVar2.a(a);
                    return;
                }
                long a2 = zzp.j().a();
                String str2 = ((zzbeq) r9).S().b;
                zzp.c();
                zzcqoVar2.a(new zzcqv(a2, str2, a, com.google.android.gms.ads.internal.util.zzm.p(((zzbex) r9).getContext()) ? zzcql.b : zzcql.a));
            }
        };
    }

    public static <T extends zzbdk & zzbeq & zzbex & zzbfe> zzahv<T> b(zzcqo zzcqoVar, zzdrz zzdrzVar) {
        return new zzahv(zzdrzVar, zzcqoVar) { // from class: com.google.android.gms.internal.ads.aip
            private final zzdrz a;
            private final zzcqo b;

            {
                this.a = zzdrzVar;
                this.b = zzcqoVar;
            }

            @Override // com.google.android.gms.internal.ads.zzahv
            public final void a(Object obj, Map map) {
                zzdrz zzdrzVar2 = this.a;
                zzcqo zzcqoVar2 = this.b;
                zzbdk zzbdkVar = (zzbdk) obj;
                String str = (String) map.get("u");
                if (str == null) {
                    zzd.e("URL missing from httpTrack GMSG.");
                } else if (zzbdkVar.q().ae) {
                    zzcqoVar2.a(new zzcqv(zzp.j().a(), ((zzbeq) zzbdkVar).S().b, str, zzcql.b));
                } else {
                    zzdrzVar2.a(str);
                }
            }
        };
    }
}
