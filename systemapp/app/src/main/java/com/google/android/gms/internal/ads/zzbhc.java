package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbhc implements zzepf<zzatz> {
    private final zzeps<Context> a;

    public zzbhc(zzeps<Context> zzepsVar) {
        this.a = zzepsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        Context b = this.a.b();
        return (zzatz) zzepl.a(new zzatx(b, new zzaua(b).a()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
