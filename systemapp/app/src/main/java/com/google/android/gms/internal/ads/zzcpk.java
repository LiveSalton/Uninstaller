package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcpk implements zzepf<zzcou> {
    private final zzeps<Context> a;
    private final zzeps<Executor> b;
    private final zzeps<zzaty> c;
    private final zzeps<zzbjl> d;
    private final zzeps<zzatz> e;
    private final zzeps<HashMap<String, zzcpf>> f;

    private zzcpk(zzeps<Context> zzepsVar, zzeps<Executor> zzepsVar2, zzeps<zzaty> zzepsVar3, zzeps<zzbjl> zzepsVar4, zzeps<zzatz> zzepsVar5, zzeps<HashMap<String, zzcpf>> zzepsVar6) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
        this.f = zzepsVar6;
    }

    public static zzcpk a(zzeps<Context> zzepsVar, zzeps<Executor> zzepsVar2, zzeps<zzaty> zzepsVar3, zzeps<zzbjl> zzepsVar4, zzeps<zzatz> zzepsVar5, zzeps<HashMap<String, zzcpf>> zzepsVar6) {
        return new zzcpk(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4, zzepsVar5, zzepsVar6);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcou(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b(), this.f.b());
    }
}
