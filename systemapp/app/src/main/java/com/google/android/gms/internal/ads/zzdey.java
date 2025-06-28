package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdey implements zzdfi<zzdfj<Bundle>> {
    private final boolean a;

    zzdey(zzdkt zzdktVar) {
        if (zzdktVar != null) {
            this.a = true;
        } else {
            this.a = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdfj<Bundle>> a() {
        return zzdyr.a(this.a ? aed.a : null);
    }
}
