package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzddu implements zzepf<zzdds> {
    private final zzeps<zzdzc> a;
    private final zzeps<Context> b;
    private final zzeps<Set<String>> c;

    private zzddu(zzeps<zzdzc> zzepsVar, zzeps<Context> zzepsVar2, zzeps<Set<String>> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    public static zzddu a(zzeps<zzdzc> zzepsVar, zzeps<Context> zzepsVar2, zzeps<Set<String>> zzepsVar3) {
        return new zzddu(zzepsVar, zzepsVar2, zzepsVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdds(this.a.b(), this.b.b(), this.c.b());
    }
}
