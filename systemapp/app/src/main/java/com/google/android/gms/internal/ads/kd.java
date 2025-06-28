package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
final class kd implements zzdij {
    private zzeps<Context> a;
    private zzeps<String> b;
    private zzeps<zzdkl<zzblg, zzbll>> c;
    private zzeps<zzdir> d;
    private zzeps<zzdib> e;
    private zzeps<zzdid> f;
    private zzeps<zzdkl<zzblp, zzblv>> g;
    private zzeps<zzdjd> h;
    private zzeps<zzdjf> i;
    private final /* synthetic */ zzbhg j;

    /* JADX INFO: Access modifiers changed from: private */
    kd(zzbhg zzbhgVar, Context context, String str) {
        zzeps zzepsVar;
        zzeps zzepsVar2;
        zzeps zzepsVar3;
        zzeps zzepsVar4;
        zzeps zzepsVar5;
        zzeps zzepsVar6;
        zzeps zzepsVar7;
        zzeps zzepsVar8;
        zzeps zzepsVar9;
        zzeps zzepsVar10;
        zzeps zzepsVar11;
        zzeps zzepsVar12;
        this.j = zzbhgVar;
        this.a = zzepi.a(context);
        this.b = zzepi.a(str);
        zzeps<Context> zzepsVar13 = this.a;
        zzepsVar = this.j.ac;
        zzepsVar2 = this.j.ad;
        this.c = new zzdkr(zzepsVar13, zzepsVar, zzepsVar2);
        zzepsVar3 = this.j.ac;
        this.d = zzepg.a(new zzdja(zzepsVar3));
        zzeps<Context> zzepsVar14 = this.a;
        zzepsVar4 = this.j.c;
        zzepsVar5 = this.j.x;
        this.e = zzepg.a(new zzdia(zzepsVar14, zzepsVar4, zzepsVar5, this.c, this.d, zzdno.a()));
        zzepsVar6 = this.j.x;
        zzeps<Context> zzepsVar15 = this.a;
        zzeps<String> zzepsVar16 = this.b;
        zzeps<zzdib> zzepsVar17 = this.e;
        zzeps<zzdir> zzepsVar18 = this.d;
        zzepsVar7 = this.j.k;
        this.f = zzepg.a(new zzdig(zzepsVar6, zzepsVar15, zzepsVar16, zzepsVar17, zzepsVar18, zzepsVar7));
        zzeps<Context> zzepsVar19 = this.a;
        zzepsVar8 = this.j.ac;
        zzepsVar9 = this.j.ad;
        this.g = new zzdko(zzepsVar19, zzepsVar8, zzepsVar9);
        zzeps<Context> zzepsVar20 = this.a;
        zzepsVar10 = this.j.c;
        zzepsVar11 = this.j.x;
        this.h = zzepg.a(new zzdjc(zzepsVar20, zzepsVar10, zzepsVar11, this.g, this.d, zzdno.a()));
        zzepsVar12 = this.j.x;
        this.i = zzepg.a(new zzdjl(zzepsVar12, this.a, this.b, this.h, this.d));
    }

    @Override // com.google.android.gms.internal.ads.zzdij
    public final zzdid a() {
        return this.f.b();
    }

    @Override // com.google.android.gms.internal.ads.zzdij
    public final zzdjf b() {
        return this.i.b();
    }

    /* synthetic */ kd(zzbhg zzbhgVar, Context context, String str, js jsVar) {
        this(zzbhgVar, context, str);
    }
}
