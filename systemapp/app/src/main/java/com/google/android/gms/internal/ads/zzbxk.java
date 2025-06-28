package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzbxk implements zzepf<zzcum> {
    private final zzbwp a;
    private final zzeps<Clock> b;
    private final zzeps<zzcuo> c;
    private final zzeps<zzcrg> d;

    private zzbxk(zzbwp zzbwpVar, zzeps<Clock> zzepsVar, zzeps<zzcuo> zzepsVar2, zzeps<zzcrg> zzepsVar3) {
        this.a = zzbwpVar;
        this.b = zzepsVar;
        this.c = zzepsVar2;
        this.d = zzepsVar3;
    }

    public static zzbxk a(zzbwp zzbwpVar, zzeps<Clock> zzepsVar, zzeps<zzcuo> zzepsVar2, zzeps<zzcrg> zzepsVar3) {
        return new zzbxk(zzbwpVar, zzepsVar, zzepsVar2, zzepsVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return (zzcum) zzepl.a(this.a.a(this.b.b(), this.c.b(), this.d.b()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
