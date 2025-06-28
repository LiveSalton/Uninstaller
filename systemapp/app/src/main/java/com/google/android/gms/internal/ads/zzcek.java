package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcek implements zzepf<zzbxy<VideoController.VideoLifecycleCallbacks>> {
    private final zzceb a;
    private final zzeps<zzcgy> b;
    private final zzeps<Executor> c;

    public zzcek(zzceb zzcebVar, zzeps<zzcgy> zzepsVar, zzeps<Executor> zzepsVar2) {
        this.a = zzcebVar;
        this.b = zzepsVar;
        this.c = zzepsVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzbxy) zzepl.a(new zzbxy(this.b.b(), this.c.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
