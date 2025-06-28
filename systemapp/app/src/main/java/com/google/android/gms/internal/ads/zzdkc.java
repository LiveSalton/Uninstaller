package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbre;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdkc<RequestComponentT extends zzbre<AdT>, AdT> implements zzdkl<RequestComponentT, AdT> {
    private final zzdkl<RequestComponentT, AdT> a;

    @GuardedBy("this")
    private RequestComponentT b;

    public zzdkc(zzdkl<RequestComponentT, AdT> zzdklVar) {
        this.a = zzdklVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdkl
    /* renamed from: b */
    public final synchronized RequestComponentT a() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzdkl
    public final synchronized zzdyz<AdT> a(zzdkm zzdkmVar, zzdkn<RequestComponentT> zzdknVar) {
        if (zzdkmVar.a != null) {
            this.b = zzdknVar.a(zzdkmVar.b).b();
            return this.b.c().b(zzdkmVar.a);
        }
        zzdyz<AdT> a = this.a.a(zzdkmVar, zzdknVar);
        this.b = this.a.a();
        return a;
    }
}
