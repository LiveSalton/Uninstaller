package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdds implements zzdfi<zzddt> {
    private final zzdzc a;
    private final Context b;
    private final Set<String> c;

    public zzdds(zzdzc zzdzcVar, Context context, Set<String> set) {
        this.a = zzdzcVar;
        this.b = context;
        this.c = set;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzddt> a() {
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.adr
            private final zzdds a;

            {
                this.a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.b();
            }
        });
    }

    final /* synthetic */ zzddt b() throws Exception {
        boolean b;
        if (((Boolean) zzwq.e().a(zzabf.cz)).booleanValue()) {
            b = zzddt.b(this.c);
            if (b) {
                return new zzddt(zzp.r().b(this.b));
            }
        }
        return new zzddt(null);
    }
}
