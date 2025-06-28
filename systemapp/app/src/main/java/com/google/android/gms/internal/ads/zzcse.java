package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzbl;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcse implements zzcrh<zzbme, zzdoe, zzcst> {
    private final Context a;
    private final zzazh b;
    private final zzbna c;
    private final Executor d;

    public zzcse(Context context, zzazh zzazhVar, zzbna zzbnaVar, Executor executor) {
        this.a = context;
        this.b = zzazhVar;
        this.c = zzbnaVar;
        this.d = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final void a(zzdnj zzdnjVar, zzdmu zzdmuVar, zzcrb<zzdoe, zzcst> zzcrbVar) throws zzdnr {
        zzvn a;
        zzvn zzvnVar = zzdnjVar.a.a.e;
        if (zzvnVar.m) {
            a = new zzvn(this.a, com.google.android.gms.ads.zzb.a(zzvnVar.e, zzvnVar.b));
        } else {
            a = zzdns.a(this.a, zzdmuVar.t);
        }
        zzvn zzvnVar2 = a;
        if (this.b.c < 4100000) {
            zzcrbVar.b.a(this.a, zzvnVar2, zzdnjVar.a.a.d, zzdmuVar.u.toString(), zzcrbVar.c);
        } else {
            zzcrbVar.b.a(this.a, zzvnVar2, zzdnjVar.a.a.d, zzdmuVar.u.toString(), com.google.android.gms.ads.internal.util.zzbk.a((zzbl) zzdmuVar.r), zzcrbVar.c);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcrh
    public final /* synthetic */ zzbme b(zzdnj zzdnjVar, zzdmu zzdmuVar, zzcrb<zzdoe, zzcst> zzcrbVar) throws zzdnr, zzcuq {
        zzbna zzbnaVar = this.c;
        zzbos zzbosVar = new zzbos(zzdnjVar, zzdmuVar, zzcrbVar.a);
        View a = zzcrbVar.b.a();
        zzdoe zzdoeVar = zzcrbVar.b;
        zzdoeVar.getClass();
        zzbmd a2 = zzbnaVar.a(zzbosVar, new zzbmh(a, null, yj.a(zzdoeVar), zzdmuVar.t.get(0)));
        a2.j().a(zzcrbVar.b.a());
        a2.a().a((zzbso) new zzbjt(zzcrbVar.b), this.d);
        zzcrbVar.c.a((zzano) a2.f());
        return a2.h();
    }
}
