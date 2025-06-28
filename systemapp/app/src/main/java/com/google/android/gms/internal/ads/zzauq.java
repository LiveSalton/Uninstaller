package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;

/* compiled from: source */
/* loaded from: classes.dex */
public final class zzauq implements RewardItem {
    private final zzauf a;

    public zzauq(zzauf zzaufVar) {
        this.a = zzaufVar;
    }

    @Override // com.google.android.gms.ads.reward.RewardItem
    public final String a() {
        if (this.a == null) {
            return null;
        }
        try {
            return this.a.a();
        } catch (RemoteException e) {
            zzaza.d("Could not forward getType to RewardItem", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardItem
    public final int b() {
        if (this.a == null) {
            return 0;
        }
        try {
            return this.a.b();
        } catch (RemoteException e) {
            zzaza.d("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }
}
