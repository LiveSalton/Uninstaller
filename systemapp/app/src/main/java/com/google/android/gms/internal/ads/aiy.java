package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzue;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
final class aiy implements zzdpd {

    @GuardedBy("this")
    private final ConcurrentHashMap<zzdpq, aiw> a;
    private zzdpk b;
    private aiz c = new aiz();

    public aiy(zzdpk zzdpkVar) {
        this.a = new ConcurrentHashMap<>(zzdpkVar.d);
        this.b = zzdpkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdpd
    public final synchronized zzdpn<?> a(zzdpq zzdpqVar) {
        zzdpn<?> zzdpnVar;
        aiw aiwVar = this.a.get(zzdpqVar);
        zzdpnVar = null;
        if (aiwVar != null) {
            zzdpnVar = aiwVar.a();
            if (zzdpnVar == null) {
                this.c.b();
            }
            a(zzdpnVar, aiwVar.g());
        } else {
            this.c.a();
            a((zzdpn<?>) null, (zzdqg) null);
        }
        return zzdpnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdpd
    public final synchronized boolean a(zzdpq zzdpqVar, zzdpn<?> zzdpnVar) {
        boolean a;
        aiw aiwVar = this.a.get(zzdpqVar);
        zzdpnVar.d = zzp.j().a();
        if (aiwVar == null) {
            aiwVar = new aiw(this.b.d, this.b.e * 1000);
            if (this.a.size() == this.b.c) {
                long j = Long.MAX_VALUE;
                zzdpq zzdpqVar2 = null;
                switch (aix.a[this.b.g - 1]) {
                    case 1:
                        for (Map.Entry<zzdpq, aiw> entry : this.a.entrySet()) {
                            if (entry.getValue().c() < j) {
                                j = entry.getValue().c();
                                zzdpqVar2 = entry.getKey();
                            }
                        }
                        if (zzdpqVar2 != null) {
                            this.a.remove(zzdpqVar2);
                            break;
                        }
                        break;
                    case 2:
                        for (Map.Entry<zzdpq, aiw> entry2 : this.a.entrySet()) {
                            if (entry2.getValue().d() < j) {
                                j = entry2.getValue().d();
                                zzdpqVar2 = entry2.getKey();
                            }
                        }
                        if (zzdpqVar2 != null) {
                            this.a.remove(zzdpqVar2);
                            break;
                        }
                        break;
                    case 3:
                        int i = Integer.MAX_VALUE;
                        for (Map.Entry<zzdpq, aiw> entry3 : this.a.entrySet()) {
                            if (entry3.getValue().e() < i) {
                                i = entry3.getValue().e();
                                zzdpqVar2 = entry3.getKey();
                            }
                        }
                        if (zzdpqVar2 != null) {
                            this.a.remove(zzdpqVar2);
                            break;
                        }
                        break;
                }
                this.c.d();
            }
            this.a.put(zzdpqVar, aiwVar);
            this.c.c();
        }
        a = aiwVar.a(zzdpnVar);
        this.c.e();
        zzdph f = this.c.f();
        zzdqg g = aiwVar.g();
        if (zzdpnVar != null) {
            zzdpnVar.a.c().b((zzue.zzb) ((zzekh) zzue.zzb.a().a(zzue.zzb.zza.a().a(zzue.zzb.EnumC0077zzb.IN_MEMORY).a(zzue.zzb.zze.a().a(f.a).b(f.b).a(g.b))).g()));
        }
        b();
        return a;
    }

    @Override // com.google.android.gms.internal.ads.zzdpd
    public final synchronized boolean b(zzdpq zzdpqVar) {
        aiw aiwVar = this.a.get(zzdpqVar);
        if (aiwVar != null) {
            return aiwVar.b() < this.b.d;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdpd
    @Deprecated
    public final zzdpq a(zzvk zzvkVar, String str, zzvw zzvwVar) {
        return new zzdpp(zzvkVar, str, new zzatt(this.b.a).a().j, this.b.f, zzvwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdpd
    public final zzdpk a() {
        return this.b;
    }

    private final void a(zzdpn<?> zzdpnVar, zzdqg zzdqgVar) {
        if (zzdpnVar != null) {
            zzdpnVar.a.c().a((zzue.zzb) ((zzekh) zzue.zzb.a().a(zzue.zzb.zza.a().a(zzue.zzb.EnumC0077zzb.IN_MEMORY).a(zzue.zzb.zzd.a().a(zzdqgVar.a).a(zzdqgVar.b))).g()));
        }
        b();
    }

    private final void b() {
        if (zzdpk.a()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.b.b);
            sb.append(" PoolCollection");
            sb.append(this.c.g());
            int i = 0;
            for (Map.Entry<zzdpq, aiw> entry : this.a.entrySet()) {
                i++;
                sb.append(i);
                sb.append(". ");
                sb.append(entry.getValue());
                sb.append("#");
                sb.append(entry.getKey().hashCode());
                sb.append("    ");
                for (int i2 = 0; i2 < entry.getValue().b(); i2++) {
                    sb.append("[O]");
                }
                for (int b = entry.getValue().b(); b < this.b.d; b++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(entry.getValue().f());
                sb.append("\n");
            }
            while (i < this.b.c) {
                i++;
                sb.append(i);
                sb.append(".\n");
            }
            zzd.b(sb.toString());
        }
    }
}
