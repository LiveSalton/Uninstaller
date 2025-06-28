package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzboc;
import com.google.android.gms.internal.ads.zzbre;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdju<R extends zzbre<AdT>, AdT extends zzboc> implements zzdkl<R, zzdjy<AdT>> {
    private final zzdpd a;
    private final Executor b;
    private zzdyo<Void> c = new agq(this);

    public zzdju(zzdpd zzdpdVar, Executor executor) {
        this.a = zzdpdVar;
        this.b = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzdkl
    public final /* bridge */ /* synthetic */ Object a() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdkl
    public final zzdyz<zzdjy<AdT>> a(zzdkm zzdkmVar, zzdkn<R> zzdknVar) {
        return zzdyi.c((zzdyz) new agt(this.a, zzdkmVar.b, zzdknVar, this.b).a()).a(new zzdyb(this, zzdkmVar, zzdknVar) { // from class: com.google.android.gms.internal.ads.agp
            private final zzdju a;
            private final zzdkm b;
            private final zzdkn c;

            {
                this.a = this;
                this.b = zzdkmVar;
                this.c = zzdknVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return this.a.a(this.b, this.c, (zzdkj) obj);
            }
        }, this.b).a(Exception.class, new ago(this), this.b);
    }

    final /* synthetic */ zzdyz a(zzdkm zzdkmVar, zzdkn zzdknVar, zzdkj zzdkjVar) throws Exception {
        zzdpq zzdpqVar = zzdkjVar.b;
        zzatl zzatlVar = zzdkjVar.a;
        zzdpn<?> a = zzdpqVar != null ? this.a.a(zzdpqVar) : null;
        if (zzdpqVar == null) {
            return zzdyr.a((Object) null);
        }
        if (a != null && zzatlVar != null) {
            zzdyr.a(((zzbre) zzdknVar.a(zzdkmVar.b).b()).c().c(zzatlVar), this.c, this.b);
        }
        return zzdyr.a(new zzdjy(zzdpqVar, zzatlVar, a));
    }
}
