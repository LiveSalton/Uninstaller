package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzday implements zzdfi<zzdfj<Bundle>> {
    private final Executor a;
    private final zzayg b;

    zzday(Executor executor, zzayg zzaygVar) {
        this.a = executor;
        this.b = zzaygVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdyz<zzdfj<Bundle>> a() {
        if (((Boolean) zzwq.e().a(zzabf.bk)).booleanValue()) {
            return zzdyr.a((Object) null);
        }
        return zzdyr.a(this.b.j(), acr.a, this.a);
    }
}
