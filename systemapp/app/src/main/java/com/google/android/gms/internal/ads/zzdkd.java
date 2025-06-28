package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbre;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdkd<RequestComponentT extends zzbre<AdT>, AdT> implements zzdkl<RequestComponentT, AdT> {

    @GuardedBy("this")
    private RequestComponentT a;

    @Override // com.google.android.gms.internal.ads.zzdkl
    /* renamed from: b */
    public final synchronized RequestComponentT a() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.ads.zzdkl
    public final synchronized zzdyz<AdT> a(zzdkm zzdkmVar, zzdkn<RequestComponentT> zzdknVar) {
        this.a = zzdknVar.a(zzdkmVar.b).b();
        return this.a.c().b();
    }
}
