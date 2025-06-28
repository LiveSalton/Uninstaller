package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdhk implements zzepf<zzdhi> {
    private final zzeps<zzarr> a;
    private final zzeps<ScheduledExecutorService> b;
    private final zzeps<Context> c;

    public zzdhk(zzeps<zzarr> zzepsVar, zzeps<ScheduledExecutorService> zzepsVar2, zzeps<Context> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdhi(this.a.b(), this.b.b(), this.c.b());
    }
}
