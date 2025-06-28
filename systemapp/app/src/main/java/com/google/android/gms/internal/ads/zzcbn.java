package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcbn implements zzepf<zzbxx> {
    private final zzeps<Context> a;
    private final zzeps<zzdmu> b;

    public zzcbn(zzeps<Context> zzepsVar, zzeps<zzdmu> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzbxx) zzepl.a(new zzbxx(this.a.b(), new HashSet(), this.b.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
