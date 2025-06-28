package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbtw extends zzbwk<zzbub> implements zzbsm, zzbto {
    private final zzdmu a;
    private AtomicBoolean b;

    public zzbtw(Set<zzbxy<zzbub>> set, zzdmu zzdmuVar) {
        super(set);
        this.b = new AtomicBoolean();
        this.a = zzdmuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsm
    public final void b() {
        if (this.a.b == 2 || this.a.b == 5 || this.a.b == 4) {
            a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final void s() {
        if (this.a.b == 1) {
            a();
        }
    }

    private final void a() {
        if (((Boolean) zzwq.e().a(zzabf.eb)).booleanValue() && this.b.compareAndSet(false, true) && this.a.aa != null && this.a.aa.a == 3) {
            a(new zzbwm(this) { // from class: com.google.android.gms.internal.ads.nr
                private final zzbtw a;

                {
                    this.a = this;
                }

                @Override // com.google.android.gms.internal.ads.zzbwm
                public final void a(Object obj) {
                    this.a.a((zzbub) obj);
                }
            });
        }
    }

    final /* synthetic */ void a(zzbub zzbubVar) throws Exception {
        zzbubVar.a(this.a.aa);
    }
}
