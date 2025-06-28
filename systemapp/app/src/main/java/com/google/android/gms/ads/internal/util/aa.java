package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzayv;

/* compiled from: source */
/* loaded from: classes.dex */
final class aa implements zzayv {
    private final /* synthetic */ Context a;
    private final /* synthetic */ String b;

    aa(zzm zzmVar, Context context, String str) {
        this.a = context;
        this.b = str;
    }

    @Override // com.google.android.gms.internal.ads.zzayv
    public final void a(String str) {
        zzp.c();
        zzm.a(this.a, this.b, str);
    }
}
