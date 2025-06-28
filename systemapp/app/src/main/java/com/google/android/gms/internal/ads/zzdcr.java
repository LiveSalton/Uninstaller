package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdcr implements zzepf<zzdcn> {
    private final zzeps<Context> a;
    private final zzeps<zzdzc> b;

    private zzdcr(zzeps<Context> zzepsVar, zzeps<zzdzc> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzdcr a(zzeps<Context> zzepsVar, zzeps<zzdzc> zzepsVar2) {
        return new zzdcr(zzepsVar, zzepsVar2);
    }

    public static zzdcn a(Context context, zzdzc zzdzcVar) {
        return new zzdcn(context, zzdzcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return a(this.a.b(), this.b.b());
    }
}
