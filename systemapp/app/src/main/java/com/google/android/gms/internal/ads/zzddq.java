package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import com.google.android.gms.ads.internal.util.zzf;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzddq implements zzepf<zzddn> {
    private final zzeps<zzdzc> a;
    private final zzeps<zzdnn> b;
    private final zzeps<PackageInfo> c;
    private final zzeps<zzf> d;

    public zzddq(zzeps<zzdzc> zzepsVar, zzeps<zzdnn> zzepsVar2, zzeps<PackageInfo> zzepsVar3, zzeps<zzf> zzepsVar4) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzddn(this.a.b(), this.b.b(), this.c.b(), this.d.b());
    }
}
