package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdce implements zzepf<zzdms> {
    private final zzeps<Clock> a;

    public zzdce(zzeps<Clock> zzepsVar) {
        this.a = zzepsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzdms) zzepl.a(new zzdms(this.a.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
