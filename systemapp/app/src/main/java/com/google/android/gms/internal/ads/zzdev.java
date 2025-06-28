package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzdev implements zzepf<zzdet> {
    private final zzeps<zzawx> a;
    private final zzeps<zzdzc> b;
    private final zzeps<Context> c;

    private zzdev(zzeps<zzawx> zzepsVar, zzeps<zzdzc> zzepsVar2, zzeps<Context> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    public static zzdev a(zzeps<zzawx> zzepsVar, zzeps<zzdzc> zzepsVar2, zzeps<Context> zzepsVar3) {
        return new zzdev(zzepsVar, zzepsVar2, zzepsVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzdet(this.a.b(), this.b.b(), this.c.b());
    }
}
