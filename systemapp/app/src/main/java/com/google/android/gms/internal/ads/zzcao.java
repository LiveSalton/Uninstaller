package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.ads.zzue;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzcao implements zzepf<zzcal> {
    private final zzeps<zzawu> a;
    private final zzeps<Context> b;
    private final zzeps<zzawx> c;
    private final zzeps<View> d;
    private final zzeps<zzue.zza.EnumC0075zza> e;

    private zzcao(zzeps<zzawu> zzepsVar, zzeps<Context> zzepsVar2, zzeps<zzawx> zzepsVar3, zzeps<View> zzepsVar4, zzeps<zzue.zza.EnumC0075zza> zzepsVar5) {
        this.a = zzepsVar;
        this.b = zzepsVar2;
        this.c = zzepsVar3;
        this.d = zzepsVar4;
        this.e = zzepsVar5;
    }

    public static zzcao a(zzeps<zzawu> zzepsVar, zzeps<Context> zzepsVar2, zzeps<zzawx> zzepsVar3, zzeps<View> zzepsVar4, zzeps<zzue.zza.EnumC0075zza> zzepsVar5) {
        return new zzcao(zzepsVar, zzepsVar2, zzepsVar3, zzepsVar4, zzepsVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzeps
    public final /* synthetic */ Object b() {
        return new zzcal(this.a.b(), this.b.b(), this.c.b(), this.d.b(), this.e.b());
    }
}
