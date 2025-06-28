package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzboc;
import com.google.android.gms.internal.ads.zzbre;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdjk<R extends zzbre<AdT>, AdT extends zzboc> implements zzdkl<R, zzdpn<AdT>> {
    private R a;
    private final Executor b = zzdzb.a();

    @Override // com.google.android.gms.internal.ads.zzdkl
    public final zzdyz<zzdpn<AdT>> a(zzdkm zzdkmVar, zzdkn<R> zzdknVar) {
        zzdyz<zzdnj> a;
        zzbrd<R> a2 = zzdknVar.a(zzdkmVar.b);
        a2.a(new zzdkt(true));
        this.a = a2.b();
        zzboz c = this.a.c();
        zzdpn zzdpnVar = new zzdpn();
        if (zzdkmVar.a != null) {
            a = c.a(zzdkmVar.a);
        } else {
            a = c.a();
        }
        return zzdyi.c((zzdyz) a).a(new zzdyb(this, zzdpnVar, c) { // from class: com.google.android.gms.internal.ads.agi
            private final zzdjk a;
            private final zzdpn b;
            private final zzboz c;

            {
                this.a = this;
                this.b = zzdpnVar;
                this.c = c;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                zzdpn zzdpnVar2 = this.b;
                zzboz zzbozVar = this.c;
                zzdnj zzdnjVar = (zzdnj) obj;
                zzdpnVar2.b = zzdnjVar;
                Iterator<zzdmu> it = zzdnjVar.b.a.iterator();
                boolean z = false;
                boolean z2 = false;
                loop0: while (true) {
                    if (!it.hasNext()) {
                        z = z2;
                        break;
                    }
                    Iterator<String> it2 = it.next().a.iterator();
                    while (it2.hasNext()) {
                        if (!it2.next().contains("FirstPartyRenderer")) {
                            break loop0;
                        }
                        z2 = true;
                    }
                }
                return !z ? zzdyr.a((Object) null) : zzbozVar.a(zzdyr.a(zzdnjVar));
            }
        }, this.b).a(new zzdvm(zzdpnVar) { // from class: com.google.android.gms.internal.ads.agh
            private final zzdpn a;

            {
                this.a = zzdpnVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdvm
            public final Object a(Object obj) {
                zzdpn zzdpnVar2 = this.a;
                zzdpnVar2.c = (AdT) obj;
                return zzdpnVar2;
            }
        }, this.b);
    }

    @Override // com.google.android.gms.internal.ads.zzdkl
    public final /* synthetic */ Object a() {
        return this.a;
    }
}
