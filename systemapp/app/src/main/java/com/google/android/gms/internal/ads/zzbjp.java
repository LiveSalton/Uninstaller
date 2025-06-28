package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzf;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbjp implements zzepf<zzbjq> {
    private final zzeps<zzf> a;

    private zzbjp(zzeps<zzf> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzbjp a(zzeps<zzf> zzepsVar) {
        return new zzbjp(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbjq(this.a.b());
    }
}
