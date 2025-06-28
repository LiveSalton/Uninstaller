package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbrg;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcub extends zzcud<zzboi> {
    private final zzbgm a;
    private final zzcap b;
    private final zzbrg.zza c;
    private final zzbwp d;

    public zzcub(zzbgm zzbgmVar, zzcap zzcapVar, zzbrg.zza zzaVar, zzbwp zzbwpVar) {
        this.a = zzbgmVar;
        this.b = zzcapVar;
        this.c = zzaVar;
        this.d = zzbwpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcud
    protected final zzdyz<zzboi> a(zzdnn zzdnnVar, Bundle bundle) {
        return this.a.n().a(this.c.a(zzdnnVar).a(bundle).a()).a(this.d).a(this.b).a(new zzblz(null)).b().a().b();
    }
}
