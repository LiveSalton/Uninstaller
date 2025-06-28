package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbso extends zzbwk<zzbsp> {
    public zzbso(Set<zzbxy<zzbsp>> set) {
        super(set);
    }

    public final void a(Context context) {
        a(new zzbwm(context) { // from class: com.google.android.gms.internal.ads.na
            private final Context a;

            {
                this.a = context;
            }

            @Override // com.google.android.gms.internal.ads.zzbwm
            public final void a(Object obj) {
                ((zzbsp) obj).a(this.a);
            }
        });
    }

    public final void b(Context context) {
        a(new zzbwm(context) { // from class: com.google.android.gms.internal.ads.mz
            private final Context a;

            {
                this.a = context;
            }

            @Override // com.google.android.gms.internal.ads.zzbwm
            public final void a(Object obj) {
                ((zzbsp) obj).b(this.a);
            }
        });
    }

    public final void c(Context context) {
        a(new zzbwm(context) { // from class: com.google.android.gms.internal.ads.nc
            private final Context a;

            {
                this.a = context;
            }

            @Override // com.google.android.gms.internal.ads.zzbwm
            public final void a(Object obj) {
                ((zzbsp) obj).c(this.a);
            }
        });
    }

    public final void a(zzbyo zzbyoVar, Executor executor) {
        a(zzbxy.a(new nb(this, zzbyoVar), executor));
    }
}
