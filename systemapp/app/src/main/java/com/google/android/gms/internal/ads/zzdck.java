package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import com.google.android.gms.ads.internal.util.zzf;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdck implements zzepf<zzdcg> {
    private final zzeps<zzamy> a;
    private final zzeps<ScheduledExecutorService> b;
    private final zzeps<zzf> c;
    private final zzeps<ApplicationInfo> d;
    private final zzeps<zzdnn> e;

    private zzdck(zzeps<zzamy> zzepsVar, zzeps<ScheduledExecutorService> zzepsVar2, zzeps<zzf> zzepsVar3, zzeps<ApplicationInfo> zzepsVar4, zzeps<zzdnn> zzepsVar5) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
    }

    public static zzdck a(zzeps<zzamy> zzepsVar, zzeps<ScheduledExecutorService> zzepsVar2, zzeps<zzf> zzepsVar3, zzeps<ApplicationInfo> zzepsVar4, zzeps<zzdnn> zzepsVar5) {
        return new zzdck(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4, zzepsVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdcg(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b());
    }
}
