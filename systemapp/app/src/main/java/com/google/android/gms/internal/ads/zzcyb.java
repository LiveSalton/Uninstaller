package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzcyb implements zzbub {
    private final AtomicReference<zzym> a = new AtomicReference<>();

    public final void a(zzym zzymVar) {
        this.a.set(zzymVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbub
    public final void a(zzvp zzvpVar) {
        zzdkb.a(this.a, new zzdka(zzvpVar) { // from class: com.google.android.gms.internal.ads.abe
            private final zzvp a;

            {
                this.a = zzvpVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdka
            public final void a(Object obj) {
                ((zzym) obj).a(this.a);
            }
        });
    }
}
