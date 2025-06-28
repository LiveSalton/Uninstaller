package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdhp implements zzepf<ApplicationInfo> {
    private final zzdhn a;

    public zzdhp(zzdhn zzdhnVar) {
        this.a = zzdhnVar;
    }

    public static ApplicationInfo a(zzdhn zzdhnVar) {
        return (ApplicationInfo) zzepl.a(zzdhnVar.f(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a);
    }
}
