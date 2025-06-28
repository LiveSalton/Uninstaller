package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcmw implements zzepf<zzcns> {
    private final zzeps<Context> a;

    private zzcmw(zzeps<Context> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzcmw a(zzeps<Context> zzepsVar) {
        return new zzcmw(zzepsVar);
    }

    public static zzcns a(Context context) {
        return (zzcns) zzepl.a(new zzcns(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a.b());
    }
}
