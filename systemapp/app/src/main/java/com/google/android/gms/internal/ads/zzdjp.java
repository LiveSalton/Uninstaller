package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzboc;
import com.google.android.gms.internal.ads.zzbre;
import com.google.android.gms.internal.ads.zzue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdjp<R extends zzbre<AdT>, AdT extends zzboc> implements zzdkl<R, AdT> {
    private final zzdkl<R, AdT> a;
    private final zzdkl<R, zzdjy<AdT>> b;
    private final zzdpv<AdT> c;

    @GuardedBy("this")
    private R d;
    private final Executor e;

    public zzdjp(zzdkl<R, AdT> zzdklVar, zzdkl<R, zzdjy<AdT>> zzdklVar2, zzdpv<AdT> zzdpvVar, Executor executor) {
        this.a = zzdklVar;
        this.b = zzdklVar2;
        this.c = zzdpvVar;
        this.e = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzdkl
    /* renamed from: b */
    public final synchronized R a() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.zzdkl
    public final synchronized zzdyz<AdT> a(zzdkm zzdkmVar, zzdkn<R> zzdknVar) {
        zzdnn a;
        a = zzdknVar.a(zzdkmVar.b).b().a();
        return zzdyi.c((zzdyz) this.b.a(zzdkmVar, zzdknVar)).a(new zzdyb(this, zzdkmVar, new agm(zzdknVar, zzdkmVar, a.d, a.f, this.e, a.j, null), zzdknVar) { // from class: com.google.android.gms.internal.ads.agj
            private final zzdjp a;
            private final zzdkm b;
            private final agm c;
            private final zzdkn d;

            {
                this.a = this;
                this.b = zzdkmVar;
                this.c = agmVar;
                this.d = zzdknVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return this.a.a(this.b, this.c, this.d, (zzdjy) obj);
            }
        }, this.e);
    }

    private final zzdyz<AdT> a(zzdpn<AdT> zzdpnVar, zzdkm zzdkmVar, zzdkn<R> zzdknVar) {
        zzbrd<R> a = zzdknVar.a(zzdkmVar.b);
        if (zzdpnVar.c != null) {
            R b = a.b();
            if (b.d() != null) {
                zzdpnVar.c.l().a(b.d());
            }
            return zzdyr.a(zzdpnVar.c);
        }
        a.a(zzdpnVar.b);
        zzdyz<AdT> a2 = this.a.a(zzdkmVar, new zzdkn(a) { // from class: com.google.android.gms.internal.ads.agl
            private final zzbrd a;

            {
                this.a = a;
            }

            @Override // com.google.android.gms.internal.ads.zzdkn
            public final zzbrd a(zzdkk zzdkkVar) {
                return this.a;
            }
        });
        this.d = this.a.a();
        return a2;
    }

    final /* synthetic */ zzdyz a(zzdkn zzdknVar, zzdpz zzdpzVar) throws Exception {
        if (zzdpzVar != null && zzdpzVar.a != null && zzdpzVar.b != null) {
            agm agmVar = (agm) zzdpzVar.b;
            zzdpzVar.a.a.c().c((zzue.zzb) ((zzekh) zzue.zzb.a().a(zzue.zzb.zza.a().a(zzue.zzb.EnumC0077zzb.IN_MEMORY).a(zzue.zzb.zzd.a())).g()));
            return a(zzdpzVar.a, agmVar.b, zzdknVar);
        }
        throw new zzcme(zzdok.INTERNAL_ERROR, "Empty prefetch");
    }

    final /* synthetic */ zzdyz a(zzdkm zzdkmVar, agm agmVar, zzdkn zzdknVar, zzdjy zzdjyVar) throws Exception {
        if (zzdjyVar != null) {
            agm agmVar2 = new agm(agmVar.a, agmVar.b, agmVar.c, agmVar.d, agmVar.e, agmVar.f, zzdjyVar.a);
            if (zzdjyVar.c != null) {
                this.d = null;
                this.c.a(agmVar2);
                return a(zzdjyVar.c, zzdkmVar, zzdknVar);
            }
            zzdyz<zzdpz<AdT>> b = this.c.b(agmVar2);
            if (b != null) {
                this.d = (R) zzdknVar.a(zzdkmVar.b).b();
                return zzdyr.a(b, new zzdyb(this, zzdknVar) { // from class: com.google.android.gms.internal.ads.agk
                    private final zzdjp a;
                    private final zzdkn b;

                    {
                        this.a = this;
                        this.b = zzdknVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdyb
                    public final zzdyz a(Object obj) {
                        return this.a.a(this.b, (zzdpz) obj);
                    }
                }, this.e);
            }
            this.c.a(agmVar2);
            zzdkmVar = new zzdkm(zzdkmVar.b, zzdjyVar.b);
        }
        zzdyz<AdT> a = this.a.a(zzdkmVar, zzdknVar);
        this.d = this.a.a();
        return a;
    }
}
