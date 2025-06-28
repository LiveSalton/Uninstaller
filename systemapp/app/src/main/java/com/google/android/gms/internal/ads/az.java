package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: source */
/* loaded from: classes.dex */
final class az implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzazq a;

    az(zzait zzaitVar, zzazq zzazqVar) {
        this.a = zzazqVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void a(ConnectionResult connectionResult) {
        this.a.a(new RuntimeException("Connection failed."));
    }
}
