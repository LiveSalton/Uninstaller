package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdhd implements zzdfi<zzdha> {
    zzaar a;
    List<String> b;
    private zzdzc c;

    public zzdhd(zzaar zzaarVar, zzdzc zzdzcVar, List<String> list) {
        this.a = zzaarVar;
        this.c = zzdzcVar;
        this.b = list;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdha> a() {
        return this.c.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.afb
            private final zzdhd a;

            {
                this.a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdhd zzdhdVar = this.a;
                return new zzdha(zzdhdVar.a.a(zzdhdVar.b));
            }
        });
    }
}
