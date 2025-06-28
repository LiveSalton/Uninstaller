package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbrj implements zzepf<Context> {
    private final zzbrg a;
    private final zzeps<Context> b;

    private zzbrj(zzbrg zzbrgVar, zzeps<Context> zzepsVar) {
        this.a = zzbrgVar;
        this.b = zzepsVar;
    }

    public static zzbrj a(zzbrg zzbrgVar, zzeps<Context> zzepsVar) {
        return new zzbrj(zzbrgVar, zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (Context) zzepl.a(this.a.a(this.b.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
