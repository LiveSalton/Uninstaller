package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* compiled from: source */
/* loaded from: classes.dex */
final class jv extends zzdga {
    private final zzdhn a;
    private zzeps<zzdfw> b;
    private zzeps<String> c;
    private zzeps<zzdgg> d;
    private zzeps<Integer> e;
    private zzeps<zzdgk> f;
    private zzeps<zzdgq> g;
    private zzeps<zzdgz> h;
    private zzeps<Boolean> i;
    private zzeps<ApplicationInfo> j;
    private zzeps<zzdhe> k;
    private zzeps<zzdhi> l;
    private zzeps<zzdhw> m;
    private zzeps<String> n;
    private zzeps<zzckc> o;
    private zzeps<zzckc> p;
    private zzeps<zzckc> q;
    private zzeps<zzckc> r;
    private zzeps<Map<zzdrl, zzckc>> s;
    private zzeps<Set<zzbxy<zzdru>>> t;
    private zzeps<Set<zzbxy<zzdru>>> u;
    private zzeps v;
    private zzeps<zzdro> w;
    private final /* synthetic */ zzbhg x;

    /* JADX INFO: Access modifiers changed from: private */
    jv(zzbhg zzbhgVar, zzdhn zzdhnVar) {
        zzbjk zzbjkVar;
        zzeps zzepsVar;
        zzeps zzepsVar2;
        zzbgy zzbgyVar;
        zzeps zzepsVar3;
        zzbjk zzbjkVar2;
        zzeps zzepsVar4;
        zzeps zzepsVar5;
        zzeps zzepsVar6;
        zzbje zzbjeVar;
        zzeps zzepsVar7;
        zzbjg zzbjgVar;
        zzeps zzepsVar8;
        zzeps zzepsVar9;
        zzbji zzbjiVar;
        zzeps zzepsVar10;
        zzeps zzepsVar11;
        zzeps zzepsVar12;
        zzeps zzepsVar13;
        this.x = zzbhgVar;
        this.a = zzdhnVar;
        zzbjkVar = lc.a;
        zzepsVar = this.x.j;
        zzepsVar2 = this.x.e;
        this.b = new zzdgb(zzbjkVar, zzepsVar, zzepsVar2, zzdqo.a());
        this.c = new zzdhm(zzdhnVar);
        zzbgyVar = jo.a;
        zzepsVar3 = this.x.j;
        this.d = new zzdgi(zzbgyVar, zzepsVar3, this.c, zzdqo.a());
        this.e = new zzdhr(zzdhnVar);
        zzbjkVar2 = lc.a;
        zzeps<Integer> zzepsVar14 = this.e;
        zzepsVar4 = this.x.j;
        zzepsVar5 = this.x.H;
        zzepsVar6 = this.x.e;
        this.f = new zzdgo(zzbjkVar2, zzepsVar14, zzepsVar4, zzepsVar5, zzepsVar6, zzdqo.a());
        zzbjeVar = kz.a;
        zzdqo a = zzdqo.a();
        zzepsVar7 = this.x.j;
        this.g = new zzdgs(zzbjeVar, a, zzepsVar7);
        zzbjgVar = la.a;
        this.h = new zzdhb(zzbjgVar, zzdqo.a(), this.c);
        this.i = new zzdho(zzdhnVar);
        this.j = new zzdhp(zzdhnVar);
        zzepsVar8 = this.x.J;
        zzepsVar9 = this.x.e;
        this.k = new zzdhg(zzepsVar8, zzepsVar9, this.i, this.j);
        zzbjiVar = lb.a;
        zzepsVar10 = this.x.e;
        zzepsVar11 = this.x.j;
        this.l = new zzdhk(zzbjiVar, zzepsVar10, zzepsVar11);
        this.m = new zzdhy(zzdqo.a());
        this.n = new zzdhq(zzdhnVar);
        this.o = zzepg.a(zzcjr.a());
        this.p = zzepg.a(zzcjp.a());
        this.q = zzepg.a(zzcjt.a());
        this.r = zzepg.a(zzcjv.a());
        this.s = ((zzepj) ((zzepj) ((zzepj) ((zzepj) zzeph.a(4).a(zzdrl.GMS_SIGNALS, this.o)).a(zzdrl.BUILD_URL, this.p)).a(zzdrl.HTTP, this.q)).a(zzdrl.PRE_PROCESS, this.r)).a();
        zzeps<String> zzepsVar15 = this.n;
        zzepsVar12 = this.x.j;
        this.t = zzepg.a(new zzcjx(zzepsVar15, zzepsVar12, zzdqo.a(), this.s));
        this.u = zzepo.a(0, 1).b(this.t).a();
        this.v = zzdrw.a(this.u);
        zzdqo a2 = zzdqo.a();
        zzepsVar13 = this.x.e;
        this.w = zzepg.a(zzdrt.a(a2, zzepsVar13, this.v));
    }

    private final zzdhd d() {
        return new zzdhd((zzaao) zzepl.a(new zzaao(), "Cannot return null from a non-@Nullable @Provides method"), zzdqo.c(), (List) zzepl.a(this.a.e(), "Cannot return null from a non-@Nullable @Provides method"));
    }

    private final zzdgc e() {
        return new zzdgc(zzbjk.a(), zzdqo.c(), (String) zzepl.a(this.a.b(), "Cannot return null from a non-@Nullable @Provides method"), this.a.c());
    }

    @Override // com.google.android.gms.internal.ads.zzdga
    public final zzdfl<JSONObject> a() {
        zzeps zzepsVar;
        zzbim zzbimVar;
        zzeps zzepsVar2;
        zzeps zzepsVar3;
        zzeps zzepsVar4;
        zzbgl zzbglVar;
        zzeps zzepsVar5;
        zzbgl zzbglVar2;
        zzeps zzepsVar6;
        zzeps zzepsVar7;
        zzeps zzepsVar8;
        zzbgl zzbglVar3;
        zzbgl zzbglVar4;
        zzbgl zzbglVar5;
        zzeps zzepsVar9;
        zzeps zzepsVar10;
        zzeps zzepsVar11;
        zzdzc c = zzdqo.c();
        zzdgz zzdgzVar = new zzdgz(zzbjg.a(), zzdqo.c(), zzdhm.a(this.a));
        zzepsVar = this.x.e;
        zzdfi zzdfiVar = (zzdfi) zzepl.a(new zzddx(zzdgzVar, 0L, (ScheduledExecutorService) zzepsVar.b()), "Cannot return null from a non-@Nullable @Provides method");
        zzbimVar = this.x.a;
        zzamy a = zzbip.a(zzbimVar);
        zzepsVar2 = this.x.e;
        zzdhe zzdheVar = new zzdhe(a, (ScheduledExecutorService) zzepsVar2.b(), this.a.d(), zzdhp.a(this.a));
        zzepsVar3 = this.x.e;
        zzdfi zzdfiVar2 = (zzdfi) zzepl.a(new zzddx(zzdheVar, ((Long) zzwq.e().a(zzabf.bL)).longValue(), (ScheduledExecutorService) zzepsVar3.b()), "Cannot return null from a non-@Nullable @Provides method");
        zzarm a2 = zzbji.a();
        zzepsVar4 = this.x.e;
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) zzepsVar4.b();
        zzbglVar = this.x.b;
        zzdhi zzdhiVar = new zzdhi(a2, scheduledExecutorService, zzbgo.a(zzbglVar));
        zzepsVar5 = this.x.e;
        zzdfi zzdfiVar3 = (zzdfi) zzepl.a(new zzddx(zzdhiVar, ((Long) zzwq.e().a(zzabf.bQ)).longValue(), (ScheduledExecutorService) zzepsVar5.b()), "Cannot return null from a non-@Nullable @Provides method");
        zzayc a3 = zzbjk.a();
        zzbglVar2 = this.x.b;
        Context a4 = zzbgo.a(zzbglVar2);
        zzepsVar6 = this.x.e;
        zzdfw zzdfwVar = new zzdfw(a3, a4, (ScheduledExecutorService) zzepsVar6.b(), zzdqo.c());
        zzepsVar7 = this.x.e;
        zzdfi zzdfiVar4 = (zzdfi) zzepl.a(new zzddx(zzdfwVar, 0L, (ScheduledExecutorService) zzepsVar7.b()), "Cannot return null from a non-@Nullable @Provides method");
        zzdhw zzdhwVar = new zzdhw(zzdqo.c());
        zzepsVar8 = this.x.e;
        zzdfi zzdfiVar5 = (zzdfi) zzepl.a(new zzddx(zzdhwVar, 0L, (ScheduledExecutorService) zzepsVar8.b()), "Cannot return null from a non-@Nullable @Provides method");
        zzdfi zzdfiVar6 = (zzdfi) zzepl.a(zzdht.a(), "Cannot return null from a non-@Nullable @Provides method");
        zzbglVar3 = this.x.b;
        zzti a5 = zzbje.a();
        zzdzc c2 = zzdqo.c();
        zzbglVar4 = this.x.b;
        zzayc a6 = zzbjk.a();
        int h = this.a.h();
        zzbglVar5 = this.x.b;
        Context a7 = zzbgo.a(zzbglVar5);
        zzepsVar9 = this.x.H;
        zzayg zzaygVar = (zzayg) zzepsVar9.b();
        zzepsVar10 = this.x.e;
        zzepsVar11 = this.x.I;
        return zzdfm.a(c, zzdwt.a(zzdfiVar, zzdfiVar2, zzdfiVar3, zzdfiVar4, zzdfiVar5, zzdfiVar6, new zzdgg(null, zzbgo.a(zzbglVar3), zzdhm.a(this.a), zzdqo.c()), new zzdgq(a5, c2, zzbgo.a(zzbglVar4)), d(), e(), new zzdgk(a6, h, a7, zzaygVar, (ScheduledExecutorService) zzepsVar10.b(), zzdqo.c()), (zzdfi) zzepsVar11.b()));
    }

    @Override // com.google.android.gms.internal.ads.zzdga
    public final zzdfl<JSONObject> b() {
        zzeps zzepsVar;
        zzeps zzepsVar2;
        zzayb a = zzbjg.a();
        zzepsVar = this.x.I;
        Object b = zzepsVar.b();
        zzdgc e = e();
        zzdhd d = d();
        zzeoz b2 = zzepg.b(this.b);
        zzeoz b3 = zzepg.b(this.d);
        zzeoz b4 = zzepg.b(this.f);
        zzeoz b5 = zzepg.b(this.g);
        zzeoz b6 = zzepg.b(this.h);
        zzeoz b7 = zzepg.b(this.k);
        zzeoz b8 = zzepg.b(this.l);
        zzeoz b9 = zzepg.b(this.m);
        zzdzc c = zzdqo.c();
        zzepsVar2 = this.x.e;
        return zzdhu.a(a, b, e, d, b2, b3, b4, b5, b6, b7, b8, b9, c, (ScheduledExecutorService) zzepsVar2.b());
    }

    @Override // com.google.android.gms.internal.ads.zzdga
    public final zzdro c() {
        return this.w.b();
    }

    /* synthetic */ jv(zzbhg zzbhgVar, zzdhn zzdhnVar, js jsVar) {
        this(zzbhgVar, zzdhnVar);
    }
}
