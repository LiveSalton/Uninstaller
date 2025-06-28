package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcxd implements zzepf<zzcwz> {
    private final zzeps<Executor> a;

    public zzcxd(zzeps<Executor> zzepsVar) {
        this.a = zzepsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcwz(this.a.b());
    }
}
