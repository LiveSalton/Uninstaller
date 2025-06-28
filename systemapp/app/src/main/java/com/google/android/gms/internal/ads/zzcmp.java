package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcmp implements zzepf<ApplicationInfo> {
    private final zzeps<Context> a;

    private zzcmp(zzeps<Context> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzcmp a(zzeps<Context> zzepsVar) {
        return new zzcmp(zzepsVar);
    }

    public static ApplicationInfo a(Context context) {
        return (ApplicationInfo) zzepl.a(context.getApplicationInfo(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a.b());
    }
}
