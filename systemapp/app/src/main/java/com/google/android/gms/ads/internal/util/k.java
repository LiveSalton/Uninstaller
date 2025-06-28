package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzai;
import com.google.android.gms.internal.ads.zzao;

/* compiled from: source */
/* loaded from: classes.dex */
final class k implements zzai {
    private final /* synthetic */ String a;
    private final /* synthetic */ n b;

    k(zzax zzaxVar, String str, n nVar) {
        this.a = str;
        this.b = nVar;
    }

    @Override // com.google.android.gms.internal.ads.zzai
    public final void a(zzao zzaoVar) {
        String str = this.a;
        String zzaoVar2 = zzaoVar.toString();
        StringBuilder sb = new StringBuilder(21 + String.valueOf(str).length() + String.valueOf(zzaoVar2).length());
        sb.append("Failed to load URL: ");
        sb.append(str);
        sb.append("\n");
        sb.append(zzaoVar2);
        zzd.e(sb.toString());
        this.b.a((n) null);
    }
}
