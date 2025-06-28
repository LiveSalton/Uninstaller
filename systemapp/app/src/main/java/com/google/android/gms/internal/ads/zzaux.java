package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.reward.RewardedVideoAd;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzaux implements RewardedVideoAd {
    private final zzaui a;
    private final Context b;
    private final Object c = new Object();
    private final zzaus d = new zzaus(null);

    public zzaux(Context context, zzaui zzauiVar) {
        this.a = zzauiVar == null ? new zzaaa() : zzauiVar;
        this.b = context.getApplicationContext();
    }
}
