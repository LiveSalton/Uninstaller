package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdhg implements zzepf<zzdhe> {
    private final zzeps<zzamy> a;
    private final zzeps<ScheduledExecutorService> b;
    private final zzeps<Boolean> c;
    private final zzeps<ApplicationInfo> d;

    public zzdhg(zzeps<zzamy> zzepsVar, zzeps<ScheduledExecutorService> zzepsVar2, zzeps<Boolean> zzepsVar3, zzeps<ApplicationInfo> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdhe(this.a.b(), this.b.b(), this.c.b().booleanValue(), this.d.b());
    }
}
