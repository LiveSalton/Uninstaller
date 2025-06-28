package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import com.google.android.gms.internal.ads.zzbrg;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcug extends zzcud<zzbme> {
    private final zzbgm a;
    private final zzbrg.zza b;
    private final zzcwq c;
    private final zzbwp d;
    private final zzcap e;
    private final zzbua f;
    private final ViewGroup g;

    public zzcug(zzbgm zzbgmVar, zzbrg.zza zzaVar, zzcwq zzcwqVar, zzbwp zzbwpVar, zzcap zzcapVar, zzbua zzbuaVar, ViewGroup viewGroup) {
        this.a = zzbgmVar;
        this.b = zzaVar;
        this.c = zzcwqVar;
        this.d = zzbwpVar;
        this.e = zzcapVar;
        this.f = zzbuaVar;
        this.g = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzcud
    protected final zzdyz<zzbme> a(zzdnn zzdnnVar, Bundle bundle) {
        return this.a.h().a(this.b.a(zzdnnVar).a(bundle).a()).a(this.d).a(this.c).a(this.e).a(new zzbnv(this.f)).a(new zzblz(this.g)).b().b().b();
    }
}
