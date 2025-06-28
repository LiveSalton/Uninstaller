package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzczq implements zzepf<Set<String>> {
    private final zzczo a;

    public zzczq(zzczo zzczoVar) {
        this.a = zzczoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Set) zzepl.a(this.a.a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
