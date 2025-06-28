package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdqt implements zzepf<ThreadFactory> {
    public static zzdqt a() {
        zzdqt zzdqtVar;
        zzdqtVar = ajo.a;
        return zzdqtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (ThreadFactory) zzepl.a(new ajh(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
