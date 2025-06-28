package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzvh extends zzxm {
    private final AdMetadataListener a;

    public zzvh(AdMetadataListener adMetadataListener) {
        this.a = adMetadataListener;
    }

    @Override // com.google.android.gms.internal.ads.zzxj
    public final void a() {
        if (this.a != null) {
            this.a.k_();
        }
    }
}
