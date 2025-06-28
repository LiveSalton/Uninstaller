package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbtc;
import java.util.Iterator;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcvy<AdT, AdapterT, ListenerT extends zzbtc> implements zzcqz<AdT> {
    private final zzcre<AdapterT, ListenerT> a;
    private final zzcrh<AdT, AdapterT, ListenerT> b;
    private final zzdro c;
    private final zzdzc d;

    public zzcvy(zzdro zzdroVar, zzdzc zzdzcVar, zzcre<AdapterT, ListenerT> zzcreVar, zzcrh<AdT, AdapterT, ListenerT> zzcrhVar) {
        this.c = zzdroVar;
        this.d = zzdzcVar;
        this.b = zzcrhVar;
        this.a = zzcreVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcqz
    public final boolean a(zzdnj zzdnjVar, zzdmu zzdmuVar) {
        return !zzdmuVar.s.isEmpty();
    }

    @Override // com.google.android.gms.internal.ads.zzcqz
    public final zzdyz<AdT> b(zzdnj zzdnjVar, zzdmu zzdmuVar) {
        zzcrb<AdapterT, ListenerT> zzcrbVar;
        Iterator<String> it = zzdmuVar.s.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzcrbVar = null;
                break;
            }
            try {
                zzcrbVar = this.a.a(it.next(), zzdmuVar.u);
                break;
            } catch (zzdnr unused) {
            }
        }
        if (zzcrbVar == null) {
            return zzdyr.a((Throwable) new zzcuc("unable to instantiate mediation adapter class"));
        }
        zzazq zzazqVar = new zzazq();
        zzcrbVar.c.a(new aac(this, zzcrbVar, zzazqVar));
        if (zzdmuVar.H) {
            Bundle bundle = zzdnjVar.a.a.d.m;
            Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        return this.c.a((zzdro) zzdrl.ADAPTER_LOAD_AD_SYN).a(new zzdqy(this, zzdnjVar, zzdmuVar, zzcrbVar) { // from class: com.google.android.gms.internal.ads.aab
            private final zzcvy a;
            private final zzdnj b;
            private final zzdmu c;
            private final zzcrb d;

            {
                this.a = this;
                this.b = zzdnjVar;
                this.c = zzdmuVar;
                this.d = zzcrbVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdqy
            public final void a() {
                this.a.a(this.b, this.c, this.d);
            }
        }, this.d).a((zzdrg<?>) zzdrl.ADAPTER_LOAD_AD_ACK).a((zzdyz) zzazqVar).a((zzdrg<O2>) zzdrl.ADAPTER_WRAP_ADAPTER).a(new zzdqv(this, zzdnjVar, zzdmuVar, zzcrbVar) { // from class: com.google.android.gms.internal.ads.aad
            private final zzcvy a;
            private final zzdnj b;
            private final zzdmu c;
            private final zzcrb d;

            {
                this.a = this;
                this.b = zzdnjVar;
                this.c = zzdmuVar;
                this.d = zzcrbVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdqv
            public final Object a(Object obj) {
                return this.a.a(this.b, this.c, this.d, (Void) obj);
            }
        }).a();
    }

    @VisibleForTesting
    static String a(String str, int i) {
        StringBuilder sb = new StringBuilder(31 + String.valueOf(str).length());
        sb.append("Error from: ");
        sb.append(str);
        sb.append(", code: ");
        sb.append(i);
        return sb.toString();
    }

    final /* synthetic */ Object a(zzdnj zzdnjVar, zzdmu zzdmuVar, zzcrb zzcrbVar, Void r4) throws Exception {
        return this.b.b(zzdnjVar, zzdmuVar, zzcrbVar);
    }

    final /* synthetic */ void a(zzdnj zzdnjVar, zzdmu zzdmuVar, zzcrb zzcrbVar) throws Exception {
        this.b.a(zzdnjVar, zzdmuVar, zzcrbVar);
    }
}
