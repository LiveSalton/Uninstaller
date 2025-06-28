package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

/* compiled from: source */
/* loaded from: classes.dex */
final /* synthetic */ class vd implements zzdyb {
    static final zzdyb a = new vd();

    private vd() {
    }

    @Override // com.google.android.gms.internal.ads.zzdyb
    public final zzdyz a(Object obj) {
        return zzdyr.a(((ExecutionException) obj).getCause());
    }
}
