package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbrg;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcuk extends zzcud<zzchc> {
    private final zzbgm a;
    private final zzbrg.zza b;
    private final zzbwp c;

    public zzcuk(zzbgm zzbgmVar, zzbrg.zza zzaVar, zzbwp zzbwpVar) {
        this.a = zzbgmVar;
        this.b = zzaVar;
        this.c = zzbwpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcud
    protected final zzdyz<zzchc> a(zzdnn zzdnnVar, Bundle bundle) {
        return this.a.o().a(this.b.a(zzdnnVar).a(bundle).a()).a(this.c).b().c().b();
    }
}
