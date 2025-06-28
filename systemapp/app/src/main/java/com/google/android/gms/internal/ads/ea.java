package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: source */
/* loaded from: classes.dex */
final /* synthetic */ class ea implements zzazc {
    static final zzazc a = new ea();

    private ea() {
    }

    @Override // com.google.android.gms.internal.ads.zzazc
    public final Object a(Object obj) {
        IBinder iBinder = (IBinder) obj;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCreator");
        return queryLocalInterface instanceof zzavn ? (zzavn) queryLocalInterface : new zzavm(iBinder);
    }
}
