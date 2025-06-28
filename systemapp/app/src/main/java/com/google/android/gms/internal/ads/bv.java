package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class bv implements zzahv<zzalz> {
    private final /* synthetic */ zzals a;
    private final /* synthetic */ zzako b;
    private final /* synthetic */ zzalb c;

    bv(zzalb zzalbVar, zzals zzalsVar, zzako zzakoVar) {
        this.c = zzalbVar;
        this.a = zzalsVar;
        this.b = zzakoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahv
    public final /* synthetic */ void a(zzalz zzalzVar, Map map) {
        Object obj;
        com.google.android.gms.ads.internal.util.zzau zzauVar;
        obj = this.c.a;
        synchronized (obj) {
            if (this.a.e() != -1 && this.a.e() != 1) {
                this.c.h = 0;
                zzauVar = this.c.e;
                zzauVar.a(this.b);
                this.a.a((zzals) this.b);
                this.c.g = this.a;
                zzd.a("Successfully loaded JS Engine.");
            }
        }
    }
}
