package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzciw implements zzepf<zzcis> {
    private final zzeps<Executor> a;

    public zzciw(zzeps<Executor> zzepsVar) {
        this.a = zzepsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcis(this.a.b());
    }
}
