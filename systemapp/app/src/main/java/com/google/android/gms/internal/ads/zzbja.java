package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzax;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbja implements zzepf<zzax> {
    private final zzeps<Context> a;

    public zzbja(zzeps<Context> zzepsVar) {
        this.a = zzepsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzax) zzepl.a(new zzax(this.a.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
