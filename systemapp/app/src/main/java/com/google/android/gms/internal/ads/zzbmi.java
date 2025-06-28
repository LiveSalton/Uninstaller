package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbmi implements zzepf<ls> {
    private final zzeps<zzbob> a;
    private final zzeps<Context> b;
    private final zzeps<zzdmx> c;
    private final zzeps<View> d;
    private final zzeps<zzbdv> e;
    private final zzeps<zzbnz> f;
    private final zzeps<zzccl> g;
    private final zzeps<zzbyc> h;
    private final zzeps<zzcxi> i;
    private final zzeps<Executor> j;

    public zzbmi(zzeps<zzbob> zzepsVar, zzeps<Context> zzepsVar2, zzeps<zzdmx> zzepsVar3, zzeps<View> zzepsVar4, zzeps<zzbdv> zzepsVar5, zzeps<zzbnz> zzepsVar6, zzeps<zzccl> zzepsVar7, zzeps<zzbyc> zzepsVar8, zzeps<zzcxi> zzepsVar9, zzeps<Executor> zzepsVar10) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
        this.f = zzepsVar6;
        this.g = zzepsVar7;
        this.h = zzepsVar8;
        this.i = zzepsVar9;
        this.j = zzepsVar10;
    }

    public static ls a(zzbob zzbobVar, Context context, zzdmx zzdmxVar, View view, zzbdv zzbdvVar, zzbnz zzbnzVar, zzccl zzcclVar, zzbyc zzbycVar, zzeoz<zzcxi> zzeozVar, Executor executor) {
        return new ls(zzbobVar, context, zzdmxVar, view, zzbdvVar, zzbnzVar, zzcclVar, zzbycVar, zzeozVar, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b(), this.f.b(), this.g.b(), this.h.b(), zzepg.b(this.i), this.j.b());
    }
}
