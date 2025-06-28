package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdoy implements zzepf<Context> {
    private final zzdot a;
    private final zzeps<zzdor> b;

    private zzdoy(zzdot zzdotVar, zzeps<zzdor> zzepsVar) {
        this.a = zzdotVar;
        this.b = zzepsVar;
    }

    public static zzdoy a(zzdot zzdotVar, zzeps<zzdor> zzepsVar) {
        return new zzdoy(zzdotVar, zzepsVar);
    }

    public static Context a(zzdot zzdotVar, zzdor zzdorVar) {
        return (Context) zzepl.a(zzdorVar.a, "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a, this.b.b());
    }
}
