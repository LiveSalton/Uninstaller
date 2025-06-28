package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdom implements zzepf<Clock> {
    private final zzdoj a;

    public zzdom(zzdoj zzdojVar) {
        this.a = zzdojVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Clock) zzepl.a(DefaultClock.d(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
