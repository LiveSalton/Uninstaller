package com.google.android.gms.internal.ads;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzddl implements zzepf<zzddj> {
    private final zzeps<zzdzc> a;
    private final zzeps<zzdms> b;

    private zzddl(zzeps<zzdzc> zzepsVar, zzeps<zzdms> zzepsVar2) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
    }

    public static zzddl a(zzeps<zzdzc> zzepsVar, zzeps<zzdms> zzepsVar2) {
        return new zzddl(zzepsVar, zzepsVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzddj(this.a.b(), this.b.b());
    }
}
