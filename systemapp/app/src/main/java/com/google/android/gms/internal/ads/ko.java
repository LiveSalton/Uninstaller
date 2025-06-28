package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
final class ko implements zzdmm {
    private zzeps<Context> a;
    private zzeps<zzdkl<zzchf, zzchc>> b;
    private zzeps<zzdlf> c;
    private zzeps<zzdni> d;
    private zzeps<zzdma> e;
    private zzeps<zzdmo> f;
    private zzeps<String> g;
    private zzeps<zzdmi> h;
    private final /* synthetic */ zzbhg i;

    /* JADX INFO: Access modifiers changed from: private */
    ko(zzbhg zzbhgVar, Context context, String str) {
        zzeps zzepsVar;
        zzeps zzepsVar2;
        zzeps zzepsVar3;
        zzeps zzepsVar4;
        zzeps zzepsVar5;
        this.i = zzbhgVar;
        this.a = zzepi.a(context);
        zzeps<Context> zzepsVar6 = this.a;
        zzepsVar = this.i.ac;
        zzepsVar2 = this.i.ad;
        this.b = new zzdkq(zzepsVar6, zzepsVar, zzepsVar2);
        zzepsVar3 = this.i.ac;
        this.c = zzepg.a(zzdly.a(zzepsVar3));
        this.d = zzepg.a(zzdnl.a());
        zzeps<Context> zzepsVar7 = this.a;
        zzepsVar4 = this.i.c;
        zzepsVar5 = this.i.x;
        this.e = zzepg.a(new zzdmj(zzepsVar7, zzepsVar4, zzepsVar5, this.b, this.c, zzdno.a(), this.d));
        this.f = zzepg.a(new zzdmt(this.e, this.c, this.d));
        this.g = zzepi.b(str);
        this.h = zzepg.a(new zzdmn(this.g, this.e, this.a, this.c, this.d));
    }

    @Override // com.google.android.gms.internal.ads.zzdmm
    public final zzdmo a() {
        return this.f.b();
    }

    @Override // com.google.android.gms.internal.ads.zzdmm
    public final zzdmi b() {
        return this.h.b();
    }

    /* synthetic */ ko(zzbhg zzbhgVar, Context context, String str, js jsVar) {
        this(zzbhgVar, context, str);
    }
}
