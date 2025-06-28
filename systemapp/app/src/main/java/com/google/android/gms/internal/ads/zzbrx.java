package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbrx extends zzbwk<zzbrz> implements zzbrz {
    public zzbrx(Set<zzbxy<zzbrz>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbrz
    public final void a_(zzve zzveVar) {
        a(new zzbwm(zzveVar) { // from class: com.google.android.gms.internal.ads.ms
            private final zzve a;

            {
                this.a = zzveVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwm
            public final void a(Object obj) {
                ((zzbrz) obj).a_(this.a);
            }
        });
    }
}
