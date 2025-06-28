package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbyt implements zzepf<zzbyn> {
    private final zzeps<Set<zzbxy<VideoController.VideoLifecycleCallbacks>>> a;

    private zzbyt(zzeps<Set<zzbxy<VideoController.VideoLifecycleCallbacks>>> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzbyt a(zzeps<Set<zzbxy<VideoController.VideoLifecycleCallbacks>>> zzepsVar) {
        return new zzbyt(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbyn(this.a.b());
    }
}
