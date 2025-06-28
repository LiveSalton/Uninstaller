package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdqu implements zzepf<ScheduledExecutorService> {
    private final zzeps<ThreadFactory> a;

    public zzdqu(zzeps<ThreadFactory> zzepsVar) {
        this.a = zzepsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (ScheduledExecutorService) zzepl.a(zzduo.a().b(1, this.a.b(), zzdut.b), "Cannot return null from a non-@Nullable @Provides method");
    }
}
