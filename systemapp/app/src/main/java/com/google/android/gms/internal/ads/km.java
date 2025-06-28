package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
final class km implements zzdld {
    private zzeps<Context> a;
    private zzeps<zzvn> b;
    private zzeps<String> c;
    private zzeps<zzcxq> d;
    private zzeps<zzdlf> e;
    private zzeps<zzdkv> f;
    private zzeps<zzcyg> g;
    private final /* synthetic */ zzbhg h;

    /* JADX INFO: Access modifiers changed from: private */
    km(zzbhg zzbhgVar, Context context, String str, zzvn zzvnVar) {
        zzeps zzepsVar;
        zzeps zzepsVar2;
        zzeps zzepsVar3;
        this.h = zzbhgVar;
        this.a = zzepi.a(context);
        this.b = zzepi.a(zzvnVar);
        this.c = zzepi.a(str);
        this.d = zzepg.a(zzcxz.a());
        zzepsVar = this.h.ac;
        this.e = zzepg.a(zzdly.a(zzepsVar));
        zzeps<Context> zzepsVar4 = this.a;
        zzepsVar2 = this.h.c;
        zzepsVar3 = this.h.x;
        this.f = zzepg.a(new zzdla(zzepsVar4, zzepsVar2, zzepsVar3, this.d, this.e, zzdno.a()));
        this.g = zzepg.a(new zzcyi(this.a, this.b, this.c, this.f, this.d, this.e));
    }

    @Override // com.google.android.gms.internal.ads.zzdld
    public final zzcyg a() {
        return this.g.b();
    }

    /* synthetic */ km(zzbhg zzbhgVar, Context context, String str, zzvn zzvnVar, js jsVar) {
        this(zzbhgVar, context, str, zzvnVar);
    }
}
