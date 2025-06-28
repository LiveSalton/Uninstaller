package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.ads.zzdte;
import com.google.android.gms.internal.ads.zzdti;

/* compiled from: source */
@ShowFirstParty
/* loaded from: classes.dex */
public final class zzdst {
    private final Context a;
    private final Looper b;

    public zzdst(Context context, Looper looper) {
        this.a = context;
        this.b = looper;
    }

    public final void a(String str) {
        new akm(this.a, this.b, (zzdti) ((zzekh) zzdti.a().a(this.a.getPackageName()).a(zzdti.zzb.BLOCKED_IMPRESSION).a(zzdte.a().a(str).a(zzdte.zza.BLOCKED_REASON_BACKGROUND)).g())).a();
    }
}
