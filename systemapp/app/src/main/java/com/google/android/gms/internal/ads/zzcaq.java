package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcaq implements zzepf<qm> {
    private final zzeps<Map<String, zzcqz<zzboi>>> a;
    private final zzeps<Map<String, zzcqz<zzcbt>>> b;
    private final zzeps<Map<String, zzcto<zzcbt>>> c;
    private final zzeps<zzbod<zzbme>> d;
    private final zzeps<zzccl> e;

    public zzcaq(zzeps<Map<String, zzcqz<zzboi>>> zzepsVar, zzeps<Map<String, zzcqz<zzcbt>>> zzepsVar2, zzeps<Map<String, zzcto<zzcbt>>> zzepsVar3, zzeps<zzbod<zzbme>> zzepsVar4, zzeps<zzccl> zzepsVar5) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new qm(this.a.b(), this.b.b(), this.c.b(), this.d, this.e.b());
    }
}
