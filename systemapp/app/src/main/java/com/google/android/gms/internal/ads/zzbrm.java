package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrg;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbrm implements zzepf<zzbrg.zza> {
    private final zzbrg a;

    private zzbrm(zzbrg zzbrgVar) {
        this.a = zzbrgVar;
    }

    public static zzbrm a(zzbrg zzbrgVar) {
        return new zzbrm(zzbrgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzbrg.zza) zzepl.a(this.a.a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
