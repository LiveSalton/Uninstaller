package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdgq implements zzdfi<zzdgr> {
    zzth a;
    Context b;
    private zzdzc c;

    public zzdgq(zzth zzthVar, zzdzc zzdzcVar, Context context) {
        this.a = zzthVar;
        this.c = zzdzcVar;
        this.b = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdgr> a() {
        return this.c.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.aew
            private final zzdgq a;

            {
                this.a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdgq zzdgqVar = this.a;
                return new zzdgr(zzdgqVar.a.a(zzdgqVar.b));
            }
        });
    }
}
