package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbxd implements zzepf<Set<zzbxy<AppEventListener>>> {
    private final zzbwp a;

    private zzbxd(zzbwp zzbwpVar) {
        this.a = zzbwpVar;
    }

    public static zzbxd a(zzbwp zzbwpVar) {
        return new zzbxd(zzbwpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Set) zzepl.a(this.a.f(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
