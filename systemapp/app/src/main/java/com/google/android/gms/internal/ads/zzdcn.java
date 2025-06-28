package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdcn implements zzdfi<adf> {
    private final Context a;
    private final zzdzc b;

    zzdcn(Context context, zzdzc zzdzcVar) {
        this.a = context;
        this.b = zzdzcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<adf> a() {
        return this.b.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.ade
            private final zzdcn a;

            {
                this.a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.b();
            }
        });
    }

    final /* synthetic */ adf b() throws Exception {
        zzp.c();
        String k = com.google.android.gms.ads.internal.util.zzm.k(this.a);
        String string = !((Boolean) zzwq.e().a(zzabf.dn)).booleanValue() ? "" : this.a.getSharedPreferences("mobileads_consent", 0).getString("fc_consent", "");
        zzp.c();
        return new adf(k, string, com.google.android.gms.ads.internal.util.zzm.l(this.a));
    }
}
