package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcle implements zzepf<zzclb> {
    private final zzeps<Clock> a;

    public zzcle(zzeps<Clock> zzepsVar) {
        this.a = zzepsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzclb(this.a.b());
    }
}
