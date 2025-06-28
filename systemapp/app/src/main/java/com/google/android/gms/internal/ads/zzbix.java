package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbix implements zzepf<zzdst> {
    private final zzeps<Context> a;

    public zzbix(zzeps<Context> zzepsVar) {
        this.a = zzepsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzdst) zzepl.a(new zzdst(this.a.b(), zzp.q().a()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
