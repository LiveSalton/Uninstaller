package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdgc implements zzdfi<zzdgd> {
    private final zzayc a;
    private final Executor b;
    private final String c;
    private final PackageInfo d;

    public zzdgc(zzayc zzaycVar, Executor executor, String str, PackageInfo packageInfo) {
        this.a = zzaycVar;
        this.b = executor;
        this.c = str;
        this.d = packageInfo;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdgd> a() {
        return zzdyr.a(zzdyr.a(this.a.a(this.c, this.d), aer.a, this.b), Throwable.class, new zzdyb(this) { // from class: com.google.android.gms.internal.ads.aeq
            private final zzdgc a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdyz a(Object obj) {
                return this.a.a((Throwable) obj);
            }
        }, this.b);
    }

    final /* synthetic */ zzdyz a(Throwable th) throws Exception {
        return zzdyr.a(new zzdgd(this.c));
    }
}
