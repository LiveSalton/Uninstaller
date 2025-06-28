package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzf;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbqz {
    private final zzdro a;
    private final zzazh b;
    private final ApplicationInfo c;
    private final String d;
    private final List<String> e;
    private final PackageInfo f;
    private final zzeoz<zzdyz<String>> g;
    private final zzf h;
    private final String i;
    private final zzdfl<Bundle> j;

    public zzbqz(zzdro zzdroVar, zzazh zzazhVar, ApplicationInfo applicationInfo, String str, List<String> list, PackageInfo packageInfo, zzeoz<zzdyz<String>> zzeozVar, zzf zzfVar, String str2, zzdfl<Bundle> zzdflVar) {
        this.a = zzdroVar;
        this.b = zzazhVar;
        this.c = applicationInfo;
        this.d = str;
        this.e = list;
        this.f = packageInfo;
        this.g = zzeozVar;
        this.h = zzfVar;
        this.i = str2;
        this.j = zzdflVar;
    }

    public final zzdyz<Bundle> a() {
        return this.a.a((zzdro) zzdrl.SIGNALS).a(this.j.a(new Bundle())).a();
    }

    public final zzdyz<zzatl> b() {
        zzdyz<Bundle> a = a();
        return this.a.a((zzdro) zzdrl.REQUEST_PARCEL, a, this.g.b()).a(new Callable(this, a) { // from class: com.google.android.gms.internal.ads.mp
            private final zzbqz a;
            private final zzdyz b;

            {
                this.a = this;
                this.b = a;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.a(this.b);
            }
        }).a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ zzatl a(zzdyz zzdyzVar) throws Exception {
        return new zzatl((Bundle) zzdyzVar.get(), this.b, this.c, this.d, this.e, this.f, this.g.b().get(), this.h.f(), this.i, null, null);
    }
}
