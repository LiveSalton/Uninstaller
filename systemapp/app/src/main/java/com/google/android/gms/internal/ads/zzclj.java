package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzclj implements zzepf<Set<zzbxy<AppEventListener>>> {
    private final zzcld a;
    private final zzeps<zzcln> b;
    private final zzeps<Executor> c;

    private zzclj(zzcld zzcldVar, zzeps<zzcln> zzepsVar, zzeps<Executor> zzepsVar2) {
        this.a = zzcldVar;
        this.b = zzepsVar;
        this.c = zzepsVar2;
    }

    public static zzclj a(zzcld zzcldVar, zzeps<zzcln> zzepsVar, zzeps<Executor> zzepsVar2) {
        return new zzclj(zzcldVar, zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Set) zzepl.a(zzcld.b(this.b.b(), this.c.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
