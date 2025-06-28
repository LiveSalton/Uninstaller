package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbri implements zzepf<Bundle> {
    private final zzbrg a;

    private zzbri(zzbrg zzbrgVar) {
        this.a = zzbrgVar;
    }

    public static zzbri a(zzbrg zzbrgVar) {
        return new zzbri(zzbrgVar);
    }

    public static Bundle b(zzbrg zzbrgVar) {
        return zzbrgVar.d();
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return this.a.d();
    }
}
