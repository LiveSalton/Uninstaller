package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: source */
/* loaded from: classes.dex */
final class bcu implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzazq a;
    private final /* synthetic */ zztl b;

    bcu(zztl zztlVar, zzazq zzazqVar) {
        this.b = zztlVar;
        this.a = zzazqVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void a(ConnectionResult connectionResult) {
        Object obj;
        obj = this.b.d;
        synchronized (obj) {
            this.a.a(new RuntimeException("Connection failed."));
        }
    }
}
