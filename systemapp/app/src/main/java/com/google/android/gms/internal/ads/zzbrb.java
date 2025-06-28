package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzf;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbrb implements zzepf<zzbqz> {
    private final zzeps<zzdro> a;
    private final zzeps<zzazh> b;
    private final zzeps<ApplicationInfo> c;
    private final zzeps<String> d;
    private final zzeps<List<String>> e;
    private final zzeps<PackageInfo> f;
    private final zzeps<zzdyz<String>> g;
    private final zzeps<zzf> h;
    private final zzeps<String> i;
    private final zzeps<zzdfl<Bundle>> j;

    private zzbrb(zzeps<zzdro> zzepsVar, zzeps<zzazh> zzepsVar2, zzeps<ApplicationInfo> zzepsVar3, zzeps<String> zzepsVar4, zzeps<List<String>> zzepsVar5, zzeps<PackageInfo> zzepsVar6, zzeps<zzdyz<String>> zzepsVar7, zzeps<zzf> zzepsVar8, zzeps<String> zzepsVar9, zzeps<zzdfl<Bundle>> zzepsVar10) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
        this.f = zzepsVar6;
        this.g = zzepsVar7;
        this.h = zzepsVar8;
        this.i = zzepsVar9;
        this.j = zzepsVar10;
    }

    public static zzbrb a(zzeps<zzdro> zzepsVar, zzeps<zzazh> zzepsVar2, zzeps<ApplicationInfo> zzepsVar3, zzeps<String> zzepsVar4, zzeps<List<String>> zzepsVar5, zzeps<PackageInfo> zzepsVar6, zzeps<zzdyz<String>> zzepsVar7, zzeps<zzf> zzepsVar8, zzeps<String> zzepsVar9, zzeps<zzdfl<Bundle>> zzepsVar10) {
        return new zzbrb(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4, zzepsVar5, zzepsVar6, zzepsVar7, zzepsVar8, zzepsVar9, zzepsVar10);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbqz(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b(), this.f.b(), zzepg.b(this.g), this.h.b(), this.i.b(), this.j.b());
    }
}
