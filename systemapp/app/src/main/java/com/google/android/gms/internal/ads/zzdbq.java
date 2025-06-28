package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdbq implements zzdfi<zzdbr> {
    private final zzdzc a;
    private final Context b;

    public zzdbq(zzdzc zzdzcVar, Context context) {
        this.a = zzdzcVar;
        this.b = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdbr> a() {
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.acx
            private final zzdbq a;

            {
                this.a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.b();
            }
        });
    }

    final /* synthetic */ zzdbr b() throws Exception {
        double d;
        Intent registerReceiver = this.b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            d = registerReceiver.getIntExtra("level", -1) / registerReceiver.getIntExtra("scale", -1);
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
        } else {
            d = -1.0d;
        }
        return new zzdbr(d, z);
    }
}
