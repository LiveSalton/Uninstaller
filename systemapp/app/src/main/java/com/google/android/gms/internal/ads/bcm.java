package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: source */
/* loaded from: classes.dex */
final class bcm implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ zzsx a;

    bcm(zzsx zzsxVar) {
        this.a = zzsxVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void a(Bundle bundle) {
        Object obj;
        Object obj2;
        zztc zztcVar;
        zztc zztcVar2;
        obj = this.a.b;
        synchronized (obj) {
            try {
                zztcVar = this.a.c;
                if (zztcVar != null) {
                    zzsx zzsxVar = this.a;
                    zztcVar2 = this.a.c;
                    zzsxVar.e = zztcVar2.w();
                }
            } catch (DeadObjectException e) {
                zzd.c("Unable to obtain a cache service instance.", e);
                this.a.c();
            }
            obj2 = this.a.b;
            obj2.notifyAll();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void a(int i) {
        Object obj;
        Object obj2;
        obj = this.a.b;
        synchronized (obj) {
            this.a.e = null;
            obj2 = this.a.b;
            obj2.notifyAll();
        }
    }
}
