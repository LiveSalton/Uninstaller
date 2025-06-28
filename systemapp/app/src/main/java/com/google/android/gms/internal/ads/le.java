package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.List;

/* compiled from: source */
/* loaded from: classes.dex */
final class le implements zzdyo<String> {
    private final /* synthetic */ zzbjv a;

    le(zzbjv zzbjvVar) {
        this.a = zzbjvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final void a(Throwable th) {
        zzdnv zzdnvVar;
        zzdrx zzdrxVar;
        zzdnj zzdnjVar;
        zzdmu zzdmuVar;
        zzdmu zzdmuVar2;
        Context context;
        zzdnvVar = this.a.g;
        zzdrxVar = this.a.f;
        zzdnjVar = this.a.d;
        zzdmuVar = this.a.e;
        zzdmuVar2 = this.a.e;
        List<String> a = zzdrxVar.a(zzdnjVar, zzdmuVar, false, "", "failure_click_attok", zzdmuVar2.c);
        zzp.c();
        context = this.a.a;
        zzdnvVar.a(a, com.google.android.gms.ads.internal.util.zzm.p(context) ? zzcql.b : zzcql.a);
    }

    @Override // com.google.android.gms.internal.ads.zzdyo
    public final /* synthetic */ void a(String str) {
        zzdnv zzdnvVar;
        zzdrx zzdrxVar;
        zzdnj zzdnjVar;
        zzdmu zzdmuVar;
        zzdmu zzdmuVar2;
        Context context;
        int i;
        String str2 = str;
        zzdnvVar = this.a.g;
        zzdrxVar = this.a.f;
        zzdnjVar = this.a.d;
        zzdmuVar = this.a.e;
        zzdmuVar2 = this.a.e;
        List<String> a = zzdrxVar.a(zzdnjVar, zzdmuVar, false, "", str2, zzdmuVar2.c);
        zzp.c();
        context = this.a.a;
        if (com.google.android.gms.ads.internal.util.zzm.p(context)) {
            i = zzcql.b;
        } else {
            i = zzcql.a;
        }
        zzdnvVar.a(a, i);
    }
}
