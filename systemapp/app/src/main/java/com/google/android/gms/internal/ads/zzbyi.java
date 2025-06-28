package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbyi extends zzbwk<zzaij> implements zzaij {
    public zzbyi(Set<zzbxy<zzaij>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final synchronized void a() {
        a(pv.a);
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void a(zzava zzavaVar) {
        a(new zzbwm(zzavaVar) { // from class: com.google.android.gms.internal.ads.px
            private final zzava a;

            {
                this.a = zzavaVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwm
            public final void a(Object obj) {
                ((zzaij) obj).a(this.a);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void b() {
        a(pw.a);
    }
}
