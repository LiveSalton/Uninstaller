package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcka implements zzdru {
    private Map<zzdrl, zzckc> a;
    private zzts b;

    zzcka(zzts zztsVar, Map<zzdrl, zzckc> map) {
        this.a = map;
        this.b = zztsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdru
    public final void a(zzdrl zzdrlVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdru
    public final void b(zzdrl zzdrlVar, String str) {
        if (this.a.containsKey(zzdrlVar)) {
            this.b.a(this.a.get(zzdrlVar).a);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdru
    public final void a(zzdrl zzdrlVar, String str, Throwable th) {
        if (this.a.containsKey(zzdrlVar)) {
            this.b.a(this.a.get(zzdrlVar).c);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdru
    public final void c(zzdrl zzdrlVar, String str) {
        if (this.a.containsKey(zzdrlVar)) {
            this.b.a(this.a.get(zzdrlVar).b);
        }
    }
}
