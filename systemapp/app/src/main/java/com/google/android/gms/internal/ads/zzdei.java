package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdei implements zzepf<zzdeg> {
    private final zzeps<Context> a;
    private final zzeps<String> b;

    private zzdei(zzeps<Context> zzepsVar, zzeps<String> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzdei a(zzeps<Context> zzepsVar, zzeps<String> zzepsVar2) {
        return new zzdei(zzepsVar, zzepsVar2);
    }

    public static zzdeg a(Context context, String str) {
        return new zzdeg(context, str);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a.b(), this.b.b());
    }
}
