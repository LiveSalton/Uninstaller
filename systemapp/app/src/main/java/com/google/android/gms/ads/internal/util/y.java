package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.c;
import com.google.android.gms.internal.ads.zzace;
import com.google.android.gms.internal.ads.zzacf;

/* compiled from: source */
/* loaded from: classes.dex */
final class y implements zzace {
    private final /* synthetic */ zzacf a;
    private final /* synthetic */ Context b;
    private final /* synthetic */ Uri c;

    y(zzm zzmVar, zzacf zzacfVar, Context context, Uri uri) {
        this.a = zzacfVar;
        this.b = context;
        this.c = uri;
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final void b() {
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final void a() {
        new c.a(this.a.a()).a().a(this.b, this.c);
        this.a.a((Activity) this.b);
    }
}
