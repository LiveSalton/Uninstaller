package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Set;

/* compiled from: source */
@VisibleForTesting
/* loaded from: classes.dex */
public final class zzbsf extends zzbwk<zzbsi> implements zzbry {
    @VisibleForTesting
    public zzbsf(Set<zzbxy<zzbsi>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final void a(zzcai zzcaiVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final void a(zzve zzveVar) {
        a(new zzbwm(zzveVar) { // from class: com.google.android.gms.internal.ads.mw
            private final zzve a;

            {
                this.a = zzveVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwm
            public final void a(Object obj) {
                ((zzbsi) obj).a(this.a);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final void a() {
        a(mx.a);
    }
}
