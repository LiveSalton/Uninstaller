package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdax implements zzdfi<zzdau> {
    private final zzdzc a;
    private final zzdnn b;
    private final zzazh c;

    public zzdax(zzdzc zzdzcVar, zzdnn zzdnnVar, zzazh zzazhVar) {
        this.a = zzdzcVar;
        this.b = zzdnnVar;
        this.c = zzazhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdau> a() {
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.aco
            private final zzdax a;

            {
                this.a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.b();
            }
        });
    }

    final /* synthetic */ zzdau b() throws Exception {
        return new zzdau(this.b.j, this.c);
    }
}
