package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: source */
/* loaded from: classes.dex */
final class bco implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzsx a;

    bco(zzsx zzsxVar) {
        this.a = zzsxVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void a(ConnectionResult connectionResult) {
        Object obj;
        zztc zztcVar;
        Object obj2;
        obj = this.a.b;
        synchronized (obj) {
            this.a.e = null;
            zztcVar = this.a.c;
            if (zztcVar != null) {
                zzsx.a(this.a, (zztc) null);
            }
            obj2 = this.a.b;
            obj2.notifyAll();
        }
    }
}
