package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzaml {

    @VisibleForTesting
    private static final com.google.android.gms.ads.internal.util.zzau<zzako> a = new cm();

    @VisibleForTesting
    private static final com.google.android.gms.ads.internal.util.zzau<zzako> b = new cn();
    private final zzalb c;

    public zzaml(Context context, zzazh zzazhVar, String str) {
        this.c = new zzalb(context, zzazhVar, str, a, b);
    }

    public final <I, O> zzamd<I, O> a(String str, zzame<I> zzameVar, zzamf<O> zzamfVar) {
        return new zzamm(this.c, str, zzameVar, zzamfVar);
    }

    public final zzamq a() {
        return new zzamq(this.c);
    }
}
