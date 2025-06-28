package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: source */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzavs {
    private final zzavh a;
    private final Context b;

    public zzavs(Context context, String str) {
        this.b = context.getApplicationContext();
        this.a = zzwq.b().b(context, str, new zzanj());
    }

    public final void a(zzza zzzaVar, RewardedAdLoadCallback rewardedAdLoadCallback) {
        try {
            this.a.a(zzvl.a(this.b, zzzaVar), new zzavz(rewardedAdLoadCallback));
        } catch (RemoteException e) {
            zzaza.e("#007 Could not call remote method.", e);
        }
    }
}
