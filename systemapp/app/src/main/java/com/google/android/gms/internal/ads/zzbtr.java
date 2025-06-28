package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbtr extends zzbwk<zzp> implements zzp {
    public zzbtr(Set<zzbxy<zzp>> set) {
        super(set);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void a(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        a(new zzbwm(zzlVar) { // from class: com.google.android.gms.internal.ads.nm
            private final com.google.android.gms.ads.internal.overlay.zzl a;

            {
                this.a = zzlVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwm
            public final void a(Object obj) {
                ((zzp) obj).a(this.a);
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void f_() {
        a(no.a);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void b_() {
        a(nn.a);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void g_() {
        a(nq.a);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void e_() {
        a(np.a);
    }
}
