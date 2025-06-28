package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* compiled from: source */
/* loaded from: classes.dex */
final class aw implements zzdyb<zzair, ParcelFileDescriptor> {
    private final /* synthetic */ zzail a;

    aw(zzait zzaitVar, zzail zzailVar) {
        this.a = zzailVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyb
    public final /* synthetic */ zzdyz<ParcelFileDescriptor> a(zzair zzairVar) throws Exception {
        zzazq zzazqVar = new zzazq();
        zzairVar.a(this.a, new ay(this, zzazqVar));
        return zzazqVar;
    }
}
