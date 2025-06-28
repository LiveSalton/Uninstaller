package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Collections;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbxj implements zzepf<Set<zzbxy<VideoController.VideoLifecycleCallbacks>>> {
    private final zzbwp a;

    private zzbxj(zzbwp zzbwpVar) {
        this.a = zzbwpVar;
    }

    public static zzbxj a(zzbwp zzbwpVar) {
        return new zzbxj(zzbwpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Set) zzepl.a(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
