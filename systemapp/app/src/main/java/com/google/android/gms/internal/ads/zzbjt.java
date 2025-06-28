package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbjt implements zzbsp {
    private final zzdoe a;

    public zzbjt(zzdoe zzdoeVar) {
        this.a = zzdoeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final void a(Context context) {
        try {
            this.a.d();
        } catch (zzdnr e) {
            zzd.d("Cannot invoke onPause for the mediation adapter.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final void b(Context context) {
        try {
            this.a.e();
            if (context != null) {
                this.a.a(context);
            }
        } catch (zzdnr e) {
            zzd.d("Cannot invoke onResume for the mediation adapter.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final void c(Context context) {
        try {
            this.a.c();
        } catch (zzdnr e) {
            zzd.d("Cannot invoke onDestroy for the mediation adapter.", e);
        }
    }
}
