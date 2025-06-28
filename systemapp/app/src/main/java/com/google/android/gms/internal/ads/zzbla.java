package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbla implements zzepf<View> {
    private final zzbkx a;

    public zzbla(zzbkx zzbkxVar) {
        this.a = zzbkxVar;
    }

    public static View a(zzbkx zzbkxVar) {
        return (View) zzepl.a(zzbkxVar.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a);
    }
}
