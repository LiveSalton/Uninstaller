package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
final class ef implements zzdyo<Void> {
    private final /* synthetic */ zzdyz a;

    ef(zzawh zzawhVar, zzdyz zzdyzVar) {
        this.a = zzdyzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Throwable th) {
        List list;
        list = zzawh.a;
        list.remove(this.a);
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final /* synthetic */ void a(Void r2) {
        List list;
        list = zzawh.a;
        list.remove(this.a);
    }
}
