package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbsb extends zzbwk<zzbry> implements zzbry {
    public zzbsb(zzbsf zzbsfVar, Set<zzbxy<zzbry>> set, Executor executor) {
        super(set);
        a(zzbsfVar, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final void a(zzve zzveVar) {
        a(new zzbwm(zzveVar) { // from class: com.google.android.gms.internal.ads.mt
            private final zzve a;

            {
                this.a = zzveVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwm
            public final void a(Object obj) {
                ((zzbry) obj).a(this.a);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final void a(zzcai zzcaiVar) {
        a(new zzbwm(zzcaiVar) { // from class: com.google.android.gms.internal.ads.mv
            private final zzcai a;

            {
                this.a = zzcaiVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwm
            public final void a(Object obj) {
                ((zzbry) obj).a(this.a);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final void a() {
        a(mu.a);
    }
}
