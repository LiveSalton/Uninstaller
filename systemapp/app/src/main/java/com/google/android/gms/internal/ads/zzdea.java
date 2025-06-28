package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdea implements zzdfi<zzdeb> {
    private final zzdzc a;
    private final Bundle b;

    public zzdea(zzdzc zzdzcVar, Bundle bundle) {
        this.a = zzdzcVar;
        this.b = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdeb> a() {
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.adu
            private final zzdea a;

            {
                this.a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.b();
            }
        });
    }

    final /* synthetic */ zzdeb b() throws Exception {
        return new zzdeb(this.b);
    }
}
