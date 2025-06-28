package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzax;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcel implements zzepf<zzcej> {
    private final zzeps<zzax> a;
    private final zzeps<Clock> b;
    private final zzeps<Executor> c;

    public zzcel(zzeps<zzax> zzepsVar, zzeps<Clock> zzepsVar2, zzeps<Executor> zzepsVar3) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcej(this.a.b(), this.b.b(), this.c.b());
    }
}
