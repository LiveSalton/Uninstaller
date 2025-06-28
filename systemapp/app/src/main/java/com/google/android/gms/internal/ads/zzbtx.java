package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbtx implements zzepf<zzbtr> {
    private final zzeps<Set<zzbxy<zzp>>> a;

    private zzbtx(zzeps<Set<zzbxy<zzp>>> zzepsVar) {
        this.a = zzepsVar;
    }

    public static zzbtx a(zzeps<Set<zzbxy<zzp>>> zzepsVar) {
        return new zzbtx(zzepsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzbtr(this.a.b());
    }
}
