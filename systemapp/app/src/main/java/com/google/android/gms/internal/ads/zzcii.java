package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcii implements zzbsp {
    private final zzbdv a;

    zzcii(zzbdv zzbdvVar) {
        this.a = ((Boolean) zzwq.e().a(zzabf.al)).booleanValue() ? zzbdvVar : null;
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final void a(Context context) {
        if (this.a != null) {
            this.a.onPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final void b(Context context) {
        if (this.a != null) {
            this.a.onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final void c(Context context) {
        if (this.a != null) {
            this.a.destroy();
        }
    }
}
