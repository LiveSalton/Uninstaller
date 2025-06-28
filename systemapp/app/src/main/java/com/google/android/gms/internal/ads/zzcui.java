package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbrg;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcui extends zzcud<zzbyx> {
    private final zzbgm a;
    private final zzbrg.zza b;
    private final zzcwq c;
    private final zzbwp d;

    public zzcui(zzbgm zzbgmVar, zzbrg.zza zzaVar, zzcwq zzcwqVar, zzbwp zzbwpVar) {
        this.a = zzbgmVar;
        this.b = zzaVar;
        this.c = zzcwqVar;
        this.d = zzbwpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcud
    protected final zzdyz<zzbyx> a(zzdnn zzdnnVar, Bundle bundle) {
        return this.a.l().a(this.b.a(zzdnnVar).a(bundle).a()).a(this.d).a(this.c).b().b().b();
    }
}
