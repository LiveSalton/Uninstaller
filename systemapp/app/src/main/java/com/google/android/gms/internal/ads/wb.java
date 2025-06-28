package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: source */
/* loaded from: classes.dex */
final class wb implements zzbui {
    private final Context a;
    private final zzawx b;

    wb(Context context, zzawx zzawxVar) {
        this.a = context;
        this.b = zzawxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbui
    public final void a(zzatl zzatlVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbui
    public final void a(zzdnj zzdnjVar) {
        if (TextUtils.isEmpty(zzdnjVar.b.b.d)) {
            return;
        }
        this.b.a(this.a, zzdnjVar.a.a.d);
        this.b.f(this.a, zzdnjVar.b.b.d);
    }
}
