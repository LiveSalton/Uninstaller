package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbdh extends zzbcx {
    public zzbdh(zzbbe zzbbeVar) {
        super(zzbbeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbcx
    public final void a() {
    }

    @Override // com.google.android.gms.internal.ads.zzbcx
    public final boolean a(String str) {
        zzbbe zzbbeVar = this.c.get();
        if (zzbbeVar != null) {
            zzbbeVar.a(b(str), this);
        }
        zzd.e("VideoStreamNoopCache is doing nothing.");
        a(str, b(str), "noop", "Noop cache is a noop.");
        return false;
    }
}
