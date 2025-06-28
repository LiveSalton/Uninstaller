package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcfo {
    private final Executor a;
    private final zzbkr b;
    private final zzbxx c;

    zzcfo(Executor executor, zzbkr zzbkrVar, zzbxx zzbxxVar) {
        this.a = executor;
        this.c = zzbxxVar;
        this.b = zzbkrVar;
    }

    public final void a(zzbdv zzbdvVar) {
        if (zzbdvVar == null) {
            return;
        }
        this.c.a(zzbdvVar.getView());
        this.c.a(new zzqu(zzbdvVar) { // from class: com.google.android.gms.internal.ads.sm
            private final zzbdv a;

            {
                this.a = zzbdvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzqu
            public final void a(zzqv zzqvVar) {
                this.a.z().a(zzqvVar.d.left, zzqvVar.d.top, false);
            }
        }, this.a);
        this.c.a(new zzqu(zzbdvVar) { // from class: com.google.android.gms.internal.ads.so
            private final zzbdv a;

            {
                this.a = zzbdvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzqu
            public final void a(zzqv zzqvVar) {
                zzbdv zzbdvVar2 = this.a;
                HashMap hashMap = new HashMap();
                hashMap.put("isVisible", zzqvVar.j ? "1" : "0");
                zzbdvVar2.a("onAdVisibilityChanged", hashMap);
            }
        }, this.a);
        this.c.a(this.b, this.a);
        this.b.a(zzbdvVar);
        zzbdvVar.a("/trackActiveViewUnit", new zzahv(this) { // from class: com.google.android.gms.internal.ads.sn
            private final zzcfo a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzahv
            public final void a(Object obj, Map map) {
                this.a.b((zzbdv) obj, map);
            }
        });
        zzbdvVar.a("/untrackActiveViewUnit", new zzahv(this) { // from class: com.google.android.gms.internal.ads.sp
            private final zzcfo a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzahv
            public final void a(Object obj, Map map) {
                this.a.a((zzbdv) obj, map);
            }
        });
    }

    final /* synthetic */ void a(zzbdv zzbdvVar, Map map) {
        this.b.a();
    }

    final /* synthetic */ void b(zzbdv zzbdvVar, Map map) {
        this.b.b();
    }
}
