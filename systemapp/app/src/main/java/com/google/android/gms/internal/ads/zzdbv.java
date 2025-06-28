package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdbv implements zzdfi<zzdfj<Bundle>> {
    private final zzdjv a;

    zzdbv(zzdjv zzdjvVar) {
        this.a = zzdjvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdfj<Bundle>> a() {
        return zzdyr.a((this.a == null || this.a.a() == null || this.a.a().isEmpty()) ? null : new zzdfj(this) { // from class: com.google.android.gms.internal.ads.acy
            private final zzdbv a;

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
        bundle.putString("key_schema", this.a.a());
    }
}
