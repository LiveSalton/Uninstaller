package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.io.IOException;
import java.util.concurrent.Future;

/* compiled from: source */
/* loaded from: classes.dex */
final class bcr implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zztl a;
    private final /* synthetic */ zztf b;
    private final /* synthetic */ zzazq c;

    bcr(zztl zztlVar, zztf zztfVar, zzazq zzazqVar) {
        this.a = zztlVar;
        this.b = zztfVar;
        this.c = zzazqVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void a(int i) {
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void a(Bundle bundle) {
        Object obj;
        boolean z;
        zztc zztcVar;
        obj = this.a.d;
        synchronized (obj) {
            z = this.a.b;
            if (z) {
                return;
            }
            zztl.a(this.a, true);
            zztcVar = this.a.a;
            if (zztcVar == null) {
                return;
            }
            this.c.a(new Runnable(this.c, zzazj.a.submit(new Runnable(this, zztcVar, this.b, this.c) { // from class: com.google.android.gms.internal.ads.bcq
                private final bcr a;
                private final zztc b;
                private final zztf c;
                private final zzazq d;

                {
                    this.a = this;
                    this.b = zztcVar;
                    this.c = zztfVar;
                    this.d = zzazqVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    bcr bcrVar = this.a;
                    zztc zztcVar2 = this.b;
                    zztf zztfVar2 = this.c;
                    zzazq zzazqVar2 = this.d;
                    try {
                        zztg w = zztcVar2.w();
                        zzta b = zztcVar2.x() ? w.b(zztfVar2) : w.a(zztfVar2);
                        if (!b.a()) {
                            zzazqVar2.a(new RuntimeException("No entry contents."));
                            bcrVar.a.a();
                            return;
                        }
                        bcs bcsVar = new bcs(bcrVar, b.b(), 1);
                        int read = bcsVar.read();
                        if (read == -1) {
                            throw new IOException("Unable to read from cache.");
                        }
                        bcsVar.unread(read);
                        zzazqVar2.b(zztt.a(bcsVar, b.c(), b.f(), b.e(), b.d()));
                    } catch (RemoteException | IOException e) {
                        zzd.c("Unable to obtain a cache service instance.", e);
                        zzazqVar2.a(e);
                        bcrVar.a.a();
                    }
                }
            })) { // from class: com.google.android.gms.internal.ads.bct
                private final zzazq a;
                private final Future b;

                {
                    this.a = zzazqVar3;
                    this.b = submit;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzazq zzazqVar4 = this.a;
                    Future future = this.b;
                    if (zzazqVar4.isCancelled()) {
                        future.cancel(true);
                    }
                }
            }, zzazj.f);
        }
    }
}
