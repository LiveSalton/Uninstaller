package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbgo implements zzepf<Context> {
    private final zzbgl a;

    public zzbgo(zzbgl zzbglVar) {
        this.a = zzbglVar;
    }

    public static Context a(zzbgl zzbglVar) {
        return (Context) zzepl.a(zzbglVar.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a);
    }
}
