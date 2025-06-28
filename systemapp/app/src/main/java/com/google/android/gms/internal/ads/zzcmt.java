package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcmt implements zzepf<String> {
    private final zzeps<Context> a;

    private zzcmt(zzeps<Context> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzcmt a(zzeps<Context> zzepsVar) {
        return new zzcmt(zzepsVar);
    }

    public static String a(Context context) {
        return (String) zzepl.a(context.getPackageName(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a.b());
    }
}
