package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzder implements zzepf<zzdek> {
    private final zzeps<zzdzc> a;
    private final zzeps<ScheduledExecutorService> b;
    private final zzeps<String> c;
    private final zzeps<zzcwz> d;
    private final zzeps<Context> e;
    private final zzeps<zzdnn> f;
    private final zzeps<zzcwx> g;

    private zzder(zzeps<zzdzc> zzepsVar, zzeps<ScheduledExecutorService> zzepsVar2, zzeps<String> zzepsVar3, zzeps<zzcwz> zzepsVar4, zzeps<Context> zzepsVar5, zzeps<zzdnn> zzepsVar6, zzeps<zzcwx> zzepsVar7) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
        this.f = zzepsVar6;
        this.g = zzepsVar7;
    }

    public static zzder a(zzeps<zzdzc> zzepsVar, zzeps<ScheduledExecutorService> zzepsVar2, zzeps<String> zzepsVar3, zzeps<zzcwz> zzepsVar4, zzeps<Context> zzepsVar5, zzeps<zzdnn> zzepsVar6, zzeps<zzcwx> zzepsVar7) {
        return new zzder(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4, zzepsVar5, zzepsVar6, zzepsVar7);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdek(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b(), this.f.b(), this.g.b());
    }
}
