package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzckw implements zzepf<zzcku> {
    private final zzeps<zzcko> a;
    private final zzeps<Set<up>> b;
    private final zzeps<Clock> c;

    private zzckw(zzeps<zzcko> zzepsVar, zzeps<Set<up>> zzepsVar2, zzeps<Clock> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    public static zzckw a(zzeps<zzcko> zzepsVar, zzeps<Set<up>> zzepsVar2, zzeps<Clock> zzepsVar3) {
        return new zzckw(zzepsVar, zzepsVar2, zzepsVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcku(this.a.b(), this.b.b(), this.c.b());
    }
}
