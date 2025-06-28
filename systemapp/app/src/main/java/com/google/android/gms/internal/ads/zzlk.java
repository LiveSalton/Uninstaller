package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzlk implements zzjw, zzkf {
    private static final zzkb a = new azz();
    private static final int b = zzpt.c("qt  ");
    private int g;
    private int h;
    private long i;
    private int j;
    private zzpn k;
    private int l;
    private int m;
    private zzjy n;
    private azy[] o;
    private long p;
    private boolean q;
    private final zzpn e = new zzpn(16);
    private final Stack<azk> f = new Stack<>();
    private final zzpn c = new zzpn(zzpi.a);
    private final zzpn d = new zzpn(4);

    @Override // com.google.android.gms.internal.ads.zzkf
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzjw
    public final void c() {
    }

    @Override // com.google.android.gms.internal.ads.zzjw
    public final boolean a(zzjz zzjzVar) throws IOException, InterruptedException {
        return baa.b(zzjzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzjw
    public final void a(zzjy zzjyVar) {
        this.n = zzjyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzjw
    public final void a(long j, long j2) {
        this.f.clear();
        this.j = 0;
        this.l = 0;
        this.m = 0;
        if (j == 0) {
            d();
            return;
        }
        if (this.o != null) {
            for (azy azyVar : this.o) {
                bac bacVar = azyVar.b;
                int a2 = bacVar.a(j2);
                if (a2 == -1) {
                    a2 = bacVar.b(j2);
                }
                azyVar.d = a2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x019e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02b3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0006 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzjw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(com.google.android.gms.internal.ads.zzjz r25, com.google.android.gms.internal.ads.zzkc r26) throws java.io.IOException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 702
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlk.a(com.google.android.gms.internal.ads.zzjz, com.google.android.gms.internal.ads.zzkc):int");
    }

    @Override // com.google.android.gms.internal.ads.zzkf
    public final long b() {
        return this.p;
    }

    @Override // com.google.android.gms.internal.ads.zzkf
    public final long a(long j) {
        long j2 = Long.MAX_VALUE;
        for (azy azyVar : this.o) {
            bac bacVar = azyVar.b;
            int a2 = bacVar.a(j);
            if (a2 == -1) {
                a2 = bacVar.b(j);
            }
            long j3 = bacVar.b[a2];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    private final void d() {
        this.g = 0;
        this.j = 0;
    }

    private final void b(long j) throws zzhw {
        zzlo a2;
        while (!this.f.isEmpty() && this.f.peek().aP == j) {
            azk pop = this.f.pop();
            if (pop.aO == azh.B) {
                ArrayList arrayList = new ArrayList();
                zzmd zzmdVar = null;
                zzka zzkaVar = new zzka();
                azj d = pop.d(azh.az);
                if (d != null && (zzmdVar = azm.a(d, this.q)) != null) {
                    zzkaVar.a(zzmdVar);
                }
                long j2 = Long.MAX_VALUE;
                long j3 = -9223372036854775807L;
                for (int i = 0; i < pop.aR.size(); i++) {
                    azk azkVar = pop.aR.get(i);
                    if (azkVar.aO == azh.D && (a2 = azm.a(azkVar, pop.d(azh.C), -9223372036854775807L, (zzjo) null, this.q)) != null) {
                        bac a3 = azm.a(a2, azkVar.e(azh.E).e(azh.F).e(azh.G), zzkaVar);
                        if (a3.a != 0) {
                            azy azyVar = new azy(a2, a3, this.n.a(i, a2.b));
                            zzhp a4 = a2.f.a(a3.d + 30);
                            if (a2.b == 1) {
                                if (zzkaVar.a()) {
                                    a4 = a4.a(zzkaVar.a, zzkaVar.b);
                                }
                                if (zzmdVar != null) {
                                    a4 = a4.a(zzmdVar);
                                }
                            }
                            azyVar.c.a(a4);
                            long max = Math.max(j3, a2.e);
                            arrayList.add(azyVar);
                            long j4 = a3.b[0];
                            if (j4 < j2) {
                                j2 = j4;
                            }
                            j3 = max;
                        }
                    }
                }
                this.p = j3;
                this.o = (azy[]) arrayList.toArray(new azy[arrayList.size()]);
                this.n.a();
                this.n.a(this);
                this.f.clear();
                this.g = 2;
            } else if (!this.f.isEmpty()) {
                this.f.peek().a(pop);
            }
        }
        if (this.g != 2) {
            d();
        }
    }
}
