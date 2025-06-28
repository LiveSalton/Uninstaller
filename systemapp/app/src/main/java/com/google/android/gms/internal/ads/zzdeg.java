package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdeg implements zzdfi<zzdfj<Bundle>> {
    private final Context a;
    private final String b;

    zzdeg(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdfj<Bundle>> a() {
        return zzdyr.a(this.b == null ? null : new zzdfj(this) { // from class: com.google.android.gms.internal.ads.adv
            private final zzdeg a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdfj
            public final void a(Object obj) {
                this.a.a((Bundle) obj);
            }
        });
    }

    final /* synthetic */ void a(Bundle bundle) {
        bundle.putString("rewarded_sku_package", this.a.getPackageName());
    }
}
