package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbqg implements zzepf<zzbxy<zzp>> {
    private final zzeps<zzbul> a;
    private final zzeps<Executor> b;

    private zzbqg(zzeps<zzbul> zzepsVar, zzeps<Executor> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzbqg a(zzeps<zzbul> zzepsVar, zzeps<Executor> zzepsVar2) {
        return new zzbqg(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzbxy) zzepl.a(new zzbxy(this.a.b(), this.b.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
