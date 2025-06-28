package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzddj implements zzdfi<zzddg> {
    private final zzdzc a;
    private final zzdms b;

    public zzddj(zzdzc zzdzcVar, zzdms zzdmsVar) {
        this.a = zzdzcVar;
        this.b = zzdmsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzddg> a() {
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.adm
            private final zzddj a;

            {
                this.a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.b();
            }
        });
    }

    final /* synthetic */ zzddg b() throws Exception {
        return new zzddg(this.b);
    }
}
