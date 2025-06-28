package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
final class in implements zzdyo<Map<String, String>> {
    private final /* synthetic */ List a;
    private final /* synthetic */ String b;
    private final /* synthetic */ zzbdu c;

    in(zzbdu zzbduVar, List list, String str) {
        this.c = zzbduVar;
        this.a = list;
        this.b = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final /* synthetic */ void a(Map<String, String> map) {
        zzbdu zzbduVar = this.c;
        List list = this.a;
        zzbduVar.a((Map<String, String>) map, (List<zzahv<? super zzbdv>>) list, this.b);
    }
}
